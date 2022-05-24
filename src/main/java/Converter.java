import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Converter {
    public Converter() {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private final ObjectMapper mapper = new ObjectMapper();

    public Poll parse(String json) throws JsonProcessingException {
        try {
            return mapper.readValue(json, Poll.class);
        } catch (JsonProcessingException error) {
            System.out.println("JSON invalid | " + json + " | " + error);
            throw error;
        }
    }

    public String stringify(Object object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }
}
