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
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Blob;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.DataTypeDefXsd;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.EmbeddedDataSpecification;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Extension;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.LangStringNameType;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.LangStringTextType;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.ModelFile;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.MultiLanguageProperty;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Property;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Qualifier;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Range;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Reference;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.ReferenceElement;
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
@JsonDeserialize(using = DataElementChoice.DataElementChoiceDeserializer.class)
@JsonSerialize(using = DataElementChoice.DataElementChoiceSerializer.class)
public class DataElementChoice extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(DataElementChoice.class.getName());

    public static class DataElementChoiceSerializer extends StdSerializer<DataElementChoice> {
        public DataElementChoiceSerializer(Class<DataElementChoice> t) {
            super(t);
        }

        public DataElementChoiceSerializer() {
            this(null);
        }

        @Override
        public void serialize(DataElementChoice value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
            jgen.writeObject(value.getActualInstance());
        }
    }

    public static class DataElementChoiceDeserializer extends StdDeserializer<DataElementChoice> {
        public DataElementChoiceDeserializer() {
            this(DataElementChoice.class);
        }

        public DataElementChoiceDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public DataElementChoice deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            JsonNode tree = jp.readValueAsTree();
            Object deserialized = null;
            boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
            int match = 0;
            JsonToken token = tree.traverse(jp.getCodec()).nextToken();
            // deserialize Blob
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (Blob.class.equals(Integer.class) || Blob.class.equals(Long.class) || Blob.class.equals(Float.class) || Blob.class.equals(Double.class) || Blob.class.equals(Boolean.class) || Blob.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((Blob.class.equals(Integer.class) || Blob.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((Blob.class.equals(Float.class) || Blob.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (Blob.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (Blob.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                    }
                }
                if (attemptParsing) {
                    deserialized = tree.traverse(jp.getCodec()).readValueAs(Blob.class);
                    // TODO: there is no validation against JSON schema constraints
                    // (min, max, enum, pattern...), this does not perform a strict JSON
                    // validation, which means the 'match' count may be higher than it should be.
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'Blob'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'Blob'", e);
            }

            // deserialize ModelFile
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (ModelFile.class.equals(Integer.class) || ModelFile.class.equals(Long.class) || ModelFile.class.equals(Float.class) || ModelFile.class.equals(Double.class) || ModelFile.class.equals(Boolean.class) || ModelFile.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((ModelFile.class.equals(Integer.class) || ModelFile.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((ModelFile.class.equals(Float.class) || ModelFile.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (ModelFile.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (ModelFile.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                    }
                }
                if (attemptParsing) {
                    deserialized = tree.traverse(jp.getCodec()).readValueAs(ModelFile.class);
                    // TODO: there is no validation against JSON schema constraints
                    // (min, max, enum, pattern...), this does not perform a strict JSON
                    // validation, which means the 'match' count may be higher than it should be.
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'ModelFile'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'ModelFile'", e);
            }

            // deserialize MultiLanguageProperty
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (MultiLanguageProperty.class.equals(Integer.class) || MultiLanguageProperty.class.equals(Long.class) || MultiLanguageProperty.class.equals(Float.class) || MultiLanguageProperty.class.equals(Double.class) || MultiLanguageProperty.class.equals(Boolean.class) || MultiLanguageProperty.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((MultiLanguageProperty.class.equals(Integer.class) || MultiLanguageProperty.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((MultiLanguageProperty.class.equals(Float.class) || MultiLanguageProperty.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (MultiLanguageProperty.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (MultiLanguageProperty.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                    }
                }
                if (attemptParsing) {
                    deserialized = tree.traverse(jp.getCodec()).readValueAs(MultiLanguageProperty.class);
                    // TODO: there is no validation against JSON schema constraints
                    // (min, max, enum, pattern...), this does not perform a strict JSON
                    // validation, which means the 'match' count may be higher than it should be.
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'MultiLanguageProperty'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'MultiLanguageProperty'", e);
            }

            // deserialize Property
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (Property.class.equals(Integer.class) || Property.class.equals(Long.class) || Property.class.equals(Float.class) || Property.class.equals(Double.class) || Property.class.equals(Boolean.class) || Property.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((Property.class.equals(Integer.class) || Property.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((Property.class.equals(Float.class) || Property.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (Property.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (Property.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                    }
                }
                if (attemptParsing) {
                    deserialized = tree.traverse(jp.getCodec()).readValueAs(Property.class);
                    // TODO: there is no validation against JSON schema constraints
                    // (min, max, enum, pattern...), this does not perform a strict JSON
                    // validation, which means the 'match' count may be higher than it should be.
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'Property'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'Property'", e);
            }

            // deserialize Range
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (Range.class.equals(Integer.class) || Range.class.equals(Long.class) || Range.class.equals(Float.class) || Range.class.equals(Double.class) || Range.class.equals(Boolean.class) || Range.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((Range.class.equals(Integer.class) || Range.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((Range.class.equals(Float.class) || Range.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (Range.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (Range.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                    }
                }
                if (attemptParsing) {
                    deserialized = tree.traverse(jp.getCodec()).readValueAs(Range.class);
                    // TODO: there is no validation against JSON schema constraints
                    // (min, max, enum, pattern...), this does not perform a strict JSON
                    // validation, which means the 'match' count may be higher than it should be.
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'Range'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'Range'", e);
            }

            // deserialize ReferenceElement
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (ReferenceElement.class.equals(Integer.class) || ReferenceElement.class.equals(Long.class) || ReferenceElement.class.equals(Float.class) || ReferenceElement.class.equals(Double.class) || ReferenceElement.class.equals(Boolean.class) || ReferenceElement.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((ReferenceElement.class.equals(Integer.class) || ReferenceElement.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((ReferenceElement.class.equals(Float.class) || ReferenceElement.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (ReferenceElement.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (ReferenceElement.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                    }
                }
                if (attemptParsing) {
                    deserialized = tree.traverse(jp.getCodec()).readValueAs(ReferenceElement.class);
                    // TODO: there is no validation against JSON schema constraints
                    // (min, max, enum, pattern...), this does not perform a strict JSON
                    // validation, which means the 'match' count may be higher than it should be.
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'ReferenceElement'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'ReferenceElement'", e);
            }

            if (match == 1) {
                DataElementChoice ret = new DataElementChoice();
                ret.setActualInstance(deserialized);
                return ret;
            }
            throw new IOException(String.format("Failed deserialization for DataElementChoice: %d classes match result, expected 1", match));
        }

        /**
         * Handle deserialization of the 'null' value.
         */
        @Override
        public DataElementChoice getNullValue(DeserializationContext ctxt) throws JsonMappingException {
            throw new JsonMappingException(ctxt.getParser(), "DataElementChoice cannot be null");
        }
    }

    // store a list of schema names defined in oneOf
    public static final Map<String, Class<?>> schemas = new HashMap<>();

    public DataElementChoice() {
        super("oneOf", Boolean.FALSE);
    }

    public DataElementChoice(Blob o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public DataElementChoice(ModelFile o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public DataElementChoice(MultiLanguageProperty o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public DataElementChoice(Property o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public DataElementChoice(Range o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public DataElementChoice(ReferenceElement o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("Blob", Blob.class);
        schemas.put("ModelFile", ModelFile.class);
        schemas.put("MultiLanguageProperty", MultiLanguageProperty.class);
        schemas.put("Property", Property.class);
        schemas.put("Range", Range.class);
        schemas.put("ReferenceElement", ReferenceElement.class);
        JSON.registerDescendants(DataElementChoice.class, Collections.unmodifiableMap(schemas));
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return DataElementChoice.schemas;
    }

    /**
     * Set the instance that matches the oneOf child schema, check
     * the instance parameter is valid against the oneOf child schemas:
     * Blob, ModelFile, MultiLanguageProperty, Property, Range, ReferenceElement
     *
     * It could be an instance of the 'oneOf' schemas.
     * The oneOf child schemas may themselves be a composed schema (allOf, anyOf, oneOf).
     */
    @Override
    public void setActualInstance(Object instance) {
        if (JSON.isInstanceOf(Blob.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(ModelFile.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(MultiLanguageProperty.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(Property.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(Range.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(ReferenceElement.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be Blob, ModelFile, MultiLanguageProperty, Property, Range, ReferenceElement");
    }

    /**
     * Get the actual instance, which can be the following:
     * Blob, ModelFile, MultiLanguageProperty, Property, Range, ReferenceElement
     *
     * @return The actual instance (Blob, ModelFile, MultiLanguageProperty, Property, Range, ReferenceElement)
     */
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `Blob`. If the actual instance is not `Blob`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `Blob`
     * @throws ClassCastException if the instance is not `Blob`
     */
    public Blob getBlob() throws ClassCastException {
        return (Blob)super.getActualInstance();
    }

    /**
     * Get the actual instance of `ModelFile`. If the actual instance is not `ModelFile`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `ModelFile`
     * @throws ClassCastException if the instance is not `ModelFile`
     */
    public ModelFile getModelFile() throws ClassCastException {
        return (ModelFile)super.getActualInstance();
    }

    /**
     * Get the actual instance of `MultiLanguageProperty`. If the actual instance is not `MultiLanguageProperty`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `MultiLanguageProperty`
     * @throws ClassCastException if the instance is not `MultiLanguageProperty`
     */
    public MultiLanguageProperty getMultiLanguageProperty() throws ClassCastException {
        return (MultiLanguageProperty)super.getActualInstance();
    }

    /**
     * Get the actual instance of `Property`. If the actual instance is not `Property`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `Property`
     * @throws ClassCastException if the instance is not `Property`
     */
    public Property getProperty() throws ClassCastException {
        return (Property)super.getActualInstance();
    }

    /**
     * Get the actual instance of `Range`. If the actual instance is not `Range`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `Range`
     * @throws ClassCastException if the instance is not `Range`
     */
    public Range getRange() throws ClassCastException {
        return (Range)super.getActualInstance();
    }

    /**
     * Get the actual instance of `ReferenceElement`. If the actual instance is not `ReferenceElement`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `ReferenceElement`
     * @throws ClassCastException if the instance is not `ReferenceElement`
     */
    public ReferenceElement getReferenceElement() throws ClassCastException {
        return (ReferenceElement)super.getActualInstance();
    }



}

