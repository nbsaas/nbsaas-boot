package com.nbsaas.boot.rest.response;

import com.nbsaas.boot.rest.enums.ResponseType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

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

}
