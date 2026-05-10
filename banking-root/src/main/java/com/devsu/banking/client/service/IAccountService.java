package com.devsu.banking.client.service;

import com.devsu.banking.client.entity.AccountEntity;
import com.devsu.banking.vo.AccountVo;

public interface IAccountService {

    /**
     * Method to save account
     * @param accountVo
     */
    void saveAccount(AccountVo accountVo);

    /**
     * Method to find account by id
     * @param accountId
     * @return AccountEntity
     */
    AccountEntity findByAccountId(Integer accountId);

}
