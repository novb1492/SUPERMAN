package com.kimcompany.jangbogbackendver2.Company.Model;

import com.kimcompany.jangbogbackendver2.admin.Model.AdminEntity;
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
public class CompanyPk implements Serializable {

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ADMIN_ID",referencedColumnName = "ADMIN_ID")
    private AdminEntity adminEntity;

    @Column(name = "COMPANY_CODE")
    private String companyCode;
}
