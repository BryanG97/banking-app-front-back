package com.devsu.banking.client.repository;

import com.devsu.banking.client.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<AccountEntity, Integer> {
}
