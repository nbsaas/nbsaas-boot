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
import com.nbsaas.boot.rest.request.SortField;
import com.nbsaas.boot.rest.response.PageResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class JpaSearchHelper<Entity> {

    private final JpaRepositoryImplementation<Entity, Serializable> repository;

    public JpaSearchHelper(JpaRepositoryImplementation<Entity, Serializable> repository) {
        this.repository = repository;
    }



    public <Simple> PageResponse<Simple> search(PageRequest request, Function<Entity,Simple> convert) {
        PageResponse<Simple> result = new PageResponse<>();
        SpecificationData<Entity> data = new SpecificationData<>(request);
        Pageable pageable = org.springframework.data.domain.PageRequest.of(request.getNo() - 1, request.getSize());
        if (StringUtils.hasText(request.getSortField())){
            pageable = org.springframework.data.domain.PageRequest.of(request.getNo() - 1, request.getSize(),getSortData(request));
        }

        if (request.getSorts()!=null){
            for (SortField sort : request.getSorts()) {
                if ("asc".equals(sort.getField())){
                    pageable.getSort().and(Sort.by(sort.getField()).ascending());
                }else{
                    pageable.getSort().and(Sort.by(sort.getField()).descending());
                }
            }
        }

        Page<Entity> res = repository.findAll(data, pageable);
        if (!res.getContent().isEmpty()) {
            List<Simple> list = res.getContent().stream().map(convert).collect(toList());
            result.setData(list);
        }
        result.setSize(res.getSize());
        result.setNo(res.getNumber());
        result.setTotal(res.getTotalElements());
        result.setTotalPage(res.getTotalPages());
        return result;
    }

    public static Sort getSortData(PageRequest request) {
        Sort sort;
        if ("asc".equals(request.getSortMethod())){
            sort=Sort.by(Sort.Direction.ASC, request.getSortField());
        }else{
            sort=Sort.by(Sort.Direction.DESC, request.getSortField());
        }
        return sort;
    }

}
