package bdma.ulb.adb.domain

import bdma.ulb.adb.req.ClickReq
import bdma.ulb.adb.util.Assert

import javax.persistence.*
import java.time.LocalDateTime

/**
 * Created by ankushsharma on 08/03/18.
 */
@Entity
@Table(name = "clicks")
class Click {

    @Id
    @GeneratedValue
    Integer id

    @Column(name = "uuid", nullable = false, columnDefinition = "VARCHAR(50) DEFAULT ''")
     String uuid

    @Column(name = "timestamp", columnDefinition = "TIMESTAMP")
    LocalDateTime timestamp

    @Column(name = "campaign_id", nullable = false, columnDefinition = "INT(5)")
    Integer campaignId

    @Column(name = "pub_id", nullable = false, columnDefinition = "INT(5)")
    Integer pubId

    @Column(name = "ip", nullable = false, columnDefinition = "VARCHAR(50) DEFAULT ''")
     String ip

    @Column(name = "city", nullable = false, columnDefinition = "VARCHAR(50) DEFAULT ''")
     String city

    @Column(name = "country", nullable = false, columnDefinition = "VARCHAR(50) DEFAULT ''")
    String country

    @Column(name = "browser", nullable = false, columnDefinition = "VARCHAR(50) DEFAULT ''")
     String browser

    @Column(name = "platform", columnDefinition = "VARCHAR(50) DEFAULT ''")
     String platform

    @Column(name = "platform_ver", columnDefinition = "VARCHAR(10) DEFAULT ''")
     String platformVersion

    @Column(name = "offset", nullable = false, columnDefinition =  "INT(12)")
    long offset

    Click(ClickReq req, long offset) {
        Assert.notNull(req, "Req cannot be null")
        this.uuid = req.uid.toString()
        this.timestamp = req.timestamp
        this.campaignId = req.campaignId
        this.pubId = req.pubId
        this.ip = req.ip
        this.city = req.city
        this.country = req.country
        this.browser = req.browser
        this.platform = req.platform
        this.platformVersion = req.platformVersion
        this.offset = offset
    }
}
