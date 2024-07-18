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
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Reference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * EventPayload
 */
@JsonPropertyOrder({
  EventPayload.JSON_PROPERTY_SOURCE,
  EventPayload.JSON_PROPERTY_SOURCE_SEMANTIC_ID,
  EventPayload.JSON_PROPERTY_OBSERVABLE_REFERENCE,
  EventPayload.JSON_PROPERTY_OBSERVABLE_SEMANTIC_ID,
  EventPayload.JSON_PROPERTY_TOPIC,
  EventPayload.JSON_PROPERTY_SUBJECT_ID,
  EventPayload.JSON_PROPERTY_TIME_STAMP,
  EventPayload.JSON_PROPERTY_PAYLOAD
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:07.399784100+01:00[Europe/Berlin]")
public class EventPayload {
  public static final String JSON_PROPERTY_SOURCE = "source";
  private Reference source;

  public static final String JSON_PROPERTY_SOURCE_SEMANTIC_ID = "sourceSemanticId";
  private Reference sourceSemanticId;

  public static final String JSON_PROPERTY_OBSERVABLE_REFERENCE = "observableReference";
  private Reference observableReference;

  public static final String JSON_PROPERTY_OBSERVABLE_SEMANTIC_ID = "observableSemanticId";
  private Reference observableSemanticId;

  public static final String JSON_PROPERTY_TOPIC = "topic";
  private String topic;

  public static final String JSON_PROPERTY_SUBJECT_ID = "subjectId";
  private Reference subjectId;

  public static final String JSON_PROPERTY_TIME_STAMP = "timeStamp";
  private String timeStamp;

  public static final String JSON_PROPERTY_PAYLOAD = "payload";
  private byte[] payload;

  public EventPayload() { 
  }

  public EventPayload source(Reference source) {
    this.source = source;
    return this;
  }

   /**
   * Get source
   * @return source
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_SOURCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Reference getSource() {
    return source;
  }


  @JsonProperty(JSON_PROPERTY_SOURCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSource(Reference source) {
    this.source = source;
  }


  public EventPayload sourceSemanticId(Reference sourceSemanticId) {
    this.sourceSemanticId = sourceSemanticId;
    return this;
  }

   /**
   * Get sourceSemanticId
   * @return sourceSemanticId
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SOURCE_SEMANTIC_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Reference getSourceSemanticId() {
    return sourceSemanticId;
  }


  @JsonProperty(JSON_PROPERTY_SOURCE_SEMANTIC_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSourceSemanticId(Reference sourceSemanticId) {
    this.sourceSemanticId = sourceSemanticId;
  }


  public EventPayload observableReference(Reference observableReference) {
    this.observableReference = observableReference;
    return this;
  }

   /**
   * Get observableReference
   * @return observableReference
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_OBSERVABLE_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Reference getObservableReference() {
    return observableReference;
  }


  @JsonProperty(JSON_PROPERTY_OBSERVABLE_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setObservableReference(Reference observableReference) {
    this.observableReference = observableReference;
  }


  public EventPayload observableSemanticId(Reference observableSemanticId) {
    this.observableSemanticId = observableSemanticId;
    return this;
  }

   /**
   * Get observableSemanticId
   * @return observableSemanticId
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_OBSERVABLE_SEMANTIC_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Reference getObservableSemanticId() {
    return observableSemanticId;
  }


  @JsonProperty(JSON_PROPERTY_OBSERVABLE_SEMANTIC_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setObservableSemanticId(Reference observableSemanticId) {
    this.observableSemanticId = observableSemanticId;
  }


  public EventPayload topic(String topic) {
    this.topic = topic;
    return this;
  }

   /**
   * Get topic
   * @return topic
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TOPIC)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTopic() {
    return topic;
  }


  @JsonProperty(JSON_PROPERTY_TOPIC)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTopic(String topic) {
    this.topic = topic;
  }


  public EventPayload subjectId(Reference subjectId) {
    this.subjectId = subjectId;
    return this;
  }

   /**
   * Get subjectId
   * @return subjectId
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SUBJECT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Reference getSubjectId() {
    return subjectId;
  }


  @JsonProperty(JSON_PROPERTY_SUBJECT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSubjectId(Reference subjectId) {
    this.subjectId = subjectId;
  }


  public EventPayload timeStamp(String timeStamp) {
    this.timeStamp = timeStamp;
    return this;
  }

   /**
   * Get timeStamp
   * @return timeStamp
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_TIME_STAMP)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getTimeStamp() {
    return timeStamp;
  }


  @JsonProperty(JSON_PROPERTY_TIME_STAMP)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTimeStamp(String timeStamp) {
    this.timeStamp = timeStamp;
  }


  public EventPayload payload(byte[] payload) {
    this.payload = payload;
    return this;
  }

   /**
   * Get payload
   * @return payload
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PAYLOAD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public byte[] getPayload() {
    return payload;
  }


  @JsonProperty(JSON_PROPERTY_PAYLOAD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPayload(byte[] payload) {
    this.payload = payload;
  }


  /**
   * Return true if this EventPayload object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventPayload eventPayload = (EventPayload) o;
    return Objects.equals(this.source, eventPayload.source) &&
        Objects.equals(this.sourceSemanticId, eventPayload.sourceSemanticId) &&
        Objects.equals(this.observableReference, eventPayload.observableReference) &&
        Objects.equals(this.observableSemanticId, eventPayload.observableSemanticId) &&
        Objects.equals(this.topic, eventPayload.topic) &&
        Objects.equals(this.subjectId, eventPayload.subjectId) &&
        Objects.equals(this.timeStamp, eventPayload.timeStamp) &&
        Arrays.equals(this.payload, eventPayload.payload);
  }

  @Override
  public int hashCode() {
    return Objects.hash(source, sourceSemanticId, observableReference, observableSemanticId, topic, subjectId, timeStamp, Arrays.hashCode(payload));
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventPayload {\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    sourceSemanticId: ").append(toIndentedString(sourceSemanticId)).append("\n");
    sb.append("    observableReference: ").append(toIndentedString(observableReference)).append("\n");
    sb.append("    observableSemanticId: ").append(toIndentedString(observableSemanticId)).append("\n");
    sb.append("    topic: ").append(toIndentedString(topic)).append("\n");
    sb.append("    subjectId: ").append(toIndentedString(subjectId)).append("\n");
    sb.append("    timeStamp: ").append(toIndentedString(timeStamp)).append("\n");
    sb.append("    payload: ").append(toIndentedString(payload)).append("\n");
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

