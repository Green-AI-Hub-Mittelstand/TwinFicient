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
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Reference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * SpecificAssetId
 */
@JsonPropertyOrder({
  SpecificAssetId.JSON_PROPERTY_SEMANTIC_ID,
  SpecificAssetId.JSON_PROPERTY_SUPPLEMENTAL_SEMANTIC_IDS,
  SpecificAssetId.JSON_PROPERTY_NAME,
  SpecificAssetId.JSON_PROPERTY_VALUE,
  SpecificAssetId.JSON_PROPERTY_EXTERNAL_SUBJECT_ID
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:07.399784100+01:00[Europe/Berlin]")
public class SpecificAssetId {
  public static final String JSON_PROPERTY_SEMANTIC_ID = "semanticId";
  private Reference semanticId;

  public static final String JSON_PROPERTY_SUPPLEMENTAL_SEMANTIC_IDS = "supplementalSemanticIds";
  private List<Reference> supplementalSemanticIds;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_VALUE = "value";
  private String value;

  public static final String JSON_PROPERTY_EXTERNAL_SUBJECT_ID = "externalSubjectId";
  private Reference externalSubjectId;

  public SpecificAssetId() { 
  }

  public SpecificAssetId semanticId(Reference semanticId) {
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


  public SpecificAssetId supplementalSemanticIds(List<Reference> supplementalSemanticIds) {
    this.supplementalSemanticIds = supplementalSemanticIds;
    return this;
  }

  public SpecificAssetId addSupplementalSemanticIdsItem(Reference supplementalSemanticIdsItem) {
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


  public SpecificAssetId name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getName() {
    return name;
  }


  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setName(String name) {
    this.name = name;
  }


  public SpecificAssetId value(String value) {
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


  public SpecificAssetId externalSubjectId(Reference externalSubjectId) {
    this.externalSubjectId = externalSubjectId;
    return this;
  }

   /**
   * Get externalSubjectId
   * @return externalSubjectId
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_EXTERNAL_SUBJECT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Reference getExternalSubjectId() {
    return externalSubjectId;
  }


  @JsonProperty(JSON_PROPERTY_EXTERNAL_SUBJECT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExternalSubjectId(Reference externalSubjectId) {
    this.externalSubjectId = externalSubjectId;
  }


  /**
   * Return true if this SpecificAssetId object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpecificAssetId specificAssetId = (SpecificAssetId) o;
    return Objects.equals(this.semanticId, specificAssetId.semanticId) &&
        Objects.equals(this.supplementalSemanticIds, specificAssetId.supplementalSemanticIds) &&
        Objects.equals(this.name, specificAssetId.name) &&
        Objects.equals(this.value, specificAssetId.value) &&
        Objects.equals(this.externalSubjectId, specificAssetId.externalSubjectId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(semanticId, supplementalSemanticIds, name, value, externalSubjectId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpecificAssetId {\n");
    sb.append("    semanticId: ").append(toIndentedString(semanticId)).append("\n");
    sb.append("    supplementalSemanticIds: ").append(toIndentedString(supplementalSemanticIds)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    externalSubjectId: ").append(toIndentedString(externalSubjectId)).append("\n");
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

