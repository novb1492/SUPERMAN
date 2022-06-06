package com.kimcompany.jangbogbackendver2.product.Model;

import com.kimcompany.jangbogbackendver2.Flyer.Model.FlyerEntity;
import com.kimcompany.jangbogbackendver2.FlyerDetail.Model.FlyerDetailEntity;
import com.kimcompany.jangbogbackendver2.Store.Model.StoreEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ProductPk implements Serializable {

    @Column(name = "PRODUCT_NAME",length = 100)
    private String productName;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FLYER_DETAIL_ID")
    private FlyerDetailEntity flyerDetailEntity;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FLYER_ID")
    private FlyerEntity flyerEntity;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STORE_ID")
    private StoreEntity storeEntity;


}
