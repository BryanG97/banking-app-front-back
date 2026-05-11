package com.devsu.banking.client.service;

import com.devsu.banking.client.entity.MovementEntity;
import com.devsu.banking.vo.MovementVo;

import java.util.List;

public interface IMovementService {

    /**
     * Find the top movement by account id
     * @param accountId
     * @return
     */
    MovementEntity findTopByOrderByMovementDateDesc(Integer accountId);

    /**
     * Find all movements
     * @return
     */
    List<MovementEntity> findAll();

    /**
     * Find all movements by account id and actual date
     * @param accountId
     * @return
     */
    List<MovementEntity> findByAccountAccountIdAndMovementTypeAndMovementDateBetween(Integer accountId);

    /**
     * Save a movement
     * @param movementVo
     */
    void saveMovement(MovementVo movementVo);

}
