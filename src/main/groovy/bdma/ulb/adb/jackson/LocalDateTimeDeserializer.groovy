package bdma.ulb.adb.jackson

import bdma.ulb.adb.util.Strings
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    @Override
    LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        def text = p.text
        if(Strings.hasText(text)) {
            LocalDateTime.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        }
    }

}
