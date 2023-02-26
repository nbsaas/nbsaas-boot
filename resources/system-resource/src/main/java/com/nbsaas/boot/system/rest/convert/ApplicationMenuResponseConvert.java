package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.entity.system.ApplicationMenu;
import com.nbsaas.boot.system.api.domain.response.ApplicationMenuResponse;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;

/**
* 实体对象转化成响应对象
*/

public class ApplicationMenuResponseConvert  implements Converter
<ApplicationMenuResponse,ApplicationMenu  > {
@Override
public ApplicationMenuResponse convert(ApplicationMenu source) {
ApplicationMenuResponse  result = new  ApplicationMenuResponse();
BeanDataUtils.copyProperties(source, result);
            if(source.getApp()!=null){
            result.setAppName(source.getApp().getName());
            }
            if(source.getParent()!=null){
            result.setParent(source.getParent().getId());
            }
            if(source.getApp()!=null){
            result.setApp(source.getApp().getId());
            }
            if(source.getCreator()!=null){
            result.setCreatorName(source.getCreator().getName());
            }
            if(source.getCreator()!=null){
            result.setCreator(source.getCreator().getId());
            }
return result;
}
}

