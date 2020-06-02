package sk.laslofi.entityService;

import io.advantageous.qbit.annotation.PathVariable;
import io.advantageous.qbit.annotation.RequestMapping;
import io.advantageous.qbit.annotation.RequestMethod;
import sk.laslofi.entityService.models.BaseEntity;
import sk.laslofi.entityService.models.Entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/entity-service")
public class EntityService {

    private final Map<String,Entity> rootEntities = new HashMap<>();

    /**
     * List all entities
     * @return a collection of entities
     */
    @RequestMapping("/entities")
    public Collection<Entity> getEntityList() {
        return rootEntities.values();
    }

    /**
     * Add an entity
     * @param entityMap JSON request body parsed as a String->Object map
     * @return the added entity or null in case of error
     */
    @RequestMapping(value = "/entities", method = RequestMethod.POST)
    public Entity addEntity(final Map<String, Object> entityMap) {
        try {
            Entity entity = new BaseEntity(entityMap);
            rootEntities.put(entity.getId(), entity);
            return entity;
        } catch (RuntimeException e) {
            // TODO find out how to return HTTP error codes and return a meaningful error here
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    /**
     * Return an entity by its ID
     * @param id of the root entity to be retrieved
     * @return the requested entity or null if not found
     */
    @RequestMapping("/entities/{id}")
    public Entity readEntity(@PathVariable("id") String id) {
        return rootEntities.get(id);
    }
}
