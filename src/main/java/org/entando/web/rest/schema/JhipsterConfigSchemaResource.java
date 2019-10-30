

package org.entando.web.rest.schema;

import org.entando.config.JhipsterConfig;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kjetland.jackson.jsonSchema.JsonSchemaGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/schemas/application")
public class JhipsterConfigSchemaResource {

    private final Logger log = LoggerFactory.getLogger(JhipsterConfigSchemaResource.class);

    @GetMapping(produces = "application/schema+json")
    public String getJsonSchemaFormConfiguration() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        JsonSchemaGenerator jsonSchemaGenerator = new JsonSchemaGenerator(objectMapper);

        JsonNode jsonSchema = jsonSchemaGenerator.generateJsonSchema(JhipsterConfig.class);

        return objectMapper.writeValueAsString(jsonSchema);
    }
}