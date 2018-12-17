package bdma.ulb.adb.kafka

import bdma.ulb.adb.domain.Click
import bdma.ulb.adb.req.ClickReq
import bdma.ulb.adb.service.ClickService
import bdma.ulb.adb.util.Json
import groovy.util.logging.Slf4j
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

/**
 * Created by ankushsharma on 09/03/18.
 */
@Component
@Slf4j
class ClickStreamsListener {

    private final ClickService clickService

    ClickStreamsListener(ClickService clickService) {
        this.clickService = clickService
    }

    @KafkaListener(topics = "clicks")
    void saveClicks(
            @Payload byte[] payload,
            @Header(KafkaHeaders.OFFSET) Long offset,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition
    )
    {
        log.debug "Partition : {}, Offset : {}", partition, offset
        def json = new String(payload)
        def clickReq = Json.toObject(json, ClickReq)
        def click = new Click(clickReq, offset)
        clickService.save(click)
    }

}
