package com.nbsaas.boot.generator.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ComponentSimple {

    /**
     * 名称
     */
    private String name;

    /**
     * js路径
     */
    private String  model;
}
