package com.devsu.banking.client.repository;

import com.devsu.banking.client.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<ClientEntity, Integer> {
}
