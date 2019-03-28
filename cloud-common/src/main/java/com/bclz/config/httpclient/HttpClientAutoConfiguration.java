package com.bclz.config.httpclient;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;


@EnableConfigurationProperties(value = HttpClientProperties.class)
@ConditionalOnClass(value = HttpClient.class)
public class HttpClientAutoConfiguration {


    private HttpClientProperties httpClientProperties;


    @Bean
    @ConditionalOnMissingBean(value = HttpClient.class)
    public HttpClient httpClient() {
        RequestConfig reConfig = RequestConfig.custom().setConnectTimeout(httpClientProperties.getConnectTimeout()).setSocketTimeout(httpClientProperties.getSocketTimeout())
                .setConnectionRequestTimeout(httpClientProperties.getConnectionRequestTimeout()).build();


        HttpClient h = HttpClientBuilder.create().setDefaultRequestConfig(reConfig).setMaxConnPerRoute(httpClientProperties.getMaxConnPerRoute())
                .setMaxConnTotal(httpClientProperties.getMaxConnTotal()).build();
        return h;

    }


}
