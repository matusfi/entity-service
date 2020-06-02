# Entity Service

This is a simple RESTful implementation of a interview exercise.

### Testing
For a quick test with cURL you can use sample json requests provided in `src/test/resources/`.

For example:

```bash
# To get all entities
curl localhost:8080/services/entity-service/entities

# To add an entity
curl -X POST -H 'Content-Type: application/json' localhost:8080/services/entity-service/entities -d @src/test/resources/simple-entity.json

# To read an entity
curl localhost:8080/services/entity-service/entities/simple-entity-id
```