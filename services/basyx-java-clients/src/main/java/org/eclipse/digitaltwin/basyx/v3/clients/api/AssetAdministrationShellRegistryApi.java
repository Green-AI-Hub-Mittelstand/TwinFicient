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

import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.AssetAdministrationShellDescriptor;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.AssetKind;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetAssetAdministrationShellDescriptorsResult;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetSubmodelDescriptorsResult;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.Result;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.ServiceDescription;
import org.eclipse.digitaltwin.basyx.v3.clients.model.search.ShellDescriptorSearchRequest;
import org.eclipse.digitaltwin.basyx.v3.clients.model.search.ShellDescriptorSearchResponse;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.SubmodelDescriptor;

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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:10.160916500+01:00[Europe/Berlin]")
public class AssetAdministrationShellRegistryApi {
  private final HttpClient memberVarHttpClient;
  private final ObjectMapper memberVarObjectMapper;
  private final String memberVarBaseUri;
  private final Consumer<HttpRequest.Builder> memberVarInterceptor;
  private final Duration memberVarReadTimeout;
  private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;
  private final Consumer<HttpResponse<String>> memberVarAsyncResponseInterceptor;

  public AssetAdministrationShellRegistryApi() {
    this(new ApiClient());
  }

  public AssetAdministrationShellRegistryApi(ObjectMapper mapper, String baseUri) {
    this(new ApiClient(HttpClient.newBuilder(), mapper, baseUri));
  }
  
  public AssetAdministrationShellRegistryApi(String baseUri) {
    this(new ApiClient(HttpClient.newBuilder(), JSON.getDefault().getMapper(), baseUri));
  }


  public AssetAdministrationShellRegistryApi(ApiClient apiClient) {
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
   * Deletes an Asset Administration Shell Descriptor, i.e. de-registers an AAS
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteAssetAdministrationShellDescriptorById(String aasIdentifier) throws ApiException {

    deleteAssetAdministrationShellDescriptorByIdWithHttpInfo(aasIdentifier);
  }

  /**
   * Deletes an Asset Administration Shell Descriptor, i.e. de-registers an AAS
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
 public ApiResponse<Void> deleteAssetAdministrationShellDescriptorByIdWithHttpInfo(String aasIdentifier) throws ApiException {
    String  aasIdentifierAsBytes = ApiClient.base64UrlEncode(aasIdentifier);
  	return deleteAssetAdministrationShellDescriptorByIdWithHttpInfoNoUrlEncoding(aasIdentifierAsBytes);
 	
 }


  /**
   * Deletes an Asset Administration Shell Descriptor, i.e. de-registers an AAS
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> deleteAssetAdministrationShellDescriptorByIdWithHttpInfoNoUrlEncoding(String aasIdentifier) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = deleteAssetAdministrationShellDescriptorByIdRequestBuilder(aasIdentifier);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("deleteAssetAdministrationShellDescriptorById", localVarResponse);
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

  private HttpRequest.Builder deleteAssetAdministrationShellDescriptorByIdRequestBuilder(String aasIdentifier) throws ApiException {
    // verify the required parameter 'aasIdentifier' is set
    if (aasIdentifier == null) {
      throw new ApiException(400, "Missing the required parameter 'aasIdentifier' when calling deleteAssetAdministrationShellDescriptorById");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/shell-descriptors/{aasIdentifier}"
        .replace("{aasIdentifier}", ApiClient.urlEncode(aasIdentifier.toString()));

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
   * Deletes a Submodel Descriptor, i.e. de-registers a submodel
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteSubmodelDescriptorByIdThroughSuperpath(String aasIdentifier, String submodelIdentifier) throws ApiException {

    deleteSubmodelDescriptorByIdThroughSuperpathWithHttpInfo(aasIdentifier, submodelIdentifier);
  }

  /**
   * Deletes a Submodel Descriptor, i.e. de-registers a submodel
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
 public ApiResponse<Void> deleteSubmodelDescriptorByIdThroughSuperpathWithHttpInfo(String aasIdentifier, String submodelIdentifier) throws ApiException {
    String  aasIdentifierAsBytes = ApiClient.base64UrlEncode(aasIdentifier);
    String  submodelIdentifierAsBytes = ApiClient.base64UrlEncode(submodelIdentifier);
  	return deleteSubmodelDescriptorByIdThroughSuperpathWithHttpInfoNoUrlEncoding(aasIdentifierAsBytes, submodelIdentifierAsBytes);
 	
 }


  /**
   * Deletes a Submodel Descriptor, i.e. de-registers a submodel
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> deleteSubmodelDescriptorByIdThroughSuperpathWithHttpInfoNoUrlEncoding(String aasIdentifier, String submodelIdentifier) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = deleteSubmodelDescriptorByIdThroughSuperpathRequestBuilder(aasIdentifier, submodelIdentifier);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("deleteSubmodelDescriptorByIdThroughSuperpath", localVarResponse);
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

  private HttpRequest.Builder deleteSubmodelDescriptorByIdThroughSuperpathRequestBuilder(String aasIdentifier, String submodelIdentifier) throws ApiException {
    // verify the required parameter 'aasIdentifier' is set
    if (aasIdentifier == null) {
      throw new ApiException(400, "Missing the required parameter 'aasIdentifier' when calling deleteSubmodelDescriptorByIdThroughSuperpath");
    }
    // verify the required parameter 'submodelIdentifier' is set
    if (submodelIdentifier == null) {
      throw new ApiException(400, "Missing the required parameter 'submodelIdentifier' when calling deleteSubmodelDescriptorByIdThroughSuperpath");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/shell-descriptors/{aasIdentifier}/submodel-descriptors/{submodelIdentifier}"
        .replace("{aasIdentifier}", ApiClient.urlEncode(aasIdentifier.toString()))
        .replace("{submodelIdentifier}", ApiClient.urlEncode(submodelIdentifier.toString()));

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
   * Returns all Asset Administration Shell Descriptors
   * 
   * @param limit The maximum number of elements in the response array (optional)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @param assetKind The Asset&#39;s kind (Instance or Type) (optional)
   * @param assetType The Asset&#39;s type (UTF8-BASE64-URL-encoded) (optional)
   * @return GetAssetAdministrationShellDescriptorsResult
   * @throws ApiException if fails to make API call
   */
  public GetAssetAdministrationShellDescriptorsResult getAllAssetAdministrationShellDescriptors(Integer limit, String cursor, AssetKind assetKind, String assetType) throws ApiException {

    ApiResponse<GetAssetAdministrationShellDescriptorsResult> localVarResponse = getAllAssetAdministrationShellDescriptorsWithHttpInfo(limit, cursor, assetKind, assetType);
    return localVarResponse.getData();
  }

  /**
   * Returns all Asset Administration Shell Descriptors
   * 
   * @param limit The maximum number of elements in the response array (optional)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @param assetKind The Asset&#39;s kind (Instance or Type) (optional)
   * @param assetType The Asset&#39;s type (UTF8-BASE64-URL-encoded) (optional)
   * @return ApiResponse&lt;GetAssetAdministrationShellDescriptorsResult&gt;
   * @throws ApiException if fails to make API call
   */
 public ApiResponse<GetAssetAdministrationShellDescriptorsResult> getAllAssetAdministrationShellDescriptorsWithHttpInfo(Integer limit, String cursor, AssetKind assetKind, String assetType) throws ApiException {
  	return getAllAssetAdministrationShellDescriptorsWithHttpInfoNoUrlEncoding(limit, cursor, assetKind, assetType);
 	
 }


  /**
   * Returns all Asset Administration Shell Descriptors
   * 
   * @param limit The maximum number of elements in the response array (optional)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @param assetKind The Asset&#39;s kind (Instance or Type) (optional)
   * @param assetType The Asset&#39;s type (UTF8-BASE64-URL-encoded) (optional)
   * @return ApiResponse&lt;GetAssetAdministrationShellDescriptorsResult&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<GetAssetAdministrationShellDescriptorsResult> getAllAssetAdministrationShellDescriptorsWithHttpInfoNoUrlEncoding(Integer limit, String cursor, AssetKind assetKind, String assetType) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getAllAssetAdministrationShellDescriptorsRequestBuilder(limit, cursor, assetKind, assetType);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getAllAssetAdministrationShellDescriptors", localVarResponse);
        }
        return new ApiResponse<GetAssetAdministrationShellDescriptorsResult>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<GetAssetAdministrationShellDescriptorsResult>() {}) // closes the InputStream
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

  private HttpRequest.Builder getAllAssetAdministrationShellDescriptorsRequestBuilder(Integer limit, String cursor, AssetKind assetKind, String assetType) throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/shell-descriptors";

    List<Pair> localVarQueryParams = new ArrayList<>();
    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    localVarQueryParameterBaseName = "limit";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("limit", limit));
    localVarQueryParameterBaseName = "cursor";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("cursor", cursor));
    localVarQueryParameterBaseName = "assetKind";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("assetKind", assetKind));
    localVarQueryParameterBaseName = "assetType";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("assetType", assetType));

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
   * Returns all Submodel Descriptors
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param limit The maximum number of elements in the response array (optional)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @return GetSubmodelDescriptorsResult
   * @throws ApiException if fails to make API call
   */
  public GetSubmodelDescriptorsResult getAllSubmodelDescriptorsThroughSuperpath(String aasIdentifier, Integer limit, String cursor) throws ApiException {

    ApiResponse<GetSubmodelDescriptorsResult> localVarResponse = getAllSubmodelDescriptorsThroughSuperpathWithHttpInfo(aasIdentifier, limit, cursor);
    return localVarResponse.getData();
  }

  /**
   * Returns all Submodel Descriptors
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param limit The maximum number of elements in the response array (optional)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @return ApiResponse&lt;GetSubmodelDescriptorsResult&gt;
   * @throws ApiException if fails to make API call
   */
 public ApiResponse<GetSubmodelDescriptorsResult> getAllSubmodelDescriptorsThroughSuperpathWithHttpInfo(String aasIdentifier, Integer limit, String cursor) throws ApiException {
    String  aasIdentifierAsBytes = ApiClient.base64UrlEncode(aasIdentifier);
  	return getAllSubmodelDescriptorsThroughSuperpathWithHttpInfoNoUrlEncoding(aasIdentifierAsBytes, limit, cursor);
 	
 }


  /**
   * Returns all Submodel Descriptors
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param limit The maximum number of elements in the response array (optional)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @return ApiResponse&lt;GetSubmodelDescriptorsResult&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<GetSubmodelDescriptorsResult> getAllSubmodelDescriptorsThroughSuperpathWithHttpInfoNoUrlEncoding(String aasIdentifier, Integer limit, String cursor) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getAllSubmodelDescriptorsThroughSuperpathRequestBuilder(aasIdentifier, limit, cursor);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getAllSubmodelDescriptorsThroughSuperpath", localVarResponse);
        }
        return new ApiResponse<GetSubmodelDescriptorsResult>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<GetSubmodelDescriptorsResult>() {}) // closes the InputStream
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

  private HttpRequest.Builder getAllSubmodelDescriptorsThroughSuperpathRequestBuilder(String aasIdentifier, Integer limit, String cursor) throws ApiException {
    // verify the required parameter 'aasIdentifier' is set
    if (aasIdentifier == null) {
      throw new ApiException(400, "Missing the required parameter 'aasIdentifier' when calling getAllSubmodelDescriptorsThroughSuperpath");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/shell-descriptors/{aasIdentifier}/submodel-descriptors"
        .replace("{aasIdentifier}", ApiClient.urlEncode(aasIdentifier.toString()));

    List<Pair> localVarQueryParams = new ArrayList<>();
    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
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
   * Returns a specific Asset Administration Shell Descriptor
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @return AssetAdministrationShellDescriptor
   * @throws ApiException if fails to make API call
   */
  public AssetAdministrationShellDescriptor getAssetAdministrationShellDescriptorById(String aasIdentifier) throws ApiException {

    ApiResponse<AssetAdministrationShellDescriptor> localVarResponse = getAssetAdministrationShellDescriptorByIdWithHttpInfo(aasIdentifier);
    return localVarResponse.getData();
  }

  /**
   * Returns a specific Asset Administration Shell Descriptor
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @return ApiResponse&lt;AssetAdministrationShellDescriptor&gt;
   * @throws ApiException if fails to make API call
   */
 public ApiResponse<AssetAdministrationShellDescriptor> getAssetAdministrationShellDescriptorByIdWithHttpInfo(String aasIdentifier) throws ApiException {
    String  aasIdentifierAsBytes = ApiClient.base64UrlEncode(aasIdentifier);
  	return getAssetAdministrationShellDescriptorByIdWithHttpInfoNoUrlEncoding(aasIdentifierAsBytes);
 	
 }


  /**
   * Returns a specific Asset Administration Shell Descriptor
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @return ApiResponse&lt;AssetAdministrationShellDescriptor&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<AssetAdministrationShellDescriptor> getAssetAdministrationShellDescriptorByIdWithHttpInfoNoUrlEncoding(String aasIdentifier) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getAssetAdministrationShellDescriptorByIdRequestBuilder(aasIdentifier);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getAssetAdministrationShellDescriptorById", localVarResponse);
        }
        return new ApiResponse<AssetAdministrationShellDescriptor>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<AssetAdministrationShellDescriptor>() {}) // closes the InputStream
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

  private HttpRequest.Builder getAssetAdministrationShellDescriptorByIdRequestBuilder(String aasIdentifier) throws ApiException {
    // verify the required parameter 'aasIdentifier' is set
    if (aasIdentifier == null) {
      throw new ApiException(400, "Missing the required parameter 'aasIdentifier' when calling getAssetAdministrationShellDescriptorById");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/shell-descriptors/{aasIdentifier}"
        .replace("{aasIdentifier}", ApiClient.urlEncode(aasIdentifier.toString()));

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
   * Returns a specific Submodel Descriptor
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @return SubmodelDescriptor
   * @throws ApiException if fails to make API call
   */
  public SubmodelDescriptor getSubmodelDescriptorByIdThroughSuperpath(String aasIdentifier, String submodelIdentifier) throws ApiException {

    ApiResponse<SubmodelDescriptor> localVarResponse = getSubmodelDescriptorByIdThroughSuperpathWithHttpInfo(aasIdentifier, submodelIdentifier);
    return localVarResponse.getData();
  }

  /**
   * Returns a specific Submodel Descriptor
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @return ApiResponse&lt;SubmodelDescriptor&gt;
   * @throws ApiException if fails to make API call
   */
 public ApiResponse<SubmodelDescriptor> getSubmodelDescriptorByIdThroughSuperpathWithHttpInfo(String aasIdentifier, String submodelIdentifier) throws ApiException {
    String  aasIdentifierAsBytes = ApiClient.base64UrlEncode(aasIdentifier);
    String  submodelIdentifierAsBytes = ApiClient.base64UrlEncode(submodelIdentifier);
  	return getSubmodelDescriptorByIdThroughSuperpathWithHttpInfoNoUrlEncoding(aasIdentifierAsBytes, submodelIdentifierAsBytes);
 	
 }


  /**
   * Returns a specific Submodel Descriptor
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @return ApiResponse&lt;SubmodelDescriptor&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<SubmodelDescriptor> getSubmodelDescriptorByIdThroughSuperpathWithHttpInfoNoUrlEncoding(String aasIdentifier, String submodelIdentifier) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getSubmodelDescriptorByIdThroughSuperpathRequestBuilder(aasIdentifier, submodelIdentifier);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getSubmodelDescriptorByIdThroughSuperpath", localVarResponse);
        }
        return new ApiResponse<SubmodelDescriptor>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<SubmodelDescriptor>() {}) // closes the InputStream
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

  private HttpRequest.Builder getSubmodelDescriptorByIdThroughSuperpathRequestBuilder(String aasIdentifier, String submodelIdentifier) throws ApiException {
    // verify the required parameter 'aasIdentifier' is set
    if (aasIdentifier == null) {
      throw new ApiException(400, "Missing the required parameter 'aasIdentifier' when calling getSubmodelDescriptorByIdThroughSuperpath");
    }
    // verify the required parameter 'submodelIdentifier' is set
    if (submodelIdentifier == null) {
      throw new ApiException(400, "Missing the required parameter 'submodelIdentifier' when calling getSubmodelDescriptorByIdThroughSuperpath");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/shell-descriptors/{aasIdentifier}/submodel-descriptors/{submodelIdentifier}"
        .replace("{aasIdentifier}", ApiClient.urlEncode(aasIdentifier.toString()))
        .replace("{submodelIdentifier}", ApiClient.urlEncode(submodelIdentifier.toString()));

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
   * Creates a new Asset Administration Shell Descriptor, i.e. registers an AAS
   * 
   * @param assetAdministrationShellDescriptor Asset Administration Shell Descriptor object (required)
   * @return AssetAdministrationShellDescriptor
   * @throws ApiException if fails to make API call
   */
  public AssetAdministrationShellDescriptor postAssetAdministrationShellDescriptor(AssetAdministrationShellDescriptor assetAdministrationShellDescriptor) throws ApiException {

    ApiResponse<AssetAdministrationShellDescriptor> localVarResponse = postAssetAdministrationShellDescriptorWithHttpInfo(assetAdministrationShellDescriptor);
    return localVarResponse.getData();
  }

  /**
   * Creates a new Asset Administration Shell Descriptor, i.e. registers an AAS
   * 
   * @param assetAdministrationShellDescriptor Asset Administration Shell Descriptor object (required)
   * @return ApiResponse&lt;AssetAdministrationShellDescriptor&gt;
   * @throws ApiException if fails to make API call
   */
 public ApiResponse<AssetAdministrationShellDescriptor> postAssetAdministrationShellDescriptorWithHttpInfo(AssetAdministrationShellDescriptor assetAdministrationShellDescriptor) throws ApiException {
  	return postAssetAdministrationShellDescriptorWithHttpInfoNoUrlEncoding(assetAdministrationShellDescriptor);
 	
 }


  /**
   * Creates a new Asset Administration Shell Descriptor, i.e. registers an AAS
   * 
   * @param assetAdministrationShellDescriptor Asset Administration Shell Descriptor object (required)
   * @return ApiResponse&lt;AssetAdministrationShellDescriptor&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<AssetAdministrationShellDescriptor> postAssetAdministrationShellDescriptorWithHttpInfoNoUrlEncoding(AssetAdministrationShellDescriptor assetAdministrationShellDescriptor) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = postAssetAdministrationShellDescriptorRequestBuilder(assetAdministrationShellDescriptor);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("postAssetAdministrationShellDescriptor", localVarResponse);
        }
        return new ApiResponse<AssetAdministrationShellDescriptor>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<AssetAdministrationShellDescriptor>() {}) // closes the InputStream
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

  private HttpRequest.Builder postAssetAdministrationShellDescriptorRequestBuilder(AssetAdministrationShellDescriptor assetAdministrationShellDescriptor) throws ApiException {
    // verify the required parameter 'assetAdministrationShellDescriptor' is set
    if (assetAdministrationShellDescriptor == null) {
      throw new ApiException(400, "Missing the required parameter 'assetAdministrationShellDescriptor' when calling postAssetAdministrationShellDescriptor");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/shell-descriptors";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(assetAdministrationShellDescriptor);
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
   * Creates a new Submodel Descriptor, i.e. registers a submodel
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param submodelDescriptor Submodel Descriptor object (required)
   * @return SubmodelDescriptor
   * @throws ApiException if fails to make API call
   */
  public SubmodelDescriptor postSubmodelDescriptorThroughSuperpath(String aasIdentifier, SubmodelDescriptor submodelDescriptor) throws ApiException {

    ApiResponse<SubmodelDescriptor> localVarResponse = postSubmodelDescriptorThroughSuperpathWithHttpInfo(aasIdentifier, submodelDescriptor);
    return localVarResponse.getData();
  }

  /**
   * Creates a new Submodel Descriptor, i.e. registers a submodel
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param submodelDescriptor Submodel Descriptor object (required)
   * @return ApiResponse&lt;SubmodelDescriptor&gt;
   * @throws ApiException if fails to make API call
   */
 public ApiResponse<SubmodelDescriptor> postSubmodelDescriptorThroughSuperpathWithHttpInfo(String aasIdentifier, SubmodelDescriptor submodelDescriptor) throws ApiException {
    String  aasIdentifierAsBytes = ApiClient.base64UrlEncode(aasIdentifier);
  	return postSubmodelDescriptorThroughSuperpathWithHttpInfoNoUrlEncoding(aasIdentifierAsBytes, submodelDescriptor);
 	
 }


  /**
   * Creates a new Submodel Descriptor, i.e. registers a submodel
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param submodelDescriptor Submodel Descriptor object (required)
   * @return ApiResponse&lt;SubmodelDescriptor&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<SubmodelDescriptor> postSubmodelDescriptorThroughSuperpathWithHttpInfoNoUrlEncoding(String aasIdentifier, SubmodelDescriptor submodelDescriptor) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = postSubmodelDescriptorThroughSuperpathRequestBuilder(aasIdentifier, submodelDescriptor);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("postSubmodelDescriptorThroughSuperpath", localVarResponse);
        }
        return new ApiResponse<SubmodelDescriptor>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<SubmodelDescriptor>() {}) // closes the InputStream
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

  private HttpRequest.Builder postSubmodelDescriptorThroughSuperpathRequestBuilder(String aasIdentifier, SubmodelDescriptor submodelDescriptor) throws ApiException {
    // verify the required parameter 'aasIdentifier' is set
    if (aasIdentifier == null) {
      throw new ApiException(400, "Missing the required parameter 'aasIdentifier' when calling postSubmodelDescriptorThroughSuperpath");
    }
    // verify the required parameter 'submodelDescriptor' is set
    if (submodelDescriptor == null) {
      throw new ApiException(400, "Missing the required parameter 'submodelDescriptor' when calling postSubmodelDescriptorThroughSuperpath");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/shell-descriptors/{aasIdentifier}/submodel-descriptors"
        .replace("{aasIdentifier}", ApiClient.urlEncode(aasIdentifier.toString()));

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(submodelDescriptor);
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
   * Updates an existing Asset Administration Shell Descriptor
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param assetAdministrationShellDescriptor Asset Administration Shell Descriptor object (required)
   * @throws ApiException if fails to make API call
   */
  public void putAssetAdministrationShellDescriptorById(String aasIdentifier, AssetAdministrationShellDescriptor assetAdministrationShellDescriptor) throws ApiException {

    putAssetAdministrationShellDescriptorByIdWithHttpInfo(aasIdentifier, assetAdministrationShellDescriptor);
  }

  /**
   * Updates an existing Asset Administration Shell Descriptor
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param assetAdministrationShellDescriptor Asset Administration Shell Descriptor object (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
 public ApiResponse<Void> putAssetAdministrationShellDescriptorByIdWithHttpInfo(String aasIdentifier, AssetAdministrationShellDescriptor assetAdministrationShellDescriptor) throws ApiException {
    String  aasIdentifierAsBytes = ApiClient.base64UrlEncode(aasIdentifier);
  	return putAssetAdministrationShellDescriptorByIdWithHttpInfoNoUrlEncoding(aasIdentifierAsBytes, assetAdministrationShellDescriptor);
 	
 }


  /**
   * Updates an existing Asset Administration Shell Descriptor
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param assetAdministrationShellDescriptor Asset Administration Shell Descriptor object (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> putAssetAdministrationShellDescriptorByIdWithHttpInfoNoUrlEncoding(String aasIdentifier, AssetAdministrationShellDescriptor assetAdministrationShellDescriptor) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = putAssetAdministrationShellDescriptorByIdRequestBuilder(aasIdentifier, assetAdministrationShellDescriptor);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("putAssetAdministrationShellDescriptorById", localVarResponse);
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

  private HttpRequest.Builder putAssetAdministrationShellDescriptorByIdRequestBuilder(String aasIdentifier, AssetAdministrationShellDescriptor assetAdministrationShellDescriptor) throws ApiException {
    // verify the required parameter 'aasIdentifier' is set
    if (aasIdentifier == null) {
      throw new ApiException(400, "Missing the required parameter 'aasIdentifier' when calling putAssetAdministrationShellDescriptorById");
    }
    // verify the required parameter 'assetAdministrationShellDescriptor' is set
    if (assetAdministrationShellDescriptor == null) {
      throw new ApiException(400, "Missing the required parameter 'assetAdministrationShellDescriptor' when calling putAssetAdministrationShellDescriptorById");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/shell-descriptors/{aasIdentifier}"
        .replace("{aasIdentifier}", ApiClient.urlEncode(aasIdentifier.toString()));

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(assetAdministrationShellDescriptor);
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
  /**
   * Updates an existing Submodel Descriptor
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param submodelDescriptor Submodel Descriptor object (required)
   * @throws ApiException if fails to make API call
   */
  public void putSubmodelDescriptorByIdThroughSuperpath(String aasIdentifier, String submodelIdentifier, SubmodelDescriptor submodelDescriptor) throws ApiException {

    putSubmodelDescriptorByIdThroughSuperpathWithHttpInfo(aasIdentifier, submodelIdentifier, submodelDescriptor);
  }

  /**
   * Updates an existing Submodel Descriptor
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param submodelDescriptor Submodel Descriptor object (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
 public ApiResponse<Void> putSubmodelDescriptorByIdThroughSuperpathWithHttpInfo(String aasIdentifier, String submodelIdentifier, SubmodelDescriptor submodelDescriptor) throws ApiException {
    String  aasIdentifierAsBytes = ApiClient.base64UrlEncode(aasIdentifier);
    String  submodelIdentifierAsBytes = ApiClient.base64UrlEncode(submodelIdentifier);
  	return putSubmodelDescriptorByIdThroughSuperpathWithHttpInfoNoUrlEncoding(aasIdentifierAsBytes, submodelIdentifierAsBytes, submodelDescriptor);
 	
 }


  /**
   * Updates an existing Submodel Descriptor
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param submodelDescriptor Submodel Descriptor object (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> putSubmodelDescriptorByIdThroughSuperpathWithHttpInfoNoUrlEncoding(String aasIdentifier, String submodelIdentifier, SubmodelDescriptor submodelDescriptor) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = putSubmodelDescriptorByIdThroughSuperpathRequestBuilder(aasIdentifier, submodelIdentifier, submodelDescriptor);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("putSubmodelDescriptorByIdThroughSuperpath", localVarResponse);
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

  private HttpRequest.Builder putSubmodelDescriptorByIdThroughSuperpathRequestBuilder(String aasIdentifier, String submodelIdentifier, SubmodelDescriptor submodelDescriptor) throws ApiException {
    // verify the required parameter 'aasIdentifier' is set
    if (aasIdentifier == null) {
      throw new ApiException(400, "Missing the required parameter 'aasIdentifier' when calling putSubmodelDescriptorByIdThroughSuperpath");
    }
    // verify the required parameter 'submodelIdentifier' is set
    if (submodelIdentifier == null) {
      throw new ApiException(400, "Missing the required parameter 'submodelIdentifier' when calling putSubmodelDescriptorByIdThroughSuperpath");
    }
    // verify the required parameter 'submodelDescriptor' is set
    if (submodelDescriptor == null) {
      throw new ApiException(400, "Missing the required parameter 'submodelDescriptor' when calling putSubmodelDescriptorByIdThroughSuperpath");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/shell-descriptors/{aasIdentifier}/submodel-descriptors/{submodelIdentifier}"
        .replace("{aasIdentifier}", ApiClient.urlEncode(aasIdentifier.toString()))
        .replace("{submodelIdentifier}", ApiClient.urlEncode(submodelIdentifier.toString()));

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(submodelDescriptor);
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
  /**
   * 
   * 
   * @param shellDescriptorSearchRequest  (required)
   * @return ShellDescriptorSearchResponse
   * @throws ApiException if fails to make API call
   */
  public ShellDescriptorSearchResponse searchShellDescriptors(ShellDescriptorSearchRequest shellDescriptorSearchRequest) throws ApiException {

    ApiResponse<ShellDescriptorSearchResponse> localVarResponse = searchShellDescriptorsWithHttpInfo(shellDescriptorSearchRequest);
    return localVarResponse.getData();
  }

  /**
   * 
   * 
   * @param shellDescriptorSearchRequest  (required)
   * @return ApiResponse&lt;ShellDescriptorSearchResponse&gt;
   * @throws ApiException if fails to make API call
   */
 public ApiResponse<ShellDescriptorSearchResponse> searchShellDescriptorsWithHttpInfo(ShellDescriptorSearchRequest shellDescriptorSearchRequest) throws ApiException {
  	return searchShellDescriptorsWithHttpInfoNoUrlEncoding(shellDescriptorSearchRequest);
 	
 }


  /**
   * 
   * 
   * @param shellDescriptorSearchRequest  (required)
   * @return ApiResponse&lt;ShellDescriptorSearchResponse&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<ShellDescriptorSearchResponse> searchShellDescriptorsWithHttpInfoNoUrlEncoding(ShellDescriptorSearchRequest shellDescriptorSearchRequest) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = searchShellDescriptorsRequestBuilder(shellDescriptorSearchRequest);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("searchShellDescriptors", localVarResponse);
        }
        return new ApiResponse<ShellDescriptorSearchResponse>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<ShellDescriptorSearchResponse>() {}) // closes the InputStream
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

  private HttpRequest.Builder searchShellDescriptorsRequestBuilder(ShellDescriptorSearchRequest shellDescriptorSearchRequest) throws ApiException {
    // verify the required parameter 'shellDescriptorSearchRequest' is set
    if (shellDescriptorSearchRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'shellDescriptorSearchRequest' when calling searchShellDescriptors");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/search";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(shellDescriptorSearchRequest);
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
  
}
