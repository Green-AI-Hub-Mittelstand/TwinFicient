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
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.ExecutionState;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.Message;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * OperationResult
 */
@JsonPropertyOrder({
  OperationResult.JSON_PROPERTY_MESSAGES,
  OperationResult.JSON_PROPERTY_EXECUTION_STATE,
  OperationResult.JSON_PROPERTY_SUCCESS,
  OperationResult.JSON_PROPERTY_INOUTPUT_ARGUMENTS,
  OperationResult.JSON_PROPERTY_OUTPUT_ARGUMENTS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:09.185125100+01:00[Europe/Berlin]")
public class OperationResult {
  public static final String JSON_PROPERTY_MESSAGES = "messages";
  private List<Message> messages;

  public static final String JSON_PROPERTY_EXECUTION_STATE = "executionState";
  private ExecutionState executionState;

  public static final String JSON_PROPERTY_SUCCESS = "success";
  private Boolean success;

  public static final String JSON_PROPERTY_INOUTPUT_ARGUMENTS = "inoutputArguments";
  private List<OperationVariable> inoutputArguments;

  public static final String JSON_PROPERTY_OUTPUT_ARGUMENTS = "outputArguments";
  private List<OperationVariable> outputArguments;

  public OperationResult() { 
  }

  public OperationResult messages(List<Message> messages) {
    this.messages = messages;
    return this;
  }

  public OperationResult addMessagesItem(Message messagesItem) {
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


  public OperationResult executionState(ExecutionState executionState) {
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


  public OperationResult success(Boolean success) {
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


  public OperationResult inoutputArguments(List<OperationVariable> inoutputArguments) {
    this.inoutputArguments = inoutputArguments;
    return this;
  }

  public OperationResult addInoutputArgumentsItem(OperationVariable inoutputArgumentsItem) {
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


  public OperationResult outputArguments(List<OperationVariable> outputArguments) {
    this.outputArguments = outputArguments;
    return this;
  }

  public OperationResult addOutputArgumentsItem(OperationVariable outputArgumentsItem) {
    if (this.outputArguments == null) {
      this.outputArguments = new ArrayList<>();
    }
    this.outputArguments.add(outputArgumentsItem);
    return this;
  }

   /**
   * Get outputArguments
   * @return outputArguments
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_OUTPUT_ARGUMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<OperationVariable> getOutputArguments() {
    return outputArguments;
  }


  @JsonProperty(JSON_PROPERTY_OUTPUT_ARGUMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOutputArguments(List<OperationVariable> outputArguments) {
    this.outputArguments = outputArguments;
  }


  /**
   * Return true if this OperationResult object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OperationResult operationResult = (OperationResult) o;
    return Objects.equals(this.messages, operationResult.messages) &&
        Objects.equals(this.executionState, operationResult.executionState) &&
        Objects.equals(this.success, operationResult.success) &&
        Objects.equals(this.inoutputArguments, operationResult.inoutputArguments) &&
        Objects.equals(this.outputArguments, operationResult.outputArguments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(messages, executionState, success, inoutputArguments, outputArguments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OperationResult {\n");
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

