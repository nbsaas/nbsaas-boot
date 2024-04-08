package com.nbsaas.boot.model.data.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nbsaas.boot.model.data.entity.Model;
import com.nbsaas.boot.rest.response.MapResponse;
import org.apache.ibatis.annotations.Param;

/**
 * Mapper
 */
public interface ModelMapper extends BaseMapper<Model> {


    Page<MapResponse> page(IPage<MapResponse> page, @Param("sql") String sql);

}