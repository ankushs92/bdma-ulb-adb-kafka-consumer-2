package bdma.ulb.adb.util;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Helper class to serialize/deserialize POJOs/Maps to JSON and vice versa
 * Created by Ankush on 17/07/17.
 */
public class Json {

    //Reasons for static initialization, check out this link:
    //https://stackoverflow.com/questions/18611565/how-do-i-correctly-reuse-jackson-objectmapper
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static{
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    /**
     * Convert JSON to POJO
     * @param json The JSON to deserialize to a POJO
     * @param clazz The Class that the JSON will be deserialized to a POJO
     * @return An instance of class T
     * @throws Exception
     */
    public static <T> T toObject(final String json, final Class<T> clazz) throws Exception {
        Assert.notNull(clazz, "clazz cannot be null");
        return objectMapper
                .readValue(json, clazz);
    }



}
