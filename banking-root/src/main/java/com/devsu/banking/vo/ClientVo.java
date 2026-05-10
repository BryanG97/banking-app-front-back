package com.devsu.banking.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientVo {

    private Integer clientId;

    private String clientPassword;

    private Boolean clientStatus;

    private PersonVo person;

}
