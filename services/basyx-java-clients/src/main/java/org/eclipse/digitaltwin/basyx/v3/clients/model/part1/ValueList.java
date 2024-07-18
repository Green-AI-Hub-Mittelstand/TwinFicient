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
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.ValueReferencePair;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * ValueList
 */
@JsonPropertyOrder({
  ValueList.JSON_PROPERTY_VALUE_REFERENCE_PAIRS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:07.399784100+01:00[Europe/Berlin]")
public class ValueList {
  public static final String JSON_PROPERTY_VALUE_REFERENCE_PAIRS = "valueReferencePairs";
  private List<ValueReferencePair> valueReferencePairs = new ArrayList<>();

  public ValueList() { 
  }

  public ValueList valueReferencePairs(List<ValueReferencePair> valueReferencePairs) {
    this.valueReferencePairs = valueReferencePairs;
    return this;
  }

  public ValueList addValueReferencePairsItem(ValueReferencePair valueReferencePairsItem) {
    if (this.valueReferencePairs == null) {
      this.valueReferencePairs = new ArrayList<>();
    }
    this.valueReferencePairs.add(valueReferencePairsItem);
    return this;
  }

   /**
   * Get valueReferencePairs
   * @return valueReferencePairs
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_VALUE_REFERENCE_PAIRS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<ValueReferencePair> getValueReferencePairs() {
    return valueReferencePairs;
  }


  @JsonProperty(JSON_PROPERTY_VALUE_REFERENCE_PAIRS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setValueReferencePairs(List<ValueReferencePair> valueReferencePairs) {
    this.valueReferencePairs = valueReferencePairs;
  }


  /**
   * Return true if this ValueList object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ValueList valueList = (ValueList) o;
    return Objects.equals(this.valueReferencePairs, valueList.valueReferencePairs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(valueReferencePairs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ValueList {\n");
    sb.append("    valueReferencePairs: ").append(toIndentedString(valueReferencePairs)).append("\n");
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

