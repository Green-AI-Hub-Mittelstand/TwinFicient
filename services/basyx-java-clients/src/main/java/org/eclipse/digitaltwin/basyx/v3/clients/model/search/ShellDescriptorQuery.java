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
 * ShellDescriptorQuery
 */
@JsonPropertyOrder({
  ShellDescriptorQuery.JSON_PROPERTY_PATH,
  ShellDescriptorQuery.JSON_PROPERTY_VALUE,
  ShellDescriptorQuery.JSON_PROPERTY_EXTENSION_NAME,
  ShellDescriptorQuery.JSON_PROPERTY_QUERY_TYPE,
  ShellDescriptorQuery.JSON_PROPERTY_COMBINED_WITH
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:10.160916500+01:00[Europe/Berlin]")
public class ShellDescriptorQuery {
  public static final String JSON_PROPERTY_PATH = "path";
  private String path;

  public static final String JSON_PROPERTY_VALUE = "value";
  private String value;

  public static final String JSON_PROPERTY_EXTENSION_NAME = "extensionName";
  private String extensionName;

  /**
   * Gets or Sets queryType
   */
  public enum QueryTypeEnum {
    MATCH("match"),
    
    REGEX("regex");

    private String value;

    QueryTypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static QueryTypeEnum fromValue(String value) {
      for (QueryTypeEnum b : QueryTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_QUERY_TYPE = "queryType";
  private QueryTypeEnum queryType = QueryTypeEnum.MATCH;

  public static final String JSON_PROPERTY_COMBINED_WITH = "combinedWith";
  private ShellDescriptorQuery combinedWith;

  public ShellDescriptorQuery() { 
  }

  public ShellDescriptorQuery path(String path) {
    this.path = path;
    return this;
  }

   /**
   * Get path
   * @return path
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_PATH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getPath() {
    return path;
  }


  @JsonProperty(JSON_PROPERTY_PATH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPath(String path) {
    this.path = path;
  }


  public ShellDescriptorQuery value(String value) {
    this.value = value;
    return this;
  }

   /**
   * Get value
   * @return value
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getValue() {
    return value;
  }


  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setValue(String value) {
    this.value = value;
  }


  public ShellDescriptorQuery extensionName(String extensionName) {
    this.extensionName = extensionName;
    return this;
  }

   /**
   * If this property is set, the query applies only to the extension of this name. In this case, the path must reference the value property of the extension object. 
   * @return extensionName
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_EXTENSION_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getExtensionName() {
    return extensionName;
  }


  @JsonProperty(JSON_PROPERTY_EXTENSION_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExtensionName(String extensionName) {
    this.extensionName = extensionName;
  }


  public ShellDescriptorQuery queryType(QueryTypeEnum queryType) {
    this.queryType = queryType;
    return this;
  }

   /**
   * Get queryType
   * @return queryType
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_QUERY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public QueryTypeEnum getQueryType() {
    return queryType;
  }


  @JsonProperty(JSON_PROPERTY_QUERY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setQueryType(QueryTypeEnum queryType) {
    this.queryType = queryType;
  }


  public ShellDescriptorQuery combinedWith(ShellDescriptorQuery combinedWith) {
    this.combinedWith = combinedWith;
    return this;
  }

   /**
   * Get combinedWith
   * @return combinedWith
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_COMBINED_WITH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ShellDescriptorQuery getCombinedWith() {
    return combinedWith;
  }


  @JsonProperty(JSON_PROPERTY_COMBINED_WITH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCombinedWith(ShellDescriptorQuery combinedWith) {
    this.combinedWith = combinedWith;
  }


  /**
   * Return true if this ShellDescriptorQuery object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShellDescriptorQuery shellDescriptorQuery = (ShellDescriptorQuery) o;
    return Objects.equals(this.path, shellDescriptorQuery.path) &&
        Objects.equals(this.value, shellDescriptorQuery.value) &&
        Objects.equals(this.extensionName, shellDescriptorQuery.extensionName) &&
        Objects.equals(this.queryType, shellDescriptorQuery.queryType) &&
        Objects.equals(this.combinedWith, shellDescriptorQuery.combinedWith);
  }

  @Override
  public int hashCode() {
    return Objects.hash(path, value, extensionName, queryType, combinedWith);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShellDescriptorQuery {\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    extensionName: ").append(toIndentedString(extensionName)).append("\n");
    sb.append("    queryType: ").append(toIndentedString(queryType)).append("\n");
    sb.append("    combinedWith: ").append(toIndentedString(combinedWith)).append("\n");
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

