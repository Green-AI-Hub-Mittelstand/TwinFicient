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
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.DataTypeDefXsd;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.EmbeddedDataSpecification;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Extension;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.LangStringNameType;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.LangStringTextType;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.ModelType;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.ModellingKind;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Qualifier;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Reference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * SubmodelElementListMetadata
 */
@JsonPropertyOrder({
  SubmodelElementListMetadata.JSON_PROPERTY_ORDER_RELEVANT,
  SubmodelElementListMetadata.JSON_PROPERTY_SEMANTIC_ID_LIST_ELEMENT,
  SubmodelElementListMetadata.JSON_PROPERTY_TYPE_VALUE_LIST_ELEMENT,
  SubmodelElementListMetadata.JSON_PROPERTY_VALUE_TYPE_LIST_ELEMENT,
  SubmodelElementListMetadata.JSON_PROPERTY_EXTENSIONS,
  SubmodelElementListMetadata.JSON_PROPERTY_CATEGORY,
  SubmodelElementListMetadata.JSON_PROPERTY_ID_SHORT,
  SubmodelElementListMetadata.JSON_PROPERTY_DISPLAY_NAME,
  SubmodelElementListMetadata.JSON_PROPERTY_DESCRIPTION,
  SubmodelElementListMetadata.JSON_PROPERTY_MODEL_TYPE,
  SubmodelElementListMetadata.JSON_PROPERTY_EMBEDDED_DATA_SPECIFICATIONS,
  SubmodelElementListMetadata.JSON_PROPERTY_SEMANTIC_ID,
  SubmodelElementListMetadata.JSON_PROPERTY_SUPPLEMENTAL_SEMANTIC_IDS,
  SubmodelElementListMetadata.JSON_PROPERTY_QUALIFIERS,
  SubmodelElementListMetadata.JSON_PROPERTY_KIND
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:09.185125100+01:00[Europe/Berlin]")
public class SubmodelElementListMetadata {
  public static final String JSON_PROPERTY_ORDER_RELEVANT = "orderRelevant";
  private Boolean orderRelevant;

  public static final String JSON_PROPERTY_SEMANTIC_ID_LIST_ELEMENT = "semanticIdListElement";
  private Reference semanticIdListElement;

  public static final String JSON_PROPERTY_TYPE_VALUE_LIST_ELEMENT = "typeValueListElement";
  private ModelType typeValueListElement;

  public static final String JSON_PROPERTY_VALUE_TYPE_LIST_ELEMENT = "valueTypeListElement";
  private DataTypeDefXsd valueTypeListElement;

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
  private ModelType modelType;

  public static final String JSON_PROPERTY_EMBEDDED_DATA_SPECIFICATIONS = "embeddedDataSpecifications";
  private List<EmbeddedDataSpecification> embeddedDataSpecifications;

  public static final String JSON_PROPERTY_SEMANTIC_ID = "semanticId";
  private Reference semanticId;

  public static final String JSON_PROPERTY_SUPPLEMENTAL_SEMANTIC_IDS = "supplementalSemanticIds";
  private List<Reference> supplementalSemanticIds;

  public static final String JSON_PROPERTY_QUALIFIERS = "qualifiers";
  private List<Qualifier> qualifiers;

  public static final String JSON_PROPERTY_KIND = "kind";
  private ModellingKind kind;

  public SubmodelElementListMetadata() { 
  }

  public SubmodelElementListMetadata orderRelevant(Boolean orderRelevant) {
    this.orderRelevant = orderRelevant;
    return this;
  }

   /**
   * Get orderRelevant
   * @return orderRelevant
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ORDER_RELEVANT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getOrderRelevant() {
    return orderRelevant;
  }


  @JsonProperty(JSON_PROPERTY_ORDER_RELEVANT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOrderRelevant(Boolean orderRelevant) {
    this.orderRelevant = orderRelevant;
  }


  public SubmodelElementListMetadata semanticIdListElement(Reference semanticIdListElement) {
    this.semanticIdListElement = semanticIdListElement;
    return this;
  }

   /**
   * Get semanticIdListElement
   * @return semanticIdListElement
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SEMANTIC_ID_LIST_ELEMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Reference getSemanticIdListElement() {
    return semanticIdListElement;
  }


  @JsonProperty(JSON_PROPERTY_SEMANTIC_ID_LIST_ELEMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSemanticIdListElement(Reference semanticIdListElement) {
    this.semanticIdListElement = semanticIdListElement;
  }


  public SubmodelElementListMetadata typeValueListElement(ModelType typeValueListElement) {
    this.typeValueListElement = typeValueListElement;
    return this;
  }

   /**
   * Get typeValueListElement
   * @return typeValueListElement
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TYPE_VALUE_LIST_ELEMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ModelType getTypeValueListElement() {
    return typeValueListElement;
  }


  @JsonProperty(JSON_PROPERTY_TYPE_VALUE_LIST_ELEMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTypeValueListElement(ModelType typeValueListElement) {
    this.typeValueListElement = typeValueListElement;
  }


  public SubmodelElementListMetadata valueTypeListElement(DataTypeDefXsd valueTypeListElement) {
    this.valueTypeListElement = valueTypeListElement;
    return this;
  }

   /**
   * Get valueTypeListElement
   * @return valueTypeListElement
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_VALUE_TYPE_LIST_ELEMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public DataTypeDefXsd getValueTypeListElement() {
    return valueTypeListElement;
  }


  @JsonProperty(JSON_PROPERTY_VALUE_TYPE_LIST_ELEMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setValueTypeListElement(DataTypeDefXsd valueTypeListElement) {
    this.valueTypeListElement = valueTypeListElement;
  }


  public SubmodelElementListMetadata extensions(List<Extension> extensions) {
    this.extensions = extensions;
    return this;
  }

  public SubmodelElementListMetadata addExtensionsItem(Extension extensionsItem) {
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


  public SubmodelElementListMetadata category(String category) {
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


  public SubmodelElementListMetadata idShort(String idShort) {
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


  public SubmodelElementListMetadata displayName(List<LangStringNameType> displayName) {
    this.displayName = displayName;
    return this;
  }

  public SubmodelElementListMetadata addDisplayNameItem(LangStringNameType displayNameItem) {
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


  public SubmodelElementListMetadata description(List<LangStringTextType> description) {
    this.description = description;
    return this;
  }

  public SubmodelElementListMetadata addDescriptionItem(LangStringTextType descriptionItem) {
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


  public SubmodelElementListMetadata modelType(ModelType modelType) {
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

  public ModelType getModelType() {
    return modelType;
  }


  @JsonProperty(JSON_PROPERTY_MODEL_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setModelType(ModelType modelType) {
    this.modelType = modelType;
  }


  public SubmodelElementListMetadata embeddedDataSpecifications(List<EmbeddedDataSpecification> embeddedDataSpecifications) {
    this.embeddedDataSpecifications = embeddedDataSpecifications;
    return this;
  }

  public SubmodelElementListMetadata addEmbeddedDataSpecificationsItem(EmbeddedDataSpecification embeddedDataSpecificationsItem) {
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


  public SubmodelElementListMetadata semanticId(Reference semanticId) {
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


  public SubmodelElementListMetadata supplementalSemanticIds(List<Reference> supplementalSemanticIds) {
    this.supplementalSemanticIds = supplementalSemanticIds;
    return this;
  }

  public SubmodelElementListMetadata addSupplementalSemanticIdsItem(Reference supplementalSemanticIdsItem) {
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


  public SubmodelElementListMetadata qualifiers(List<Qualifier> qualifiers) {
    this.qualifiers = qualifiers;
    return this;
  }

  public SubmodelElementListMetadata addQualifiersItem(Qualifier qualifiersItem) {
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


  public SubmodelElementListMetadata kind(ModellingKind kind) {
    this.kind = kind;
    return this;
  }

   /**
   * Get kind
   * @return kind
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_KIND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ModellingKind getKind() {
    return kind;
  }


  @JsonProperty(JSON_PROPERTY_KIND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setKind(ModellingKind kind) {
    this.kind = kind;
  }


  /**
   * Return true if this SubmodelElementListMetadata object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubmodelElementListMetadata submodelElementListMetadata = (SubmodelElementListMetadata) o;
    return Objects.equals(this.orderRelevant, submodelElementListMetadata.orderRelevant) &&
        Objects.equals(this.semanticIdListElement, submodelElementListMetadata.semanticIdListElement) &&
        Objects.equals(this.typeValueListElement, submodelElementListMetadata.typeValueListElement) &&
        Objects.equals(this.valueTypeListElement, submodelElementListMetadata.valueTypeListElement) &&
        Objects.equals(this.extensions, submodelElementListMetadata.extensions) &&
        Objects.equals(this.category, submodelElementListMetadata.category) &&
        Objects.equals(this.idShort, submodelElementListMetadata.idShort) &&
        Objects.equals(this.displayName, submodelElementListMetadata.displayName) &&
        Objects.equals(this.description, submodelElementListMetadata.description) &&
        Objects.equals(this.modelType, submodelElementListMetadata.modelType) &&
        Objects.equals(this.embeddedDataSpecifications, submodelElementListMetadata.embeddedDataSpecifications) &&
        Objects.equals(this.semanticId, submodelElementListMetadata.semanticId) &&
        Objects.equals(this.supplementalSemanticIds, submodelElementListMetadata.supplementalSemanticIds) &&
        Objects.equals(this.qualifiers, submodelElementListMetadata.qualifiers) &&
        Objects.equals(this.kind, submodelElementListMetadata.kind);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderRelevant, semanticIdListElement, typeValueListElement, valueTypeListElement, extensions, category, idShort, displayName, description, modelType, embeddedDataSpecifications, semanticId, supplementalSemanticIds, qualifiers, kind);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubmodelElementListMetadata {\n");
    sb.append("    orderRelevant: ").append(toIndentedString(orderRelevant)).append("\n");
    sb.append("    semanticIdListElement: ").append(toIndentedString(semanticIdListElement)).append("\n");
    sb.append("    typeValueListElement: ").append(toIndentedString(typeValueListElement)).append("\n");
    sb.append("    valueTypeListElement: ").append(toIndentedString(valueTypeListElement)).append("\n");
    sb.append("    extensions: ").append(toIndentedString(extensions)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    idShort: ").append(toIndentedString(idShort)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    modelType: ").append(toIndentedString(modelType)).append("\n");
    sb.append("    embeddedDataSpecifications: ").append(toIndentedString(embeddedDataSpecifications)).append("\n");
    sb.append("    semanticId: ").append(toIndentedString(semanticId)).append("\n");
    sb.append("    supplementalSemanticIds: ").append(toIndentedString(supplementalSemanticIds)).append("\n");
    sb.append("    qualifiers: ").append(toIndentedString(qualifiers)).append("\n");
    sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
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

