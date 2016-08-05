package person;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize(using = PersonMapDeserializer.class)
public class Person {

    private String uid;

    private Name name;

    private List<String> groups;

    public Person() {}

    public Person(String uid, Name name, List<String> groups) {
        this.uid = uid;
        this.name = name;
        this.groups = groups;
    }

    public String getUid() {
        return uid;
    }

    public Name getName() {
        return name;
    }

    public List<String> getGroups() {
        return groups;
    }

}
