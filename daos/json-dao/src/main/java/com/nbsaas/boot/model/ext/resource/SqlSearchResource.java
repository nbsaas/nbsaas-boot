package com.nbsaas.boot.model.ext.resource;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nbsaas.boot.model.data.mapper.ModelMapper;
import com.nbsaas.boot.model.ext.apis.SqlSearchApi;
import com.nbsaas.boot.model.ext.domain.request.SqlObject;
import com.nbsaas.boot.mp.utils.QueryWrapperUtils;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.MapResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;

public class SqlSearchResource implements SqlSearchApi {

    private final ModelMapper modelMapper;

    public SqlSearchResource(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public PageResponse<MapResponse> search(SqlObject searchObject) {
        Page<MapResponse> page = new Page<>(searchObject.getPage(), searchObject.getSize());
        Page<MapResponse> res = modelMapper.page(page, searchObject.getSql());
        return QueryWrapperUtils.handle(res);
    }

    @Override
    public ListResponse<MapResponse> list(SqlObject searchObject) {
        ListResponse<MapResponse> result=new  ListResponse<>();
        result.setData(modelMapper.list(searchObject.getSql()));
        return result;
    }

    @Override
    public ResponseObject<Integer> executeSql(SqlObject searchObject) {
        ResponseObject<Integer> result=new  ResponseObject<>();
        result.setData(modelMapper.executeSql(searchObject.getSql()));
        return result;
    }

    @Override
    public ResponseObject<MapResponse>  selectOne(SqlObject searchObject) {
        ResponseObject<MapResponse> result=new  ResponseObject<>();
        result.setData(modelMapper.selectResponse(searchObject.getSql()));
        return result;
    }
}
