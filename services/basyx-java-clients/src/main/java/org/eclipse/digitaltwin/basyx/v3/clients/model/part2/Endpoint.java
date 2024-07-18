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
import java.util.Arrays;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.ProtocolInformation;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Endpoint
 */
@JsonPropertyOrder({
  Endpoint.JSON_PROPERTY_INTERFACE,
  Endpoint.JSON_PROPERTY_PROTOCOL_INFORMATION
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:09.185125100+01:00[Europe/Berlin]")
public class Endpoint {
  public static final String JSON_PROPERTY_INTERFACE = "interface";
  @JsonProperty("interface")
  private String _interface;

  public static final String JSON_PROPERTY_PROTOCOL_INFORMATION = "protocolInformation";
  private ProtocolInformation protocolInformation;

  public Endpoint() { 
  }

  public Endpoint _interface(String _interface) {
    this._interface = _interface;
    return this;
  }

   /**
   * Get _interface
   * @return _interface
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_INTERFACE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getInterface() {
    return _interface;
  }


  @JsonProperty(JSON_PROPERTY_INTERFACE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setInterface(String _interface) {
    this._interface = _interface;
  }


  public Endpoint protocolInformation(ProtocolInformation protocolInformation) {
    this.protocolInformation = protocolInformation;
    return this;
  }

   /**
   * Get protocolInformation
   * @return protocolInformation
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_PROTOCOL_INFORMATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ProtocolInformation getProtocolInformation() {
    return protocolInformation;
  }


  @JsonProperty(JSON_PROPERTY_PROTOCOL_INFORMATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setProtocolInformation(ProtocolInformation protocolInformation) {
    this.protocolInformation = protocolInformation;
  }


  /**
   * Return true if this Endpoint object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Endpoint endpoint = (Endpoint) o;
    return Objects.equals(this._interface, endpoint._interface) &&
        Objects.equals(this.protocolInformation, endpoint.protocolInformation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_interface, protocolInformation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Endpoint {\n");
    sb.append("    _interface: ").append(toIndentedString(_interface)).append("\n");
    sb.append("    protocolInformation: ").append(toIndentedString(protocolInformation)).append("\n");
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

