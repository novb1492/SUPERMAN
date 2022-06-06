package com.kimcompany.jangbogbackendver2.product.Model;

import com.kimcompany.jangbogbackendver2.Common.CommonColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Table(name = "PRODUCT")
@Entity
public class ProductEntity {

    @EmbeddedId
    private ProductPk productPk;

    @Embedded
    private CommonColumn commonColumn;

    @Column(name = "CATEGORY",nullable = false,length = 20)
    private String category;

    @Column(name = "ORIGIN",nullable = false,length = 30)
    private String origin;

    @Lob
    @Column(name = "INTRODUCE")
    private String introduce;

    @Column(name = "PRODUCT_IMG_PATH",nullable = false,length = 1000)
    private String productImgPath;



}
