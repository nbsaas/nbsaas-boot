package com.nbsaas.boot.model.ext.apis;

import com.nbsaas.boot.rest.request.SqlObject;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.MapResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;

public interface SqlExeApi {

    PageResponse<MapResponse> search(SqlObject searchObject);


    ListResponse<MapResponse> list(SqlObject searchObject);


    /**
     * 执行sql语句
     *
     */
    ResponseObject<Integer> executeSql(SqlObject searchObject);


    /**
     * 根据sql查询获取单条数据
     *
     */
    ResponseObject<MapResponse> selectOne(SqlObject searchObject);
}
