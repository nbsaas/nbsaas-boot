package com.nbsaas.boot.model.data.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nbsaas.boot.model.data.entity.Model;
import com.nbsaas.boot.rest.response.MapResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 */
public interface ModelMapper extends BaseMapper<Model> {


    /**
     * 根据sql查询获取分页数据
     *
     * @param page
     * @param sql
     * @return
     */
    Page<MapResponse> page(IPage<MapResponse> page, @Param("sql") String sql);


    /**
     * 执行sql语句
     *
     * @param sql
     * @return
     */
    int executeSql(@Param("sql") String sql);


    /**
     * 根据sql查询获取单条数据
     *
     * @param sql
     * @return
     */
    MapResponse selectResponse(@Param("sql") String sql);


    /**
     * 获取列表
     *
     * @param sql
     * @return
     */
    List<MapResponse> list(@Param("sql") String sql);


}