package org.cie.controller;

import com.alibaba.fastjson.JSON;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.cie.util.PropertiesUtil;

import java.io.IOException;

public abstract class BaseController {
    public <T> String sendPostJson(String action, T model) throws IOException {
        String url = new PropertiesUtil().getProperty("url");
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        ResponseHandler<String> responseHandler = new BasicResponseHandler();

        String JSONString = JSON.toJSONString(model);
        System.out.println("sent  to:" + url + action + " message:" + JSONString);
        HttpPost httpPost = new HttpPost(url + action);
        StringEntity requestEntity = new StringEntity(JSONString, "utf-8");
        requestEntity.setContentEncoding("UTF-8");
        httpPost.setHeader("Content-type", "application/json");
        httpPost.setEntity(requestEntity);
        return httpClient.execute(httpPost, responseHandler);
    }
}
