package com.devsu.banking.vo;

import com.devsu.banking.client.entity.ClientEntity;
import com.devsu.banking.client.entity.MovementEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AccountVo {

    private Integer accountId;

    private String accountNumber;

    private String accountType;

    private Double accountBeginBalance;

    private Boolean accountStatus;

    private ClientEntity client;

    private List<MovementEntity> movementEntities;

}
