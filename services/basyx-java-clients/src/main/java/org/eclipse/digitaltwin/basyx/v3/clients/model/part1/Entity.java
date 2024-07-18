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
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.EntityType;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Extension;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.LangStringNameType;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.LangStringTextType;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Qualifier;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Reference;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.SpecificAssetId;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.SubmodelElementChoice;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Entity
 */
@JsonPropertyOrder({
  Entity.JSON_PROPERTY_EXTENSIONS,
  Entity.JSON_PROPERTY_CATEGORY,
  Entity.JSON_PROPERTY_ID_SHORT,
  Entity.JSON_PROPERTY_DISPLAY_NAME,
  Entity.JSON_PROPERTY_DESCRIPTION,
  Entity.JSON_PROPERTY_MODEL_TYPE,
  Entity.JSON_PROPERTY_SEMANTIC_ID,
  Entity.JSON_PROPERTY_SUPPLEMENTAL_SEMANTIC_IDS,
  Entity.JSON_PROPERTY_QUALIFIERS,
  Entity.JSON_PROPERTY_EMBEDDED_DATA_SPECIFICATIONS,
  Entity.JSON_PROPERTY_STATEMENTS,
  Entity.JSON_PROPERTY_ENTITY_TYPE,
  Entity.JSON_PROPERTY_GLOBAL_ASSET_ID,
  Entity.JSON_PROPERTY_SPECIFIC_ASSET_IDS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:07.399784100+01:00[Europe/Berlin]")
public class Entity {
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

  public static final String JSON_PROPERTY_STATEMENTS = "statements";
  private List<SubmodelElementChoice> statements;

  public static final String JSON_PROPERTY_ENTITY_TYPE = "entityType";
  private EntityType entityType;

  public static final String JSON_PROPERTY_GLOBAL_ASSET_ID = "globalAssetId";
  private String globalAssetId;

  public static final String JSON_PROPERTY_SPECIFIC_ASSET_IDS = "specificAssetIds";
  private List<SpecificAssetId> specificAssetIds;

  public Entity() { 
  }

  public Entity extensions(List<Extension> extensions) {
    this.extensions = extensions;
    return this;
  }

  public Entity addExtensionsItem(Extension extensionsItem) {
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


  public Entity category(String category) {
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


  public Entity idShort(String idShort) {
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


  public Entity displayName(List<LangStringNameType> displayName) {
    this.displayName = displayName;
    return this;
  }

  public Entity addDisplayNameItem(LangStringNameType displayNameItem) {
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


  public Entity description(List<LangStringTextType> description) {
    this.description = description;
    return this;
  }

  public Entity addDescriptionItem(LangStringTextType descriptionItem) {
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


  public Entity modelType(String modelType) {
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


  public Entity semanticId(Reference semanticId) {
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


  public Entity supplementalSemanticIds(List<Reference> supplementalSemanticIds) {
    this.supplementalSemanticIds = supplementalSemanticIds;
    return this;
  }

  public Entity addSupplementalSemanticIdsItem(Reference supplementalSemanticIdsItem) {
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


  public Entity qualifiers(List<Qualifier> qualifiers) {
    this.qualifiers = qualifiers;
    return this;
  }

  public Entity addQualifiersItem(Qualifier qualifiersItem) {
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


  public Entity embeddedDataSpecifications(List<EmbeddedDataSpecification> embeddedDataSpecifications) {
    this.embeddedDataSpecifications = embeddedDataSpecifications;
    return this;
  }

  public Entity addEmbeddedDataSpecificationsItem(EmbeddedDataSpecification embeddedDataSpecificationsItem) {
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


  public Entity statements(List<SubmodelElementChoice> statements) {
    this.statements = statements;
    return this;
  }

  public Entity addStatementsItem(SubmodelElementChoice statementsItem) {
    if (this.statements == null) {
      this.statements = new ArrayList<>();
    }
    this.statements.add(statementsItem);
    return this;
  }

   /**
   * Get statements
   * @return statements
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_STATEMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<SubmodelElementChoice> getStatements() {
    return statements;
  }


  @JsonProperty(JSON_PROPERTY_STATEMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStatements(List<SubmodelElementChoice> statements) {
    this.statements = statements;
  }


  public Entity entityType(EntityType entityType) {
    this.entityType = entityType;
    return this;
  }

   /**
   * Get entityType
   * @return entityType
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_ENTITY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public EntityType getEntityType() {
    return entityType;
  }


  @JsonProperty(JSON_PROPERTY_ENTITY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEntityType(EntityType entityType) {
    this.entityType = entityType;
  }


  public Entity globalAssetId(String globalAssetId) {
    this.globalAssetId = globalAssetId;
    return this;
  }

   /**
   * Get globalAssetId
   * @return globalAssetId
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_GLOBAL_ASSET_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getGlobalAssetId() {
    return globalAssetId;
  }


  @JsonProperty(JSON_PROPERTY_GLOBAL_ASSET_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setGlobalAssetId(String globalAssetId) {
    this.globalAssetId = globalAssetId;
  }


  public Entity specificAssetIds(List<SpecificAssetId> specificAssetIds) {
    this.specificAssetIds = specificAssetIds;
    return this;
  }

  public Entity addSpecificAssetIdsItem(SpecificAssetId specificAssetIdsItem) {
    if (this.specificAssetIds == null) {
      this.specificAssetIds = new ArrayList<>();
    }
    this.specificAssetIds.add(specificAssetIdsItem);
    return this;
  }

   /**
   * Get specificAssetIds
   * @return specificAssetIds
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SPECIFIC_ASSET_IDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<SpecificAssetId> getSpecificAssetIds() {
    return specificAssetIds;
  }


  @JsonProperty(JSON_PROPERTY_SPECIFIC_ASSET_IDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSpecificAssetIds(List<SpecificAssetId> specificAssetIds) {
    this.specificAssetIds = specificAssetIds;
  }


  /**
   * Return true if this Entity object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Entity entity = (Entity) o;
    return Objects.equals(this.extensions, entity.extensions) &&
        Objects.equals(this.category, entity.category) &&
        Objects.equals(this.idShort, entity.idShort) &&
        Objects.equals(this.displayName, entity.displayName) &&
        Objects.equals(this.description, entity.description) &&
        Objects.equals(this.modelType, entity.modelType) &&
        Objects.equals(this.semanticId, entity.semanticId) &&
        Objects.equals(this.supplementalSemanticIds, entity.supplementalSemanticIds) &&
        Objects.equals(this.qualifiers, entity.qualifiers) &&
        Objects.equals(this.embeddedDataSpecifications, entity.embeddedDataSpecifications) &&
        Objects.equals(this.statements, entity.statements) &&
        Objects.equals(this.entityType, entity.entityType) &&
        Objects.equals(this.globalAssetId, entity.globalAssetId) &&
        Objects.equals(this.specificAssetIds, entity.specificAssetIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(extensions, category, idShort, displayName, description, modelType, semanticId, supplementalSemanticIds, qualifiers, embeddedDataSpecifications, statements, entityType, globalAssetId, specificAssetIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Entity {\n");
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
    sb.append("    statements: ").append(toIndentedString(statements)).append("\n");
    sb.append("    entityType: ").append(toIndentedString(entityType)).append("\n");
    sb.append("    globalAssetId: ").append(toIndentedString(globalAssetId)).append("\n");
    sb.append("    specificAssetIds: ").append(toIndentedString(specificAssetIds)).append("\n");
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

