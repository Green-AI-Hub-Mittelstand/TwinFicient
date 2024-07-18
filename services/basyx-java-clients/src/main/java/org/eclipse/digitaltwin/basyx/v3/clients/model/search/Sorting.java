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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.digitaltwin.basyx.v3.clients.model.search.SortDirection;
import org.eclipse.digitaltwin.basyx.v3.clients.model.search.SortingPath;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Sorting
 */
@JsonPropertyOrder({
  Sorting.JSON_PROPERTY_DIRECTION,
  Sorting.JSON_PROPERTY_PATH
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:10.160916500+01:00[Europe/Berlin]")
public class Sorting {
  public static final String JSON_PROPERTY_DIRECTION = "direction";
  private SortDirection direction;

  public static final String JSON_PROPERTY_PATH = "path";
  private List<SortingPath> path = new ArrayList<>();

  public Sorting() { 
  }

  public Sorting direction(SortDirection direction) {
    this.direction = direction;
    return this;
  }

   /**
   * Get direction
   * @return direction
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DIRECTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SortDirection getDirection() {
    return direction;
  }


  @JsonProperty(JSON_PROPERTY_DIRECTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDirection(SortDirection direction) {
    this.direction = direction;
  }


  public Sorting path(List<SortingPath> path) {
    this.path = path;
    return this;
  }

  public Sorting addPathItem(SortingPath pathItem) {
    if (this.path == null) {
      this.path = new ArrayList<>();
    }
    this.path.add(pathItem);
    return this;
  }

   /**
   * Get path
   * @return path
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_PATH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<SortingPath> getPath() {
    return path;
  }


  @JsonProperty(JSON_PROPERTY_PATH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPath(List<SortingPath> path) {
    this.path = path;
  }


  /**
   * Return true if this Sorting object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Sorting sorting = (Sorting) o;
    return Objects.equals(this.direction, sorting.direction) &&
        Objects.equals(this.path, sorting.path);
  }

  @Override
  public int hashCode() {
    return Objects.hash(direction, path);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Sorting {\n");
    sb.append("    direction: ").append(toIndentedString(direction)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
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

