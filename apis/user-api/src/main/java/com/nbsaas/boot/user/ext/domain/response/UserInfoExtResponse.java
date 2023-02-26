package com.nbsaas.boot.user.ext.domain.response;

import com.nbsaas.boot.user.api.domain.response.UserInfoResponse;
import lombok.Data;


@Data
public class UserInfoExtResponse extends UserInfoResponse {

    private String sessionId;
}
