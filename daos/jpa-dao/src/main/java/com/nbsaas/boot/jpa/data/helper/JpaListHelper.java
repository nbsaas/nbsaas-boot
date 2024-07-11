/*
 *
 *  * 版权声明和许可协议
 *  *
 *  * 版权所有 (c) 2023 纽百特®
 *  * 版权所有，保留所有权利
 *  *
 *  * 本软件使用 MIT 许可协议进行许可，详情请参阅：
 *  *
 *  *   https://opensource.org/licenses/MIT
 *  *
 *  * 更多信息，请访问我们的网站：
 *  *
 *  *   http://www.nbsaas.com
 *  *
 *  * 纽百特® 是西安纽百特科技有限责任公司的注册商标，未经授权不得使用。
 *
 */

package com.nbsaas.boot.jpa.data.helper;

import com.nbsaas.boot.jpa.data.core.SpecificationData;
import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.rest.response.ListResponse;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class JpaListHelper<Entity> {

    private final JpaRepositoryImplementation<Entity, Serializable> repository;

    public JpaListHelper(JpaRepositoryImplementation<Entity, Serializable> repository) {
        this.repository = repository;
    }


    public <Simple> ListResponse<Simple> list(PageRequest request, Function<Entity,Simple> convert) {
        ListResponse<Simple> result = new ListResponse<>();
        SpecificationData<Entity> spec = new SpecificationData<>(request);
        List<Entity> res;
        if (StringUtils.hasText(request.getSortField())){
            res =repository.findAll(spec,JpaSearchHelper.getSortData(request));
        }else{
            res = repository.findAll(spec);
        }

        if (res != null && !res.isEmpty()) {
            List<Simple> list = res.stream().map(convert).collect(toList());
            result.setData(list);
        }
        return result;
    }


}
