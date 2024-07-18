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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Page
 */
@JsonPropertyOrder({
  Page.JSON_PROPERTY_INDEX,
  Page.JSON_PROPERTY_SIZE
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:10.160916500+01:00[Europe/Berlin]")
public class Page {
  public static final String JSON_PROPERTY_INDEX = "index";
  private Integer index;

  public static final String JSON_PROPERTY_SIZE = "size";
  private Integer size;

  public Page() { 
  }

  public Page index(Integer index) {
    this.index = index;
    return this;
  }

   /**
   * Get index
   * minimum: 0
   * @return index
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_INDEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getIndex() {
    return index;
  }


  @JsonProperty(JSON_PROPERTY_INDEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIndex(Integer index) {
    this.index = index;
  }


  public Page size(Integer size) {
    this.size = size;
    return this;
  }

   /**
   * Get size
   * minimum: 1
   * maximum: 10000
   * @return size
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_SIZE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getSize() {
    return size;
  }


  @JsonProperty(JSON_PROPERTY_SIZE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSize(Integer size) {
    this.size = size;
  }


  /**
   * Return true if this Page object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Page page = (Page) o;
    return Objects.equals(this.index, page.index) &&
        Objects.equals(this.size, page.size);
  }

  @Override
  public int hashCode() {
    return Objects.hash(index, size);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Page {\n");
    sb.append("    index: ").append(toIndentedString(index)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
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

