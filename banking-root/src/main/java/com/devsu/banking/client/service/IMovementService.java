package com.devsu.banking.client.service;

import com.devsu.banking.client.entity.MovementEntity;
import com.devsu.banking.vo.MovementVo;

public interface IMovementService {

    MovementEntity findTopByOrderByMovementDateDesc(Integer accountId);

    void saveMovement(MovementVo movementVo);

}
