package com.devsu.banking.client.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PARAMETER")
@Table(name = "\"PARAMETER\"")
public class ParameterEntity {

    @Id
    @Column(name = "\"PARAMETER_CODE\"")
    private String parameterCode;

    @Column(name = "\"PARAMETER_VALUE\"")
    private String parameterValue;

}
