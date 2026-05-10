package com.devsu.banking.core.service;

import com.devsu.banking.client.entity.AccountEntity;
import com.devsu.banking.client.entity.ClientEntity;
import com.devsu.banking.client.repository.IAccountRepository;
import com.devsu.banking.client.service.IAccountService;
import com.devsu.banking.vo.AccountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private IAccountRepository iAccountRepository;

    @Override
    public void saveAccount(AccountVo accountVo){
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setClientId(accountVo.getClient().getClientId());

        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountNumber(accountVo.getAccountNumber());
        accountEntity.setAccountType(accountVo.getAccountType());
        accountEntity.setAccountBeginBalance(accountVo.getAccountBeginBalance());
        accountEntity.setAccountStatus(true);
        accountEntity.setClient(clientEntity);
        this.iAccountRepository.save(accountEntity);

        accountVo.setAccountId(accountEntity.getAccountId());
    }

    @Override
    public AccountEntity findByAccountId(Integer accountId){
        return this.iAccountRepository.findById(accountId).orElse(null);
    }

}
