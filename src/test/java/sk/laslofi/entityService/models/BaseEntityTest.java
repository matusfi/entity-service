package sk.laslofi.entityService.models;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BaseEntityTest {

    Map<String, Object> makeEntityMap(String id, Object subEntities, Object data) {
        Map<String,Object> entityMap = new HashMap<String, Object>();
        entityMap.put("id", id);
        entityMap.put("subEntities", subEntities);
        entityMap.put("data", data);
        return entityMap;
    }

    @Test
    public void mapConstructorTest() {
        Map<String,Object> subEnt1 = new HashMap<>();

        Object subEntities = Arrays.asList(
                makeEntityMap("id1", Collections.EMPTY_SET, Collections.EMPTY_MAP),
                makeEntityMap("id2", Collections.EMPTY_SET, Collections.EMPTY_MAP)
        );

        Map<String,Object> entityMap = makeEntityMap("root-entity-id", subEntities, Collections.EMPTY_MAP);
        Entity entity = new BaseEntity(entityMap);

        assertNotNull(entity);
        assertEquals("root-entity-id", entity.getId());
        assertEquals(2, entity.getSubEntities().size());
    }
}