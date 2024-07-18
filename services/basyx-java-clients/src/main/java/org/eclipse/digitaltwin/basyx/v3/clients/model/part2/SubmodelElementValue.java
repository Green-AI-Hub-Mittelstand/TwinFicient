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

package org.eclipse.digitaltwin.basyx.v3.clients.model.part2;

import java.util.Objects;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.EntityType;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Key;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.ReferenceTypes;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.AnnotatedRelationshipElementValue;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.BasicEventElementValue;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.BlobValue;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.EntityValue;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.FileValue;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.PropertyValue;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.RangeValue;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.ReferenceValue;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.RelationshipElementValue;
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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:09.185125100+01:00[Europe/Berlin]")
@JsonDeserialize(using = SubmodelElementValue.SubmodelElementValueDeserializer.class)
@JsonSerialize(using = SubmodelElementValue.SubmodelElementValueSerializer.class)
public class SubmodelElementValue extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(SubmodelElementValue.class.getName());

    public static class SubmodelElementValueSerializer extends StdSerializer<SubmodelElementValue> {
        public SubmodelElementValueSerializer(Class<SubmodelElementValue> t) {
            super(t);
        }

        public SubmodelElementValueSerializer() {
            this(null);
        }

        @Override
        public void serialize(SubmodelElementValue value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
            jgen.writeObject(value.getActualInstance());
        }
    }

    public static class SubmodelElementValueDeserializer extends StdDeserializer<SubmodelElementValue> {
        public SubmodelElementValueDeserializer() {
            this(SubmodelElementValue.class);
        }

        public SubmodelElementValueDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public SubmodelElementValue deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            JsonNode tree = jp.readValueAsTree();
            Object deserialized = null;
            boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
            int match = 0;
            JsonToken token = tree.traverse(jp.getCodec()).nextToken();
            // deserialize AnnotatedRelationshipElementValue
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (AnnotatedRelationshipElementValue.class.equals(Integer.class) || AnnotatedRelationshipElementValue.class.equals(Long.class) || AnnotatedRelationshipElementValue.class.equals(Float.class) || AnnotatedRelationshipElementValue.class.equals(Double.class) || AnnotatedRelationshipElementValue.class.equals(Boolean.class) || AnnotatedRelationshipElementValue.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((AnnotatedRelationshipElementValue.class.equals(Integer.class) || AnnotatedRelationshipElementValue.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((AnnotatedRelationshipElementValue.class.equals(Float.class) || AnnotatedRelationshipElementValue.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (AnnotatedRelationshipElementValue.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (AnnotatedRelationshipElementValue.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                    }
                }
                if (attemptParsing) {
                    deserialized = tree.traverse(jp.getCodec()).readValueAs(AnnotatedRelationshipElementValue.class);
                    // TODO: there is no validation against JSON schema constraints
                    // (min, max, enum, pattern...), this does not perform a strict JSON
                    // validation, which means the 'match' count may be higher than it should be.
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'AnnotatedRelationshipElementValue'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'AnnotatedRelationshipElementValue'", e);
            }

            // deserialize BasicEventElementValue
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (BasicEventElementValue.class.equals(Integer.class) || BasicEventElementValue.class.equals(Long.class) || BasicEventElementValue.class.equals(Float.class) || BasicEventElementValue.class.equals(Double.class) || BasicEventElementValue.class.equals(Boolean.class) || BasicEventElementValue.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((BasicEventElementValue.class.equals(Integer.class) || BasicEventElementValue.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((BasicEventElementValue.class.equals(Float.class) || BasicEventElementValue.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (BasicEventElementValue.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (BasicEventElementValue.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                    }
                }
                if (attemptParsing) {
                    deserialized = tree.traverse(jp.getCodec()).readValueAs(BasicEventElementValue.class);
                    // TODO: there is no validation against JSON schema constraints
                    // (min, max, enum, pattern...), this does not perform a strict JSON
                    // validation, which means the 'match' count may be higher than it should be.
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'BasicEventElementValue'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'BasicEventElementValue'", e);
            }

            // deserialize BlobValue
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (BlobValue.class.equals(Integer.class) || BlobValue.class.equals(Long.class) || BlobValue.class.equals(Float.class) || BlobValue.class.equals(Double.class) || BlobValue.class.equals(Boolean.class) || BlobValue.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((BlobValue.class.equals(Integer.class) || BlobValue.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((BlobValue.class.equals(Float.class) || BlobValue.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (BlobValue.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (BlobValue.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                    }
                }
                if (attemptParsing) {
                    deserialized = tree.traverse(jp.getCodec()).readValueAs(BlobValue.class);
                    // TODO: there is no validation against JSON schema constraints
                    // (min, max, enum, pattern...), this does not perform a strict JSON
                    // validation, which means the 'match' count may be higher than it should be.
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'BlobValue'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'BlobValue'", e);
            }

            // deserialize EntityValue
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (EntityValue.class.equals(Integer.class) || EntityValue.class.equals(Long.class) || EntityValue.class.equals(Float.class) || EntityValue.class.equals(Double.class) || EntityValue.class.equals(Boolean.class) || EntityValue.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((EntityValue.class.equals(Integer.class) || EntityValue.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((EntityValue.class.equals(Float.class) || EntityValue.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (EntityValue.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (EntityValue.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                    }
                }
                if (attemptParsing) {
                    deserialized = tree.traverse(jp.getCodec()).readValueAs(EntityValue.class);
                    // TODO: there is no validation against JSON schema constraints
                    // (min, max, enum, pattern...), this does not perform a strict JSON
                    // validation, which means the 'match' count may be higher than it should be.
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'EntityValue'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'EntityValue'", e);
            }

            // deserialize FileValue
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (FileValue.class.equals(Integer.class) || FileValue.class.equals(Long.class) || FileValue.class.equals(Float.class) || FileValue.class.equals(Double.class) || FileValue.class.equals(Boolean.class) || FileValue.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((FileValue.class.equals(Integer.class) || FileValue.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((FileValue.class.equals(Float.class) || FileValue.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (FileValue.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (FileValue.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                    }
                }
                if (attemptParsing) {
                    deserialized = tree.traverse(jp.getCodec()).readValueAs(FileValue.class);
                    // TODO: there is no validation against JSON schema constraints
                    // (min, max, enum, pattern...), this does not perform a strict JSON
                    // validation, which means the 'match' count may be higher than it should be.
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'FileValue'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'FileValue'", e);
            }

            // deserialize Object
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (Object.class.equals(Integer.class) || Object.class.equals(Long.class) || Object.class.equals(Float.class) || Object.class.equals(Double.class) || Object.class.equals(Boolean.class) || Object.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((Object.class.equals(Integer.class) || Object.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((Object.class.equals(Float.class) || Object.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (Object.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (Object.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                    }
                }
                if (attemptParsing) {
                    deserialized = tree.traverse(jp.getCodec()).readValueAs(Object.class);
                    // TODO: there is no validation against JSON schema constraints
                    // (min, max, enum, pattern...), this does not perform a strict JSON
                    // validation, which means the 'match' count may be higher than it should be.
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'Object'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'Object'", e);
            }

            // deserialize PropertyValue
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (PropertyValue.class.equals(Integer.class) || PropertyValue.class.equals(Long.class) || PropertyValue.class.equals(Float.class) || PropertyValue.class.equals(Double.class) || PropertyValue.class.equals(Boolean.class) || PropertyValue.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((PropertyValue.class.equals(Integer.class) || PropertyValue.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((PropertyValue.class.equals(Float.class) || PropertyValue.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (PropertyValue.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (PropertyValue.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                    }
                }
                if (attemptParsing) {
                    deserialized = tree.traverse(jp.getCodec()).readValueAs(PropertyValue.class);
                    // TODO: there is no validation against JSON schema constraints
                    // (min, max, enum, pattern...), this does not perform a strict JSON
                    // validation, which means the 'match' count may be higher than it should be.
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'PropertyValue'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'PropertyValue'", e);
            }

            // deserialize RangeValue
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (RangeValue.class.equals(Integer.class) || RangeValue.class.equals(Long.class) || RangeValue.class.equals(Float.class) || RangeValue.class.equals(Double.class) || RangeValue.class.equals(Boolean.class) || RangeValue.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((RangeValue.class.equals(Integer.class) || RangeValue.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((RangeValue.class.equals(Float.class) || RangeValue.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (RangeValue.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (RangeValue.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                    }
                }
                if (attemptParsing) {
                    deserialized = tree.traverse(jp.getCodec()).readValueAs(RangeValue.class);
                    // TODO: there is no validation against JSON schema constraints
                    // (min, max, enum, pattern...), this does not perform a strict JSON
                    // validation, which means the 'match' count may be higher than it should be.
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'RangeValue'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'RangeValue'", e);
            }

            // deserialize ReferenceValue
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (ReferenceValue.class.equals(Integer.class) || ReferenceValue.class.equals(Long.class) || ReferenceValue.class.equals(Float.class) || ReferenceValue.class.equals(Double.class) || ReferenceValue.class.equals(Boolean.class) || ReferenceValue.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((ReferenceValue.class.equals(Integer.class) || ReferenceValue.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((ReferenceValue.class.equals(Float.class) || ReferenceValue.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (ReferenceValue.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (ReferenceValue.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                    }
                }
                if (attemptParsing) {
                    deserialized = tree.traverse(jp.getCodec()).readValueAs(ReferenceValue.class);
                    // TODO: there is no validation against JSON schema constraints
                    // (min, max, enum, pattern...), this does not perform a strict JSON
                    // validation, which means the 'match' count may be higher than it should be.
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'ReferenceValue'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'ReferenceValue'", e);
            }

            // deserialize RelationshipElementValue
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (RelationshipElementValue.class.equals(Integer.class) || RelationshipElementValue.class.equals(Long.class) || RelationshipElementValue.class.equals(Float.class) || RelationshipElementValue.class.equals(Double.class) || RelationshipElementValue.class.equals(Boolean.class) || RelationshipElementValue.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((RelationshipElementValue.class.equals(Integer.class) || RelationshipElementValue.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((RelationshipElementValue.class.equals(Float.class) || RelationshipElementValue.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (RelationshipElementValue.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (RelationshipElementValue.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                    }
                }
                if (attemptParsing) {
                    deserialized = tree.traverse(jp.getCodec()).readValueAs(RelationshipElementValue.class);
                    // TODO: there is no validation against JSON schema constraints
                    // (min, max, enum, pattern...), this does not perform a strict JSON
                    // validation, which means the 'match' count may be higher than it should be.
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'RelationshipElementValue'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'RelationshipElementValue'", e);
            }

            if (match == 1) {
                SubmodelElementValue ret = new SubmodelElementValue();
                ret.setActualInstance(deserialized);
                return ret;
            }
            throw new IOException(String.format("Failed deserialization for SubmodelElementValue: %d classes match result, expected 1", match));
        }

        /**
         * Handle deserialization of the 'null' value.
         */
        @Override
        public SubmodelElementValue getNullValue(DeserializationContext ctxt) throws JsonMappingException {
            throw new JsonMappingException(ctxt.getParser(), "SubmodelElementValue cannot be null");
        }
    }

    // store a list of schema names defined in oneOf
    public static final Map<String, Class<?>> schemas = new HashMap<>();

    public SubmodelElementValue() {
        super("oneOf", Boolean.FALSE);
    }

    public SubmodelElementValue(AnnotatedRelationshipElementValue o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public SubmodelElementValue(BasicEventElementValue o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public SubmodelElementValue(BlobValue o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public SubmodelElementValue(EntityValue o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public SubmodelElementValue(FileValue o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public SubmodelElementValue(Object o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public SubmodelElementValue(PropertyValue o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public SubmodelElementValue(RangeValue o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public SubmodelElementValue(ReferenceValue o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public SubmodelElementValue(RelationshipElementValue o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("AnnotatedRelationshipElementValue", AnnotatedRelationshipElementValue.class);
        schemas.put("BasicEventElementValue", BasicEventElementValue.class);
        schemas.put("BlobValue", BlobValue.class);
        schemas.put("EntityValue", EntityValue.class);
        schemas.put("FileValue", FileValue.class);
        schemas.put("Object", Object.class);
        schemas.put("PropertyValue", PropertyValue.class);
        schemas.put("RangeValue", RangeValue.class);
        schemas.put("ReferenceValue", ReferenceValue.class);
        schemas.put("RelationshipElementValue", RelationshipElementValue.class);
        JSON.registerDescendants(SubmodelElementValue.class, Collections.unmodifiableMap(schemas));
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return SubmodelElementValue.schemas;
    }

    /**
     * Set the instance that matches the oneOf child schema, check
     * the instance parameter is valid against the oneOf child schemas:
     * AnnotatedRelationshipElementValue, BasicEventElementValue, BlobValue, EntityValue, FileValue, Object, PropertyValue, RangeValue, ReferenceValue, RelationshipElementValue
     *
     * It could be an instance of the 'oneOf' schemas.
     * The oneOf child schemas may themselves be a composed schema (allOf, anyOf, oneOf).
     */
    @Override
    public void setActualInstance(Object instance) {
        if (JSON.isInstanceOf(AnnotatedRelationshipElementValue.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(BasicEventElementValue.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(BlobValue.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(EntityValue.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(FileValue.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(Object.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(PropertyValue.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(RangeValue.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(ReferenceValue.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(RelationshipElementValue.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be AnnotatedRelationshipElementValue, BasicEventElementValue, BlobValue, EntityValue, FileValue, Object, PropertyValue, RangeValue, ReferenceValue, RelationshipElementValue");
    }

    /**
     * Get the actual instance, which can be the following:
     * AnnotatedRelationshipElementValue, BasicEventElementValue, BlobValue, EntityValue, FileValue, Object, PropertyValue, RangeValue, ReferenceValue, RelationshipElementValue
     *
     * @return The actual instance (AnnotatedRelationshipElementValue, BasicEventElementValue, BlobValue, EntityValue, FileValue, Object, PropertyValue, RangeValue, ReferenceValue, RelationshipElementValue)
     */
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `AnnotatedRelationshipElementValue`. If the actual instance is not `AnnotatedRelationshipElementValue`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `AnnotatedRelationshipElementValue`
     * @throws ClassCastException if the instance is not `AnnotatedRelationshipElementValue`
     */
    public AnnotatedRelationshipElementValue getAnnotatedRelationshipElementValue() throws ClassCastException {
        return (AnnotatedRelationshipElementValue)super.getActualInstance();
    }

    /**
     * Get the actual instance of `BasicEventElementValue`. If the actual instance is not `BasicEventElementValue`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `BasicEventElementValue`
     * @throws ClassCastException if the instance is not `BasicEventElementValue`
     */
    public BasicEventElementValue getBasicEventElementValue() throws ClassCastException {
        return (BasicEventElementValue)super.getActualInstance();
    }

    /**
     * Get the actual instance of `BlobValue`. If the actual instance is not `BlobValue`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `BlobValue`
     * @throws ClassCastException if the instance is not `BlobValue`
     */
    public BlobValue getBlobValue() throws ClassCastException {
        return (BlobValue)super.getActualInstance();
    }

    /**
     * Get the actual instance of `EntityValue`. If the actual instance is not `EntityValue`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `EntityValue`
     * @throws ClassCastException if the instance is not `EntityValue`
     */
    public EntityValue getEntityValue() throws ClassCastException {
        return (EntityValue)super.getActualInstance();
    }

    /**
     * Get the actual instance of `FileValue`. If the actual instance is not `FileValue`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `FileValue`
     * @throws ClassCastException if the instance is not `FileValue`
     */
    public FileValue getFileValue() throws ClassCastException {
        return (FileValue)super.getActualInstance();
    }

    /**
     * Get the actual instance of `Object`. If the actual instance is not `Object`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `Object`
     * @throws ClassCastException if the instance is not `Object`
     */
    public Object getObject() throws ClassCastException {
        return (Object)super.getActualInstance();
    }

    /**
     * Get the actual instance of `PropertyValue`. If the actual instance is not `PropertyValue`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `PropertyValue`
     * @throws ClassCastException if the instance is not `PropertyValue`
     */
    public PropertyValue getPropertyValue() throws ClassCastException {
        return (PropertyValue)super.getActualInstance();
    }

    /**
     * Get the actual instance of `RangeValue`. If the actual instance is not `RangeValue`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `RangeValue`
     * @throws ClassCastException if the instance is not `RangeValue`
     */
    public RangeValue getRangeValue() throws ClassCastException {
        return (RangeValue)super.getActualInstance();
    }

    /**
     * Get the actual instance of `ReferenceValue`. If the actual instance is not `ReferenceValue`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `ReferenceValue`
     * @throws ClassCastException if the instance is not `ReferenceValue`
     */
    public ReferenceValue getReferenceValue() throws ClassCastException {
        return (ReferenceValue)super.getActualInstance();
    }

    /**
     * Get the actual instance of `RelationshipElementValue`. If the actual instance is not `RelationshipElementValue`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `RelationshipElementValue`
     * @throws ClassCastException if the instance is not `RelationshipElementValue`
     */
    public RelationshipElementValue getRelationshipElementValue() throws ClassCastException {
        return (RelationshipElementValue)super.getActualInstance();
    }



}

