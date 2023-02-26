package com.nbsaas.boot.entity.tenant;

import com.nbsaas.boot.hibernate.data.entity.CatalogEntity;
import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class TenantCatalogEntity extends CatalogEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Tenant tenant;
}
