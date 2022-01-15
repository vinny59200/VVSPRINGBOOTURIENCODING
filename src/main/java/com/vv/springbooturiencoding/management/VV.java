package com.vv.springbooturiencoding.management;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Jacksonized //missing
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VV {

    private String name;
    private int age;
    private int count;

}

