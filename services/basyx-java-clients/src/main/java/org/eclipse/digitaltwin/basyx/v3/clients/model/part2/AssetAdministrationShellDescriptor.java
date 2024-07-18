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
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.AssetKind;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Extension;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.LangStringNameType;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.LangStringTextType;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.SpecificAssetId;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.Endpoint;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.SubmodelDescriptor;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * AssetAdministrationShellDescriptor
 */
@JsonPropertyOrder({
  AssetAdministrationShellDescriptor.JSON_PROPERTY_DESCRIPTION,
  AssetAdministrationShellDescriptor.JSON_PROPERTY_DISPLAY_NAME,
  AssetAdministrationShellDescriptor.JSON_PROPERTY_EXTENSIONS,
  AssetAdministrationShellDescriptor.JSON_PROPERTY_ADMINISTRATION,
  AssetAdministrationShellDescriptor.JSON_PROPERTY_ASSET_KIND,
  AssetAdministrationShellDescriptor.JSON_PROPERTY_ASSET_TYPE,
  AssetAdministrationShellDescriptor.JSON_PROPERTY_ENDPOINTS,
  AssetAdministrationShellDescriptor.JSON_PROPERTY_GLOBAL_ASSET_ID,
  AssetAdministrationShellDescriptor.JSON_PROPERTY_ID_SHORT,
  AssetAdministrationShellDescriptor.JSON_PROPERTY_ID,
  AssetAdministrationShellDescriptor.JSON_PROPERTY_SPECIFIC_ASSET_IDS,
  AssetAdministrationShellDescriptor.JSON_PROPERTY_SUBMODEL_DESCRIPTORS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:09.185125100+01:00[Europe/Berlin]")
public class AssetAdministrationShellDescriptor {
  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private List<LangStringTextType> description;

  public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
  private List<LangStringNameType> displayName;

  public static final String JSON_PROPERTY_EXTENSIONS = "extensions";
  private List<Extension> extensions;

  public static final String JSON_PROPERTY_ADMINISTRATION = "administration";
  private AdministrativeInformation administration;

  public static final String JSON_PROPERTY_ASSET_KIND = "assetKind";
  private AssetKind assetKind;

  public static final String JSON_PROPERTY_ASSET_TYPE = "assetType";
  private String assetType;

  public static final String JSON_PROPERTY_ENDPOINTS = "endpoints";
  private List<Endpoint> endpoints;

  public static final String JSON_PROPERTY_GLOBAL_ASSET_ID = "globalAssetId";
  private String globalAssetId;

  public static final String JSON_PROPERTY_ID_SHORT = "idShort";
  private String idShort;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_SPECIFIC_ASSET_IDS = "specificAssetIds";
  private List<SpecificAssetId> specificAssetIds;

  public static final String JSON_PROPERTY_SUBMODEL_DESCRIPTORS = "submodelDescriptors";
  private List<SubmodelDescriptor> submodelDescriptors;

  public AssetAdministrationShellDescriptor() { 
  }

  public AssetAdministrationShellDescriptor description(List<LangStringTextType> description) {
    this.description = description;
    return this;
  }

  public AssetAdministrationShellDescriptor addDescriptionItem(LangStringTextType descriptionItem) {
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


  public AssetAdministrationShellDescriptor displayName(List<LangStringNameType> displayName) {
    this.displayName = displayName;
    return this;
  }

  public AssetAdministrationShellDescriptor addDisplayNameItem(LangStringNameType displayNameItem) {
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


  public AssetAdministrationShellDescriptor extensions(List<Extension> extensions) {
    this.extensions = extensions;
    return this;
  }

  public AssetAdministrationShellDescriptor addExtensionsItem(Extension extensionsItem) {
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


  public AssetAdministrationShellDescriptor administration(AdministrativeInformation administration) {
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


  public AssetAdministrationShellDescriptor assetKind(AssetKind assetKind) {
    this.assetKind = assetKind;
    return this;
  }

   /**
   * Get assetKind
   * @return assetKind
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ASSET_KIND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public AssetKind getAssetKind() {
    return assetKind;
  }


  @JsonProperty(JSON_PROPERTY_ASSET_KIND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAssetKind(AssetKind assetKind) {
    this.assetKind = assetKind;
  }


  public AssetAdministrationShellDescriptor assetType(String assetType) {
    this.assetType = assetType;
    return this;
  }

   /**
   * Get assetType
   * @return assetType
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ASSET_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getAssetType() {
    return assetType;
  }


  @JsonProperty(JSON_PROPERTY_ASSET_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAssetType(String assetType) {
    this.assetType = assetType;
  }


  public AssetAdministrationShellDescriptor endpoints(List<Endpoint> endpoints) {
    this.endpoints = endpoints;
    return this;
  }

  public AssetAdministrationShellDescriptor addEndpointsItem(Endpoint endpointsItem) {
    if (this.endpoints == null) {
      this.endpoints = new ArrayList<>();
    }
    this.endpoints.add(endpointsItem);
    return this;
  }

   /**
   * Get endpoints
   * @return endpoints
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ENDPOINTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Endpoint> getEndpoints() {
    return endpoints;
  }


  @JsonProperty(JSON_PROPERTY_ENDPOINTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEndpoints(List<Endpoint> endpoints) {
    this.endpoints = endpoints;
  }


  public AssetAdministrationShellDescriptor globalAssetId(String globalAssetId) {
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


  public AssetAdministrationShellDescriptor idShort(String idShort) {
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


  public AssetAdministrationShellDescriptor id(String id) {
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


  public AssetAdministrationShellDescriptor specificAssetIds(List<SpecificAssetId> specificAssetIds) {
    this.specificAssetIds = specificAssetIds;
    return this;
  }

  public AssetAdministrationShellDescriptor addSpecificAssetIdsItem(SpecificAssetId specificAssetIdsItem) {
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


  public AssetAdministrationShellDescriptor submodelDescriptors(List<SubmodelDescriptor> submodelDescriptors) {
    this.submodelDescriptors = submodelDescriptors;
    return this;
  }

  public AssetAdministrationShellDescriptor addSubmodelDescriptorsItem(SubmodelDescriptor submodelDescriptorsItem) {
    if (this.submodelDescriptors == null) {
      this.submodelDescriptors = new ArrayList<>();
    }
    this.submodelDescriptors.add(submodelDescriptorsItem);
    return this;
  }

   /**
   * Get submodelDescriptors
   * @return submodelDescriptors
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SUBMODEL_DESCRIPTORS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<SubmodelDescriptor> getSubmodelDescriptors() {
    return submodelDescriptors;
  }


  @JsonProperty(JSON_PROPERTY_SUBMODEL_DESCRIPTORS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSubmodelDescriptors(List<SubmodelDescriptor> submodelDescriptors) {
    this.submodelDescriptors = submodelDescriptors;
  }


  /**
   * Return true if this AssetAdministrationShellDescriptor object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AssetAdministrationShellDescriptor assetAdministrationShellDescriptor = (AssetAdministrationShellDescriptor) o;
    return Objects.equals(this.description, assetAdministrationShellDescriptor.description) &&
        Objects.equals(this.displayName, assetAdministrationShellDescriptor.displayName) &&
        Objects.equals(this.extensions, assetAdministrationShellDescriptor.extensions) &&
        Objects.equals(this.administration, assetAdministrationShellDescriptor.administration) &&
        Objects.equals(this.assetKind, assetAdministrationShellDescriptor.assetKind) &&
        Objects.equals(this.assetType, assetAdministrationShellDescriptor.assetType) &&
        Objects.equals(this.endpoints, assetAdministrationShellDescriptor.endpoints) &&
        Objects.equals(this.globalAssetId, assetAdministrationShellDescriptor.globalAssetId) &&
        Objects.equals(this.idShort, assetAdministrationShellDescriptor.idShort) &&
        Objects.equals(this.id, assetAdministrationShellDescriptor.id) &&
        Objects.equals(this.specificAssetIds, assetAdministrationShellDescriptor.specificAssetIds) &&
        Objects.equals(this.submodelDescriptors, assetAdministrationShellDescriptor.submodelDescriptors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, displayName, extensions, administration, assetKind, assetType, endpoints, globalAssetId, idShort, id, specificAssetIds, submodelDescriptors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AssetAdministrationShellDescriptor {\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    extensions: ").append(toIndentedString(extensions)).append("\n");
    sb.append("    administration: ").append(toIndentedString(administration)).append("\n");
    sb.append("    assetKind: ").append(toIndentedString(assetKind)).append("\n");
    sb.append("    assetType: ").append(toIndentedString(assetType)).append("\n");
    sb.append("    endpoints: ").append(toIndentedString(endpoints)).append("\n");
    sb.append("    globalAssetId: ").append(toIndentedString(globalAssetId)).append("\n");
    sb.append("    idShort: ").append(toIndentedString(idShort)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    specificAssetIds: ").append(toIndentedString(specificAssetIds)).append("\n");
    sb.append("    submodelDescriptors: ").append(toIndentedString(submodelDescriptors)).append("\n");
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

