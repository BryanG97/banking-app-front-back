package com.devsu.banking.core.service;

import com.devsu.banking.client.entity.AccountEntity;
import com.devsu.banking.client.entity.MovementEntity;
import com.devsu.banking.client.repository.IMovementRepository;
import com.devsu.banking.client.service.IMovementService;
import com.devsu.banking.vo.MovementVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MovementService implements IMovementService {

    @Autowired
    private IMovementRepository iMovementRepository;

    @Override
    public MovementEntity findTopByOrderByMovementDateDesc(Integer accountId) {
        return this.iMovementRepository.findTopByAccountAccountIdOrderByMovementDateDesc(accountId)
                .orElse(null);
    }

    @Override
    public void saveMovement(MovementVo movementVo) {

        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountId(movementVo.getAccount().getAccountId());

        MovementEntity movementEntity = new MovementEntity();
        movementEntity.setMovementDate(new Date());
        movementEntity.setMovementType(movementVo.getMovementType());
        movementEntity.setMovementValue(movementVo.getMovementValue());
        movementEntity.setMovementBalance(movementVo.getMovementBalance());
        movementEntity.setAccount(accountEntity);

        this.iMovementRepository.save(movementEntity);

        movementVo.setMovementId(movementEntity.getMovementId());
        movementVo.setMovementDate(movementEntity.getMovementDate());

    }

}
