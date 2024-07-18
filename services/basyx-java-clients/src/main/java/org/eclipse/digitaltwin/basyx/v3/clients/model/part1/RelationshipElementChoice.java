/*******************************************************************************
 * Copyright (C) 2023 DFKI GmbH (https://www.dfki.de/en/web)
 * 
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 * SPDX-License-Identifier: MIT
 ******************************************************************************/

package org.eclipse.digitaltwin.basyx.v3.clients.model.part1;

import java.util.Objects;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.AnnotatedRelationshipElement;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.DataElementChoice;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.EmbeddedDataSpecification;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Extension;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.LangStringNameType;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.LangStringTextType;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Qualifier;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Reference;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.RelationshipElement;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.eclipse.digitaltwin.basyx.v3.clients.JSON;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:07.399784100+01:00[Europe/Berlin]")
@JsonDeserialize(using = RelationshipElementChoice.RelationshipElementChoiceDeserializer.class)
@JsonSerialize(using = RelationshipElementChoice.RelationshipElementChoiceSerializer.class)
public class RelationshipElementChoice extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(RelationshipElementChoice.class.getName());

    public static class RelationshipElementChoiceSerializer extends StdSerializer<RelationshipElementChoice> {
        public RelationshipElementChoiceSerializer(Class<RelationshipElementChoice> t) {
            super(t);
        }

        public RelationshipElementChoiceSerializer() {
            this(null);
        }

        @Override
        public void serialize(RelationshipElementChoice value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
            jgen.writeObject(value.getActualInstance());
        }
    }

    public static class RelationshipElementChoiceDeserializer extends StdDeserializer<RelationshipElementChoice> {
        public RelationshipElementChoiceDeserializer() {
            this(RelationshipElementChoice.class);
        }

        public RelationshipElementChoiceDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public RelationshipElementChoice deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            JsonNode tree = jp.readValueAsTree();
            Object deserialized = null;
            boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
            int match = 0;
            JsonToken token = tree.traverse(jp.getCodec()).nextToken();
            // deserialize AnnotatedRelationshipElement
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (AnnotatedRelationshipElement.class.equals(Integer.class) || AnnotatedRelationshipElement.class.equals(Long.class) || AnnotatedRelationshipElement.class.equals(Float.class) || AnnotatedRelationshipElement.class.equals(Double.class) || AnnotatedRelationshipElement.class.equals(Boolean.class) || AnnotatedRelationshipElement.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((AnnotatedRelationshipElement.class.equals(Integer.class) || AnnotatedRelationshipElement.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((AnnotatedRelationshipElement.class.equals(Float.class) || AnnotatedRelationshipElement.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (AnnotatedRelationshipElement.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (AnnotatedRelationshipElement.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                    }
                }
                if (attemptParsing) {
                    deserialized = tree.traverse(jp.getCodec()).readValueAs(AnnotatedRelationshipElement.class);
                    // TODO: there is no validation against JSON schema constraints
                    // (min, max, enum, pattern...), this does not perform a strict JSON
                    // validation, which means the 'match' count may be higher than it should be.
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'AnnotatedRelationshipElement'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'AnnotatedRelationshipElement'", e);
            }

            // deserialize RelationshipElement
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (RelationshipElement.class.equals(Integer.class) || RelationshipElement.class.equals(Long.class) || RelationshipElement.class.equals(Float.class) || RelationshipElement.class.equals(Double.class) || RelationshipElement.class.equals(Boolean.class) || RelationshipElement.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((RelationshipElement.class.equals(Integer.class) || RelationshipElement.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((RelationshipElement.class.equals(Float.class) || RelationshipElement.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (RelationshipElement.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (RelationshipElement.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                    }
                }
                if (attemptParsing) {
                    deserialized = tree.traverse(jp.getCodec()).readValueAs(RelationshipElement.class);
                    // TODO: there is no validation against JSON schema constraints
                    // (min, max, enum, pattern...), this does not perform a strict JSON
                    // validation, which means the 'match' count may be higher than it should be.
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'RelationshipElement'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'RelationshipElement'", e);
            }

            if (match == 1) {
                RelationshipElementChoice ret = new RelationshipElementChoice();
                ret.setActualInstance(deserialized);
                return ret;
            }
            throw new IOException(String.format("Failed deserialization for RelationshipElementChoice: %d classes match result, expected 1", match));
        }

        /**
         * Handle deserialization of the 'null' value.
         */
        @Override
        public RelationshipElementChoice getNullValue(DeserializationContext ctxt) throws JsonMappingException {
            throw new JsonMappingException(ctxt.getParser(), "RelationshipElementChoice cannot be null");
        }
    }

    // store a list of schema names defined in oneOf
    public static final Map<String, Class<?>> schemas = new HashMap<>();

    public RelationshipElementChoice() {
        super("oneOf", Boolean.FALSE);
    }

    public RelationshipElementChoice(AnnotatedRelationshipElement o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public RelationshipElementChoice(RelationshipElement o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("AnnotatedRelationshipElement", AnnotatedRelationshipElement.class);
        schemas.put("RelationshipElement", RelationshipElement.class);
        JSON.registerDescendants(RelationshipElementChoice.class, Collections.unmodifiableMap(schemas));
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return RelationshipElementChoice.schemas;
    }

    /**
     * Set the instance that matches the oneOf child schema, check
     * the instance parameter is valid against the oneOf child schemas:
     * AnnotatedRelationshipElement, RelationshipElement
     *
     * It could be an instance of the 'oneOf' schemas.
     * The oneOf child schemas may themselves be a composed schema (allOf, anyOf, oneOf).
     */
    @Override
    public void setActualInstance(Object instance) {
        if (JSON.isInstanceOf(AnnotatedRelationshipElement.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(RelationshipElement.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be AnnotatedRelationshipElement, RelationshipElement");
    }

    /**
     * Get the actual instance, which can be the following:
     * AnnotatedRelationshipElement, RelationshipElement
     *
     * @return The actual instance (AnnotatedRelationshipElement, RelationshipElement)
     */
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `AnnotatedRelationshipElement`. If the actual instance is not `AnnotatedRelationshipElement`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `AnnotatedRelationshipElement`
     * @throws ClassCastException if the instance is not `AnnotatedRelationshipElement`
     */
    public AnnotatedRelationshipElement getAnnotatedRelationshipElement() throws ClassCastException {
        return (AnnotatedRelationshipElement)super.getActualInstance();
    }

    /**
     * Get the actual instance of `RelationshipElement`. If the actual instance is not `RelationshipElement`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `RelationshipElement`
     * @throws ClassCastException if the instance is not `RelationshipElement`
     */
    public RelationshipElement getRelationshipElement() throws ClassCastException {
        return (RelationshipElement)super.getActualInstance();
    }



}

