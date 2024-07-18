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
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.AssetAdministrationShell;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.ConceptDescription;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Submodel;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Environment
 */
@JsonPropertyOrder({
  Environment.JSON_PROPERTY_ASSET_ADMINISTRATION_SHELLS,
  Environment.JSON_PROPERTY_SUBMODELS,
  Environment.JSON_PROPERTY_CONCEPT_DESCRIPTIONS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:07.399784100+01:00[Europe/Berlin]")
public class Environment {
  public static final String JSON_PROPERTY_ASSET_ADMINISTRATION_SHELLS = "assetAdministrationShells";
  private List<AssetAdministrationShell> assetAdministrationShells;

  public static final String JSON_PROPERTY_SUBMODELS = "submodels";
  private List<Submodel> submodels;

  public static final String JSON_PROPERTY_CONCEPT_DESCRIPTIONS = "conceptDescriptions";
  private List<ConceptDescription> conceptDescriptions;

  public Environment() { 
  }

  public Environment assetAdministrationShells(List<AssetAdministrationShell> assetAdministrationShells) {
    this.assetAdministrationShells = assetAdministrationShells;
    return this;
  }

  public Environment addAssetAdministrationShellsItem(AssetAdministrationShell assetAdministrationShellsItem) {
    if (this.assetAdministrationShells == null) {
      this.assetAdministrationShells = new ArrayList<>();
    }
    this.assetAdministrationShells.add(assetAdministrationShellsItem);
    return this;
  }

   /**
   * Get assetAdministrationShells
   * @return assetAdministrationShells
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ASSET_ADMINISTRATION_SHELLS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<AssetAdministrationShell> getAssetAdministrationShells() {
    return assetAdministrationShells;
  }


  @JsonProperty(JSON_PROPERTY_ASSET_ADMINISTRATION_SHELLS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAssetAdministrationShells(List<AssetAdministrationShell> assetAdministrationShells) {
    this.assetAdministrationShells = assetAdministrationShells;
  }


  public Environment submodels(List<Submodel> submodels) {
    this.submodels = submodels;
    return this;
  }

  public Environment addSubmodelsItem(Submodel submodelsItem) {
    if (this.submodels == null) {
      this.submodels = new ArrayList<>();
    }
    this.submodels.add(submodelsItem);
    return this;
  }

   /**
   * Get submodels
   * @return submodels
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SUBMODELS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Submodel> getSubmodels() {
    return submodels;
  }


  @JsonProperty(JSON_PROPERTY_SUBMODELS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSubmodels(List<Submodel> submodels) {
    this.submodels = submodels;
  }


  public Environment conceptDescriptions(List<ConceptDescription> conceptDescriptions) {
    this.conceptDescriptions = conceptDescriptions;
    return this;
  }

  public Environment addConceptDescriptionsItem(ConceptDescription conceptDescriptionsItem) {
    if (this.conceptDescriptions == null) {
      this.conceptDescriptions = new ArrayList<>();
    }
    this.conceptDescriptions.add(conceptDescriptionsItem);
    return this;
  }

   /**
   * Get conceptDescriptions
   * @return conceptDescriptions
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CONCEPT_DESCRIPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<ConceptDescription> getConceptDescriptions() {
    return conceptDescriptions;
  }


  @JsonProperty(JSON_PROPERTY_CONCEPT_DESCRIPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setConceptDescriptions(List<ConceptDescription> conceptDescriptions) {
    this.conceptDescriptions = conceptDescriptions;
  }


  /**
   * Return true if this Environment object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Environment environment = (Environment) o;
    return Objects.equals(this.assetAdministrationShells, environment.assetAdministrationShells) &&
        Objects.equals(this.submodels, environment.submodels) &&
        Objects.equals(this.conceptDescriptions, environment.conceptDescriptions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(assetAdministrationShells, submodels, conceptDescriptions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Environment {\n");
    sb.append("    assetAdministrationShells: ").append(toIndentedString(assetAdministrationShells)).append("\n");
    sb.append("    submodels: ").append(toIndentedString(submodels)).append("\n");
    sb.append("    conceptDescriptions: ").append(toIndentedString(conceptDescriptions)).append("\n");
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

