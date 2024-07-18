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
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.EntityType;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * EntityValue
 */
@JsonPropertyOrder({
  EntityValue.JSON_PROPERTY_ENTITY_TYPE,
  EntityValue.JSON_PROPERTY_GLOBAL_ASSET_ID,
  EntityValue.JSON_PROPERTY_SPECIFIC_ASSET_IDS,
  EntityValue.JSON_PROPERTY_STATEMENTS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:09.185125100+01:00[Europe/Berlin]")
public class EntityValue {
  public static final String JSON_PROPERTY_ENTITY_TYPE = "entityType";
  private EntityType entityType;

  public static final String JSON_PROPERTY_GLOBAL_ASSET_ID = "globalAssetId";
  private String globalAssetId;

  public static final String JSON_PROPERTY_SPECIFIC_ASSET_IDS = "specificAssetIds";
  private List<Object> specificAssetIds;

  public static final String JSON_PROPERTY_STATEMENTS = "statements";
  private List<Object> statements = new ArrayList<>();

  public EntityValue() { 
  }

  public EntityValue entityType(EntityType entityType) {
    this.entityType = entityType;
    return this;
  }

   /**
   * Get entityType
   * @return entityType
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_ENTITY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public EntityType getEntityType() {
    return entityType;
  }


  @JsonProperty(JSON_PROPERTY_ENTITY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEntityType(EntityType entityType) {
    this.entityType = entityType;
  }


  public EntityValue globalAssetId(String globalAssetId) {
    this.globalAssetId = globalAssetId;
    return this;
  }

   /**
   * Get globalAssetId
   * @return globalAssetId
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_GLOBAL_ASSET_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getGlobalAssetId() {
    return globalAssetId;
  }


  @JsonProperty(JSON_PROPERTY_GLOBAL_ASSET_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setGlobalAssetId(String globalAssetId) {
    this.globalAssetId = globalAssetId;
  }


  public EntityValue specificAssetIds(List<Object> specificAssetIds) {
    this.specificAssetIds = specificAssetIds;
    return this;
  }

  public EntityValue addSpecificAssetIdsItem(Object specificAssetIdsItem) {
    if (this.specificAssetIds == null) {
      this.specificAssetIds = new ArrayList<>();
    }
    this.specificAssetIds.add(specificAssetIdsItem);
    return this;
  }

   /**
   * Get specificAssetIds
   * @return specificAssetIds
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SPECIFIC_ASSET_IDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Object> getSpecificAssetIds() {
    return specificAssetIds;
  }


  @JsonProperty(JSON_PROPERTY_SPECIFIC_ASSET_IDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSpecificAssetIds(List<Object> specificAssetIds) {
    this.specificAssetIds = specificAssetIds;
  }


  public EntityValue statements(List<Object> statements) {
    this.statements = statements;
    return this;
  }

  public EntityValue addStatementsItem(Object statementsItem) {
    if (this.statements == null) {
      this.statements = new ArrayList<>();
    }
    this.statements.add(statementsItem);
    return this;
  }

   /**
   * Get statements
   * @return statements
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_STATEMENTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<Object> getStatements() {
    return statements;
  }


  @JsonProperty(JSON_PROPERTY_STATEMENTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStatements(List<Object> statements) {
    this.statements = statements;
  }


  /**
   * Return true if this EntityValue object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EntityValue entityValue = (EntityValue) o;
    return Objects.equals(this.entityType, entityValue.entityType) &&
        Objects.equals(this.globalAssetId, entityValue.globalAssetId) &&
        Objects.equals(this.specificAssetIds, entityValue.specificAssetIds) &&
        Objects.equals(this.statements, entityValue.statements);
  }

  @Override
  public int hashCode() {
    return Objects.hash(entityType, globalAssetId, specificAssetIds, statements);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EntityValue {\n");
    sb.append("    entityType: ").append(toIndentedString(entityType)).append("\n");
    sb.append("    globalAssetId: ").append(toIndentedString(globalAssetId)).append("\n");
    sb.append("    specificAssetIds: ").append(toIndentedString(specificAssetIds)).append("\n");
    sb.append("    statements: ").append(toIndentedString(statements)).append("\n");
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

