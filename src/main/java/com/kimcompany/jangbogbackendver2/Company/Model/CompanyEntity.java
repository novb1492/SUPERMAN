package com.kimcompany.jangbogbackendver2.Company.Model;

import com.kimcompany.jangbogbackendver2.Common.AddressColumn;
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
@Table(name = "COMPANY")
@Entity
public class CompanyEntity {

    @EmbeddedId
    private CompanyPk comapnyPk;

    @Embedded
    private AddressColumn addressColumn;

    @Embedded
    private CommonColumn commonColumn;


}
