package bdma.ulb.adb.service.impl

import bdma.ulb.adb.domain.Click
import bdma.ulb.adb.repository.ClickRepository
import bdma.ulb.adb.service.ClickService
import bdma.ulb.adb.util.Assert
import groovy.util.logging.Slf4j
import org.springframework.stereotype.Service

/**
 * Created by ankushsharma on 08/03/18.
 */
@Service
@Slf4j
class ClickServiceImpl implements ClickService {

    private final ClickRepository clickRepository

    ClickServiceImpl(ClickRepository clickRepository){
        this.clickRepository = clickRepository
    }

    @Override
    void save(Click click) {
        Assert.notNull(click,'click cannot be null')
        clickRepository.save(click)
    }

}
