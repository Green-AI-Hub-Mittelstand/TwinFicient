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
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.AdministrativeInformation;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.AssetInformation;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.EmbeddedDataSpecification;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Extension;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.LangStringNameType;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.LangStringTextType;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Reference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * AssetAdministrationShell
 */
@JsonPropertyOrder({
  AssetAdministrationShell.JSON_PROPERTY_EXTENSIONS,
  AssetAdministrationShell.JSON_PROPERTY_CATEGORY,
  AssetAdministrationShell.JSON_PROPERTY_ID_SHORT,
  AssetAdministrationShell.JSON_PROPERTY_DISPLAY_NAME,
  AssetAdministrationShell.JSON_PROPERTY_DESCRIPTION,
  AssetAdministrationShell.JSON_PROPERTY_MODEL_TYPE,
  AssetAdministrationShell.JSON_PROPERTY_ADMINISTRATION,
  AssetAdministrationShell.JSON_PROPERTY_ID,
  AssetAdministrationShell.JSON_PROPERTY_EMBEDDED_DATA_SPECIFICATIONS,
  AssetAdministrationShell.JSON_PROPERTY_DERIVED_FROM,
  AssetAdministrationShell.JSON_PROPERTY_ASSET_INFORMATION,
  AssetAdministrationShell.JSON_PROPERTY_SUBMODELS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:07.399784100+01:00[Europe/Berlin]")
public class AssetAdministrationShell {
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

  public static final String JSON_PROPERTY_ADMINISTRATION = "administration";
  private AdministrativeInformation administration;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_EMBEDDED_DATA_SPECIFICATIONS = "embeddedDataSpecifications";
  private List<EmbeddedDataSpecification> embeddedDataSpecifications;

  public static final String JSON_PROPERTY_DERIVED_FROM = "derivedFrom";
  private Reference derivedFrom;

  public static final String JSON_PROPERTY_ASSET_INFORMATION = "assetInformation";
  private AssetInformation assetInformation;

  public static final String JSON_PROPERTY_SUBMODELS = "submodels";
  private List<Reference> submodels;

  public AssetAdministrationShell() { 
  }

  public AssetAdministrationShell extensions(List<Extension> extensions) {
    this.extensions = extensions;
    return this;
  }

  public AssetAdministrationShell addExtensionsItem(Extension extensionsItem) {
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


  public AssetAdministrationShell category(String category) {
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


  public AssetAdministrationShell idShort(String idShort) {
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


  public AssetAdministrationShell displayName(List<LangStringNameType> displayName) {
    this.displayName = displayName;
    return this;
  }

  public AssetAdministrationShell addDisplayNameItem(LangStringNameType displayNameItem) {
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


  public AssetAdministrationShell description(List<LangStringTextType> description) {
    this.description = description;
    return this;
  }

  public AssetAdministrationShell addDescriptionItem(LangStringTextType descriptionItem) {
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


  public AssetAdministrationShell modelType(String modelType) {
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


  public AssetAdministrationShell administration(AdministrativeInformation administration) {
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


  public AssetAdministrationShell id(String id) {
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


  public AssetAdministrationShell embeddedDataSpecifications(List<EmbeddedDataSpecification> embeddedDataSpecifications) {
    this.embeddedDataSpecifications = embeddedDataSpecifications;
    return this;
  }

  public AssetAdministrationShell addEmbeddedDataSpecificationsItem(EmbeddedDataSpecification embeddedDataSpecificationsItem) {
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


  public AssetAdministrationShell derivedFrom(Reference derivedFrom) {
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


  public AssetAdministrationShell assetInformation(AssetInformation assetInformation) {
    this.assetInformation = assetInformation;
    return this;
  }

   /**
   * Get assetInformation
   * @return assetInformation
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_ASSET_INFORMATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public AssetInformation getAssetInformation() {
    return assetInformation;
  }


  @JsonProperty(JSON_PROPERTY_ASSET_INFORMATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAssetInformation(AssetInformation assetInformation) {
    this.assetInformation = assetInformation;
  }


  public AssetAdministrationShell submodels(List<Reference> submodels) {
    this.submodels = submodels;
    return this;
  }

  public AssetAdministrationShell addSubmodelsItem(Reference submodelsItem) {
    if (this.submodels == null) {
      this.submodels = new ArrayList<>();
    }
    this.submodels.add(submodelsItem);
    return this;
  }

   /**
   * Get submodels
   * @return submodels
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SUBMODELS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Reference> getSubmodels() {
    return submodels;
  }


  @JsonProperty(JSON_PROPERTY_SUBMODELS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSubmodels(List<Reference> submodels) {
    this.submodels = submodels;
  }


  /**
   * Return true if this AssetAdministrationShell object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AssetAdministrationShell assetAdministrationShell = (AssetAdministrationShell) o;
    return Objects.equals(this.extensions, assetAdministrationShell.extensions) &&
        Objects.equals(this.category, assetAdministrationShell.category) &&
        Objects.equals(this.idShort, assetAdministrationShell.idShort) &&
        Objects.equals(this.displayName, assetAdministrationShell.displayName) &&
        Objects.equals(this.description, assetAdministrationShell.description) &&
        Objects.equals(this.modelType, assetAdministrationShell.modelType) &&
        Objects.equals(this.administration, assetAdministrationShell.administration) &&
        Objects.equals(this.id, assetAdministrationShell.id) &&
        Objects.equals(this.embeddedDataSpecifications, assetAdministrationShell.embeddedDataSpecifications) &&
        Objects.equals(this.derivedFrom, assetAdministrationShell.derivedFrom) &&
        Objects.equals(this.assetInformation, assetAdministrationShell.assetInformation) &&
        Objects.equals(this.submodels, assetAdministrationShell.submodels);
  }

  @Override
  public int hashCode() {
    return Objects.hash(extensions, category, idShort, displayName, description, modelType, administration, id, embeddedDataSpecifications, derivedFrom, assetInformation, submodels);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AssetAdministrationShell {\n");
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
    sb.append("    assetInformation: ").append(toIndentedString(assetInformation)).append("\n");
    sb.append("    submodels: ").append(toIndentedString(submodels)).append("\n");
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

