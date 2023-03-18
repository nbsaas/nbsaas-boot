package com.nbsaas.boot.generator.beans;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UniqueBean implements Serializable {

    private String message;

    private String key;
}
