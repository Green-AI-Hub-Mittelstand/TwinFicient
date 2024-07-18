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

package org.eclipse.digitaltwin.basyx.v3.clients.model.search;

import java.util.Objects;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import org.eclipse.digitaltwin.basyx.v3.clients.model.search.Page;
import org.eclipse.digitaltwin.basyx.v3.clients.model.search.ShellDescriptorQuery;
import org.eclipse.digitaltwin.basyx.v3.clients.model.search.Sorting;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * ShellDescriptorSearchRequest
 */
@JsonPropertyOrder({
  ShellDescriptorSearchRequest.JSON_PROPERTY_PAGE,
  ShellDescriptorSearchRequest.JSON_PROPERTY_SORT_BY,
  ShellDescriptorSearchRequest.JSON_PROPERTY_QUERY
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:10.160916500+01:00[Europe/Berlin]")
public class ShellDescriptorSearchRequest {
  public static final String JSON_PROPERTY_PAGE = "page";
  private Page page;

  public static final String JSON_PROPERTY_SORT_BY = "sortBy";
  private Sorting sortBy;

  public static final String JSON_PROPERTY_QUERY = "query";
  private ShellDescriptorQuery query;

  public ShellDescriptorSearchRequest() { 
  }

  public ShellDescriptorSearchRequest page(Page page) {
    this.page = page;
    return this;
  }

   /**
   * Get page
   * @return page
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Page getPage() {
    return page;
  }


  @JsonProperty(JSON_PROPERTY_PAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPage(Page page) {
    this.page = page;
  }


  public ShellDescriptorSearchRequest sortBy(Sorting sortBy) {
    this.sortBy = sortBy;
    return this;
  }

   /**
   * Get sortBy
   * @return sortBy
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SORT_BY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Sorting getSortBy() {
    return sortBy;
  }


  @JsonProperty(JSON_PROPERTY_SORT_BY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSortBy(Sorting sortBy) {
    this.sortBy = sortBy;
  }


  public ShellDescriptorSearchRequest query(ShellDescriptorQuery query) {
    this.query = query;
    return this;
  }

   /**
   * Get query
   * @return query
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_QUERY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ShellDescriptorQuery getQuery() {
    return query;
  }


  @JsonProperty(JSON_PROPERTY_QUERY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setQuery(ShellDescriptorQuery query) {
    this.query = query;
  }


  /**
   * Return true if this ShellDescriptorSearchRequest object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShellDescriptorSearchRequest shellDescriptorSearchRequest = (ShellDescriptorSearchRequest) o;
    return Objects.equals(this.page, shellDescriptorSearchRequest.page) &&
        Objects.equals(this.sortBy, shellDescriptorSearchRequest.sortBy) &&
        Objects.equals(this.query, shellDescriptorSearchRequest.query);
  }

  @Override
  public int hashCode() {
    return Objects.hash(page, sortBy, query);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShellDescriptorSearchRequest {\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    sortBy: ").append(toIndentedString(sortBy)).append("\n");
    sb.append("    query: ").append(toIndentedString(query)).append("\n");
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

