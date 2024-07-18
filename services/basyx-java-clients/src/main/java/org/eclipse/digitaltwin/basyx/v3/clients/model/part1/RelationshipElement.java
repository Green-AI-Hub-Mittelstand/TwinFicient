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
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.EmbeddedDataSpecification;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Extension;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.LangStringNameType;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.LangStringTextType;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Qualifier;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Reference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * RelationshipElement
 */
@JsonPropertyOrder({
  RelationshipElement.JSON_PROPERTY_EXTENSIONS,
  RelationshipElement.JSON_PROPERTY_CATEGORY,
  RelationshipElement.JSON_PROPERTY_ID_SHORT,
  RelationshipElement.JSON_PROPERTY_DISPLAY_NAME,
  RelationshipElement.JSON_PROPERTY_DESCRIPTION,
  RelationshipElement.JSON_PROPERTY_MODEL_TYPE,
  RelationshipElement.JSON_PROPERTY_SEMANTIC_ID,
  RelationshipElement.JSON_PROPERTY_SUPPLEMENTAL_SEMANTIC_IDS,
  RelationshipElement.JSON_PROPERTY_QUALIFIERS,
  RelationshipElement.JSON_PROPERTY_EMBEDDED_DATA_SPECIFICATIONS,
  RelationshipElement.JSON_PROPERTY_FIRST,
  RelationshipElement.JSON_PROPERTY_SECOND
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:07.399784100+01:00[Europe/Berlin]")
public class RelationshipElement {
  public static final String JSON_PROPERTY_EXTENSIONS = "extensions";
  private List<Extension> extensions;

  public static final String JSON_PROPERTY_CATEGORY = "category";
  private String category;

  public static final String JSON_PROPERTY_ID_SHORT = "idShort";
  private String idShort;

  public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
  private List<LangStringNameType> displayName;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private List<LangStringTextType> description;

  public static final String JSON_PROPERTY_MODEL_TYPE = "modelType";
  private String modelType;

  public static final String JSON_PROPERTY_SEMANTIC_ID = "semanticId";
  private Reference semanticId;

  public static final String JSON_PROPERTY_SUPPLEMENTAL_SEMANTIC_IDS = "supplementalSemanticIds";
  private List<Reference> supplementalSemanticIds;

  public static final String JSON_PROPERTY_QUALIFIERS = "qualifiers";
  private List<Qualifier> qualifiers;

  public static final String JSON_PROPERTY_EMBEDDED_DATA_SPECIFICATIONS = "embeddedDataSpecifications";
  private List<EmbeddedDataSpecification> embeddedDataSpecifications;

  public static final String JSON_PROPERTY_FIRST = "first";
  private Reference first;

  public static final String JSON_PROPERTY_SECOND = "second";
  private Reference second;

  public RelationshipElement() { 
  }

  public RelationshipElement extensions(List<Extension> extensions) {
    this.extensions = extensions;
    return this;
  }

  public RelationshipElement addExtensionsItem(Extension extensionsItem) {
    if (this.extensions == null) {
      this.extensions = new ArrayList<>();
    }
    this.extensions.add(extensionsItem);
    return this;
  }

   /**
   * Get extensions
   * @return extensions
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_EXTENSIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Extension> getExtensions() {
    return extensions;
  }


  @JsonProperty(JSON_PROPERTY_EXTENSIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExtensions(List<Extension> extensions) {
    this.extensions = extensions;
  }


  public RelationshipElement category(String category) {
    this.category = category;
    return this;
  }

   /**
   * Get category
   * @return category
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CATEGORY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCategory() {
    return category;
  }


  @JsonProperty(JSON_PROPERTY_CATEGORY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCategory(String category) {
    this.category = category;
  }


  public RelationshipElement idShort(String idShort) {
    this.idShort = idShort;
    return this;
  }

   /**
   * Get idShort
   * @return idShort
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ID_SHORT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getIdShort() {
    return idShort;
  }


  @JsonProperty(JSON_PROPERTY_ID_SHORT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIdShort(String idShort) {
    this.idShort = idShort;
  }


  public RelationshipElement displayName(List<LangStringNameType> displayName) {
    this.displayName = displayName;
    return this;
  }

  public RelationshipElement addDisplayNameItem(LangStringNameType displayNameItem) {
    if (this.displayName == null) {
      this.displayName = new ArrayList<>();
    }
    this.displayName.add(displayNameItem);
    return this;
  }

   /**
   * Get displayName
   * @return displayName
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<LangStringNameType> getDisplayName() {
    return displayName;
  }


  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDisplayName(List<LangStringNameType> displayName) {
    this.displayName = displayName;
  }


  public RelationshipElement description(List<LangStringTextType> description) {
    this.description = description;
    return this;
  }

  public RelationshipElement addDescriptionItem(LangStringTextType descriptionItem) {
    if (this.description == null) {
      this.description = new ArrayList<>();
    }
    this.description.add(descriptionItem);
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<LangStringTextType> getDescription() {
    return description;
  }


  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDescription(List<LangStringTextType> description) {
    this.description = description;
  }


  public RelationshipElement modelType(String modelType) {
    this.modelType = modelType;
    return this;
  }

   /**
   * Get modelType
   * @return modelType
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_MODEL_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getModelType() {
    return modelType;
  }


  @JsonProperty(JSON_PROPERTY_MODEL_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setModelType(String modelType) {
    this.modelType = modelType;
  }


  public RelationshipElement semanticId(Reference semanticId) {
    this.semanticId = semanticId;
    return this;
  }

   /**
   * Get semanticId
   * @return semanticId
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SEMANTIC_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Reference getSemanticId() {
    return semanticId;
  }


  @JsonProperty(JSON_PROPERTY_SEMANTIC_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSemanticId(Reference semanticId) {
    this.semanticId = semanticId;
  }


  public RelationshipElement supplementalSemanticIds(List<Reference> supplementalSemanticIds) {
    this.supplementalSemanticIds = supplementalSemanticIds;
    return this;
  }

  public RelationshipElement addSupplementalSemanticIdsItem(Reference supplementalSemanticIdsItem) {
    if (this.supplementalSemanticIds == null) {
      this.supplementalSemanticIds = new ArrayList<>();
    }
    this.supplementalSemanticIds.add(supplementalSemanticIdsItem);
    return this;
  }

   /**
   * Get supplementalSemanticIds
   * @return supplementalSemanticIds
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SUPPLEMENTAL_SEMANTIC_IDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Reference> getSupplementalSemanticIds() {
    return supplementalSemanticIds;
  }


  @JsonProperty(JSON_PROPERTY_SUPPLEMENTAL_SEMANTIC_IDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSupplementalSemanticIds(List<Reference> supplementalSemanticIds) {
    this.supplementalSemanticIds = supplementalSemanticIds;
  }


  public RelationshipElement qualifiers(List<Qualifier> qualifiers) {
    this.qualifiers = qualifiers;
    return this;
  }

  public RelationshipElement addQualifiersItem(Qualifier qualifiersItem) {
    if (this.qualifiers == null) {
      this.qualifiers = new ArrayList<>();
    }
    this.qualifiers.add(qualifiersItem);
    return this;
  }

   /**
   * Get qualifiers
   * @return qualifiers
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_QUALIFIERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Qualifier> getQualifiers() {
    return qualifiers;
  }


  @JsonProperty(JSON_PROPERTY_QUALIFIERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setQualifiers(List<Qualifier> qualifiers) {
    this.qualifiers = qualifiers;
  }


  public RelationshipElement embeddedDataSpecifications(List<EmbeddedDataSpecification> embeddedDataSpecifications) {
    this.embeddedDataSpecifications = embeddedDataSpecifications;
    return this;
  }

  public RelationshipElement addEmbeddedDataSpecificationsItem(EmbeddedDataSpecification embeddedDataSpecificationsItem) {
    if (this.embeddedDataSpecifications == null) {
      this.embeddedDataSpecifications = new ArrayList<>();
    }
    this.embeddedDataSpecifications.add(embeddedDataSpecificationsItem);
    return this;
  }

   /**
   * Get embeddedDataSpecifications
   * @return embeddedDataSpecifications
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_EMBEDDED_DATA_SPECIFICATIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<EmbeddedDataSpecification> getEmbeddedDataSpecifications() {
    return embeddedDataSpecifications;
  }


  @JsonProperty(JSON_PROPERTY_EMBEDDED_DATA_SPECIFICATIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEmbeddedDataSpecifications(List<EmbeddedDataSpecification> embeddedDataSpecifications) {
    this.embeddedDataSpecifications = embeddedDataSpecifications;
  }


  public RelationshipElement first(Reference first) {
    this.first = first;
    return this;
  }

   /**
   * Get first
   * @return first
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_FIRST)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Reference getFirst() {
    return first;
  }


  @JsonProperty(JSON_PROPERTY_FIRST)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setFirst(Reference first) {
    this.first = first;
  }


  public RelationshipElement second(Reference second) {
    this.second = second;
    return this;
  }

   /**
   * Get second
   * @return second
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_SECOND)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Reference getSecond() {
    return second;
  }


  @JsonProperty(JSON_PROPERTY_SECOND)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSecond(Reference second) {
    this.second = second;
  }


  /**
   * Return true if this RelationshipElement object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RelationshipElement relationshipElement = (RelationshipElement) o;
    return Objects.equals(this.extensions, relationshipElement.extensions) &&
        Objects.equals(this.category, relationshipElement.category) &&
        Objects.equals(this.idShort, relationshipElement.idShort) &&
        Objects.equals(this.displayName, relationshipElement.displayName) &&
        Objects.equals(this.description, relationshipElement.description) &&
        Objects.equals(this.modelType, relationshipElement.modelType) &&
        Objects.equals(this.semanticId, relationshipElement.semanticId) &&
        Objects.equals(this.supplementalSemanticIds, relationshipElement.supplementalSemanticIds) &&
        Objects.equals(this.qualifiers, relationshipElement.qualifiers) &&
        Objects.equals(this.embeddedDataSpecifications, relationshipElement.embeddedDataSpecifications) &&
        Objects.equals(this.first, relationshipElement.first) &&
        Objects.equals(this.second, relationshipElement.second);
  }

  @Override
  public int hashCode() {
    return Objects.hash(extensions, category, idShort, displayName, description, modelType, semanticId, supplementalSemanticIds, qualifiers, embeddedDataSpecifications, first, second);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RelationshipElement {\n");
    sb.append("    extensions: ").append(toIndentedString(extensions)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    idShort: ").append(toIndentedString(idShort)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    modelType: ").append(toIndentedString(modelType)).append("\n");
    sb.append("    semanticId: ").append(toIndentedString(semanticId)).append("\n");
    sb.append("    supplementalSemanticIds: ").append(toIndentedString(supplementalSemanticIds)).append("\n");
    sb.append("    qualifiers: ").append(toIndentedString(qualifiers)).append("\n");
    sb.append("    embeddedDataSpecifications: ").append(toIndentedString(embeddedDataSpecifications)).append("\n");
    sb.append("    first: ").append(toIndentedString(first)).append("\n");
    sb.append("    second: ").append(toIndentedString(second)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

