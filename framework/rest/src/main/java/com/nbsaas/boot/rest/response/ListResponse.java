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

package com.nbsaas.boot.rest.response;


import com.nbsaas.boot.rest.enums.ResponseType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @param <T>
 * @author ada
 */

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode()
public class ListResponse<T> extends ResponseObject<List<T>> {

    public ListResponse() {
        this.responseType = ResponseType.list;
    }



    public Stream<T> stream() {
        if (this.getData() == null) {
            this.setData(new ArrayList<>());
        }
        return this.getData().stream();
    }

    public void forEach(Consumer<? super T> action) {
        if (this.getData() == null) {
            this.setData(new ArrayList<>());
        }
        this.getData().forEach(action);
    }

    public Iterator<T> iterator() {
        if (this.getData() == null) {
            this.setData(new ArrayList<>());
        }
        return this.getData().iterator();
    }

    public <D> ListResponse<D> map(Function<T, D> function) {
        ListResponse<D> result = new ListResponse<>();
        List<D> list = this.stream().map(function).collect(Collectors.toList());
        result.setData(list);
        return result;
    }

    public <D extends T>  ListResponse<T>  mapSelf(Function<T, D> function) {
        List<D> list = this.stream().map(function).collect(Collectors.toList());
        this.getData().clear();
        this.getData().addAll(list);
        return this;
    }

}
