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
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * FileValue
 */
@JsonPropertyOrder({
  FileValue.JSON_PROPERTY_CONTENT_TYPE,
  FileValue.JSON_PROPERTY_VALUE
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:09.185125100+01:00[Europe/Berlin]")
public class FileValue {
  public static final String JSON_PROPERTY_CONTENT_TYPE = "contentType";
  private String contentType;

  public static final String JSON_PROPERTY_VALUE = "value";
  private String value;

  public FileValue() { 
  }

  public FileValue contentType(String contentType) {
    this.contentType = contentType;
    return this;
  }

   /**
   * Get contentType
   * @return contentType
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_CONTENT_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getContentType() {
    return contentType;
  }


  @JsonProperty(JSON_PROPERTY_CONTENT_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setContentType(String contentType) {
    this.contentType = contentType;
  }


  public FileValue value(String value) {
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


  /**
   * Return true if this FileValue object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FileValue fileValue = (FileValue) o;
    return Objects.equals(this.contentType, fileValue.contentType) &&
        Objects.equals(this.value, fileValue.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contentType, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FileValue {\n");
    sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

