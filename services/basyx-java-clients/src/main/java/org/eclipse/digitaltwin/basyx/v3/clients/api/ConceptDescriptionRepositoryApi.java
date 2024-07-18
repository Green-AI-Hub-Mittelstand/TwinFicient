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
package org.eclipse.digitaltwin.basyx.v3.clients.api;

import org.eclipse.digitaltwin.basyx.v3.clients.ApiClient;
import org.eclipse.digitaltwin.basyx.v3.clients.ApiException;
import org.eclipse.digitaltwin.basyx.v3.clients.ApiResponse;
import org.eclipse.digitaltwin.basyx.v3.clients.Pair;
import org.eclipse.digitaltwin.basyx.v3.clients.JSON;

import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.ConceptDescription;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Environment;
import java.io.File;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetConceptDescriptionsResult;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.Result;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.ServiceDescription;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.http.HttpRequest;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:11.412936200+01:00[Europe/Berlin]")
public class ConceptDescriptionRepositoryApi {
  private final HttpClient memberVarHttpClient;
  private final ObjectMapper memberVarObjectMapper;
  private final String memberVarBaseUri;
  private final Consumer<HttpRequest.Builder> memberVarInterceptor;
  private final Duration memberVarReadTimeout;
  private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;
  private final Consumer<HttpResponse<String>> memberVarAsyncResponseInterceptor;

  public ConceptDescriptionRepositoryApi() {
    this(new ApiClient());
  }

  public ConceptDescriptionRepositoryApi(ObjectMapper mapper, String baseUri) {
    this(new ApiClient(HttpClient.newBuilder(), mapper, baseUri));
  }
  
  public ConceptDescriptionRepositoryApi(String baseUri) {
    this(new ApiClient(HttpClient.newBuilder(), JSON.getDefault().getMapper(), baseUri));
  }


  public ConceptDescriptionRepositoryApi(ApiClient apiClient) {
    memberVarHttpClient = apiClient.getHttpClient();
    memberVarObjectMapper = apiClient.getObjectMapper();
    memberVarBaseUri = apiClient.getBaseUri();
    memberVarInterceptor = apiClient.getRequestInterceptor();
    memberVarReadTimeout = apiClient.getReadTimeout();
    memberVarResponseInterceptor = apiClient.getResponseInterceptor();
    memberVarAsyncResponseInterceptor = apiClient.getAsyncResponseInterceptor();
  }

  protected ApiException getApiException(String operationId, HttpResponse<InputStream> response) throws IOException {
    String body = response.body() == null ? null : new String(response.body().readAllBytes());
    String message = formatExceptionMessage(operationId, response.statusCode(), body);
    return new ApiException(response.statusCode(), message, response.headers(), body);
  }

  private String formatExceptionMessage(String operationId, int statusCode, String body) {
    if (body == null || body.isEmpty()) {
      body = "[no body]";
    }
    return operationId + " call failed with: " + statusCode + " - " + body;
  }

  /**
   * Deletes a Concept Description
   * 
   * @param cdIdentifier The Concept Description’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteConceptDescriptionById(String cdIdentifier) throws ApiException {

    deleteConceptDescriptionByIdWithHttpInfo(cdIdentifier);
  }

  /**
   * Deletes a Concept Description
   * 
   * @param cdIdentifier The Concept Description’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
 public ApiResponse<Void> deleteConceptDescriptionByIdWithHttpInfo(String cdIdentifier) throws ApiException {
    String  cdIdentifierAsBytes = ApiClient.base64UrlEncode(cdIdentifier);
  	return deleteConceptDescriptionByIdWithHttpInfoNoUrlEncoding(cdIdentifierAsBytes);
 	
 }


  /**
   * Deletes a Concept Description
   * 
   * @param cdIdentifier The Concept Description’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> deleteConceptDescriptionByIdWithHttpInfoNoUrlEncoding(String cdIdentifier) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = deleteConceptDescriptionByIdRequestBuilder(cdIdentifier);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("deleteConceptDescriptionById", localVarResponse);
        }
        return new ApiResponse<Void>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          null
        );
      } finally {
        // Drain the InputStream
        while (localVarResponse.body().read() != -1) {
            // Ignore
        }
        localVarResponse.body().close();
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder deleteConceptDescriptionByIdRequestBuilder(String cdIdentifier) throws ApiException {
    // verify the required parameter 'cdIdentifier' is set
    if (cdIdentifier == null) {
      throw new ApiException(400, "Missing the required parameter 'cdIdentifier' when calling deleteConceptDescriptionById");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/concept-descriptions/{cdIdentifier}"
        .replace("{cdIdentifier}", ApiClient.urlEncode(cdIdentifier.toString()));

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("DELETE", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Returns an appropriate serialization based on the specified format (see SerializationFormat)
   * 
   * @param aasIds The Asset Administration Shells&#39; unique ids (UTF8-BASE64-URL-encoded) (optional
   * @param submodelIds The Submodels&#39; unique ids (UTF8-BASE64-URL-encoded) (optional
   * @param includeConceptDescriptions Include Concept Descriptions? (optional, default to true)
   * @return File
   * @throws ApiException if fails to make API call
   */
  public File generateSerializationByIds(List<String> aasIds, List<String> submodelIds, Boolean includeConceptDescriptions) throws ApiException {

    ApiResponse<File> localVarResponse = generateSerializationByIdsWithHttpInfo(aasIds, submodelIds, includeConceptDescriptions);
    return localVarResponse.getData();
  }

  /**
   * Returns an appropriate serialization based on the specified format (see SerializationFormat)
   * 
   * @param aasIds The Asset Administration Shells&#39; unique ids (UTF8-BASE64-URL-encoded) (optional
   * @param submodelIds The Submodels&#39; unique ids (UTF8-BASE64-URL-encoded) (optional
   * @param includeConceptDescriptions Include Concept Descriptions? (optional, default to true)
   * @return ApiResponse&lt;File&gt;
   * @throws ApiException if fails to make API call
   */
 public ApiResponse<File> generateSerializationByIdsWithHttpInfo(List<String> aasIds, List<String> submodelIds, Boolean includeConceptDescriptions) throws ApiException {
  	return generateSerializationByIdsWithHttpInfoNoUrlEncoding(aasIds, submodelIds, includeConceptDescriptions);
 	
 }


  /**
   * Returns an appropriate serialization based on the specified format (see SerializationFormat)
   * 
   * @param aasIds The Asset Administration Shells&#39; unique ids (UTF8-BASE64-URL-encoded) (optional
   * @param submodelIds The Submodels&#39; unique ids (UTF8-BASE64-URL-encoded) (optional
   * @param includeConceptDescriptions Include Concept Descriptions? (optional, default to true)
   * @return ApiResponse&lt;File&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<File> generateSerializationByIdsWithHttpInfoNoUrlEncoding(List<String> aasIds, List<String> submodelIds, Boolean includeConceptDescriptions) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = generateSerializationByIdsRequestBuilder(aasIds, submodelIds, includeConceptDescriptions);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("generateSerializationByIds", localVarResponse);
        }
        return new ApiResponse<File>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<File>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder generateSerializationByIdsRequestBuilder(List<String> aasIds, List<String> submodelIds, Boolean includeConceptDescriptions) throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/serialization";

    List<Pair> localVarQueryParams = new ArrayList<>();
    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    localVarQueryParameterBaseName = "aasIds";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("multi", "aasIds", aasIds));
    localVarQueryParameterBaseName = "submodelIds";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("multi", "submodelIds", submodelIds));
    localVarQueryParameterBaseName = "includeConceptDescriptions";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("includeConceptDescriptions", includeConceptDescriptions));

    if (!localVarQueryParams.isEmpty() || localVarQueryStringJoiner.length() != 0) {
      StringJoiner queryJoiner = new StringJoiner("&");
      localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
      if (localVarQueryStringJoiner.length() != 0) {
        queryJoiner.add(localVarQueryStringJoiner.toString());
      }
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
    } else {
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
    }

    localVarRequestBuilder.header("Accept", "application/asset-administration-shell-package+xml, application/json, application/xml");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Returns all Concept Descriptions
   * 
   * @param idShort The Concept Description’s IdShort (optional)
   * @param isCaseOf IsCaseOf reference (UTF8-BASE64-URL-encoded) (optional)
   * @param dataSpecificationRef DataSpecification reference (UTF8-BASE64-URL-encoded) (optional)
   * @param limit The maximum number of elements in the response array (optional)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @return GetConceptDescriptionsResult
   * @throws ApiException if fails to make API call
   */
  public GetConceptDescriptionsResult getAllConceptDescriptions(String idShort, String isCaseOf, String dataSpecificationRef, Integer limit, String cursor) throws ApiException {

    ApiResponse<GetConceptDescriptionsResult> localVarResponse = getAllConceptDescriptionsWithHttpInfo(idShort, isCaseOf, dataSpecificationRef, limit, cursor);
    return localVarResponse.getData();
  }

  /**
   * Returns all Concept Descriptions
   * 
   * @param idShort The Concept Description’s IdShort (optional)
   * @param isCaseOf IsCaseOf reference (UTF8-BASE64-URL-encoded) (optional)
   * @param dataSpecificationRef DataSpecification reference (UTF8-BASE64-URL-encoded) (optional)
   * @param limit The maximum number of elements in the response array (optional)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @return ApiResponse&lt;GetConceptDescriptionsResult&gt;
   * @throws ApiException if fails to make API call
   */
 public ApiResponse<GetConceptDescriptionsResult> getAllConceptDescriptionsWithHttpInfo(String idShort, String isCaseOf, String dataSpecificationRef, Integer limit, String cursor) throws ApiException {
    String  isCaseOfAsBytes = ApiClient.base64UrlEncode(isCaseOf);
    String  dataSpecificationRefAsBytes = ApiClient.base64UrlEncode(dataSpecificationRef);
  	return getAllConceptDescriptionsWithHttpInfoNoUrlEncoding(idShort, isCaseOfAsBytes, dataSpecificationRefAsBytes, limit, cursor);
 	
 }


  /**
   * Returns all Concept Descriptions
   * 
   * @param idShort The Concept Description’s IdShort (optional)
   * @param isCaseOf IsCaseOf reference (UTF8-BASE64-URL-encoded) (optional)
   * @param dataSpecificationRef DataSpecification reference (UTF8-BASE64-URL-encoded) (optional)
   * @param limit The maximum number of elements in the response array (optional)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @return ApiResponse&lt;GetConceptDescriptionsResult&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<GetConceptDescriptionsResult> getAllConceptDescriptionsWithHttpInfoNoUrlEncoding(String idShort, String isCaseOf, String dataSpecificationRef, Integer limit, String cursor) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getAllConceptDescriptionsRequestBuilder(idShort, isCaseOf, dataSpecificationRef, limit, cursor);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getAllConceptDescriptions", localVarResponse);
        }
        return new ApiResponse<GetConceptDescriptionsResult>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<GetConceptDescriptionsResult>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getAllConceptDescriptionsRequestBuilder(String idShort, String isCaseOf, String dataSpecificationRef, Integer limit, String cursor) throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/concept-descriptions";

    List<Pair> localVarQueryParams = new ArrayList<>();
    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    localVarQueryParameterBaseName = "idShort";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("idShort", idShort));
    localVarQueryParameterBaseName = "isCaseOf";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("isCaseOf", isCaseOf));
    localVarQueryParameterBaseName = "dataSpecificationRef";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("dataSpecificationRef", dataSpecificationRef));
    localVarQueryParameterBaseName = "limit";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("limit", limit));
    localVarQueryParameterBaseName = "cursor";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("cursor", cursor));

    if (!localVarQueryParams.isEmpty() || localVarQueryStringJoiner.length() != 0) {
      StringJoiner queryJoiner = new StringJoiner("&");
      localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
      if (localVarQueryStringJoiner.length() != 0) {
        queryJoiner.add(localVarQueryStringJoiner.toString());
      }
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
    } else {
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
    }

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Returns a specific Concept Description
   * 
   * @param cdIdentifier The Concept Description’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @return ConceptDescription
   * @throws ApiException if fails to make API call
   */
  public ConceptDescription getConceptDescriptionById(String cdIdentifier) throws ApiException {

    ApiResponse<ConceptDescription> localVarResponse = getConceptDescriptionByIdWithHttpInfo(cdIdentifier);
    return localVarResponse.getData();
  }

  /**
   * Returns a specific Concept Description
   * 
   * @param cdIdentifier The Concept Description’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @return ApiResponse&lt;ConceptDescription&gt;
   * @throws ApiException if fails to make API call
   */
 public ApiResponse<ConceptDescription> getConceptDescriptionByIdWithHttpInfo(String cdIdentifier) throws ApiException {
    String  cdIdentifierAsBytes = ApiClient.base64UrlEncode(cdIdentifier);
  	return getConceptDescriptionByIdWithHttpInfoNoUrlEncoding(cdIdentifierAsBytes);
 	
 }


  /**
   * Returns a specific Concept Description
   * 
   * @param cdIdentifier The Concept Description’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @return ApiResponse&lt;ConceptDescription&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<ConceptDescription> getConceptDescriptionByIdWithHttpInfoNoUrlEncoding(String cdIdentifier) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getConceptDescriptionByIdRequestBuilder(cdIdentifier);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getConceptDescriptionById", localVarResponse);
        }
        return new ApiResponse<ConceptDescription>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<ConceptDescription>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getConceptDescriptionByIdRequestBuilder(String cdIdentifier) throws ApiException {
    // verify the required parameter 'cdIdentifier' is set
    if (cdIdentifier == null) {
      throw new ApiException(400, "Missing the required parameter 'cdIdentifier' when calling getConceptDescriptionById");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/concept-descriptions/{cdIdentifier}"
        .replace("{cdIdentifier}", ApiClient.urlEncode(cdIdentifier.toString()));

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Returns the self-describing information of a network resource (ServiceDescription)
   * 
   * @return ServiceDescription
   * @throws ApiException if fails to make API call
   */
  public ServiceDescription getDescription() throws ApiException {

    ApiResponse<ServiceDescription> localVarResponse = getDescriptionWithHttpInfo();
    return localVarResponse.getData();
  }

  /**
   * Returns the self-describing information of a network resource (ServiceDescription)
   * 
   * @return ApiResponse&lt;ServiceDescription&gt;
   * @throws ApiException if fails to make API call
   */
 public ApiResponse<ServiceDescription> getDescriptionWithHttpInfo() throws ApiException {
  	return getDescriptionWithHttpInfoNoUrlEncoding();
 	
 }


  /**
   * Returns the self-describing information of a network resource (ServiceDescription)
   * 
   * @return ApiResponse&lt;ServiceDescription&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<ServiceDescription> getDescriptionWithHttpInfoNoUrlEncoding() throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getDescriptionRequestBuilder();
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getDescription", localVarResponse);
        }
        return new ApiResponse<ServiceDescription>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<ServiceDescription>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getDescriptionRequestBuilder() throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/description";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Creates a new Concept Description
   * 
   * @param conceptDescription Concept Description object (required)
   * @return ConceptDescription
   * @throws ApiException if fails to make API call
   */
  public ConceptDescription postConceptDescription(ConceptDescription conceptDescription) throws ApiException {

    ApiResponse<ConceptDescription> localVarResponse = postConceptDescriptionWithHttpInfo(conceptDescription);
    return localVarResponse.getData();
  }

  /**
   * Creates a new Concept Description
   * 
   * @param conceptDescription Concept Description object (required)
   * @return ApiResponse&lt;ConceptDescription&gt;
   * @throws ApiException if fails to make API call
   */
 public ApiResponse<ConceptDescription> postConceptDescriptionWithHttpInfo(ConceptDescription conceptDescription) throws ApiException {
  	return postConceptDescriptionWithHttpInfoNoUrlEncoding(conceptDescription);
 	
 }


  /**
   * Creates a new Concept Description
   * 
   * @param conceptDescription Concept Description object (required)
   * @return ApiResponse&lt;ConceptDescription&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<ConceptDescription> postConceptDescriptionWithHttpInfoNoUrlEncoding(ConceptDescription conceptDescription) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = postConceptDescriptionRequestBuilder(conceptDescription);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("postConceptDescription", localVarResponse);
        }
        return new ApiResponse<ConceptDescription>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<ConceptDescription>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder postConceptDescriptionRequestBuilder(ConceptDescription conceptDescription) throws ApiException {
    // verify the required parameter 'conceptDescription' is set
    if (conceptDescription == null) {
      throw new ApiException(400, "Missing the required parameter 'conceptDescription' when calling postConceptDescription");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/concept-descriptions";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(conceptDescription);
      localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Updates an existing Concept Description
   * 
   * @param cdIdentifier The Concept Description’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param conceptDescription Concept Description object (required)
   * @throws ApiException if fails to make API call
   */
  public void putConceptDescriptionById(String cdIdentifier, ConceptDescription conceptDescription) throws ApiException {

    putConceptDescriptionByIdWithHttpInfo(cdIdentifier, conceptDescription);
  }

  /**
   * Updates an existing Concept Description
   * 
   * @param cdIdentifier The Concept Description’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param conceptDescription Concept Description object (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
 public ApiResponse<Void> putConceptDescriptionByIdWithHttpInfo(String cdIdentifier, ConceptDescription conceptDescription) throws ApiException {
    String  cdIdentifierAsBytes = ApiClient.base64UrlEncode(cdIdentifier);
  	return putConceptDescriptionByIdWithHttpInfoNoUrlEncoding(cdIdentifierAsBytes, conceptDescription);
 	
 }


  /**
   * Updates an existing Concept Description
   * 
   * @param cdIdentifier The Concept Description’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param conceptDescription Concept Description object (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> putConceptDescriptionByIdWithHttpInfoNoUrlEncoding(String cdIdentifier, ConceptDescription conceptDescription) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = putConceptDescriptionByIdRequestBuilder(cdIdentifier, conceptDescription);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("putConceptDescriptionById", localVarResponse);
        }
        return new ApiResponse<Void>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          null
        );
      } finally {
        // Drain the InputStream
        while (localVarResponse.body().read() != -1) {
            // Ignore
        }
        localVarResponse.body().close();
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder putConceptDescriptionByIdRequestBuilder(String cdIdentifier, ConceptDescription conceptDescription) throws ApiException {
    // verify the required parameter 'cdIdentifier' is set
    if (cdIdentifier == null) {
      throw new ApiException(400, "Missing the required parameter 'cdIdentifier' when calling putConceptDescriptionById");
    }
    // verify the required parameter 'conceptDescription' is set
    if (conceptDescription == null) {
      throw new ApiException(400, "Missing the required parameter 'conceptDescription' when calling putConceptDescriptionById");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/concept-descriptions/{cdIdentifier}"
        .replace("{cdIdentifier}", ApiClient.urlEncode(cdIdentifier.toString()));

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(conceptDescription);
      localVarRequestBuilder.method("PUT", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  
}
