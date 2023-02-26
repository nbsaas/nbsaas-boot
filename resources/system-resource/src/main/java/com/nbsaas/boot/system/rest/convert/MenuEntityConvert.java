package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.entity.system.Menu;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.system.api.domain.request.MenuDataRequest;

/**
 * 请求对象转换成实体对象
 */

public class MenuEntityConvert implements Converter<Menu, MenuDataRequest> {
    @Override
    public Menu convert(MenuDataRequest source) {
        Menu result = new Menu();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}

