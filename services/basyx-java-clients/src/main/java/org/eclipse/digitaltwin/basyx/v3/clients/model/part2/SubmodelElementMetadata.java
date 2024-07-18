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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.EmbeddedDataSpecification;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Extension;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.LangStringNameType;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.LangStringTextType;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.ModelType;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.ModellingKind;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Qualifier;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Reference;
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
@JsonDeserialize(using = SubmodelElementMetadata.SubmodelElementMetadataDeserializer.class)
@JsonSerialize(using = SubmodelElementMetadata.SubmodelElementMetadataSerializer.class)
public class SubmodelElementMetadata extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(SubmodelElementMetadata.class.getName());

    public static class SubmodelElementMetadataSerializer extends StdSerializer<SubmodelElementMetadata> {
        public SubmodelElementMetadataSerializer(Class<SubmodelElementMetadata> t) {
            super(t);
        }

        public SubmodelElementMetadataSerializer() {
            this(null);
        }

        @Override
        public void serialize(SubmodelElementMetadata value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
            jgen.writeObject(value.getActualInstance());
        }
    }

    public static class SubmodelElementMetadataDeserializer extends StdDeserializer<SubmodelElementMetadata> {
        public SubmodelElementMetadataDeserializer() {
            this(SubmodelElementMetadata.class);
        }

        public SubmodelElementMetadataDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public SubmodelElementMetadata deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            JsonNode tree = jp.readValueAsTree();
            Object deserialized = null;
            boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
            int match = 0;
            JsonToken token = tree.traverse(jp.getCodec()).nextToken();
            // deserialize SubmodelElementAttributes
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (SubmodelElementAttributes.class.equals(Integer.class) || SubmodelElementAttributes.class.equals(Long.class) || SubmodelElementAttributes.class.equals(Float.class) || SubmodelElementAttributes.class.equals(Double.class) || SubmodelElementAttributes.class.equals(Boolean.class) || SubmodelElementAttributes.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((SubmodelElementAttributes.class.equals(Integer.class) || SubmodelElementAttributes.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((SubmodelElementAttributes.class.equals(Float.class) || SubmodelElementAttributes.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (SubmodelElementAttributes.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (SubmodelElementAttributes.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                    }
                }
                if (attemptParsing) {
                    deserialized = tree.traverse(jp.getCodec()).readValueAs(SubmodelElementAttributes.class);
                    // TODO: there is no validation against JSON schema constraints
                    // (min, max, enum, pattern...), this does not perform a strict JSON
                    // validation, which means the 'match' count may be higher than it should be.
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'SubmodelElementAttributes'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'SubmodelElementAttributes'", e);
            }

            if (match == 1) {
                SubmodelElementMetadata ret = new SubmodelElementMetadata();
                ret.setActualInstance(deserialized);
                return ret;
            }
            throw new IOException(String.format("Failed deserialization for SubmodelElementMetadata: %d classes match result, expected 1", match));
        }

        /**
         * Handle deserialization of the 'null' value.
         */
        @Override
        public SubmodelElementMetadata getNullValue(DeserializationContext ctxt) throws JsonMappingException {
            throw new JsonMappingException(ctxt.getParser(), "SubmodelElementMetadata cannot be null");
        }
    }

    // store a list of schema names defined in oneOf
    public static final Map<String, Class<?>> schemas = new HashMap<>();

    public SubmodelElementMetadata() {
        super("oneOf", Boolean.FALSE);
    }

    public SubmodelElementMetadata(SubmodelElementAttributes o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("SubmodelElementAttributes", SubmodelElementAttributes.class);
        JSON.registerDescendants(SubmodelElementMetadata.class, Collections.unmodifiableMap(schemas));
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return SubmodelElementMetadata.schemas;
    }

    /**
     * Set the instance that matches the oneOf child schema, check
     * the instance parameter is valid against the oneOf child schemas:
     * SubmodelElementAttributes
     *
     * It could be an instance of the 'oneOf' schemas.
     * The oneOf child schemas may themselves be a composed schema (allOf, anyOf, oneOf).
     */
    @Override
    public void setActualInstance(Object instance) {
        if (JSON.isInstanceOf(SubmodelElementAttributes.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be SubmodelElementAttributes");
    }

    /**
     * Get the actual instance, which can be the following:
     * SubmodelElementAttributes
     *
     * @return The actual instance (SubmodelElementAttributes)
     */
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `SubmodelElementAttributes`. If the actual instance is not `SubmodelElementAttributes`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `SubmodelElementAttributes`
     * @throws ClassCastException if the instance is not `SubmodelElementAttributes`
     */
    public SubmodelElementAttributes getSubmodelElementAttributes() throws ClassCastException {
        return (SubmodelElementAttributes)super.getActualInstance();
    }



}

