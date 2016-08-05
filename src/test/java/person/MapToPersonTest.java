package person;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class MapToPersonTest {

    private ObjectMapper mapper;

    private Map<String, List<String>> map;

    @Before
    public void setUp() throws Exception {

        mapper = new ObjectMapper();

        map = new HashMap<String, List<String>>() {{
            put("uid", new ArrayList<String>() {{
                add("1234567890");
            }});

            put("groups", new ArrayList<String>() {{
                add("Group 1");
                add("Group 2");
                add("Group 3");
            }});

            put("firstName", new ArrayList<String>() {{
                add("John");
            }});

            put("lastName", new ArrayList<String>() {{
                add("Doe");
            }});
        }};
    }

    @Test
    public void test() {

        Person person = mapper.convertValue(map, Person.class);

        return;
    }


    @After
    public void tearDown() throws Exception {
        mapper = null;
        map = null;
    }

}
