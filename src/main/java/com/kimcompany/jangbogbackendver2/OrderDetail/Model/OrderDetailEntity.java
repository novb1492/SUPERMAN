package com.kimcompany.jangbogbackendver2.OrderDetail.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Table(name = "ORDER_DETAIL")
@Entity
public class OrderDetailEntity {

    @EmbeddedId
    private OrderDetailPk orderDetailPk;

    @Column(name = "PRICE",nullable = false)
    private Integer price;

    @Column(name = "TOTAL_COUNT",nullable = false)
    private Integer totalCount;


}
