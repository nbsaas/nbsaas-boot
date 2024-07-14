package com.nbsaas.boot.model.ext.resource;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nbsaas.boot.model.data.mapper.SqlExeMapper;
import com.nbsaas.boot.model.ext.apis.SqlExeApi;
import com.nbsaas.boot.rest.request.SqlBatchObject;
import com.nbsaas.boot.rest.request.SqlObject;
import com.nbsaas.boot.mp.utils.QueryWrapperUtils;
import com.nbsaas.boot.rest.response.*;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

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

    @Override
    public ResponseObject<MapResponse> batch(SqlBatchObject sqlObject) {
        ResponseObject<MapResponse> result = new ResponseObject<>();
        result.setData(new MapResponse());
        Integer execType = sqlObject.getExecType();
        if (execType == null) {
            execType = 1;
        }
        //执行类型 1串行 2并行
        if (execType == 1) {
            //串行
            for (SqlObject sql : sqlObject.getSqlObjects()) {
                //1 分页 2 列表 3 统计 4单对象 5单值 6执行sql
                Integer queryType = sql.getQueryType();
                if (queryType == null) {
                    queryType = 4;
                }
                ResponseObject<?> res = null;
                if (queryType == 1) {
                    ResponseObject<PageResponse<MapResponse>> tt=new    ResponseObject<>();
                    PageResponse<MapResponse> temp = search(sql);
                    tt.setData(temp);
                    res=tt;
                } else if (queryType == 2) {
                    res = list(sql);
                } else if (queryType == 3) {
                    res = selectOne(sql);
                } else if (queryType == 4) {
                    res = selectOne(sql);
                } else if (queryType == 5) {
                    res = selectOne(sql);
                } else if (queryType == 6) {
                    res = executeSql(sql);
                }
                if (res != null && res.getData() != null) {
                    if (StringUtils.hasText(sql.getVarName())) {
                        result.getData().put(sql.getVarName(), res.getData());
                    }
                }
            }
        } else if (execType == 2) {

            List<CompletableFuture<FutureResult>> futures = new ArrayList<>();
            //并行
            for (SqlObject sql : sqlObject.getSqlObjects()) {
                CompletableFuture<FutureResult> future = null;
                Integer queryType = sql.getQueryType();
                if (queryType == null) {
                    queryType = 4;
                }
                if (queryType == 1) {
                    future = CompletableFuture.supplyAsync(() ->
                            {
                                FutureResult back = new FutureResult();
                                back.setSqlObject(sql);
                                back.setResult(search(sql));
                                return back;
                            }
                    );
                } else if (queryType == 2) {
                    future = CompletableFuture.supplyAsync(() ->
                            {
                                FutureResult back = new FutureResult();
                                back.setSqlObject(sql);
                                back.setResult(list(sql));
                                return back;
                            }
                    );
                } else if (queryType == 3) {
                    future = CompletableFuture.supplyAsync(() ->
                            {
                                FutureResult back = new FutureResult();
                                back.setSqlObject(sql);
                                back.setResult(selectOne(sql));
                                return back;
                            }
                    );
                } else if (queryType == 4) {
                    future = CompletableFuture.supplyAsync(() ->
                            {
                                FutureResult back = new FutureResult();
                                back.setSqlObject(sql);
                                back.setResult(selectOne(sql));
                                return back;
                            }
                    );
                } else if (queryType == 5) {
                    future = CompletableFuture.supplyAsync(() ->
                            {
                                FutureResult back = new FutureResult();
                                back.setSqlObject(sql);
                                back.setResult(selectOne(sql));
                                return back;
                            }
                    );
                } else if (queryType == 6) {
                    future = CompletableFuture.supplyAsync(() ->
                            {
                                FutureResult back = new FutureResult();
                                back.setSqlObject(sql);
                                back.setResult(executeSql(sql));
                                return back;
                            }
                    );
                }
                if (future != null) {
                    futures.add(future);
                }
            }
            CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
            try {
                combinedFuture.get(); // 等待所有任务完成
            } catch (InterruptedException | ExecutionException ignored) {
            }
            for (CompletableFuture<FutureResult> future : futures) {
                try {
                    FutureResult res = future.get();
                    if (res != null && res.getResult().getData() != null) {
                        ResponseObject<?> data = res.getResult();
                        SqlObject sql1 = res.getSqlObject();
                        if (StringUtils.hasText(sql1.getVarName())) {
                            result.getData().put(sql1.getVarName(), data.getData());
                        }
                    }
                } catch (InterruptedException | ExecutionException ignored) {
                }
            }

        }
        return result;
    }
}
