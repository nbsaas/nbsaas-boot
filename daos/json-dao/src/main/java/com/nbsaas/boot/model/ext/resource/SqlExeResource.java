package com.nbsaas.boot.model.ext.resource;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nbsaas.boot.model.data.mapper.SqlExeMapper;
import com.nbsaas.boot.model.ext.apis.SqlExeApi;
import com.nbsaas.boot.rest.request.SqlObject;
import com.nbsaas.boot.mp.utils.QueryWrapperUtils;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.MapResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import org.springframework.util.StringUtils;

public class SqlExeResource implements SqlExeApi {

    private final SqlExeMapper sqlExeMapper;

    public SqlExeResource(SqlExeMapper sqlExeMapper) {
        this.sqlExeMapper = sqlExeMapper;
    }

    @Override
    public PageResponse<MapResponse> search(SqlObject searchObject) {
        Page<MapResponse> page = new Page<>(searchObject.getPage(), searchObject.getSize());
        Page<MapResponse> res = sqlExeMapper.page(page, searchObject.getSql());
        return QueryWrapperUtils.handle(res);
    }

    @Override
    public ListResponse<MapResponse> list(SqlObject searchObject) {
        ListResponse<MapResponse> result=new  ListResponse<>();
        if (StringUtils.hasText(searchObject.getSql())){
            result.setData(sqlExeMapper.list(searchObject.getSql()));
        }
        return result;
    }

    @Override
    public ResponseObject<Integer> executeSql(SqlObject searchObject) {
        ResponseObject<Integer> result=new  ResponseObject<>();
        if (StringUtils.hasText(searchObject.getSql())){
            result.setData(sqlExeMapper.executeSql(searchObject.getSql()));
        }
        return result;
    }

    @Override
    public ResponseObject<MapResponse>  selectOne(SqlObject searchObject) {
        ResponseObject<MapResponse> result=new  ResponseObject<>();
        if (StringUtils.hasText(searchObject.getSql())){
            result.setData(sqlExeMapper.selectResponse(searchObject.getSql()));
        }
        return result;
    }
}
