package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.entity.system.Application;
import com.nbsaas.boot.entity.system.ApplicationMenu;
import com.nbsaas.boot.hibernate.data.entity.User;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.system.api.domain.request.ApplicationMenuDataRequest;

/**
 * 请求对象转换成实体对象
 */

public class ApplicationMenuEntityConvert implements Converter<ApplicationMenu, ApplicationMenuDataRequest> {
    @Override
    public ApplicationMenu convert(ApplicationMenuDataRequest source) {
        ApplicationMenu result = new ApplicationMenu();
        BeanDataUtils.copyProperties(source, result);
        if (source.getParent() != null) {
            ApplicationMenu parent = new ApplicationMenu();
            parent.setId(source.getParent());
            result.setParent(parent);
        }
        if (source.getApp() != null) {
            Application app = new Application();
            app.setId(source.getApp());
            result.setApp(app);
        }
        if (source.getCreator() != null) {
            User creator = new User();
            creator.setId(source.getCreator());
            result.setCreator(creator);
        }
        return result;
    }
}

