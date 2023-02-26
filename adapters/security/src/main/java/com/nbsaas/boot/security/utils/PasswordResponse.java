package com.nbsaas.boot.security.utils;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PasswordResponse {

    private String password;

    private String salt;
}
