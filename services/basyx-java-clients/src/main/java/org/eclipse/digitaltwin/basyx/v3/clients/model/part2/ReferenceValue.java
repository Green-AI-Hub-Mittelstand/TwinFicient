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
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Key;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.ReferenceTypes;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * ReferenceValue
 */
@JsonPropertyOrder({
  ReferenceValue.JSON_PROPERTY_TYPE,
  ReferenceValue.JSON_PROPERTY_KEYS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:09.185125100+01:00[Europe/Berlin]")
public class ReferenceValue {
  public static final String JSON_PROPERTY_TYPE = "type";
  private ReferenceTypes type;

  public static final String JSON_PROPERTY_KEYS = "keys";
  private List<Key> keys;

  public ReferenceValue() { 
  }

  public ReferenceValue type(ReferenceTypes type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ReferenceTypes getType() {
    return type;
  }


  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(ReferenceTypes type) {
    this.type = type;
  }


  public ReferenceValue keys(List<Key> keys) {
    this.keys = keys;
    return this;
  }

  public ReferenceValue addKeysItem(Key keysItem) {
    if (this.keys == null) {
      this.keys = new ArrayList<>();
    }
    this.keys.add(keysItem);
    return this;
  }

   /**
   * Get keys
   * @return keys
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_KEYS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Key> getKeys() {
    return keys;
  }


  @JsonProperty(JSON_PROPERTY_KEYS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setKeys(List<Key> keys) {
    this.keys = keys;
  }


  /**
   * Return true if this ReferenceValue object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReferenceValue referenceValue = (ReferenceValue) o;
    return Objects.equals(this.type, referenceValue.type) &&
        Objects.equals(this.keys, referenceValue.keys);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, keys);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReferenceValue {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    keys: ").append(toIndentedString(keys)).append("\n");
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

