package com.nbsaas.boot.entity.tenant;

import lombok.Data;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class SortEntity extends TenantEntity {

    private Integer sortNum;

}
