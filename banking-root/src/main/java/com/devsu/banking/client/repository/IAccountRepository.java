package com.devsu.banking.client.repository;

import com.devsu.banking.client.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAccountRepository extends JpaRepository<AccountEntity, Integer> {

    /**
     * Method to find accounts by client id
     * @param clientId
     * @return List<AccountEntity>
     */
    List<AccountEntity> findByClientClientId(Integer clientId);

}
