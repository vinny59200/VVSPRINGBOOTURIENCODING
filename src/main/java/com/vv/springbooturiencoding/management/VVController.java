package com.vv.springbooturiencoding.management;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("vv")
@AllArgsConstructor
@RestController
public class VVController {

    @Autowired
    private VVService VVService;



    @GetMapping("{_id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public Mono<VV> getById(@PathVariable("_id") final String id) {
        System.out.println("ex: http://localhost:8080/vv/fares☀️2latess");
        System.out.println("will return an age and a count:");
        System.out.println("{'name':'fares☀️2latess','age':0,'count':0}");
        return VVService.findById(id);
    }



}
