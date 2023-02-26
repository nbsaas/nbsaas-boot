package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.entity.user.UserAccessLog;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.user.api.domain.response.UserAccessLogResponse;

/**
 * 实体对象转化成响应对象
 */

public class UserAccessLogResponseConvert implements Converter
        <UserAccessLogResponse, UserAccessLog> {
    @Override
    public UserAccessLogResponse convert(UserAccessLog source) {
        UserAccessLogResponse result = new UserAccessLogResponse();
        BeanDataUtils.copyProperties(source, result);
        if (source.getCreator() != null) {
            result.setCreator(source.getCreator().getId());
        }
        if (source.getCreator() != null) {
            result.setCreatorName(source.getCreator().getName());
        }
        return result;
    }
}

