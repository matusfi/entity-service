package sk.laslofi.entityService.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public abstract class AbstractEntity implements Entity {
    protected String id;
    protected Map<String, Entity> subEntities;
    protected Map<String, Object> data;

    private static final Collector<Entity, ?, Map<String,Entity>> entityIndexingCollector = Collectors.toMap(Entity::getId, Function.identity());

    public AbstractEntity() {}

    public AbstractEntity(final String id, final Set<Entity> subEntities, final Map<String, Object> data) {
        this.id = id;
        this.subEntities = subEntities.stream().collect(entityIndexingCollector);
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public Set<Entity> getSubEntities() {
        Collection<Entity> subEntitiesValues = this.subEntities.values();
        if (subEntitiesValues.isEmpty()) {
            return new HashSet<>();
        } else {
            return new HashSet<>(subEntitiesValues);
        }
    }

    public Map<String, Object> getData() {
        return data;
    }
}
