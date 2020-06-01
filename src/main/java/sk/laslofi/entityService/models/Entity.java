package sk.laslofi.entityService.models;

import java.util.Map;
import java.util.Set;

public interface Entity {

    /**
     * @return a unique identifier
     */
    String getId();

    /**
     * @return the sub-entities of this entity
     */
    Set<Entity> getSubEntities();

    /**
     * @return a set of key-value data belonging to this entity
     */
    Map<String, Object> getData();
}