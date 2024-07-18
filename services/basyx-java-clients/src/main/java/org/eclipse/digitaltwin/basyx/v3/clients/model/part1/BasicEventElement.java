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
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Direction;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.EmbeddedDataSpecification;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Extension;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.LangStringNameType;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.LangStringTextType;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Qualifier;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Reference;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.StateOfEvent;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * BasicEventElement
 */
@JsonPropertyOrder({
  BasicEventElement.JSON_PROPERTY_EXTENSIONS,
  BasicEventElement.JSON_PROPERTY_CATEGORY,
  BasicEventElement.JSON_PROPERTY_ID_SHORT,
  BasicEventElement.JSON_PROPERTY_DISPLAY_NAME,
  BasicEventElement.JSON_PROPERTY_DESCRIPTION,
  BasicEventElement.JSON_PROPERTY_MODEL_TYPE,
  BasicEventElement.JSON_PROPERTY_SEMANTIC_ID,
  BasicEventElement.JSON_PROPERTY_SUPPLEMENTAL_SEMANTIC_IDS,
  BasicEventElement.JSON_PROPERTY_QUALIFIERS,
  BasicEventElement.JSON_PROPERTY_EMBEDDED_DATA_SPECIFICATIONS,
  BasicEventElement.JSON_PROPERTY_OBSERVED,
  BasicEventElement.JSON_PROPERTY_DIRECTION,
  BasicEventElement.JSON_PROPERTY_STATE,
  BasicEventElement.JSON_PROPERTY_MESSAGE_TOPIC,
  BasicEventElement.JSON_PROPERTY_MESSAGE_BROKER,
  BasicEventElement.JSON_PROPERTY_LAST_UPDATE,
  BasicEventElement.JSON_PROPERTY_MIN_INTERVAL,
  BasicEventElement.JSON_PROPERTY_MAX_INTERVAL
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:07.399784100+01:00[Europe/Berlin]")
public class BasicEventElement {
  public static final String JSON_PROPERTY_EXTENSIONS = "extensions";
  private List<Extension> extensions;

  public static final String JSON_PROPERTY_CATEGORY = "category";
  private String category;

  public static final String JSON_PROPERTY_ID_SHORT = "idShort";
  private String idShort;

  public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
  private List<LangStringNameType> displayName;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private List<LangStringTextType> description;

  public static final String JSON_PROPERTY_MODEL_TYPE = "modelType";
  private String modelType;

  public static final String JSON_PROPERTY_SEMANTIC_ID = "semanticId";
  private Reference semanticId;

  public static final String JSON_PROPERTY_SUPPLEMENTAL_SEMANTIC_IDS = "supplementalSemanticIds";
  private List<Reference> supplementalSemanticIds;

  public static final String JSON_PROPERTY_QUALIFIERS = "qualifiers";
  private List<Qualifier> qualifiers;

  public static final String JSON_PROPERTY_EMBEDDED_DATA_SPECIFICATIONS = "embeddedDataSpecifications";
  private List<EmbeddedDataSpecification> embeddedDataSpecifications;

  public static final String JSON_PROPERTY_OBSERVED = "observed";
  private Reference observed;

  public static final String JSON_PROPERTY_DIRECTION = "direction";
  private Direction direction;

  public static final String JSON_PROPERTY_STATE = "state";
  private StateOfEvent state;

  public static final String JSON_PROPERTY_MESSAGE_TOPIC = "messageTopic";
  private String messageTopic;

  public static final String JSON_PROPERTY_MESSAGE_BROKER = "messageBroker";
  private Reference messageBroker;

  public static final String JSON_PROPERTY_LAST_UPDATE = "lastUpdate";
  private String lastUpdate;

  public static final String JSON_PROPERTY_MIN_INTERVAL = "minInterval";
  private String minInterval;

  public static final String JSON_PROPERTY_MAX_INTERVAL = "maxInterval";
  private String maxInterval;

  public BasicEventElement() { 
  }

  public BasicEventElement extensions(List<Extension> extensions) {
    this.extensions = extensions;
    return this;
  }

  public BasicEventElement addExtensionsItem(Extension extensionsItem) {
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


  public BasicEventElement category(String category) {
    this.category = category;
    return this;
  }

   /**
   * Get category
   * @return category
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CATEGORY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCategory() {
    return category;
  }


  @JsonProperty(JSON_PROPERTY_CATEGORY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCategory(String category) {
    this.category = category;
  }


  public BasicEventElement idShort(String idShort) {
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


  public BasicEventElement displayName(List<LangStringNameType> displayName) {
    this.displayName = displayName;
    return this;
  }

  public BasicEventElement addDisplayNameItem(LangStringNameType displayNameItem) {
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


  public BasicEventElement description(List<LangStringTextType> description) {
    this.description = description;
    return this;
  }

  public BasicEventElement addDescriptionItem(LangStringTextType descriptionItem) {
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


  public BasicEventElement modelType(String modelType) {
    this.modelType = modelType;
    return this;
  }

   /**
   * Get modelType
   * @return modelType
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_MODEL_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getModelType() {
    return modelType;
  }


  @JsonProperty(JSON_PROPERTY_MODEL_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setModelType(String modelType) {
    this.modelType = modelType;
  }


  public BasicEventElement semanticId(Reference semanticId) {
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


  public BasicEventElement supplementalSemanticIds(List<Reference> supplementalSemanticIds) {
    this.supplementalSemanticIds = supplementalSemanticIds;
    return this;
  }

  public BasicEventElement addSupplementalSemanticIdsItem(Reference supplementalSemanticIdsItem) {
    if (this.supplementalSemanticIds == null) {
      this.supplementalSemanticIds = new ArrayList<>();
    }
    this.supplementalSemanticIds.add(supplementalSemanticIdsItem);
    return this;
  }

   /**
   * Get supplementalSemanticIds
   * @return supplementalSemanticIds
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SUPPLEMENTAL_SEMANTIC_IDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Reference> getSupplementalSemanticIds() {
    return supplementalSemanticIds;
  }


  @JsonProperty(JSON_PROPERTY_SUPPLEMENTAL_SEMANTIC_IDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSupplementalSemanticIds(List<Reference> supplementalSemanticIds) {
    this.supplementalSemanticIds = supplementalSemanticIds;
  }


  public BasicEventElement qualifiers(List<Qualifier> qualifiers) {
    this.qualifiers = qualifiers;
    return this;
  }

  public BasicEventElement addQualifiersItem(Qualifier qualifiersItem) {
    if (this.qualifiers == null) {
      this.qualifiers = new ArrayList<>();
    }
    this.qualifiers.add(qualifiersItem);
    return this;
  }

   /**
   * Get qualifiers
   * @return qualifiers
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_QUALIFIERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Qualifier> getQualifiers() {
    return qualifiers;
  }


  @JsonProperty(JSON_PROPERTY_QUALIFIERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setQualifiers(List<Qualifier> qualifiers) {
    this.qualifiers = qualifiers;
  }


  public BasicEventElement embeddedDataSpecifications(List<EmbeddedDataSpecification> embeddedDataSpecifications) {
    this.embeddedDataSpecifications = embeddedDataSpecifications;
    return this;
  }

  public BasicEventElement addEmbeddedDataSpecificationsItem(EmbeddedDataSpecification embeddedDataSpecificationsItem) {
    if (this.embeddedDataSpecifications == null) {
      this.embeddedDataSpecifications = new ArrayList<>();
    }
    this.embeddedDataSpecifications.add(embeddedDataSpecificationsItem);
    return this;
  }

   /**
   * Get embeddedDataSpecifications
   * @return embeddedDataSpecifications
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_EMBEDDED_DATA_SPECIFICATIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<EmbeddedDataSpecification> getEmbeddedDataSpecifications() {
    return embeddedDataSpecifications;
  }


  @JsonProperty(JSON_PROPERTY_EMBEDDED_DATA_SPECIFICATIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEmbeddedDataSpecifications(List<EmbeddedDataSpecification> embeddedDataSpecifications) {
    this.embeddedDataSpecifications = embeddedDataSpecifications;
  }


  public BasicEventElement observed(Reference observed) {
    this.observed = observed;
    return this;
  }

   /**
   * Get observed
   * @return observed
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_OBSERVED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Reference getObserved() {
    return observed;
  }


  @JsonProperty(JSON_PROPERTY_OBSERVED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setObserved(Reference observed) {
    this.observed = observed;
  }


  public BasicEventElement direction(Direction direction) {
    this.direction = direction;
    return this;
  }

   /**
   * Get direction
   * @return direction
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_DIRECTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Direction getDirection() {
    return direction;
  }


  @JsonProperty(JSON_PROPERTY_DIRECTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDirection(Direction direction) {
    this.direction = direction;
  }


  public BasicEventElement state(StateOfEvent state) {
    this.state = state;
    return this;
  }

   /**
   * Get state
   * @return state
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public StateOfEvent getState() {
    return state;
  }


  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setState(StateOfEvent state) {
    this.state = state;
  }


  public BasicEventElement messageTopic(String messageTopic) {
    this.messageTopic = messageTopic;
    return this;
  }

   /**
   * Get messageTopic
   * @return messageTopic
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_MESSAGE_TOPIC)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getMessageTopic() {
    return messageTopic;
  }


  @JsonProperty(JSON_PROPERTY_MESSAGE_TOPIC)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMessageTopic(String messageTopic) {
    this.messageTopic = messageTopic;
  }


  public BasicEventElement messageBroker(Reference messageBroker) {
    this.messageBroker = messageBroker;
    return this;
  }

   /**
   * Get messageBroker
   * @return messageBroker
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_MESSAGE_BROKER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Reference getMessageBroker() {
    return messageBroker;
  }


  @JsonProperty(JSON_PROPERTY_MESSAGE_BROKER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMessageBroker(Reference messageBroker) {
    this.messageBroker = messageBroker;
  }


  public BasicEventElement lastUpdate(String lastUpdate) {
    this.lastUpdate = lastUpdate;
    return this;
  }

   /**
   * Get lastUpdate
   * @return lastUpdate
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_LAST_UPDATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getLastUpdate() {
    return lastUpdate;
  }


  @JsonProperty(JSON_PROPERTY_LAST_UPDATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLastUpdate(String lastUpdate) {
    this.lastUpdate = lastUpdate;
  }


  public BasicEventElement minInterval(String minInterval) {
    this.minInterval = minInterval;
    return this;
  }

   /**
   * Get minInterval
   * @return minInterval
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_MIN_INTERVAL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getMinInterval() {
    return minInterval;
  }


  @JsonProperty(JSON_PROPERTY_MIN_INTERVAL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMinInterval(String minInterval) {
    this.minInterval = minInterval;
  }


  public BasicEventElement maxInterval(String maxInterval) {
    this.maxInterval = maxInterval;
    return this;
  }

   /**
   * Get maxInterval
   * @return maxInterval
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_MAX_INTERVAL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getMaxInterval() {
    return maxInterval;
  }


  @JsonProperty(JSON_PROPERTY_MAX_INTERVAL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMaxInterval(String maxInterval) {
    this.maxInterval = maxInterval;
  }


  /**
   * Return true if this BasicEventElement object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BasicEventElement basicEventElement = (BasicEventElement) o;
    return Objects.equals(this.extensions, basicEventElement.extensions) &&
        Objects.equals(this.category, basicEventElement.category) &&
        Objects.equals(this.idShort, basicEventElement.idShort) &&
        Objects.equals(this.displayName, basicEventElement.displayName) &&
        Objects.equals(this.description, basicEventElement.description) &&
        Objects.equals(this.modelType, basicEventElement.modelType) &&
        Objects.equals(this.semanticId, basicEventElement.semanticId) &&
        Objects.equals(this.supplementalSemanticIds, basicEventElement.supplementalSemanticIds) &&
        Objects.equals(this.qualifiers, basicEventElement.qualifiers) &&
        Objects.equals(this.embeddedDataSpecifications, basicEventElement.embeddedDataSpecifications) &&
        Objects.equals(this.observed, basicEventElement.observed) &&
        Objects.equals(this.direction, basicEventElement.direction) &&
        Objects.equals(this.state, basicEventElement.state) &&
        Objects.equals(this.messageTopic, basicEventElement.messageTopic) &&
        Objects.equals(this.messageBroker, basicEventElement.messageBroker) &&
        Objects.equals(this.lastUpdate, basicEventElement.lastUpdate) &&
        Objects.equals(this.minInterval, basicEventElement.minInterval) &&
        Objects.equals(this.maxInterval, basicEventElement.maxInterval);
  }

  @Override
  public int hashCode() {
    return Objects.hash(extensions, category, idShort, displayName, description, modelType, semanticId, supplementalSemanticIds, qualifiers, embeddedDataSpecifications, observed, direction, state, messageTopic, messageBroker, lastUpdate, minInterval, maxInterval);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BasicEventElement {\n");
    sb.append("    extensions: ").append(toIndentedString(extensions)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    idShort: ").append(toIndentedString(idShort)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    modelType: ").append(toIndentedString(modelType)).append("\n");
    sb.append("    semanticId: ").append(toIndentedString(semanticId)).append("\n");
    sb.append("    supplementalSemanticIds: ").append(toIndentedString(supplementalSemanticIds)).append("\n");
    sb.append("    qualifiers: ").append(toIndentedString(qualifiers)).append("\n");
    sb.append("    embeddedDataSpecifications: ").append(toIndentedString(embeddedDataSpecifications)).append("\n");
    sb.append("    observed: ").append(toIndentedString(observed)).append("\n");
    sb.append("    direction: ").append(toIndentedString(direction)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    messageTopic: ").append(toIndentedString(messageTopic)).append("\n");
    sb.append("    messageBroker: ").append(toIndentedString(messageBroker)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("    minInterval: ").append(toIndentedString(minInterval)).append("\n");
    sb.append("    maxInterval: ").append(toIndentedString(maxInterval)).append("\n");
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

