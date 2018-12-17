package bdma.ulb.adb.req

import bdma.ulb.adb.jackson.LocalDateTimeDeserializer
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

import java.time.LocalDateTime

@JsonIgnoreProperties(ignoreUnknown = true)
class ClickReq {

    @JsonProperty("uid")
    final UUID uid

    @JsonDeserialize(using = LocalDateTimeDeserializer)
    @JsonProperty("timestamp")
    final LocalDateTime timestamp

    @JsonProperty("campaignId")
    final Integer campaignId

    @JsonProperty("pubId")
    final Integer pubId

    @JsonProperty(value="ip")
    final  String ip

    @JsonProperty(value='city',required=false , defaultValue =  '')
    final String city

    @JsonProperty(value='country',required=false , defaultValue =  '')
    final String country

    @JsonProperty(value='browser',required=false , defaultValue =  '')
    final String browser

    @JsonProperty(value='platform',required=false , defaultValue =  '')
    final String platform

    @JsonProperty(value='platformVersion',required=false , defaultValue =  '')
    final String platformVersion

}
