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
import java.math.BigDecimal;
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
@JsonDeserialize(using = PropertyValue.PropertyValueDeserializer.class)
@JsonSerialize(using = PropertyValue.PropertyValueSerializer.class)
public class PropertyValue extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(PropertyValue.class.getName());

    public static class PropertyValueSerializer extends StdSerializer<PropertyValue> {
        public PropertyValueSerializer(Class<PropertyValue> t) {
            super(t);
        }

        public PropertyValueSerializer() {
            this(null);
        }

        @Override
        public void serialize(PropertyValue value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
            jgen.writeObject(value.getActualInstance());
        }
    }

    public static class PropertyValueDeserializer extends StdDeserializer<PropertyValue> {
        public PropertyValueDeserializer() {
            this(PropertyValue.class);
        }

        public PropertyValueDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public PropertyValue deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            JsonNode tree = jp.readValueAsTree();
            Object deserialized = null;
            boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
            int match = 0;
            JsonToken token = tree.traverse(jp.getCodec()).nextToken();
            // deserialize BigDecimal
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (BigDecimal.class.equals(Integer.class) || BigDecimal.class.equals(Long.class) || BigDecimal.class.equals(Float.class) || BigDecimal.class.equals(Double.class) || BigDecimal.class.equals(Boolean.class) || BigDecimal.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((BigDecimal.class.equals(Integer.class) || BigDecimal.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((BigDecimal.class.equals(Float.class) || BigDecimal.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (BigDecimal.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (BigDecimal.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                    }
                }
                if (attemptParsing) {
                    deserialized = tree.traverse(jp.getCodec()).readValueAs(BigDecimal.class);
                    // TODO: there is no validation against JSON schema constraints
                    // (min, max, enum, pattern...), this does not perform a strict JSON
                    // validation, which means the 'match' count may be higher than it should be.
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'BigDecimal'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'BigDecimal'", e);
            }

            // deserialize Boolean
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (Boolean.class.equals(Integer.class) || Boolean.class.equals(Long.class) || Boolean.class.equals(Float.class) || Boolean.class.equals(Double.class) || Boolean.class.equals(Boolean.class) || Boolean.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((Boolean.class.equals(Integer.class) || Boolean.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((Boolean.class.equals(Float.class) || Boolean.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (Boolean.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (Boolean.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                    }
                }
                if (attemptParsing) {
                    deserialized = tree.traverse(jp.getCodec()).readValueAs(Boolean.class);
                    // TODO: there is no validation against JSON schema constraints
                    // (min, max, enum, pattern...), this does not perform a strict JSON
                    // validation, which means the 'match' count may be higher than it should be.
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'Boolean'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'Boolean'", e);
            }

            // deserialize String
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (String.class.equals(Integer.class) || String.class.equals(Long.class) || String.class.equals(Float.class) || String.class.equals(Double.class) || String.class.equals(Boolean.class) || String.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((String.class.equals(Integer.class) || String.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((String.class.equals(Float.class) || String.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (String.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (String.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                    }
                }
                if (attemptParsing) {
                    deserialized = tree.traverse(jp.getCodec()).readValueAs(String.class);
                    // TODO: there is no validation against JSON schema constraints
                    // (min, max, enum, pattern...), this does not perform a strict JSON
                    // validation, which means the 'match' count may be higher than it should be.
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'String'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'String'", e);
            }

            if (match == 1) {
                PropertyValue ret = new PropertyValue();
                ret.setActualInstance(deserialized);
                return ret;
            }
            throw new IOException(String.format("Failed deserialization for PropertyValue: %d classes match result, expected 1", match));
        }

        /**
         * Handle deserialization of the 'null' value.
         */
        @Override
        public PropertyValue getNullValue(DeserializationContext ctxt) throws JsonMappingException {
            throw new JsonMappingException(ctxt.getParser(), "PropertyValue cannot be null");
        }
    }

    // store a list of schema names defined in oneOf
    public static final Map<String, Class<?>> schemas = new HashMap<>();

    public PropertyValue() {
        super("oneOf", Boolean.FALSE);
    }

    public PropertyValue(BigDecimal o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public PropertyValue(Boolean o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public PropertyValue(String o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("BigDecimal", BigDecimal.class);
        schemas.put("Boolean", Boolean.class);
        schemas.put("String", String.class);
        JSON.registerDescendants(PropertyValue.class, Collections.unmodifiableMap(schemas));
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return PropertyValue.schemas;
    }

    /**
     * Set the instance that matches the oneOf child schema, check
     * the instance parameter is valid against the oneOf child schemas:
     * BigDecimal, Boolean, String
     *
     * It could be an instance of the 'oneOf' schemas.
     * The oneOf child schemas may themselves be a composed schema (allOf, anyOf, oneOf).
     */
    @Override
    public void setActualInstance(Object instance) {
        if (JSON.isInstanceOf(BigDecimal.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(Boolean.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(String.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be BigDecimal, Boolean, String");
    }

    /**
     * Get the actual instance, which can be the following:
     * BigDecimal, Boolean, String
     *
     * @return The actual instance (BigDecimal, Boolean, String)
     */
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `BigDecimal`. If the actual instance is not `BigDecimal`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `BigDecimal`
     * @throws ClassCastException if the instance is not `BigDecimal`
     */
    public BigDecimal getBigDecimal() throws ClassCastException {
        return (BigDecimal)super.getActualInstance();
    }

    /**
     * Get the actual instance of `Boolean`. If the actual instance is not `Boolean`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `Boolean`
     * @throws ClassCastException if the instance is not `Boolean`
     */
    public Boolean getBoolean() throws ClassCastException {
        return (Boolean)super.getActualInstance();
    }

    /**
     * Get the actual instance of `String`. If the actual instance is not `String`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `String`
     * @throws ClassCastException if the instance is not `String`
     */
    public String getString() throws ClassCastException {
        return (String)super.getActualInstance();
    }



}

