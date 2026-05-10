package com.devsu.banking.client.repository;

import com.devsu.banking.client.entity.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IMovementRepository extends JpaRepository<MovementEntity, Integer> {

    /**
     * Find the top movement by account id
     * @param accountId
     * @return
     */
    Optional<MovementEntity> findTopByAccountAccountIdOrderByMovementDateDesc( Integer accountId );

}
