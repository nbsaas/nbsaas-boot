package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.entity.system.Sequence;
import com.nbsaas.boot.system.api.domain.response.SequenceResponse;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;

/**
* 实体对象转化成响应对象
*/

public class SequenceResponseConvert  implements Converter
<SequenceResponse,Sequence  > {
@Override
public SequenceResponse convert(Sequence source) {
SequenceResponse  result = new  SequenceResponse();
BeanDataUtils.copyProperties(source, result);
return result;
}
}

