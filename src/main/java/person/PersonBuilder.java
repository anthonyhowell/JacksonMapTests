package person;

import java.util.List;

/**
 * Created by anthony on 8/5/16.
 */
public class PersonBuilder {


    private String uid;
    private List<String> groups;
    private String firstName;
    private String lastName;

    public PersonBuilder setUid(String uid) {
        this.uid = uid;
        return this;
    }

    public PersonBuilder setGroups(List<String> groups) {
        this.groups = groups;
        return this;
    }

    public PersonBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

//        public void setMap(Map<String, List<String>> map) {
//
//            if (map.containsKey("uid")) {
//                uid = map.get("uid").get(0);
//            }
//
//            if (map.containsKey("groups")) {
//                groups = map.get("groups");
//            }
//
//            if (map.containsKey("firstName")) {
//                firstName = map.get("firstName").get(0);
//            }
//
//            if (map.containsKey("lastName")) {
//                lastName = map.get("lastName").get(0);
//            }
//        }

    public Person build() {
        Name name = new Name(firstName, lastName);
        return new Person(uid, name, groups);
    }
    
}
