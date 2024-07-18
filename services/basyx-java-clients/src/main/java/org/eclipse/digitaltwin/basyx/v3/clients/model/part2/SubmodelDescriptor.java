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
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.AdministrativeInformation;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Extension;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.LangStringNameType;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.LangStringTextType;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Reference;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.Endpoint;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * SubmodelDescriptor
 */
@JsonPropertyOrder({
  SubmodelDescriptor.JSON_PROPERTY_DESCRIPTION,
  SubmodelDescriptor.JSON_PROPERTY_DISPLAY_NAME,
  SubmodelDescriptor.JSON_PROPERTY_EXTENSIONS,
  SubmodelDescriptor.JSON_PROPERTY_ADMINISTRATION,
  SubmodelDescriptor.JSON_PROPERTY_ID_SHORT,
  SubmodelDescriptor.JSON_PROPERTY_ID,
  SubmodelDescriptor.JSON_PROPERTY_SEMANTIC_ID,
  SubmodelDescriptor.JSON_PROPERTY_SUPPLEMENTAL_SEMANTIC_ID,
  SubmodelDescriptor.JSON_PROPERTY_ENDPOINTS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:09.185125100+01:00[Europe/Berlin]")
public class SubmodelDescriptor {
  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private List<LangStringTextType> description;

  public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
  private List<LangStringNameType> displayName;

  public static final String JSON_PROPERTY_EXTENSIONS = "extensions";
  private List<Extension> extensions;

  public static final String JSON_PROPERTY_ADMINISTRATION = "administration";
  private AdministrativeInformation administration;

  public static final String JSON_PROPERTY_ID_SHORT = "idShort";
  private String idShort;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_SEMANTIC_ID = "semanticId";
  private Reference semanticId;

  public static final String JSON_PROPERTY_SUPPLEMENTAL_SEMANTIC_ID = "supplementalSemanticId";
  private List<Reference> supplementalSemanticId;

  public static final String JSON_PROPERTY_ENDPOINTS = "endpoints";
  private List<Endpoint> endpoints = new ArrayList<>();

  public SubmodelDescriptor() { 
  }

  public SubmodelDescriptor description(List<LangStringTextType> description) {
    this.description = description;
    return this;
  }

  public SubmodelDescriptor addDescriptionItem(LangStringTextType descriptionItem) {
    if (this.description == null) {
      this.description = new ArrayList<>();
    }
    this.description.add(descriptionItem);
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<LangStringTextType> getDescription() {
    return description;
  }


  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDescription(List<LangStringTextType> description) {
    this.description = description;
  }


  public SubmodelDescriptor displayName(List<LangStringNameType> displayName) {
    this.displayName = displayName;
    return this;
  }

  public SubmodelDescriptor addDisplayNameItem(LangStringNameType displayNameItem) {
    if (this.displayName == null) {
      this.displayName = new ArrayList<>();
    }
    this.displayName.add(displayNameItem);
    return this;
  }

   /**
   * Get displayName
   * @return displayName
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<LangStringNameType> getDisplayName() {
    return displayName;
  }


  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDisplayName(List<LangStringNameType> displayName) {
    this.displayName = displayName;
  }


  public SubmodelDescriptor extensions(List<Extension> extensions) {
    this.extensions = extensions;
    return this;
  }

  public SubmodelDescriptor addExtensionsItem(Extension extensionsItem) {
    if (this.extensions == null) {
      this.extensions = new ArrayList<>();
    }
    this.extensions.add(extensionsItem);
    return this;
  }

   /**
   * Get extensions
   * @return extensions
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_EXTENSIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Extension> getExtensions() {
    return extensions;
  }


  @JsonProperty(JSON_PROPERTY_EXTENSIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExtensions(List<Extension> extensions) {
    this.extensions = extensions;
  }


  public SubmodelDescriptor administration(AdministrativeInformation administration) {
    this.administration = administration;
    return this;
  }

   /**
   * Get administration
   * @return administration
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ADMINISTRATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public AdministrativeInformation getAdministration() {
    return administration;
  }


  @JsonProperty(JSON_PROPERTY_ADMINISTRATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAdministration(AdministrativeInformation administration) {
    this.administration = administration;
  }


  public SubmodelDescriptor idShort(String idShort) {
    this.idShort = idShort;
    return this;
  }

   /**
   * Get idShort
   * @return idShort
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ID_SHORT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getIdShort() {
    return idShort;
  }


  @JsonProperty(JSON_PROPERTY_ID_SHORT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIdShort(String idShort) {
    this.idShort = idShort;
  }


  public SubmodelDescriptor id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setId(String id) {
    this.id = id;
  }


  public SubmodelDescriptor semanticId(Reference semanticId) {
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


  public SubmodelDescriptor supplementalSemanticId(List<Reference> supplementalSemanticId) {
    this.supplementalSemanticId = supplementalSemanticId;
    return this;
  }

  public SubmodelDescriptor addSupplementalSemanticIdItem(Reference supplementalSemanticIdItem) {
    if (this.supplementalSemanticId == null) {
      this.supplementalSemanticId = new ArrayList<>();
    }
    this.supplementalSemanticId.add(supplementalSemanticIdItem);
    return this;
  }

   /**
   * Get supplementalSemanticId
   * @return supplementalSemanticId
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SUPPLEMENTAL_SEMANTIC_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Reference> getSupplementalSemanticId() {
    return supplementalSemanticId;
  }


  @JsonProperty(JSON_PROPERTY_SUPPLEMENTAL_SEMANTIC_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSupplementalSemanticId(List<Reference> supplementalSemanticId) {
    this.supplementalSemanticId = supplementalSemanticId;
  }


  public SubmodelDescriptor endpoints(List<Endpoint> endpoints) {
    this.endpoints = endpoints;
    return this;
  }

  public SubmodelDescriptor addEndpointsItem(Endpoint endpointsItem) {
    if (this.endpoints == null) {
      this.endpoints = new ArrayList<>();
    }
    this.endpoints.add(endpointsItem);
    return this;
  }

   /**
   * Get endpoints
   * @return endpoints
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_ENDPOINTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<Endpoint> getEndpoints() {
    return endpoints;
  }


  @JsonProperty(JSON_PROPERTY_ENDPOINTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEndpoints(List<Endpoint> endpoints) {
    this.endpoints = endpoints;
  }


  /**
   * Return true if this SubmodelDescriptor object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubmodelDescriptor submodelDescriptor = (SubmodelDescriptor) o;
    return Objects.equals(this.description, submodelDescriptor.description) &&
        Objects.equals(this.displayName, submodelDescriptor.displayName) &&
        Objects.equals(this.extensions, submodelDescriptor.extensions) &&
        Objects.equals(this.administration, submodelDescriptor.administration) &&
        Objects.equals(this.idShort, submodelDescriptor.idShort) &&
        Objects.equals(this.id, submodelDescriptor.id) &&
        Objects.equals(this.semanticId, submodelDescriptor.semanticId) &&
        Objects.equals(this.supplementalSemanticId, submodelDescriptor.supplementalSemanticId) &&
        Objects.equals(this.endpoints, submodelDescriptor.endpoints);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, displayName, extensions, administration, idShort, id, semanticId, supplementalSemanticId, endpoints);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubmodelDescriptor {\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    extensions: ").append(toIndentedString(extensions)).append("\n");
    sb.append("    administration: ").append(toIndentedString(administration)).append("\n");
    sb.append("    idShort: ").append(toIndentedString(idShort)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    semanticId: ").append(toIndentedString(semanticId)).append("\n");
    sb.append("    supplementalSemanticId: ").append(toIndentedString(supplementalSemanticId)).append("\n");
    sb.append("    endpoints: ").append(toIndentedString(endpoints)).append("\n");
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

