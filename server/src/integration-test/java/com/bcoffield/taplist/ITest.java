package com.bcoffield.taplist;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Before;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class ITest {

    private static HttpClient client;
    private Gson gson;

    @Before
    public void iTestBefore() {
        clearDatabase();
    }

    private void clearDatabase() {
        System.err.println("TODO: clear database!");
    }

    protected String getEndpoint(Class<?> clazz) throws Exception {
        RequestMapping annotation = clazz.getDeclaredAnnotation(RequestMapping.class);
        if (annotation == null) {
            throw new Exception("Class " + clazz.getName() + " does not have @RequestMapping");
        }
        String[] values = annotation.value();
        if (values.length == 0 || values[0] == null) {
            throw new Exception("@RequestMapping for class " + clazz.getName() + " needs a value");
        }
        return values[0];
    }

    protected <T> T makeGetRequest(Class<?> controllerClass, String path, Class<T> returnClass, Map<String, String> queryParams) throws Exception {
        String uri = getUri(getEndpoint(controllerClass), path, queryParams);
        HttpGet request = new HttpGet(uri);
        return makeRequest(request, returnClass);
    }

    protected <T> T makePostRequest(Class<?> controllerClass, String path, Class<T> returnClass, Object requestBody) throws Exception {
        String uri = getUri(getEndpoint(controllerClass), path, null);
        HttpPost request = new HttpPost(uri);
        String stringRequestBody = getGson().toJson(requestBody);
        request.setEntity(new StringEntity(stringRequestBody));
        request.setHeader("Content-Type", "application/json");
        return makeRequest(request, returnClass);
    }

    private <T> T makeRequest(HttpRequestBase request, Class<T> returnClass) throws Exception {
        request.setHeader("Accept", "application/json");
        HttpResponse response = getClient().execute(request);
        String stringBody = EntityUtils.toString(response.getEntity());
        System.out.println(stringBody);
        return getGson().fromJson(stringBody, returnClass);
    }

    private Gson getGson() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }

    private String getUri(String endpoint, String path, Map<String, String> queryParams) throws UnsupportedEncodingException {
        // TODO: so much laziness. Need to lookup at least port.
        String uri = "http://localhost:8080/taplist/" + endpoint;
        if (path != null) {
            if (!path.startsWith("/")) {
                uri += "/";
            }
            uri += path;
        }

        if (queryParams != null) {
            uri += "?";
            for (Map.Entry<String, String> entry : queryParams.entrySet()) {
                String encodedValue = URLEncoder.encode(entry.getValue(), "UTF-8");
                uri += entry.getKey() + "=" + encodedValue + "&";
            }
        }
        return uri;
    }

    public static HttpClient getClient() {
        if (client == null) {
            client = HttpClients.createDefault();
        }
        return client;
    }
}
