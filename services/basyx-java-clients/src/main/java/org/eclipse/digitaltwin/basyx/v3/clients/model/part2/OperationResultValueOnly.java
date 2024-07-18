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
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.ExecutionState;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.Message;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * OperationResultValueOnly
 */
@JsonPropertyOrder({
  OperationResultValueOnly.JSON_PROPERTY_MESSAGES,
  OperationResultValueOnly.JSON_PROPERTY_EXECUTION_STATE,
  OperationResultValueOnly.JSON_PROPERTY_SUCCESS,
  OperationResultValueOnly.JSON_PROPERTY_INOUTPUT_ARGUMENTS,
  OperationResultValueOnly.JSON_PROPERTY_OUTPUT_ARGUMENTS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:09.185125100+01:00[Europe/Berlin]")
public class OperationResultValueOnly {
  public static final String JSON_PROPERTY_MESSAGES = "messages";
  private List<Message> messages;

  public static final String JSON_PROPERTY_EXECUTION_STATE = "executionState";
  private ExecutionState executionState;

  public static final String JSON_PROPERTY_SUCCESS = "success";
  private Boolean success;

  public static final String JSON_PROPERTY_INOUTPUT_ARGUMENTS = "inoutputArguments";
  private Object inoutputArguments;

  public static final String JSON_PROPERTY_OUTPUT_ARGUMENTS = "outputArguments";
  private Object outputArguments;

  public OperationResultValueOnly() { 
  }

  public OperationResultValueOnly messages(List<Message> messages) {
    this.messages = messages;
    return this;
  }

  public OperationResultValueOnly addMessagesItem(Message messagesItem) {
    if (this.messages == null) {
      this.messages = new ArrayList<>();
    }
    this.messages.add(messagesItem);
    return this;
  }

   /**
   * Get messages
   * @return messages
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_MESSAGES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Message> getMessages() {
    return messages;
  }


  @JsonProperty(JSON_PROPERTY_MESSAGES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMessages(List<Message> messages) {
    this.messages = messages;
  }


  public OperationResultValueOnly executionState(ExecutionState executionState) {
    this.executionState = executionState;
    return this;
  }

   /**
   * Get executionState
   * @return executionState
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_EXECUTION_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ExecutionState getExecutionState() {
    return executionState;
  }


  @JsonProperty(JSON_PROPERTY_EXECUTION_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExecutionState(ExecutionState executionState) {
    this.executionState = executionState;
  }


  public OperationResultValueOnly success(Boolean success) {
    this.success = success;
    return this;
  }

   /**
   * Get success
   * @return success
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SUCCESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getSuccess() {
    return success;
  }


  @JsonProperty(JSON_PROPERTY_SUCCESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSuccess(Boolean success) {
    this.success = success;
  }


  public OperationResultValueOnly inoutputArguments(Object inoutputArguments) {
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


  public OperationResultValueOnly outputArguments(Object outputArguments) {
    this.outputArguments = outputArguments;
    return this;
  }

   /**
   * The ValueOnly serialization of submodel elements (patternProperties and propertyNames will be supported propably with OpenApi 3.1). The full description of the generic JSON validation schema for the ValueOnly-serialization can be found in chapter 11.4.3 in Details of the Asset Administration Shell Part 2. 
   * @return outputArguments
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_OUTPUT_ARGUMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Object getOutputArguments() {
    return outputArguments;
  }


  @JsonProperty(JSON_PROPERTY_OUTPUT_ARGUMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOutputArguments(Object outputArguments) {
    this.outputArguments = outputArguments;
  }


  /**
   * Return true if this OperationResultValueOnly object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OperationResultValueOnly operationResultValueOnly = (OperationResultValueOnly) o;
    return Objects.equals(this.messages, operationResultValueOnly.messages) &&
        Objects.equals(this.executionState, operationResultValueOnly.executionState) &&
        Objects.equals(this.success, operationResultValueOnly.success) &&
        Objects.equals(this.inoutputArguments, operationResultValueOnly.inoutputArguments) &&
        Objects.equals(this.outputArguments, operationResultValueOnly.outputArguments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(messages, executionState, success, inoutputArguments, outputArguments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OperationResultValueOnly {\n");
    sb.append("    messages: ").append(toIndentedString(messages)).append("\n");
    sb.append("    executionState: ").append(toIndentedString(executionState)).append("\n");
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    inoutputArguments: ").append(toIndentedString(inoutputArguments)).append("\n");
    sb.append("    outputArguments: ").append(toIndentedString(outputArguments)).append("\n");
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

