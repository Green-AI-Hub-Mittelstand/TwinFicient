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
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.AasSubmodelElements;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.AnnotatedRelationshipElement;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.BasicEventElement;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Blob;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Capability;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.DataElementChoice;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.DataTypeDefXsd;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Direction;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.EmbeddedDataSpecification;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Entity;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.EntityType;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Extension;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.LangStringNameType;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.LangStringTextType;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.ModelFile;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.MultiLanguageProperty;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Operation;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.OperationVariable;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Property;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Qualifier;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Range;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Reference;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.ReferenceElement;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.RelationshipElement;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.SpecificAssetId;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.StateOfEvent;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.SubmodelElementCollection;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.SubmodelElementList;
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
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.eclipse.digitaltwin.basyx.v3.clients.JSON;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:07.399784100+01:00[Europe/Berlin]")
@JsonDeserialize(using = SubmodelElementChoice.SubmodelElementChoiceDeserializer.class)
@JsonSerialize(using = SubmodelElementChoice.SubmodelElementChoiceSerializer.class)
public class SubmodelElementChoice extends AbstractOpenApiSchema {
	private static final Logger log = Logger.getLogger(SubmodelElementChoice.class.getName());

	public static class SubmodelElementChoiceSerializer extends StdSerializer<SubmodelElementChoice> {
		public SubmodelElementChoiceSerializer(Class<SubmodelElementChoice> t) {
			super(t);
		}

		public SubmodelElementChoiceSerializer() {
			this(null);
		}

		@Override
		public void serialize(SubmodelElementChoice value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
			jgen.writeObject(value.getActualInstance());
		}
	}

	public static class SubmodelElementChoiceDeserializer extends StdDeserializer<SubmodelElementChoice> {
		public SubmodelElementChoiceDeserializer() {
			this(SubmodelElementChoice.class);
		}

		public SubmodelElementChoiceDeserializer(Class<?> vc) {
			super(vc);
		}

		@Override
		public SubmodelElementChoice deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
			JsonNode tree = jp.readValueAsTree();
			TextNode node = (TextNode) tree.get("modelType");
			Object deserialized;
			String name = node.textValue();
			Class<?> cls;
			if ("File".equals(name)) {
				cls = ModelFile.class;
			} else {
				String clsName = SubmodelElementChoice.class.getPackage().getName() + "." + node.textValue();
				try {
					cls = Class.forName(clsName);
				} catch (ClassNotFoundException e) {
					throw new IOException(e);
				}
			}
			deserialized = tree.traverse(jp.getCodec()).readValueAs(cls);
			// break;
			// case "AssetAdministrationShell":
			// deserialized =
			// tree.traverse(jp.getCodec()).readValueAs(AssetAdministrationShell.class);
			// break;
			// case "BasicEventElement":
			// deserialized =
			// tree.traverse(jp.getCodec()).readValueAs(BasicEventElement.class);
			// break;
			// case "Blob":
			// case "Capability":
			// case "ConceptDescription":, DataSpecificationIec61360, Entity, File,
			// MultiLanguageProperty, Operation, Property, Range, ReferenceElement,
			// RelationshipElement, Submodel, SubmodelElementCollection, SubmodelElementList
			//
			//
			// Object deserialized = null;
			// boolean typeCoercion =
			// ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
			// int match = 0;
			// JsonToken token = tree.traverse(jp.getCodec()).nextToken();
			// // deserialize AnnotatedRelationshipElement
			// try {
			// boolean attemptParsing = true;
			// // ensure that we respect type coercion as set on the client ObjectMapper
			// if (AnnotatedRelationshipElement.class.equals(Integer.class) ||
			// AnnotatedRelationshipElement.class.equals(Long.class) ||
			// AnnotatedRelationshipElement.class.equals(Float.class) ||
			// AnnotatedRelationshipElement.class.equals(Double.class) ||
			// AnnotatedRelationshipElement.class.equals(Boolean.class) ||
			// AnnotatedRelationshipElement.class.equals(String.class)) {
			// attemptParsing = typeCoercion;
			// if (!attemptParsing) {
			// attemptParsing |= ((AnnotatedRelationshipElement.class.equals(Integer.class)
			// || AnnotatedRelationshipElement.class.equals(Long.class)) && token ==
			// JsonToken.VALUE_NUMBER_INT);
			// attemptParsing |= ((AnnotatedRelationshipElement.class.equals(Float.class) ||
			// AnnotatedRelationshipElement.class.equals(Double.class)) && token ==
			// JsonToken.VALUE_NUMBER_FLOAT);
			// attemptParsing |= (AnnotatedRelationshipElement.class.equals(Boolean.class)
			// && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
			// attemptParsing |= (AnnotatedRelationshipElement.class.equals(String.class) &&
			// token == JsonToken.VALUE_STRING);
			// }
			// }
			// if (attemptParsing) {
			// deserialized =
			// tree.traverse(jp.getCodec()).readValueAs(AnnotatedRelationshipElement.class);
			// // TODO: there is no validation against JSON schema constraints
			// // (min, max, enum, pattern...), this does not perform a strict JSON
			// // validation, which means the 'match' count may be higher than it should be.
			// match++;
			// log.log(Level.FINER, "Input data matches schema
			// 'AnnotatedRelationshipElement'");
			// }
			// } catch (Exception e) {
			// // deserialization failed, continue
			// log.log(Level.FINER, "Input data does not match schema
			// 'AnnotatedRelationshipElement'", e);
			// }
			//
			// // deserialize BasicEventElement
			// try {
			// boolean attemptParsing = true;
			// // ensure that we respect type coercion as set on the client ObjectMapper
			// if (BasicEventElement.class.equals(Integer.class) ||
			// BasicEventElement.class.equals(Long.class) ||
			// BasicEventElement.class.equals(Float.class) ||
			// BasicEventElement.class.equals(Double.class) ||
			// BasicEventElement.class.equals(Boolean.class) ||
			// BasicEventElement.class.equals(String.class)) {
			// attemptParsing = typeCoercion;
			// if (!attemptParsing) {
			// attemptParsing |= ((BasicEventElement.class.equals(Integer.class) ||
			// BasicEventElement.class.equals(Long.class)) && token ==
			// JsonToken.VALUE_NUMBER_INT);
			// attemptParsing |= ((BasicEventElement.class.equals(Float.class) ||
			// BasicEventElement.class.equals(Double.class)) && token ==
			// JsonToken.VALUE_NUMBER_FLOAT);
			// attemptParsing |= (BasicEventElement.class.equals(Boolean.class) && (token ==
			// JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
			// attemptParsing |= (BasicEventElement.class.equals(String.class) && token ==
			// JsonToken.VALUE_STRING);
			// }
			// }
			// if (attemptParsing) {
			// deserialized =
			// tree.traverse(jp.getCodec()).readValueAs(BasicEventElement.class);
			// // TODO: there is no validation against JSON schema constraints
			// // (min, max, enum, pattern...), this does not perform a strict JSON
			// // validation, which means the 'match' count may be higher than it should be.
			// match++;
			// log.log(Level.FINER, "Input data matches schema 'BasicEventElement'");
			// }
			// } catch (Exception e) {
			// // deserialization failed, continue
			// log.log(Level.FINER, "Input data does not match schema 'BasicEventElement'",
			// e);
			// }
			//
			// // deserialize Blob
			// try {
			// boolean attemptParsing = true;
			// // ensure that we respect type coercion as set on the client ObjectMapper
			// if (Blob.class.equals(Integer.class) || Blob.class.equals(Long.class) ||
			// Blob.class.equals(Float.class) || Blob.class.equals(Double.class) ||
			// Blob.class.equals(Boolean.class) || Blob.class.equals(String.class)) {
			// attemptParsing = typeCoercion;
			// if (!attemptParsing) {
			// attemptParsing |= ((Blob.class.equals(Integer.class) ||
			// Blob.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
			// attemptParsing |= ((Blob.class.equals(Float.class) ||
			// Blob.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
			// attemptParsing |= (Blob.class.equals(Boolean.class) && (token ==
			// JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
			// attemptParsing |= (Blob.class.equals(String.class) && token ==
			// JsonToken.VALUE_STRING);
			// }
			// }
			// if (attemptParsing) {
			// deserialized = tree.traverse(jp.getCodec()).readValueAs(Blob.class);
			// // TODO: there is no validation against JSON schema constraints
			// // (min, max, enum, pattern...), this does not perform a strict JSON
			// // validation, which means the 'match' count may be higher than it should be.
			// match++;
			// log.log(Level.FINER, "Input data matches schema 'Blob'");
			// }
			// } catch (Exception e) {
			// // deserialization failed, continue
			// log.log(Level.FINER, "Input data does not match schema 'Blob'", e);
			// }
			//
			// // deserialize Capability
			// try {
			// boolean attemptParsing = true;
			// // ensure that we respect type coercion as set on the client ObjectMapper
			// if (Capability.class.equals(Integer.class) ||
			// Capability.class.equals(Long.class) || Capability.class.equals(Float.class)
			// || Capability.class.equals(Double.class) ||
			// Capability.class.equals(Boolean.class) ||
			// Capability.class.equals(String.class)) {
			// attemptParsing = typeCoercion;
			// if (!attemptParsing) {
			// attemptParsing |= ((Capability.class.equals(Integer.class) ||
			// Capability.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
			// attemptParsing |= ((Capability.class.equals(Float.class) ||
			// Capability.class.equals(Double.class)) && token ==
			// JsonToken.VALUE_NUMBER_FLOAT);
			// attemptParsing |= (Capability.class.equals(Boolean.class) && (token ==
			// JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
			// attemptParsing |= (Capability.class.equals(String.class) && token ==
			// JsonToken.VALUE_STRING);
			// }
			// }
			// if (attemptParsing) {
			// deserialized = tree.traverse(jp.getCodec()).readValueAs(Capability.class);
			// // TODO: there is no validation against JSON schema constraints
			// // (min, max, enum, pattern...), this does not perform a strict JSON
			// // validation, which means the 'match' count may be higher than it should be.
			// match++;
			// log.log(Level.FINER, "Input data matches schema 'Capability'");
			// }
			// } catch (Exception e) {
			// // deserialization failed, continue
			// log.log(Level.FINER, "Input data does not match schema 'Capability'", e);
			// }
			//
			// // deserialize Entity
			// try {
			// boolean attemptParsing = true;
			// // ensure that we respect type coercion as set on the client ObjectMapper
			// if (Entity.class.equals(Integer.class) || Entity.class.equals(Long.class) ||
			// Entity.class.equals(Float.class) || Entity.class.equals(Double.class) ||
			// Entity.class.equals(Boolean.class) || Entity.class.equals(String.class)) {
			// attemptParsing = typeCoercion;
			// if (!attemptParsing) {
			// attemptParsing |= ((Entity.class.equals(Integer.class) ||
			// Entity.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
			// attemptParsing |= ((Entity.class.equals(Float.class) ||
			// Entity.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
			// attemptParsing |= (Entity.class.equals(Boolean.class) && (token ==
			// JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
			// attemptParsing |= (Entity.class.equals(String.class) && token ==
			// JsonToken.VALUE_STRING);
			// }
			// }
			// if (attemptParsing) {
			// deserialized = tree.traverse(jp.getCodec()).readValueAs(Entity.class);
			// // TODO: there is no validation against JSON schema constraints
			// // (min, max, enum, pattern...), this does not perform a strict JSON
			// // validation, which means the 'match' count may be higher than it should be.
			// match++;
			// log.log(Level.FINER, "Input data matches schema 'Entity'");
			// }
			// } catch (Exception e) {
			// // deserialization failed, continue
			// log.log(Level.FINER, "Input data does not match schema 'Entity'", e);
			// }
			//
			// // deserialize ModelFile
			// try {
			// boolean attemptParsing = true;
			// // ensure that we respect type coercion as set on the client ObjectMapper
			// if (ModelFile.class.equals(Integer.class) ||
			// ModelFile.class.equals(Long.class) || ModelFile.class.equals(Float.class) ||
			// ModelFile.class.equals(Double.class) || ModelFile.class.equals(Boolean.class)
			// || ModelFile.class.equals(String.class)) {
			// attemptParsing = typeCoercion;
			// if (!attemptParsing) {
			// attemptParsing |= ((ModelFile.class.equals(Integer.class) ||
			// ModelFile.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
			// attemptParsing |= ((ModelFile.class.equals(Float.class) ||
			// ModelFile.class.equals(Double.class)) && token ==
			// JsonToken.VALUE_NUMBER_FLOAT);
			// attemptParsing |= (ModelFile.class.equals(Boolean.class) && (token ==
			// JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
			// attemptParsing |= (ModelFile.class.equals(String.class) && token ==
			// JsonToken.VALUE_STRING);
			// }
			// }
			// if (attemptParsing) {
			// deserialized = tree.traverse(jp.getCodec()).readValueAs(ModelFile.class);
			// // TODO: there is no validation against JSON schema constraints
			// // (min, max, enum, pattern...), this does not perform a strict JSON
			// // validation, which means the 'match' count may be higher than it should be.
			// match++;
			// log.log(Level.FINER, "Input data matches schema 'ModelFile'");
			// }
			// } catch (Exception e) {
			// // deserialization failed, continue
			// log.log(Level.FINER, "Input data does not match schema 'ModelFile'", e);
			// }
			//
			// // deserialize MultiLanguageProperty
			// try {
			// boolean attemptParsing = true;
			// // ensure that we respect type coercion as set on the client ObjectMapper
			// if (MultiLanguageProperty.class.equals(Integer.class) ||
			// MultiLanguageProperty.class.equals(Long.class) ||
			// MultiLanguageProperty.class.equals(Float.class) ||
			// MultiLanguageProperty.class.equals(Double.class) ||
			// MultiLanguageProperty.class.equals(Boolean.class) ||
			// MultiLanguageProperty.class.equals(String.class)) {
			// attemptParsing = typeCoercion;
			// if (!attemptParsing) {
			// attemptParsing |= ((MultiLanguageProperty.class.equals(Integer.class) ||
			// MultiLanguageProperty.class.equals(Long.class)) && token ==
			// JsonToken.VALUE_NUMBER_INT);
			// attemptParsing |= ((MultiLanguageProperty.class.equals(Float.class) ||
			// MultiLanguageProperty.class.equals(Double.class)) && token ==
			// JsonToken.VALUE_NUMBER_FLOAT);
			// attemptParsing |= (MultiLanguageProperty.class.equals(Boolean.class) &&
			// (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
			// attemptParsing |= (MultiLanguageProperty.class.equals(String.class) && token
			// == JsonToken.VALUE_STRING);
			// }
			// }
			// if (attemptParsing) {
			// deserialized =
			// tree.traverse(jp.getCodec()).readValueAs(MultiLanguageProperty.class);
			// // TODO: there is no validation against JSON schema constraints
			// // (min, max, enum, pattern...), this does not perform a strict JSON
			// // validation, which means the 'match' count may be higher than it should be.
			// match++;
			// log.log(Level.FINER, "Input data matches schema 'MultiLanguageProperty'");
			// }
			// } catch (Exception e) {
			// // deserialization failed, continue
			// log.log(Level.FINER, "Input data does not match schema
			// 'MultiLanguageProperty'", e);
			// }
			//
			// // deserialize Operation
			// try {
			// boolean attemptParsing = true;
			// // ensure that we respect type coercion as set on the client ObjectMapper
			// if (Operation.class.equals(Integer.class) ||
			// Operation.class.equals(Long.class) || Operation.class.equals(Float.class) ||
			// Operation.class.equals(Double.class) || Operation.class.equals(Boolean.class)
			// || Operation.class.equals(String.class)) {
			// attemptParsing = typeCoercion;
			// if (!attemptParsing) {
			// attemptParsing |= ((Operation.class.equals(Integer.class) ||
			// Operation.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
			// attemptParsing |= ((Operation.class.equals(Float.class) ||
			// Operation.class.equals(Double.class)) && token ==
			// JsonToken.VALUE_NUMBER_FLOAT);
			// attemptParsing |= (Operation.class.equals(Boolean.class) && (token ==
			// JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
			// attemptParsing |= (Operation.class.equals(String.class) && token ==
			// JsonToken.VALUE_STRING);
			// }
			// }
			// if (attemptParsing) {
			// deserialized = tree.traverse(jp.getCodec()).readValueAs(Operation.class);
			// // TODO: there is no validation against JSON schema constraints
			// // (min, max, enum, pattern...), this does not perform a strict JSON
			// // validation, which means the 'match' count may be higher than it should be.
			// match++;
			// log.log(Level.FINER, "Input data matches schema 'Operation'");
			// }
			// } catch (Exception e) {
			// // deserialization failed, continue
			// log.log(Level.FINER, "Input data does not match schema 'Operation'", e);
			// }
			//
			// // deserialize Property
			// try {
			// boolean attemptParsing = true;
			// // ensure that we respect type coercion as set on the client ObjectMapper
			// if (Property.class.equals(Integer.class) || Property.class.equals(Long.class)
			// || Property.class.equals(Float.class) || Property.class.equals(Double.class)
			// || Property.class.equals(Boolean.class) ||
			// Property.class.equals(String.class)) {
			// attemptParsing = typeCoercion;
			// if (!attemptParsing) {
			// attemptParsing |= ((Property.class.equals(Integer.class) ||
			// Property.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
			// attemptParsing |= ((Property.class.equals(Float.class) ||
			// Property.class.equals(Double.class)) && token ==
			// JsonToken.VALUE_NUMBER_FLOAT);
			// attemptParsing |= (Property.class.equals(Boolean.class) && (token ==
			// JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
			// attemptParsing |= (Property.class.equals(String.class) && token ==
			// JsonToken.VALUE_STRING);
			// }
			// }
			// if (attemptParsing) {
			// deserialized = tree.traverse(jp.getCodec()).readValueAs(Property.class);
			// // TODO: there is no validation against JSON schema constraints
			// // (min, max, enum, pattern...), this does not perform a strict JSON
			// // validation, which means the 'match' count may be higher than it should be.
			// match++;
			// log.log(Level.FINER, "Input data matches schema 'Property'");
			// }
			// } catch (Exception e) {
			// // deserialization failed, continue
			// log.log(Level.FINER, "Input data does not match schema 'Property'", e);
			// }
			//
			// // deserialize Range
			// try {
			// boolean attemptParsing = true;
			// // ensure that we respect type coercion as set on the client ObjectMapper
			// if (Range.class.equals(Integer.class) || Range.class.equals(Long.class) ||
			// Range.class.equals(Float.class) || Range.class.equals(Double.class) ||
			// Range.class.equals(Boolean.class) || Range.class.equals(String.class)) {
			// attemptParsing = typeCoercion;
			// if (!attemptParsing) {
			// attemptParsing |= ((Range.class.equals(Integer.class) ||
			// Range.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
			// attemptParsing |= ((Range.class.equals(Float.class) ||
			// Range.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
			// attemptParsing |= (Range.class.equals(Boolean.class) && (token ==
			// JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
			// attemptParsing |= (Range.class.equals(String.class) && token ==
			// JsonToken.VALUE_STRING);
			// }
			// }
			// if (attemptParsing) {
			// deserialized = tree.traverse(jp.getCodec()).readValueAs(Range.class);
			// // TODO: there is no validation against JSON schema constraints
			// // (min, max, enum, pattern...), this does not perform a strict JSON
			// // validation, which means the 'match' count may be higher than it should be.
			// match++;
			// log.log(Level.FINER, "Input data matches schema 'Range'");
			// }
			// } catch (Exception e) {
			// // deserialization failed, continue
			// log.log(Level.FINER, "Input data does not match schema 'Range'", e);
			// }
			//
			// // deserialize ReferenceElement
			// try {
			// boolean attemptParsing = true;
			// // ensure that we respect type coercion as set on the client ObjectMapper
			// if (ReferenceElement.class.equals(Integer.class) ||
			// ReferenceElement.class.equals(Long.class) ||
			// ReferenceElement.class.equals(Float.class) ||
			// ReferenceElement.class.equals(Double.class) ||
			// ReferenceElement.class.equals(Boolean.class) ||
			// ReferenceElement.class.equals(String.class)) {
			// attemptParsing = typeCoercion;
			// if (!attemptParsing) {
			// attemptParsing |= ((ReferenceElement.class.equals(Integer.class) ||
			// ReferenceElement.class.equals(Long.class)) && token ==
			// JsonToken.VALUE_NUMBER_INT);
			// attemptParsing |= ((ReferenceElement.class.equals(Float.class) ||
			// ReferenceElement.class.equals(Double.class)) && token ==
			// JsonToken.VALUE_NUMBER_FLOAT);
			// attemptParsing |= (ReferenceElement.class.equals(Boolean.class) && (token ==
			// JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
			// attemptParsing |= (ReferenceElement.class.equals(String.class) && token ==
			// JsonToken.VALUE_STRING);
			// }
			// }
			// if (attemptParsing) {
			// deserialized =
			// tree.traverse(jp.getCodec()).readValueAs(ReferenceElement.class);
			// // TODO: there is no validation against JSON schema constraints
			// // (min, max, enum, pattern...), this does not perform a strict JSON
			// // validation, which means the 'match' count may be higher than it should be.
			// match++;
			// log.log(Level.FINER, "Input data matches schema 'ReferenceElement'");
			// }
			// } catch (Exception e) {
			// // deserialization failed, continue
			// log.log(Level.FINER, "Input data does not match schema 'ReferenceElement'",
			// e);
			// }
			//
			// // deserialize RelationshipElement
			// try {
			// boolean attemptParsing = true;
			// // ensure that we respect type coercion as set on the client ObjectMapper
			// if (RelationshipElement.class.equals(Integer.class) ||
			// RelationshipElement.class.equals(Long.class) ||
			// RelationshipElement.class.equals(Float.class) ||
			// RelationshipElement.class.equals(Double.class) ||
			// RelationshipElement.class.equals(Boolean.class) ||
			// RelationshipElement.class.equals(String.class)) {
			// attemptParsing = typeCoercion;
			// if (!attemptParsing) {
			// attemptParsing |= ((RelationshipElement.class.equals(Integer.class) ||
			// RelationshipElement.class.equals(Long.class)) && token ==
			// JsonToken.VALUE_NUMBER_INT);
			// attemptParsing |= ((RelationshipElement.class.equals(Float.class) ||
			// RelationshipElement.class.equals(Double.class)) && token ==
			// JsonToken.VALUE_NUMBER_FLOAT);
			// attemptParsing |= (RelationshipElement.class.equals(Boolean.class) && (token
			// == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
			// attemptParsing |= (RelationshipElement.class.equals(String.class) && token ==
			// JsonToken.VALUE_STRING);
			// }
			// }
			// if (attemptParsing) {
			// deserialized =
			// tree.traverse(jp.getCodec()).readValueAs(RelationshipElement.class);
			// // TODO: there is no validation against JSON schema constraints
			// // (min, max, enum, pattern...), this does not perform a strict JSON
			// // validation, which means the 'match' count may be higher than it should be.
			// match++;
			// log.log(Level.FINER, "Input data matches schema 'RelationshipElement'");
			// }
			// } catch (Exception e) {
			// // deserialization failed, continue
			// log.log(Level.FINER, "Input data does not match schema
			// 'RelationshipElement'", e);
			// }
			//
			// // deserialize SubmodelElementCollection
			// try {
			// boolean attemptParsing = true;
			// // ensure that we respect type coercion as set on the client ObjectMapper
			// if (SubmodelElementCollection.class.equals(Integer.class) ||
			// SubmodelElementCollection.class.equals(Long.class) ||
			// SubmodelElementCollection.class.equals(Float.class) ||
			// SubmodelElementCollection.class.equals(Double.class) ||
			// SubmodelElementCollection.class.equals(Boolean.class) ||
			// SubmodelElementCollection.class.equals(String.class)) {
			// attemptParsing = typeCoercion;
			// if (!attemptParsing) {
			// attemptParsing |= ((SubmodelElementCollection.class.equals(Integer.class) ||
			// SubmodelElementCollection.class.equals(Long.class)) && token ==
			// JsonToken.VALUE_NUMBER_INT);
			// attemptParsing |= ((SubmodelElementCollection.class.equals(Float.class) ||
			// SubmodelElementCollection.class.equals(Double.class)) && token ==
			// JsonToken.VALUE_NUMBER_FLOAT);
			// attemptParsing |= (SubmodelElementCollection.class.equals(Boolean.class) &&
			// (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
			// attemptParsing |= (SubmodelElementCollection.class.equals(String.class) &&
			// token == JsonToken.VALUE_STRING);
			// }
			// }
			// if (attemptParsing) {
			// deserialized =
			// tree.traverse(jp.getCodec()).readValueAs(SubmodelElementCollection.class);
			// // TODO: there is no validation against JSON schema constraints
			// // (min, max, enum, pattern...), this does not perform a strict JSON
			// // validation, which means the 'match' count may be higher than it should be.
			// match++;
			// log.log(Level.FINER, "Input data matches schema
			// 'SubmodelElementCollection'");
			// }
			// } catch (Exception e) {
			// // deserialization failed, continue
			// log.log(Level.FINER, "Input data does not match schema
			// 'SubmodelElementCollection'", e);
			// }
			//
			// // deserialize SubmodelElementList
			// try {
			// boolean attemptParsing = true;
			// // ensure that we respect type coercion as set on the client ObjectMapper
			// if (SubmodelElementList.class.equals(Integer.class) ||
			// SubmodelElementList.class.equals(Long.class) ||
			// SubmodelElementList.class.equals(Float.class) ||
			// SubmodelElementList.class.equals(Double.class) ||
			// SubmodelElementList.class.equals(Boolean.class) ||
			// SubmodelElementList.class.equals(String.class)) {
			// attemptParsing = typeCoercion;
			// if (!attemptParsing) {
			// attemptParsing |= ((SubmodelElementList.class.equals(Integer.class) ||
			// SubmodelElementList.class.equals(Long.class)) && token ==
			// JsonToken.VALUE_NUMBER_INT);
			// attemptParsing |= ((SubmodelElementList.class.equals(Float.class) ||
			// SubmodelElementList.class.equals(Double.class)) && token ==
			// JsonToken.VALUE_NUMBER_FLOAT);
			// attemptParsing |= (SubmodelElementList.class.equals(Boolean.class) && (token
			// == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
			// attemptParsing |= (SubmodelElementList.class.equals(String.class) && token ==
			// JsonToken.VALUE_STRING);
			// }
			// }
			// if (attemptParsing) {
			//
			// Object previous = deserialized;
			// deserialized =
			// tree.traverse(jp.getCodec()).readValueAs(SubmodelElementList.class);
			// // TODO: there is no validation against JSON schema constraints
			// // (min, max, enum, pattern...), this does not perform a strict JSON
			// // validation, which means the 'match' count may be higher than it should be.
			//
			// log.log(Level.FINER, "Input data matches schema 'SubmodelElementList'");
			// if (match == 1) {
			// if (previous instanceof SubmodelElementCollection &&
			// "SubmodelElementCollection".equals(((SubmodelElementCollection)
			// previous).getModelType())) {
			// match = 1;
			// deserialized = previous; // use collection in this case
			// }
			// } else {
			// match++;
			// }
			// }
			// } catch (Exception e) {
			// // deserialization failed, continue
			// log.log(Level.FINER, "Input data does not match schema
			// 'SubmodelElementList'", e);
			// }
			//
			// if (match == 1) {
			SubmodelElementChoice ret = new SubmodelElementChoice();
			ret.setActualInstance(deserialized);
			return ret;
			// }
			// throw new IOException(String.format("Failed deserialization for
			// SubmodelElementChoice: %d classes match result, expected 1", match));
		}

		/**
		 * Handle deserialization of the 'null' value.
		 */
		@Override
		public SubmodelElementChoice getNullValue(DeserializationContext ctxt) throws JsonMappingException {
			throw new JsonMappingException(ctxt.getParser(), "SubmodelElementChoice cannot be null");
		}
	}

	// store a list of schema names defined in oneOf
	public static final Map<String, Class<?>> schemas = new HashMap<>();

	public SubmodelElementChoice() {
		super("oneOf", Boolean.FALSE);
	}

	public SubmodelElementChoice(AnnotatedRelationshipElement o) {
		super("oneOf", Boolean.FALSE);
		setActualInstance(o);
	}

	public SubmodelElementChoice(BasicEventElement o) {
		super("oneOf", Boolean.FALSE);
		setActualInstance(o);
	}

	public SubmodelElementChoice(Blob o) {
		super("oneOf", Boolean.FALSE);
		setActualInstance(o);
	}

	public SubmodelElementChoice(Capability o) {
		super("oneOf", Boolean.FALSE);
		setActualInstance(o);
	}

	public SubmodelElementChoice(Entity o) {
		super("oneOf", Boolean.FALSE);
		setActualInstance(o);
	}

	public SubmodelElementChoice(ModelFile o) {
		super("oneOf", Boolean.FALSE);
		setActualInstance(o);
	}

	public SubmodelElementChoice(MultiLanguageProperty o) {
		super("oneOf", Boolean.FALSE);
		setActualInstance(o);
	}

	public SubmodelElementChoice(Operation o) {
		super("oneOf", Boolean.FALSE);
		setActualInstance(o);
	}

	public SubmodelElementChoice(Property o) {
		super("oneOf", Boolean.FALSE);
		setActualInstance(o);
	}

	public SubmodelElementChoice(Range o) {
		super("oneOf", Boolean.FALSE);
		setActualInstance(o);
	}

	public SubmodelElementChoice(ReferenceElement o) {
		super("oneOf", Boolean.FALSE);
		setActualInstance(o);
	}

	public SubmodelElementChoice(RelationshipElement o) {
		super("oneOf", Boolean.FALSE);
		setActualInstance(o);
	}

	public SubmodelElementChoice(SubmodelElementCollection o) {
		super("oneOf", Boolean.FALSE);
		setActualInstance(o);
	}

	public SubmodelElementChoice(SubmodelElementList o) {
		super("oneOf", Boolean.FALSE);
		setActualInstance(o);
	}

	static {
		schemas.put("AnnotatedRelationshipElement", AnnotatedRelationshipElement.class);
		schemas.put("BasicEventElement", BasicEventElement.class);
		schemas.put("Blob", Blob.class);
		schemas.put("Capability", Capability.class);
		schemas.put("Entity", Entity.class);
		schemas.put("ModelFile", ModelFile.class);
		schemas.put("MultiLanguageProperty", MultiLanguageProperty.class);
		schemas.put("Operation", Operation.class);
		schemas.put("Property", Property.class);
		schemas.put("Range", Range.class);
		schemas.put("ReferenceElement", ReferenceElement.class);
		schemas.put("RelationshipElement", RelationshipElement.class);
		schemas.put("SubmodelElementCollection", SubmodelElementCollection.class);
		schemas.put("SubmodelElementList", SubmodelElementList.class);
		JSON.registerDescendants(SubmodelElementChoice.class, Collections.unmodifiableMap(schemas));
	}

	@Override
	public Map<String, Class<?>> getSchemas() {
		return SubmodelElementChoice.schemas;
	}

	/**
	 * Set the instance that matches the oneOf child schema, check the instance
	 * parameter is valid against the oneOf child schemas:
	 * AnnotatedRelationshipElement, BasicEventElement, Blob, Capability, Entity,
	 * ModelFile, MultiLanguageProperty, Operation, Property, Range,
	 * ReferenceElement, RelationshipElement, SubmodelElementCollection,
	 * SubmodelElementList
	 *
	 * It could be an instance of the 'oneOf' schemas. The oneOf child schemas may
	 * themselves be a composed schema (allOf, anyOf, oneOf).
	 */
	@Override
	public void setActualInstance(Object instance) {
		if (JSON.isInstanceOf(AnnotatedRelationshipElement.class, instance, new HashSet<Class<?>>())) {
			super.setActualInstance(instance);
			return;
		}

		if (JSON.isInstanceOf(BasicEventElement.class, instance, new HashSet<Class<?>>())) {
			super.setActualInstance(instance);
			return;
		}

		if (JSON.isInstanceOf(Blob.class, instance, new HashSet<Class<?>>())) {
			super.setActualInstance(instance);
			return;
		}

		if (JSON.isInstanceOf(Capability.class, instance, new HashSet<Class<?>>())) {
			super.setActualInstance(instance);
			return;
		}

		if (JSON.isInstanceOf(Entity.class, instance, new HashSet<Class<?>>())) {
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

		if (JSON.isInstanceOf(Operation.class, instance, new HashSet<Class<?>>())) {
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

		if (JSON.isInstanceOf(RelationshipElement.class, instance, new HashSet<Class<?>>())) {
			super.setActualInstance(instance);
			return;
		}

		if (JSON.isInstanceOf(SubmodelElementCollection.class, instance, new HashSet<Class<?>>())) {
			super.setActualInstance(instance);
			return;
		}

		if (JSON.isInstanceOf(SubmodelElementList.class, instance, new HashSet<Class<?>>())) {
			super.setActualInstance(instance);
			return;
		}

		throw new RuntimeException(
				"Invalid instance type. Must be AnnotatedRelationshipElement, BasicEventElement, Blob, Capability, Entity, ModelFile, MultiLanguageProperty, Operation, Property, Range, ReferenceElement, RelationshipElement, SubmodelElementCollection, SubmodelElementList");
	}

	/**
	 * Get the actual instance, which can be the following:
	 * AnnotatedRelationshipElement, BasicEventElement, Blob, Capability, Entity,
	 * ModelFile, MultiLanguageProperty, Operation, Property, Range,
	 * ReferenceElement, RelationshipElement, SubmodelElementCollection,
	 * SubmodelElementList
	 *
	 * @return The actual instance (AnnotatedRelationshipElement, BasicEventElement,
	 *         Blob, Capability, Entity, ModelFile, MultiLanguageProperty,
	 *         Operation, Property, Range, ReferenceElement, RelationshipElement,
	 *         SubmodelElementCollection, SubmodelElementList)
	 */
	@Override
	public Object getActualInstance() {
		return super.getActualInstance();
	}

	/**
	 * Get the actual instance of `AnnotatedRelationshipElement`. If the actual
	 * instance is not `AnnotatedRelationshipElement`, the ClassCastException will
	 * be thrown.
	 *
	 * @return The actual instance of `AnnotatedRelationshipElement`
	 * @throws ClassCastException
	 *             if the instance is not `AnnotatedRelationshipElement`
	 */
	public AnnotatedRelationshipElement getAnnotatedRelationshipElement() throws ClassCastException {
		return (AnnotatedRelationshipElement) super.getActualInstance();
	}

	/**
	 * Get the actual instance of `BasicEventElement`. If the actual instance is not
	 * `BasicEventElement`, the ClassCastException will be thrown.
	 *
	 * @return The actual instance of `BasicEventElement`
	 * @throws ClassCastException
	 *             if the instance is not `BasicEventElement`
	 */
	public BasicEventElement getBasicEventElement() throws ClassCastException {
		return (BasicEventElement) super.getActualInstance();
	}

	/**
	 * Get the actual instance of `Blob`. If the actual instance is not `Blob`, the
	 * ClassCastException will be thrown.
	 *
	 * @return The actual instance of `Blob`
	 * @throws ClassCastException
	 *             if the instance is not `Blob`
	 */
	public Blob getBlob() throws ClassCastException {
		return (Blob) super.getActualInstance();
	}

	/**
	 * Get the actual instance of `Capability`. If the actual instance is not
	 * `Capability`, the ClassCastException will be thrown.
	 *
	 * @return The actual instance of `Capability`
	 * @throws ClassCastException
	 *             if the instance is not `Capability`
	 */
	public Capability getCapability() throws ClassCastException {
		return (Capability) super.getActualInstance();
	}

	/**
	 * Get the actual instance of `Entity`. If the actual instance is not `Entity`,
	 * the ClassCastException will be thrown.
	 *
	 * @return The actual instance of `Entity`
	 * @throws ClassCastException
	 *             if the instance is not `Entity`
	 */
	public Entity getEntity() throws ClassCastException {
		return (Entity) super.getActualInstance();
	}

	/**
	 * Get the actual instance of `ModelFile`. If the actual instance is not
	 * `ModelFile`, the ClassCastException will be thrown.
	 *
	 * @return The actual instance of `ModelFile`
	 * @throws ClassCastException
	 *             if the instance is not `ModelFile`
	 */
	public ModelFile getModelFile() throws ClassCastException {
		return (ModelFile) super.getActualInstance();
	}

	/**
	 * Get the actual instance of `MultiLanguageProperty`. If the actual instance is
	 * not `MultiLanguageProperty`, the ClassCastException will be thrown.
	 *
	 * @return The actual instance of `MultiLanguageProperty`
	 * @throws ClassCastException
	 *             if the instance is not `MultiLanguageProperty`
	 */
	public MultiLanguageProperty getMultiLanguageProperty() throws ClassCastException {
		return (MultiLanguageProperty) super.getActualInstance();
	}

	/**
	 * Get the actual instance of `Operation`. If the actual instance is not
	 * `Operation`, the ClassCastException will be thrown.
	 *
	 * @return The actual instance of `Operation`
	 * @throws ClassCastException
	 *             if the instance is not `Operation`
	 */
	public Operation getOperation() throws ClassCastException {
		return (Operation) super.getActualInstance();
	}

	/**
	 * Get the actual instance of `Property`. If the actual instance is not
	 * `Property`, the ClassCastException will be thrown.
	 *
	 * @return The actual instance of `Property`
	 * @throws ClassCastException
	 *             if the instance is not `Property`
	 */
	public Property getProperty() throws ClassCastException {
		return (Property) super.getActualInstance();
	}

	/**
	 * Get the actual instance of `Range`. If the actual instance is not `Range`,
	 * the ClassCastException will be thrown.
	 *
	 * @return The actual instance of `Range`
	 * @throws ClassCastException
	 *             if the instance is not `Range`
	 */
	public Range getRange() throws ClassCastException {
		return (Range) super.getActualInstance();
	}

	/**
	 * Get the actual instance of `ReferenceElement`. If the actual instance is not
	 * `ReferenceElement`, the ClassCastException will be thrown.
	 *
	 * @return The actual instance of `ReferenceElement`
	 * @throws ClassCastException
	 *             if the instance is not `ReferenceElement`
	 */
	public ReferenceElement getReferenceElement() throws ClassCastException {
		return (ReferenceElement) super.getActualInstance();
	}

	/**
	 * Get the actual instance of `RelationshipElement`. If the actual instance is
	 * not `RelationshipElement`, the ClassCastException will be thrown.
	 *
	 * @return The actual instance of `RelationshipElement`
	 * @throws ClassCastException
	 *             if the instance is not `RelationshipElement`
	 */
	public RelationshipElement getRelationshipElement() throws ClassCastException {
		return (RelationshipElement) super.getActualInstance();
	}

	/**
	 * Get the actual instance of `SubmodelElementCollection`. If the actual
	 * instance is not `SubmodelElementCollection`, the ClassCastException will be
	 * thrown.
	 *
	 * @return The actual instance of `SubmodelElementCollection`
	 * @throws ClassCastException
	 *             if the instance is not `SubmodelElementCollection`
	 */
	public SubmodelElementCollection getSubmodelElementCollection() throws ClassCastException {
		return (SubmodelElementCollection) super.getActualInstance();
	}

	/**
	 * Get the actual instance of `SubmodelElementList`. If the actual instance is
	 * not `SubmodelElementList`, the ClassCastException will be thrown.
	 *
	 * @return The actual instance of `SubmodelElementList`
	 * @throws ClassCastException
	 *             if the instance is not `SubmodelElementList`
	 */
	public SubmodelElementList getSubmodelElementList() throws ClassCastException {
		return (SubmodelElementList) super.getActualInstance();
	}

}
