package sk.laslofi.entityService.models;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BaseEntityTest {

    Map<String, Object> makeEntityMap(String id, Object subEntities, Object data) {
        Map<String,Object> entityMap = new HashMap<>();
        entityMap.put("id", id);
        entityMap.put("subEntities", subEntities);
        entityMap.put("data", data);
        return entityMap;
    }

    @Test
    public void mapConstructorTest() {
        Map<String,Object> subEnt1 = new HashMap<>();

        List<Map<String, Object>> expectedSubEntities = Arrays.asList(
                makeEntityMap("id1", Collections.EMPTY_LIST, Collections.EMPTY_MAP),
                makeEntityMap("id2", Collections.EMPTY_LIST, Collections.EMPTY_MAP)
        );

        Map<String,Object> entityMap = makeEntityMap("root-entity-id", expectedSubEntities, Collections.EMPTY_MAP);
        Entity entity = new BaseEntity(entityMap);

        assertNotNull(entity);
        assertEquals("root-entity-id", entity.getId());

        Set<Entity> actualSubEntities = entity.getSubEntities();
        assertEquals(2, actualSubEntities.size());

        Set<String> expectedSubEntitiesIds = expectedSubEntities.stream()
                .map(em -> (String) em.get("id"))
                .collect(Collectors.toSet());
        Set<String> actualSubEntitiesIds = actualSubEntities.stream()
                .map(Entity::getId).collect(Collectors.toSet());
        assertEquals(expectedSubEntitiesIds, actualSubEntitiesIds);

    }
}