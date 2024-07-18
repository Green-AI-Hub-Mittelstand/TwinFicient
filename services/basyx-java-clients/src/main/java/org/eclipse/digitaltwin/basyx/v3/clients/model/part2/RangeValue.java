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
import java.math.BigDecimal;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * RangeValue
 */
@JsonPropertyOrder({
  RangeValue.JSON_PROPERTY_MAX,
  RangeValue.JSON_PROPERTY_MIN
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:09.185125100+01:00[Europe/Berlin]")
public class RangeValue {
  public static final String JSON_PROPERTY_MAX = "max";
  private BigDecimal max;

  public static final String JSON_PROPERTY_MIN = "min";
  private BigDecimal min;

  public RangeValue() { 
  }

  public RangeValue max(BigDecimal max) {
    this.max = max;
    return this;
  }

   /**
   * Get max
   * @return max
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_MAX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public BigDecimal getMax() {
    return max;
  }


  @JsonProperty(JSON_PROPERTY_MAX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMax(BigDecimal max) {
    this.max = max;
  }


  public RangeValue min(BigDecimal min) {
    this.min = min;
    return this;
  }

   /**
   * Get min
   * @return min
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_MIN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public BigDecimal getMin() {
    return min;
  }


  @JsonProperty(JSON_PROPERTY_MIN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMin(BigDecimal min) {
    this.min = min;
  }


  /**
   * Return true if this RangeValue object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RangeValue rangeValue = (RangeValue) o;
    return Objects.equals(this.max, rangeValue.max) &&
        Objects.equals(this.min, rangeValue.min);
  }

  @Override
  public int hashCode() {
    return Objects.hash(max, min);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RangeValue {\n");
    sb.append("    max: ").append(toIndentedString(max)).append("\n");
    sb.append("    min: ").append(toIndentedString(min)).append("\n");
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

