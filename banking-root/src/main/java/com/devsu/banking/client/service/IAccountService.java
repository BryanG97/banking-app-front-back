package com.devsu.banking.client.service;

import com.devsu.banking.client.entity.AccountEntity;
import com.devsu.banking.vo.AccountVo;

import java.util.List;

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

    /**
     * Method to find accounts by client id
     * @param clientId
     * @return List<AccountEntity>
     */
    List<AccountEntity> findByClientClientId(Integer clientId);

    /**
     * Method to find all accounts
     * @return List<AccountEntity>
     */
    List<AccountEntity> findAll();

}
