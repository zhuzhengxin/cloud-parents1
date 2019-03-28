package com.bclz.config.httpclient;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.httpclient")
@Data
public class HttpClientProperties {


    private  int connectTimeout=1000;

    private  int socketTimeout=10000;

    private  int connectionRequestTimeout=10000;

    private  int maxConnPerRoute=10;

    private  int maxConnTotal=50;
}
