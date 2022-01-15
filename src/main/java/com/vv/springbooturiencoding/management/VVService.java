package com.vv.springbooturiencoding.management;


import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
public class VVService {

    public Mono<VV> findById(String id) {
        return new VVServiceImpl().findById(id);
    }

}