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
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.AdministrativeInformation;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.EmbeddedDataSpecification;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Extension;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.LangStringNameType;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.LangStringTextType;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.ModelType;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Reference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * AssetAdministrationShellMetadata
 */
@JsonPropertyOrder({
  AssetAdministrationShellMetadata.JSON_PROPERTY_EXTENSIONS,
  AssetAdministrationShellMetadata.JSON_PROPERTY_CATEGORY,
  AssetAdministrationShellMetadata.JSON_PROPERTY_ID_SHORT,
  AssetAdministrationShellMetadata.JSON_PROPERTY_DISPLAY_NAME,
  AssetAdministrationShellMetadata.JSON_PROPERTY_DESCRIPTION,
  AssetAdministrationShellMetadata.JSON_PROPERTY_MODEL_TYPE,
  AssetAdministrationShellMetadata.JSON_PROPERTY_ADMINISTRATION,
  AssetAdministrationShellMetadata.JSON_PROPERTY_ID,
  AssetAdministrationShellMetadata.JSON_PROPERTY_EMBEDDED_DATA_SPECIFICATIONS,
  AssetAdministrationShellMetadata.JSON_PROPERTY_DERIVED_FROM
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:09.185125100+01:00[Europe/Berlin]")
public class AssetAdministrationShellMetadata {
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

  public static final String JSON_PROPERTY_ADMINISTRATION = "administration";
  private AdministrativeInformation administration;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_EMBEDDED_DATA_SPECIFICATIONS = "embeddedDataSpecifications";
  private List<EmbeddedDataSpecification> embeddedDataSpecifications;

  public static final String JSON_PROPERTY_DERIVED_FROM = "derivedFrom";
  private Reference derivedFrom;

  public AssetAdministrationShellMetadata() { 
  }

  public AssetAdministrationShellMetadata extensions(List<Extension> extensions) {
    this.extensions = extensions;
    return this;
  }

  public AssetAdministrationShellMetadata addExtensionsItem(Extension extensionsItem) {
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


  public AssetAdministrationShellMetadata category(String category) {
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


  public AssetAdministrationShellMetadata idShort(String idShort) {
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


  public AssetAdministrationShellMetadata displayName(List<LangStringNameType> displayName) {
    this.displayName = displayName;
    return this;
  }

  public AssetAdministrationShellMetadata addDisplayNameItem(LangStringNameType displayNameItem) {
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


  public AssetAdministrationShellMetadata description(List<LangStringTextType> description) {
    this.description = description;
    return this;
  }

  public AssetAdministrationShellMetadata addDescriptionItem(LangStringTextType descriptionItem) {
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


  public AssetAdministrationShellMetadata modelType(ModelType modelType) {
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


  public AssetAdministrationShellMetadata administration(AdministrativeInformation administration) {
    this.administration = administration;
    return this;
  }

   /**
   * Get administration
   * @return administration
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ADMINISTRATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public AdministrativeInformation getAdministration() {
    return administration;
  }


  @JsonProperty(JSON_PROPERTY_ADMINISTRATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAdministration(AdministrativeInformation administration) {
    this.administration = administration;
  }


  public AssetAdministrationShellMetadata id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setId(String id) {
    this.id = id;
  }


  public AssetAdministrationShellMetadata embeddedDataSpecifications(List<EmbeddedDataSpecification> embeddedDataSpecifications) {
    this.embeddedDataSpecifications = embeddedDataSpecifications;
    return this;
  }

  public AssetAdministrationShellMetadata addEmbeddedDataSpecificationsItem(EmbeddedDataSpecification embeddedDataSpecificationsItem) {
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


  public AssetAdministrationShellMetadata derivedFrom(Reference derivedFrom) {
    this.derivedFrom = derivedFrom;
    return this;
  }

   /**
   * Get derivedFrom
   * @return derivedFrom
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DERIVED_FROM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Reference getDerivedFrom() {
    return derivedFrom;
  }


  @JsonProperty(JSON_PROPERTY_DERIVED_FROM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDerivedFrom(Reference derivedFrom) {
    this.derivedFrom = derivedFrom;
  }


  /**
   * Return true if this AssetAdministrationShellMetadata object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AssetAdministrationShellMetadata assetAdministrationShellMetadata = (AssetAdministrationShellMetadata) o;
    return Objects.equals(this.extensions, assetAdministrationShellMetadata.extensions) &&
        Objects.equals(this.category, assetAdministrationShellMetadata.category) &&
        Objects.equals(this.idShort, assetAdministrationShellMetadata.idShort) &&
        Objects.equals(this.displayName, assetAdministrationShellMetadata.displayName) &&
        Objects.equals(this.description, assetAdministrationShellMetadata.description) &&
        Objects.equals(this.modelType, assetAdministrationShellMetadata.modelType) &&
        Objects.equals(this.administration, assetAdministrationShellMetadata.administration) &&
        Objects.equals(this.id, assetAdministrationShellMetadata.id) &&
        Objects.equals(this.embeddedDataSpecifications, assetAdministrationShellMetadata.embeddedDataSpecifications) &&
        Objects.equals(this.derivedFrom, assetAdministrationShellMetadata.derivedFrom);
  }

  @Override
  public int hashCode() {
    return Objects.hash(extensions, category, idShort, displayName, description, modelType, administration, id, embeddedDataSpecifications, derivedFrom);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AssetAdministrationShellMetadata {\n");
    sb.append("    extensions: ").append(toIndentedString(extensions)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    idShort: ").append(toIndentedString(idShort)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    modelType: ").append(toIndentedString(modelType)).append("\n");
    sb.append("    administration: ").append(toIndentedString(administration)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    embeddedDataSpecifications: ").append(toIndentedString(embeddedDataSpecifications)).append("\n");
    sb.append("    derivedFrom: ").append(toIndentedString(derivedFrom)).append("\n");
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

