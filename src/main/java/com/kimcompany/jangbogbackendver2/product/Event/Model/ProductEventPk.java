package com.kimcompany.jangbogbackendver2.product.Event.Model;

import com.kimcompany.jangbogbackendver2.product.Model.ProductEntity;
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
public class ProductEventPk implements Serializable {
    @MapsId
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "PRODUCT_NAME",referencedColumnName = "PRODUCT_NAME"),
            @JoinColumn(name = "FLYER_DETAIL_ID",referencedColumnName = "FLYER_DETAIL_ID"),
            @JoinColumn(name = "FLYER_ID",referencedColumnName = "FLYER_ID"),
            @JoinColumn(name = "STORE_ID",referencedColumnName = "STORE_ID")
    })
    private ProductEntity productEntity;
}
