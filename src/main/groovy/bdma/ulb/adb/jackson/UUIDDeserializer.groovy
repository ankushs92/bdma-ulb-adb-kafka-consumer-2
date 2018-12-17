package bdma.ulb.adb.jackson

import bdma.ulb.adb.util.Strings
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer

/**
 * Created by ankushsharma on 08/03/18.
 */
class UUIDDeserializer extends JsonDeserializer<UUID> {

    @Override
    UUID deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        def text = p.text
        if(Strings.hasText(text)){
            return UUID.fromString(text)
        }
        null
    }

}
