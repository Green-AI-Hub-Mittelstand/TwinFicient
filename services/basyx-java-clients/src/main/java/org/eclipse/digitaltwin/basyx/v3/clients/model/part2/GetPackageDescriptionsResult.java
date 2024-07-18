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
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.PackageDescription;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.PagedResultPagingMetadata;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * GetPackageDescriptionsResult
 */
@JsonPropertyOrder({
  GetPackageDescriptionsResult.JSON_PROPERTY_PAGING_METADATA,
  GetPackageDescriptionsResult.JSON_PROPERTY_RESULT
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:09.185125100+01:00[Europe/Berlin]")
public class GetPackageDescriptionsResult {
  public static final String JSON_PROPERTY_PAGING_METADATA = "paging_metadata";
  private PagedResultPagingMetadata pagingMetadata;

  public static final String JSON_PROPERTY_RESULT = "result";
  private List<PackageDescription> result;

  public GetPackageDescriptionsResult() { 
  }

  public GetPackageDescriptionsResult pagingMetadata(PagedResultPagingMetadata pagingMetadata) {
    this.pagingMetadata = pagingMetadata;
    return this;
  }

   /**
   * Get pagingMetadata
   * @return pagingMetadata
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PAGING_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PagedResultPagingMetadata getPagingMetadata() {
    return pagingMetadata;
  }


  @JsonProperty(JSON_PROPERTY_PAGING_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPagingMetadata(PagedResultPagingMetadata pagingMetadata) {
    this.pagingMetadata = pagingMetadata;
  }


  public GetPackageDescriptionsResult result(List<PackageDescription> result) {
    this.result = result;
    return this;
  }

  public GetPackageDescriptionsResult addResultItem(PackageDescription resultItem) {
    if (this.result == null) {
      this.result = new ArrayList<>();
    }
    this.result.add(resultItem);
    return this;
  }

   /**
   * Get result
   * @return result
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<PackageDescription> getResult() {
    return result;
  }


  @JsonProperty(JSON_PROPERTY_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setResult(List<PackageDescription> result) {
    this.result = result;
  }


  /**
   * Return true if this GetPackageDescriptionsResult object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetPackageDescriptionsResult getPackageDescriptionsResult = (GetPackageDescriptionsResult) o;
    return Objects.equals(this.pagingMetadata, getPackageDescriptionsResult.pagingMetadata) &&
        Objects.equals(this.result, getPackageDescriptionsResult.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pagingMetadata, result);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetPackageDescriptionsResult {\n");
    sb.append("    pagingMetadata: ").append(toIndentedString(pagingMetadata)).append("\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
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

