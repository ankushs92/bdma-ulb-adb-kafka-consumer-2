package bdma.ulb.adb.jpa

import javax.persistence.AttributeConverter
import javax.persistence.Converter
import java.sql.Timestamp
import java.time.LocalDateTime

@Converter(autoApply = true)
class LocalTimeJpaConverter implements AttributeConverter<LocalDateTime, Timestamp> {


    @Override
    Timestamp convertToDatabaseColumn(LocalDateTime attribute) {
        if(attribute) {
            Timestamp.valueOf(attribute)
        }
    }

    @Override
    LocalDateTime convertToEntityAttribute(Timestamp dbData) {
        if(dbData) {
            dbData.toLocalDateTime()
        }
    }
}
