package com.nbsaas.boot.model.ext.apis;

import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.MapResponse;
import com.nbsaas.boot.rest.response.PageResponse;

import java.io.InputStream;

public interface JsonSearchApi {


    PageResponse<MapResponse> search(InputStream inputStream);


    ListResponse<MapResponse> list(InputStream inputStream);

}
