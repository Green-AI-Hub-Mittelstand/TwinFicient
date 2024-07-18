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

import org.eclipse.digitaltwin.basyx.v3.clients.model.PagedResultOrStringItems;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.Result;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.ServiceDescription;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.SpecificAssetId;

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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-06T16:51:10.510101800+01:00[Europe/Berlin]")
public class AssetAdministrationShellBasicDiscoveryApi {
  private final HttpClient memberVarHttpClient;
  private final ObjectMapper memberVarObjectMapper;
  private final String memberVarBaseUri;
  private final Consumer<HttpRequest.Builder> memberVarInterceptor;
  private final Duration memberVarReadTimeout;
  private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;
  private final Consumer<HttpResponse<String>> memberVarAsyncResponseInterceptor;

  public AssetAdministrationShellBasicDiscoveryApi() {
    this(new ApiClient());
  }

  public AssetAdministrationShellBasicDiscoveryApi(ObjectMapper mapper, String baseUri) {
    this(new ApiClient(HttpClient.newBuilder(), mapper, baseUri));
  }
  
  public AssetAdministrationShellBasicDiscoveryApi(String baseUri) {
    this(new ApiClient(HttpClient.newBuilder(), JSON.getDefault().getMapper(), baseUri));
  }


  public AssetAdministrationShellBasicDiscoveryApi(ApiClient apiClient) {
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
   * Deletes all specific Asset identifiers linked to an Asset Administration Shell to edit discoverable content
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteAllAssetLinksById(String aasIdentifier) throws ApiException {

    deleteAllAssetLinksByIdWithHttpInfo(aasIdentifier);
  }

  /**
   * Deletes all specific Asset identifiers linked to an Asset Administration Shell to edit discoverable content
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
 public ApiResponse<Void> deleteAllAssetLinksByIdWithHttpInfo(String aasIdentifier) throws ApiException {
    String  aasIdentifierAsBytes = ApiClient.base64UrlEncode(aasIdentifier);
  	return deleteAllAssetLinksByIdWithHttpInfoNoUrlEncoding(aasIdentifierAsBytes);
 	
 }


  /**
   * Deletes all specific Asset identifiers linked to an Asset Administration Shell to edit discoverable content
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> deleteAllAssetLinksByIdWithHttpInfoNoUrlEncoding(String aasIdentifier) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = deleteAllAssetLinksByIdRequestBuilder(aasIdentifier);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("deleteAllAssetLinksById", localVarResponse);
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

  private HttpRequest.Builder deleteAllAssetLinksByIdRequestBuilder(String aasIdentifier) throws ApiException {
    // verify the required parameter 'aasIdentifier' is set
    if (aasIdentifier == null) {
      throw new ApiException(400, "Missing the required parameter 'aasIdentifier' when calling deleteAllAssetLinksById");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/lookup/shells/{aasIdentifier}"
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
   * Returns a list of Asset Administration Shell ids linked to specific Asset identifiers
   * 
   * @param assetIds A list of specific Asset identifiers. Each Asset identifier is a base64-url-encoded [SpecificAssetId](./model-part1.yaml#/components/schemas/SpecificAssetId) (optional
   * @param limit The maximum number of elements in the response array (optional)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @return PagedResultOrStringItems
   * @throws ApiException if fails to make API call
   */
  public PagedResultOrStringItems getAllAssetAdministrationShellIdsByAssetLink(List<String> assetIds, Integer limit, String cursor) throws ApiException {

    ApiResponse<PagedResultOrStringItems> localVarResponse = getAllAssetAdministrationShellIdsByAssetLinkWithHttpInfo(assetIds, limit, cursor);
    return localVarResponse.getData();
  }

  /**
   * Returns a list of Asset Administration Shell ids linked to specific Asset identifiers
   * 
   * @param assetIds A list of specific Asset identifiers. Each Asset identifier is a base64-url-encoded [SpecificAssetId](./model-part1.yaml#/components/schemas/SpecificAssetId) (optional
   * @param limit The maximum number of elements in the response array (optional)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @return ApiResponse&lt;PagedResultOrStringItems&gt;
   * @throws ApiException if fails to make API call
   */
 public ApiResponse<PagedResultOrStringItems> getAllAssetAdministrationShellIdsByAssetLinkWithHttpInfo(List<String> assetIds, Integer limit, String cursor) throws ApiException {
    List<String>  assetIdsAsBytes = ApiClient.base64UrlEncode(assetIds);
  	return getAllAssetAdministrationShellIdsByAssetLinkWithHttpInfoNoUrlEncoding(assetIdsAsBytes, limit, cursor);
 	
 }


  /**
   * Returns a list of Asset Administration Shell ids linked to specific Asset identifiers
   * 
   * @param assetIds A list of specific Asset identifiers. Each Asset identifier is a base64-url-encoded [SpecificAssetId](./model-part1.yaml#/components/schemas/SpecificAssetId) (optional
   * @param limit The maximum number of elements in the response array (optional)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @return ApiResponse&lt;PagedResultOrStringItems&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<PagedResultOrStringItems> getAllAssetAdministrationShellIdsByAssetLinkWithHttpInfoNoUrlEncoding(List<String> assetIds, Integer limit, String cursor) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getAllAssetAdministrationShellIdsByAssetLinkRequestBuilder(assetIds, limit, cursor);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getAllAssetAdministrationShellIdsByAssetLink", localVarResponse);
        }
        return new ApiResponse<PagedResultOrStringItems>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<PagedResultOrStringItems>() {}) // closes the InputStream
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

  private HttpRequest.Builder getAllAssetAdministrationShellIdsByAssetLinkRequestBuilder(List<String> assetIds, Integer limit, String cursor) throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/lookup/shells";

    List<Pair> localVarQueryParams = new ArrayList<>();
    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    localVarQueryParameterBaseName = "assetIds";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("multi", "assetIds", assetIds));
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
   * Returns a list of specific Asset identifiers based on an Asset Administration Shell id to edit discoverable content
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @return List&lt;SpecificAssetId&gt;
   * @throws ApiException if fails to make API call
   */
  public List<SpecificAssetId> getAllAssetLinksById(String aasIdentifier) throws ApiException {

    ApiResponse<List<SpecificAssetId>> localVarResponse = getAllAssetLinksByIdWithHttpInfo(aasIdentifier);
    return localVarResponse.getData();
  }

  /**
   * Returns a list of specific Asset identifiers based on an Asset Administration Shell id to edit discoverable content
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @return ApiResponse&lt;List&lt;SpecificAssetId&gt;&gt;
   * @throws ApiException if fails to make API call
   */
 public ApiResponse<List<SpecificAssetId>> getAllAssetLinksByIdWithHttpInfo(String aasIdentifier) throws ApiException {
    String  aasIdentifierAsBytes = ApiClient.base64UrlEncode(aasIdentifier);
  	return getAllAssetLinksByIdWithHttpInfoNoUrlEncoding(aasIdentifierAsBytes);
 	
 }


  /**
   * Returns a list of specific Asset identifiers based on an Asset Administration Shell id to edit discoverable content
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @return ApiResponse&lt;List&lt;SpecificAssetId&gt;&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<List<SpecificAssetId>> getAllAssetLinksByIdWithHttpInfoNoUrlEncoding(String aasIdentifier) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getAllAssetLinksByIdRequestBuilder(aasIdentifier);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getAllAssetLinksById", localVarResponse);
        }
        return new ApiResponse<List<SpecificAssetId>>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<List<SpecificAssetId>>() {}) // closes the InputStream
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

  private HttpRequest.Builder getAllAssetLinksByIdRequestBuilder(String aasIdentifier) throws ApiException {
    // verify the required parameter 'aasIdentifier' is set
    if (aasIdentifier == null) {
      throw new ApiException(400, "Missing the required parameter 'aasIdentifier' when calling getAllAssetLinksById");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/lookup/shells/{aasIdentifier}"
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
   * Creates specific Asset identifiers linked to an Asset Administration Shell to edit discoverable content
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param specificAssetId A list of specific Asset identifiers (required)
   * @return List&lt;SpecificAssetId&gt;
   * @throws ApiException if fails to make API call
   */
  public List<SpecificAssetId> postAllAssetLinksById(String aasIdentifier, List<SpecificAssetId> specificAssetId) throws ApiException {

    ApiResponse<List<SpecificAssetId>> localVarResponse = postAllAssetLinksByIdWithHttpInfo(aasIdentifier, specificAssetId);
    return localVarResponse.getData();
  }

  /**
   * Creates specific Asset identifiers linked to an Asset Administration Shell to edit discoverable content
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param specificAssetId A list of specific Asset identifiers (required)
   * @return ApiResponse&lt;List&lt;SpecificAssetId&gt;&gt;
   * @throws ApiException if fails to make API call
   */
 public ApiResponse<List<SpecificAssetId>> postAllAssetLinksByIdWithHttpInfo(String aasIdentifier, List<SpecificAssetId> specificAssetId) throws ApiException {
    String  aasIdentifierAsBytes = ApiClient.base64UrlEncode(aasIdentifier);
  	return postAllAssetLinksByIdWithHttpInfoNoUrlEncoding(aasIdentifierAsBytes, specificAssetId);
 	
 }


  /**
   * Creates specific Asset identifiers linked to an Asset Administration Shell to edit discoverable content
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param specificAssetId A list of specific Asset identifiers (required)
   * @return ApiResponse&lt;List&lt;SpecificAssetId&gt;&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<List<SpecificAssetId>> postAllAssetLinksByIdWithHttpInfoNoUrlEncoding(String aasIdentifier, List<SpecificAssetId> specificAssetId) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = postAllAssetLinksByIdRequestBuilder(aasIdentifier, specificAssetId);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("postAllAssetLinksById", localVarResponse);
        }
        return new ApiResponse<List<SpecificAssetId>>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<List<SpecificAssetId>>() {}) // closes the InputStream
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

  private HttpRequest.Builder postAllAssetLinksByIdRequestBuilder(String aasIdentifier, List<SpecificAssetId> specificAssetId) throws ApiException {
    // verify the required parameter 'aasIdentifier' is set
    if (aasIdentifier == null) {
      throw new ApiException(400, "Missing the required parameter 'aasIdentifier' when calling postAllAssetLinksById");
    }
    // verify the required parameter 'specificAssetId' is set
    if (specificAssetId == null) {
      throw new ApiException(400, "Missing the required parameter 'specificAssetId' when calling postAllAssetLinksById");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/lookup/shells/{aasIdentifier}"
        .replace("{aasIdentifier}", ApiClient.urlEncode(aasIdentifier.toString()));

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(specificAssetId);
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
