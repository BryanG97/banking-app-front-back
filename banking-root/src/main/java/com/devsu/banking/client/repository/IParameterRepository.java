package com.devsu.banking.client.repository;

import com.devsu.banking.client.entity.ParameterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IParameterRepository extends JpaRepository<ParameterEntity, String> {
}
