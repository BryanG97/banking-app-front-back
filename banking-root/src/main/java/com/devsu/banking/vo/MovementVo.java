package com.devsu.banking.vo;

import com.devsu.banking.client.entity.AccountEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MovementVo {

    private Integer movementId;

    private Date movementDate;

    private String movementType;

    private Double movementValue;

    private Double movementBalance;

    private AccountEntity account;
}
