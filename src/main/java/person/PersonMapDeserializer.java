package person;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;

public class PersonMapDeserializer extends JsonDeserializer<Person> {

    @Override
    public Person deserialize(JsonParser jp, DeserializationContext ctx)
            throws IOException, JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        PersonBuilder personBuilder = new PersonBuilder();

        JsonNode node = jp.getCodec().readTree(jp);

        personBuilder
                .setUid(node.get("uid").get(0).textValue())
                .setFirstName(node.get("firstName").get(0).textValue())
                .setLastName(node.get("lastName").get(0).textValue())
                .setGroups(mapper.convertValue(node.get("groups").elements(), ArrayList.class))
        ;

        Person person = personBuilder.build();

        return person;
    }

}
