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
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * LevelType
 */
@JsonPropertyOrder({
  LevelType.JSON_PROPERTY_MIN,
  LevelType.JSON_PROPERTY_NOM,
  LevelType.JSON_PROPERTY_TYP,
  LevelType.JSON_PROPERTY_MAX
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:07.399784100+01:00[Europe/Berlin]")
public class LevelType {
  public static final String JSON_PROPERTY_MIN = "min";
  private Boolean min;

  public static final String JSON_PROPERTY_NOM = "nom";
  private Boolean nom;

  public static final String JSON_PROPERTY_TYP = "typ";
  private Boolean typ;

  public static final String JSON_PROPERTY_MAX = "max";
  private Boolean max;

  public LevelType() { 
  }

  public LevelType min(Boolean min) {
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

  public Boolean getMin() {
    return min;
  }


  @JsonProperty(JSON_PROPERTY_MIN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMin(Boolean min) {
    this.min = min;
  }


  public LevelType nom(Boolean nom) {
    this.nom = nom;
    return this;
  }

   /**
   * Get nom
   * @return nom
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_NOM)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getNom() {
    return nom;
  }


  @JsonProperty(JSON_PROPERTY_NOM)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNom(Boolean nom) {
    this.nom = nom;
  }


  public LevelType typ(Boolean typ) {
    this.typ = typ;
    return this;
  }

   /**
   * Get typ
   * @return typ
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_TYP)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getTyp() {
    return typ;
  }


  @JsonProperty(JSON_PROPERTY_TYP)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTyp(Boolean typ) {
    this.typ = typ;
  }


  public LevelType max(Boolean max) {
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

  public Boolean getMax() {
    return max;
  }


  @JsonProperty(JSON_PROPERTY_MAX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMax(Boolean max) {
    this.max = max;
  }


  /**
   * Return true if this LevelType object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LevelType levelType = (LevelType) o;
    return Objects.equals(this.min, levelType.min) &&
        Objects.equals(this.nom, levelType.nom) &&
        Objects.equals(this.typ, levelType.typ) &&
        Objects.equals(this.max, levelType.max);
  }

  @Override
  public int hashCode() {
    return Objects.hash(min, nom, typ, max);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LevelType {\n");
    sb.append("    min: ").append(toIndentedString(min)).append("\n");
    sb.append("    nom: ").append(toIndentedString(nom)).append("\n");
    sb.append("    typ: ").append(toIndentedString(typ)).append("\n");
    sb.append("    max: ").append(toIndentedString(max)).append("\n");
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

