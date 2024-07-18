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
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.AssetKind;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Resource;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.SpecificAssetId;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * AssetInformation
 */
@JsonPropertyOrder({
  AssetInformation.JSON_PROPERTY_ASSET_KIND,
  AssetInformation.JSON_PROPERTY_GLOBAL_ASSET_ID,
  AssetInformation.JSON_PROPERTY_SPECIFIC_ASSET_IDS,
  AssetInformation.JSON_PROPERTY_ASSET_TYPE,
  AssetInformation.JSON_PROPERTY_DEFAULT_THUMBNAIL
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:07.399784100+01:00[Europe/Berlin]")
public class AssetInformation {
  public static final String JSON_PROPERTY_ASSET_KIND = "assetKind";
  private AssetKind assetKind;

  public static final String JSON_PROPERTY_GLOBAL_ASSET_ID = "globalAssetId";
  private String globalAssetId;

  public static final String JSON_PROPERTY_SPECIFIC_ASSET_IDS = "specificAssetIds";
  private List<SpecificAssetId> specificAssetIds;

  public static final String JSON_PROPERTY_ASSET_TYPE = "assetType";
  private String assetType;

  public static final String JSON_PROPERTY_DEFAULT_THUMBNAIL = "defaultThumbnail";
  private Resource defaultThumbnail;

  public AssetInformation() { 
  }

  public AssetInformation assetKind(AssetKind assetKind) {
    this.assetKind = assetKind;
    return this;
  }

   /**
   * Get assetKind
   * @return assetKind
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_ASSET_KIND)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public AssetKind getAssetKind() {
    return assetKind;
  }


  @JsonProperty(JSON_PROPERTY_ASSET_KIND)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAssetKind(AssetKind assetKind) {
    this.assetKind = assetKind;
  }


  public AssetInformation globalAssetId(String globalAssetId) {
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


  public AssetInformation specificAssetIds(List<SpecificAssetId> specificAssetIds) {
    this.specificAssetIds = specificAssetIds;
    return this;
  }

  public AssetInformation addSpecificAssetIdsItem(SpecificAssetId specificAssetIdsItem) {
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


  public AssetInformation assetType(String assetType) {
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


  public AssetInformation defaultThumbnail(Resource defaultThumbnail) {
    this.defaultThumbnail = defaultThumbnail;
    return this;
  }

   /**
   * Get defaultThumbnail
   * @return defaultThumbnail
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DEFAULT_THUMBNAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Resource getDefaultThumbnail() {
    return defaultThumbnail;
  }


  @JsonProperty(JSON_PROPERTY_DEFAULT_THUMBNAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDefaultThumbnail(Resource defaultThumbnail) {
    this.defaultThumbnail = defaultThumbnail;
  }


  /**
   * Return true if this AssetInformation object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AssetInformation assetInformation = (AssetInformation) o;
    return Objects.equals(this.assetKind, assetInformation.assetKind) &&
        Objects.equals(this.globalAssetId, assetInformation.globalAssetId) &&
        Objects.equals(this.specificAssetIds, assetInformation.specificAssetIds) &&
        Objects.equals(this.assetType, assetInformation.assetType) &&
        Objects.equals(this.defaultThumbnail, assetInformation.defaultThumbnail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(assetKind, globalAssetId, specificAssetIds, assetType, defaultThumbnail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AssetInformation {\n");
    sb.append("    assetKind: ").append(toIndentedString(assetKind)).append("\n");
    sb.append("    globalAssetId: ").append(toIndentedString(globalAssetId)).append("\n");
    sb.append("    specificAssetIds: ").append(toIndentedString(specificAssetIds)).append("\n");
    sb.append("    assetType: ").append(toIndentedString(assetType)).append("\n");
    sb.append("    defaultThumbnail: ").append(toIndentedString(defaultThumbnail)).append("\n");
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

