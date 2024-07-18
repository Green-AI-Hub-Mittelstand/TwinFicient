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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * PackageDescription
 */
@JsonPropertyOrder({
  PackageDescription.JSON_PROPERTY_AAS_IDS,
  PackageDescription.JSON_PROPERTY_PACKAGE_ID
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:09.185125100+01:00[Europe/Berlin]")
public class PackageDescription {
  public static final String JSON_PROPERTY_AAS_IDS = "aasIds";
  private List<String> aasIds;

  public static final String JSON_PROPERTY_PACKAGE_ID = "packageId";
  private String packageId;

  public PackageDescription() { 
  }

  public PackageDescription aasIds(List<String> aasIds) {
    this.aasIds = aasIds;
    return this;
  }

  public PackageDescription addAasIdsItem(String aasIdsItem) {
    if (this.aasIds == null) {
      this.aasIds = new ArrayList<>();
    }
    this.aasIds.add(aasIdsItem);
    return this;
  }

   /**
   * Get aasIds
   * @return aasIds
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_AAS_IDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getAasIds() {
    return aasIds;
  }


  @JsonProperty(JSON_PROPERTY_AAS_IDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAasIds(List<String> aasIds) {
    this.aasIds = aasIds;
  }


  public PackageDescription packageId(String packageId) {
    this.packageId = packageId;
    return this;
  }

   /**
   * Get packageId
   * @return packageId
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PACKAGE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPackageId() {
    return packageId;
  }


  @JsonProperty(JSON_PROPERTY_PACKAGE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPackageId(String packageId) {
    this.packageId = packageId;
  }


  /**
   * Return true if this PackageDescription object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PackageDescription packageDescription = (PackageDescription) o;
    return Objects.equals(this.aasIds, packageDescription.aasIds) &&
        Objects.equals(this.packageId, packageDescription.packageId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aasIds, packageId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PackageDescription {\n");
    sb.append("    aasIds: ").append(toIndentedString(aasIds)).append("\n");
    sb.append("    packageId: ").append(toIndentedString(packageId)).append("\n");
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

