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
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.ReferenceValue;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * AnnotatedRelationshipElementValue
 */
@JsonPropertyOrder({
  AnnotatedRelationshipElementValue.JSON_PROPERTY_FIRST,
  AnnotatedRelationshipElementValue.JSON_PROPERTY_SECOND,
  AnnotatedRelationshipElementValue.JSON_PROPERTY_ANNOTATIONS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:09.185125100+01:00[Europe/Berlin]")
public class AnnotatedRelationshipElementValue {
  public static final String JSON_PROPERTY_FIRST = "first";
  private ReferenceValue first;

  public static final String JSON_PROPERTY_SECOND = "second";
  private ReferenceValue second;

  public static final String JSON_PROPERTY_ANNOTATIONS = "annotations";
  private List<Object> annotations;

  public AnnotatedRelationshipElementValue() { 
  }

  public AnnotatedRelationshipElementValue first(ReferenceValue first) {
    this.first = first;
    return this;
  }

   /**
   * Get first
   * @return first
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_FIRST)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ReferenceValue getFirst() {
    return first;
  }


  @JsonProperty(JSON_PROPERTY_FIRST)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setFirst(ReferenceValue first) {
    this.first = first;
  }


  public AnnotatedRelationshipElementValue second(ReferenceValue second) {
    this.second = second;
    return this;
  }

   /**
   * Get second
   * @return second
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_SECOND)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ReferenceValue getSecond() {
    return second;
  }


  @JsonProperty(JSON_PROPERTY_SECOND)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSecond(ReferenceValue second) {
    this.second = second;
  }


  public AnnotatedRelationshipElementValue annotations(List<Object> annotations) {
    this.annotations = annotations;
    return this;
  }

  public AnnotatedRelationshipElementValue addAnnotationsItem(Object annotationsItem) {
    if (this.annotations == null) {
      this.annotations = new ArrayList<>();
    }
    this.annotations.add(annotationsItem);
    return this;
  }

   /**
   * Get annotations
   * @return annotations
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ANNOTATIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Object> getAnnotations() {
    return annotations;
  }


  @JsonProperty(JSON_PROPERTY_ANNOTATIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAnnotations(List<Object> annotations) {
    this.annotations = annotations;
  }


  /**
   * Return true if this AnnotatedRelationshipElementValue object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnnotatedRelationshipElementValue annotatedRelationshipElementValue = (AnnotatedRelationshipElementValue) o;
    return Objects.equals(this.first, annotatedRelationshipElementValue.first) &&
        Objects.equals(this.second, annotatedRelationshipElementValue.second) &&
        Objects.equals(this.annotations, annotatedRelationshipElementValue.annotations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(first, second, annotations);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnnotatedRelationshipElementValue {\n");
    sb.append("    first: ").append(toIndentedString(first)).append("\n");
    sb.append("    second: ").append(toIndentedString(second)).append("\n");
    sb.append("    annotations: ").append(toIndentedString(annotations)).append("\n");
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

