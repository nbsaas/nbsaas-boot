package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.entity.system.Menu;
import com.nbsaas.boot.system.api.domain.response.MenuResponse;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;

/**
* 实体对象转化成响应对象
*/

public class MenuResponseConvert  implements Converter
<MenuResponse,Menu  > {
@Override
public MenuResponse convert(Menu source) {
MenuResponse  result = new  MenuResponse();
BeanDataUtils.copyProperties(source, result);
return result;
}
}

