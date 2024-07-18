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
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.DataTypeDefXsd;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.QualifierKind;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Reference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Qualifier
 */
@JsonPropertyOrder({
  Qualifier.JSON_PROPERTY_SEMANTIC_ID,
  Qualifier.JSON_PROPERTY_SUPPLEMENTAL_SEMANTIC_IDS,
  Qualifier.JSON_PROPERTY_KIND,
  Qualifier.JSON_PROPERTY_TYPE,
  Qualifier.JSON_PROPERTY_VALUE_TYPE,
  Qualifier.JSON_PROPERTY_VALUE,
  Qualifier.JSON_PROPERTY_VALUE_ID
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:07.399784100+01:00[Europe/Berlin]")
public class Qualifier {
  public static final String JSON_PROPERTY_SEMANTIC_ID = "semanticId";
  private Reference semanticId;

  public static final String JSON_PROPERTY_SUPPLEMENTAL_SEMANTIC_IDS = "supplementalSemanticIds";
  private List<Reference> supplementalSemanticIds;

  public static final String JSON_PROPERTY_KIND = "kind";
  private QualifierKind kind;

  public static final String JSON_PROPERTY_TYPE = "type";
  private String type;

  public static final String JSON_PROPERTY_VALUE_TYPE = "valueType";
  private DataTypeDefXsd valueType;

  public static final String JSON_PROPERTY_VALUE = "value";
  private String value;

  public static final String JSON_PROPERTY_VALUE_ID = "valueId";
  private Reference valueId;

  public Qualifier() { 
  }

  public Qualifier semanticId(Reference semanticId) {
    this.semanticId = semanticId;
    return this;
  }

   /**
   * Get semanticId
   * @return semanticId
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SEMANTIC_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Reference getSemanticId() {
    return semanticId;
  }


  @JsonProperty(JSON_PROPERTY_SEMANTIC_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSemanticId(Reference semanticId) {
    this.semanticId = semanticId;
  }


  public Qualifier supplementalSemanticIds(List<Reference> supplementalSemanticIds) {
    this.supplementalSemanticIds = supplementalSemanticIds;
    return this;
  }

  public Qualifier addSupplementalSemanticIdsItem(Reference supplementalSemanticIdsItem) {
    if (this.supplementalSemanticIds == null) {
      this.supplementalSemanticIds = new ArrayList<>();
    }
    this.supplementalSemanticIds.add(supplementalSemanticIdsItem);
    return this;
  }

   /**
   * Get supplementalSemanticIds
   * @return supplementalSemanticIds
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SUPPLEMENTAL_SEMANTIC_IDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Reference> getSupplementalSemanticIds() {
    return supplementalSemanticIds;
  }


  @JsonProperty(JSON_PROPERTY_SUPPLEMENTAL_SEMANTIC_IDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSupplementalSemanticIds(List<Reference> supplementalSemanticIds) {
    this.supplementalSemanticIds = supplementalSemanticIds;
  }


  public Qualifier kind(QualifierKind kind) {
    this.kind = kind;
    return this;
  }

   /**
   * Get kind
   * @return kind
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_KIND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public QualifierKind getKind() {
    return kind;
  }


  @JsonProperty(JSON_PROPERTY_KIND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setKind(QualifierKind kind) {
    this.kind = kind;
  }


  public Qualifier type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getType() {
    return type;
  }


  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setType(String type) {
    this.type = type;
  }


  public Qualifier valueType(DataTypeDefXsd valueType) {
    this.valueType = valueType;
    return this;
  }

   /**
   * Get valueType
   * @return valueType
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_VALUE_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public DataTypeDefXsd getValueType() {
    return valueType;
  }


  @JsonProperty(JSON_PROPERTY_VALUE_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setValueType(DataTypeDefXsd valueType) {
    this.valueType = valueType;
  }


  public Qualifier value(String value) {
    this.value = value;
    return this;
  }

   /**
   * Get value
   * @return value
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getValue() {
    return value;
  }


  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setValue(String value) {
    this.value = value;
  }


  public Qualifier valueId(Reference valueId) {
    this.valueId = valueId;
    return this;
  }

   /**
   * Get valueId
   * @return valueId
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_VALUE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Reference getValueId() {
    return valueId;
  }


  @JsonProperty(JSON_PROPERTY_VALUE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setValueId(Reference valueId) {
    this.valueId = valueId;
  }


  /**
   * Return true if this Qualifier object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Qualifier qualifier = (Qualifier) o;
    return Objects.equals(this.semanticId, qualifier.semanticId) &&
        Objects.equals(this.supplementalSemanticIds, qualifier.supplementalSemanticIds) &&
        Objects.equals(this.kind, qualifier.kind) &&
        Objects.equals(this.type, qualifier.type) &&
        Objects.equals(this.valueType, qualifier.valueType) &&
        Objects.equals(this.value, qualifier.value) &&
        Objects.equals(this.valueId, qualifier.valueId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(semanticId, supplementalSemanticIds, kind, type, valueType, value, valueId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Qualifier {\n");
    sb.append("    semanticId: ").append(toIndentedString(semanticId)).append("\n");
    sb.append("    supplementalSemanticIds: ").append(toIndentedString(supplementalSemanticIds)).append("\n");
    sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    valueType: ").append(toIndentedString(valueType)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    valueId: ").append(toIndentedString(valueId)).append("\n");
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

