package com.vv.springbooturiencoding.management;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URISyntaxException;

public class VVServiceImpl extends VVService {
    public Mono<VV> findById(String id) {

        WebClient webClient = WebClient.builder().filters(exchangeFilterFunctions -> {
            exchangeFilterFunctions.add(logRequest());
            exchangeFilterFunctions.add(logResponse());
        }).build();


            return webClient.get().uri("https://api.agify.io/?name=" + id).retrieve().bodyToMono(VV.class);


    }

    ExchangeFilterFunction logRequest() {
        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {

            StringBuilder sb = new StringBuilder("Request: \n");
            //append clientRequest method and url
            sb.append(clientRequest.method()).append(" ").append(clientRequest.url());
            sb.append("\n");
            clientRequest.headers().forEach((key, value) -> {
                sb.append(key).append(": ").append(value).append("\n");
            });
            System.out.println(sb.toString());

            return Mono.just(clientRequest);
        });
    }

    ExchangeFilterFunction logResponse() {
        return ExchangeFilterFunction.ofResponseProcessor(response -> {

            StringBuilder sb = new StringBuilder("Response: \n");
            //append clientRequest method and url
            sb.append(response.statusCode()).append(" ").append(response.statusCode().getReasonPhrase()).append("\n");
            sb.append(response.headers().asHttpHeaders());
            System.out.println(sb.toString());

            return Mono.just(response);
        });
    }
}
