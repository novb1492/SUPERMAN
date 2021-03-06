package com.kimcompany.jangbogbackendver2.product.Event.Model;

import com.kimcompany.jangbogbackendver2.Common.CommonColumn;
import com.kimcompany.jangbogbackendver2.product.Model.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Table(name = "PRODUCT_EVENT")
@Entity
public class ProductEventEntity {

    @EmbeddedId
    private ProductEventPk productEventPk;

    @Embedded
    private CommonColumn commonColumn;

    @Column(name = "EVENT_PRICE",nullable = false)
    private Integer eventPrice;

    @Column(name = "START_DATE",nullable = false)
    private Timestamp startDate;

    @Column(name = "END_DATE",nullable = false)
    private Timestamp endDate;

}
