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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * The Description object enables servers to present their capabilities to the clients, in particular which profiles they implement. At least one defined profile is required. Additional, proprietary attributes might be included. Nevertheless, the server must not expect that a regular client understands them.
 */
@JsonPropertyOrder({
  ServiceDescription.JSON_PROPERTY_PROFILES
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:09.185125100+01:00[Europe/Berlin]")
public class ServiceDescription {
  /**
   * Gets or Sets profiles
   */
  public enum ProfilesEnum {
    ASSETADMINISTRATIONSHELLSERVICESPECIFICATION_SSP_001("https://admin-shell.io/aas/API/3/0/AssetAdministrationShellServiceSpecification/SSP-001"),
    
    ASSETADMINISTRATIONSHELLSERVICESPECIFICATION_SSP_002("https://admin-shell.io/aas/API/3/0/AssetAdministrationShellServiceSpecification/SSP-002"),
    
    SUBMODELSERVICESPECIFICATION_SSP_001("https://admin-shell.io/aas/API/3/0/SubmodelServiceSpecification/SSP-001"),
    
    SUBMODELSERVICESPECIFICATION_SSP_002("https://admin-shell.io/aas/API/3/0/SubmodelServiceSpecification/SSP-002"),
    
    SUBMODELSERVICESPECIFICATION_SSP_003("https://admin-shell.io/aas/API/3/0/SubmodelServiceSpecification/SSP-003"),
    
    AASXFILESERVERSERVICESPECIFICATION_SSP_001("https://admin-shell.io/aas/API/3/0/AasxFileServerServiceSpecification/SSP-001"),
    
    ASSETADMINISTRATIONSHELLREGISTRYSERVICESPECIFICATION_SSP_001("https://admin-shell.io/aas/API/3/0/AssetAdministrationShellRegistryServiceSpecification/SSP-001"),
    
    ASSETADMINISTRATIONSHELLREGISTRYSERVICESPECIFICATION_SSP_002("https://admin-shell.io/aas/API/3/0/AssetAdministrationShellRegistryServiceSpecification/SSP-002"),
    
    SUBMODELREGISTRYSERVICESPECIFICATION_SSP_001("https://admin-shell.io/aas/API/3/0/SubmodelRegistryServiceSpecification/SSP-001"),
    
    SUBMODELREGISTRYSERVICESPECIFICATION_SSP_002("https://admin-shell.io/aas/API/3/0/SubmodelRegistryServiceSpecification/SSP-002"),
    
    DISCOVERYSERVICESPECIFICATION_SSP_001("https://admin-shell.io/aas/API/3/0/DiscoveryServiceSpecification/SSP-001"),
    
    ASSETADMINISTRATIONSHELLREPOSITORYSERVICESPECIFICATION_SSP_001("https://admin-shell.io/aas/API/3/0/AssetAdministrationShellRepositoryServiceSpecification/SSP-001"),
    
    ASSETADMINISTRATIONSHELLREPOSITORYSERVICESPECIFICATION_SSP_002("https://admin-shell.io/aas/API/3/0/AssetAdministrationShellRepositoryServiceSpecification/SSP-002"),
    
    SUBMODELREPOSITORYSERVICESPECIFICATION_SSP_001("https://admin-shell.io/aas/API/3/0/SubmodelRepositoryServiceSpecification/SSP-001"),
    
    SUBMODELREPOSITORYSERVICESPECIFICATION_SSP_002("https://admin-shell.io/aas/API/3/0/SubmodelRepositoryServiceSpecification/SSP-002"),
    
    SUBMODELREPOSITORYSERVICESPECIFICATION_SSP_003("https://admin-shell.io/aas/API/3/0/SubmodelRepositoryServiceSpecification/SSP-003"),
    
    SUBMODELREPOSITORYSERVICESPECIFICATION_SSP_004("https://admin-shell.io/aas/API/3/0/SubmodelRepositoryServiceSpecification/SSP-004"),
    
    CONCEPTDESCRIPTIONSERVICESPECIFICATION_SSP_001("https://admin-shell.io/aas/API/3/0/ConceptDescriptionServiceSpecification/SSP-001");

    private String value;

    ProfilesEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ProfilesEnum fromValue(String value) {
      for (ProfilesEnum b : ProfilesEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_PROFILES = "profiles";
  private List<ProfilesEnum> profiles;

  public ServiceDescription() { 
  }

  public ServiceDescription profiles(List<ProfilesEnum> profiles) {
    this.profiles = profiles;
    return this;
  }

  public ServiceDescription addProfilesItem(ProfilesEnum profilesItem) {
    if (this.profiles == null) {
      this.profiles = new ArrayList<>();
    }
    this.profiles.add(profilesItem);
    return this;
  }

   /**
   * Get profiles
   * @return profiles
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PROFILES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<ProfilesEnum> getProfiles() {
    return profiles;
  }


  @JsonProperty(JSON_PROPERTY_PROFILES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setProfiles(List<ProfilesEnum> profiles) {
    this.profiles = profiles;
  }


  /**
   * Return true if this ServiceDescription object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceDescription serviceDescription = (ServiceDescription) o;
    return Objects.equals(this.profiles, serviceDescription.profiles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(profiles);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceDescription {\n");
    sb.append("    profiles: ").append(toIndentedString(profiles)).append("\n");
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

