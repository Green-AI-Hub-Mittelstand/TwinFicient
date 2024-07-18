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
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.OperationVariable;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * OperationRequest
 */
@JsonPropertyOrder({
  OperationRequest.JSON_PROPERTY_INOUTPUT_ARGUMENTS,
  OperationRequest.JSON_PROPERTY_INPUT_ARGUMENTS,
  OperationRequest.JSON_PROPERTY_CLIENT_TIMEOUT_DURATION
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:09.185125100+01:00[Europe/Berlin]")
public class OperationRequest {
  public static final String JSON_PROPERTY_INOUTPUT_ARGUMENTS = "inoutputArguments";
  private List<OperationVariable> inoutputArguments;

  public static final String JSON_PROPERTY_INPUT_ARGUMENTS = "inputArguments";
  private List<OperationVariable> inputArguments;

  public static final String JSON_PROPERTY_CLIENT_TIMEOUT_DURATION = "clientTimeoutDuration";
  private String clientTimeoutDuration;

  public OperationRequest() { 
  }

  public OperationRequest inoutputArguments(List<OperationVariable> inoutputArguments) {
    this.inoutputArguments = inoutputArguments;
    return this;
  }

  public OperationRequest addInoutputArgumentsItem(OperationVariable inoutputArgumentsItem) {
    if (this.inoutputArguments == null) {
      this.inoutputArguments = new ArrayList<>();
    }
    this.inoutputArguments.add(inoutputArgumentsItem);
    return this;
  }

   /**
   * Get inoutputArguments
   * @return inoutputArguments
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_INOUTPUT_ARGUMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<OperationVariable> getInoutputArguments() {
    return inoutputArguments;
  }


  @JsonProperty(JSON_PROPERTY_INOUTPUT_ARGUMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInoutputArguments(List<OperationVariable> inoutputArguments) {
    this.inoutputArguments = inoutputArguments;
  }


  public OperationRequest inputArguments(List<OperationVariable> inputArguments) {
    this.inputArguments = inputArguments;
    return this;
  }

  public OperationRequest addInputArgumentsItem(OperationVariable inputArgumentsItem) {
    if (this.inputArguments == null) {
      this.inputArguments = new ArrayList<>();
    }
    this.inputArguments.add(inputArgumentsItem);
    return this;
  }

   /**
   * Get inputArguments
   * @return inputArguments
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_INPUT_ARGUMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<OperationVariable> getInputArguments() {
    return inputArguments;
  }


  @JsonProperty(JSON_PROPERTY_INPUT_ARGUMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInputArguments(List<OperationVariable> inputArguments) {
    this.inputArguments = inputArguments;
  }


  public OperationRequest clientTimeoutDuration(String clientTimeoutDuration) {
    this.clientTimeoutDuration = clientTimeoutDuration;
    return this;
  }

   /**
   * Get clientTimeoutDuration
   * @return clientTimeoutDuration
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CLIENT_TIMEOUT_DURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getClientTimeoutDuration() {
    return clientTimeoutDuration;
  }


  @JsonProperty(JSON_PROPERTY_CLIENT_TIMEOUT_DURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setClientTimeoutDuration(String clientTimeoutDuration) {
    this.clientTimeoutDuration = clientTimeoutDuration;
  }


  /**
   * Return true if this OperationRequest object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OperationRequest operationRequest = (OperationRequest) o;
    return Objects.equals(this.inoutputArguments, operationRequest.inoutputArguments) &&
        Objects.equals(this.inputArguments, operationRequest.inputArguments) &&
        Objects.equals(this.clientTimeoutDuration, operationRequest.clientTimeoutDuration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inoutputArguments, inputArguments, clientTimeoutDuration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OperationRequest {\n");
    sb.append("    inoutputArguments: ").append(toIndentedString(inoutputArguments)).append("\n");
    sb.append("    inputArguments: ").append(toIndentedString(inputArguments)).append("\n");
    sb.append("    clientTimeoutDuration: ").append(toIndentedString(clientTimeoutDuration)).append("\n");
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

