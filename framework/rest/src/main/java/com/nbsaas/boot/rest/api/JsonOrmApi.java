package com.nbsaas.boot.rest.api;

import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.MapResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;

import java.io.InputStream;

public interface JsonOrmApi {

    /**
     * 数据搜索
     *
     * @param inputStream
     * @return
     */
    PageResponse<MapResponse> search(InputStream inputStream);


    /**
     * sql语句生成
     *
     * @param inputStream
     * @return
     */
    ResponseObject<String> generateSql(InputStream inputStream);

    /**
     * 数据列表
     *
     * @param inputStream
     * @return
     */
    ListResponse<MapResponse> list(InputStream inputStream);


    /**
     * 数据创建
     *
     * @param inputStream
     * @return
     */
    ResponseObject<?> create(InputStream inputStream);

    /**
     * 数据更新
     *
     * @param inputStream
     * @return
     */
    ResponseObject<?> update(InputStream inputStream);


    /**
     * 数据删除
     *
     * @param inputStream
     * @return
     */
    ResponseObject<?> delete(InputStream inputStream);


    /**
     * 数据详情
     *
     * @param inputStream
     * @return
     */
    ResponseObject<?> info(InputStream inputStream);

}
