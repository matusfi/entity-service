package sk.laslofi.entityService.models;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BaseEntity extends AbstractEntity implements Entity {

    private static Map<String, Object> extractData(Object o) {
        if (o == null || (o instanceof Map)) {
            return (Map<String, Object>) o; // FIXME check this cast
        } else {
            throw new RuntimeException("Entity's data parameter is not a map");
        }
    }

    private static Map<String, Entity> extractSubEntities(Object o) {
        if (o != null && !(o instanceof List)) {
            throw new RuntimeException("Entity's subEntities parameter is not a list");
        }

        List<Map<String,Object>> rawSubEntities = (List<Map<String, Object>>) o; // FIXME don't just assume every element is a map
        return rawSubEntities.stream()
                .map(BaseEntity::new)
                .collect(Collectors.toMap(Entity::getId, Function.identity()));
    }

    public BaseEntity(Map<String, Object> entityMap) {
        super();

        this.id = entityMap.get("id").toString();
        this.data = extractData(entityMap.get("data"));
        this.subEntities = extractSubEntities(entityMap.get("subEntities"));
    }
}
