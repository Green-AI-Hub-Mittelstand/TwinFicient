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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * OperationRequestValueOnly
 */
@JsonPropertyOrder({
  OperationRequestValueOnly.JSON_PROPERTY_INOUTPUT_ARGUMENTS,
  OperationRequestValueOnly.JSON_PROPERTY_INPUT_ARGUMENTS,
  OperationRequestValueOnly.JSON_PROPERTY_CLIENT_TIMEOUT_DURATION
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:09.185125100+01:00[Europe/Berlin]")
public class OperationRequestValueOnly {
  public static final String JSON_PROPERTY_INOUTPUT_ARGUMENTS = "inoutputArguments";
  private Object inoutputArguments;

  public static final String JSON_PROPERTY_INPUT_ARGUMENTS = "inputArguments";
  private Object inputArguments;

  public static final String JSON_PROPERTY_CLIENT_TIMEOUT_DURATION = "clientTimeoutDuration";
  private String clientTimeoutDuration;

  public OperationRequestValueOnly() { 
  }

  public OperationRequestValueOnly inoutputArguments(Object inoutputArguments) {
    this.inoutputArguments = inoutputArguments;
    return this;
  }

   /**
   * The ValueOnly serialization of submodel elements (patternProperties and propertyNames will be supported propably with OpenApi 3.1). The full description of the generic JSON validation schema for the ValueOnly-serialization can be found in chapter 11.4.3 in Details of the Asset Administration Shell Part 2. 
   * @return inoutputArguments
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_INOUTPUT_ARGUMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Object getInoutputArguments() {
    return inoutputArguments;
  }


  @JsonProperty(JSON_PROPERTY_INOUTPUT_ARGUMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInoutputArguments(Object inoutputArguments) {
    this.inoutputArguments = inoutputArguments;
  }


  public OperationRequestValueOnly inputArguments(Object inputArguments) {
    this.inputArguments = inputArguments;
    return this;
  }

   /**
   * The ValueOnly serialization of submodel elements (patternProperties and propertyNames will be supported propably with OpenApi 3.1). The full description of the generic JSON validation schema for the ValueOnly-serialization can be found in chapter 11.4.3 in Details of the Asset Administration Shell Part 2. 
   * @return inputArguments
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_INPUT_ARGUMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Object getInputArguments() {
    return inputArguments;
  }


  @JsonProperty(JSON_PROPERTY_INPUT_ARGUMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInputArguments(Object inputArguments) {
    this.inputArguments = inputArguments;
  }


  public OperationRequestValueOnly clientTimeoutDuration(String clientTimeoutDuration) {
    this.clientTimeoutDuration = clientTimeoutDuration;
    return this;
  }

   /**
   * Get clientTimeoutDuration
   * @return clientTimeoutDuration
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_CLIENT_TIMEOUT_DURATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getClientTimeoutDuration() {
    return clientTimeoutDuration;
  }


  @JsonProperty(JSON_PROPERTY_CLIENT_TIMEOUT_DURATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setClientTimeoutDuration(String clientTimeoutDuration) {
    this.clientTimeoutDuration = clientTimeoutDuration;
  }


  /**
   * Return true if this OperationRequestValueOnly object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OperationRequestValueOnly operationRequestValueOnly = (OperationRequestValueOnly) o;
    return Objects.equals(this.inoutputArguments, operationRequestValueOnly.inoutputArguments) &&
        Objects.equals(this.inputArguments, operationRequestValueOnly.inputArguments) &&
        Objects.equals(this.clientTimeoutDuration, operationRequestValueOnly.clientTimeoutDuration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inoutputArguments, inputArguments, clientTimeoutDuration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OperationRequestValueOnly {\n");
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

