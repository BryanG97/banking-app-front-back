package com.devsu.banking.client.repository;

import com.devsu.banking.client.entity.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IMovementRepository extends JpaRepository<MovementEntity, Integer> {

    /**
     * Find the top movement by account id
     * @param accountId
     * @return
     */
    Optional<MovementEntity> findTopByAccountAccountIdOrderByMovementDateDesc( Integer accountId );

    /**
     * Find all movements by account id and movement type and movement date between
     * @param accountId
     * @param movementType
     * @param startDate
     * @param endDate
     * @return
     */
    List<MovementEntity> findByAccountAccountIdAndMovementTypeAndMovementDateBetween(Integer accountId, String movementType, Date startDate, Date endDate );

    /**
     * Find all movements by account id and movement date between
     * @param accountId
     * @param startDate
     * @param endDate
     * @return
     */
    List<MovementEntity> findByAccountAccountIdAndMovementDateBetween(Integer accountId, Date startDate, Date endDate );
}
