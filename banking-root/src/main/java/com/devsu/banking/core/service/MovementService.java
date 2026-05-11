package com.devsu.banking.core.service;

import com.devsu.banking.client.entity.AccountEntity;
import com.devsu.banking.client.entity.MovementEntity;
import com.devsu.banking.client.repository.IMovementRepository;
import com.devsu.banking.client.service.IMovementService;
import com.devsu.banking.vo.MovementVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
    public List<MovementEntity> findAll(){
        return this.iMovementRepository.findAll();
    }

    @Override
    public List<MovementEntity> findByAccountAccountIdAndMovementTypeAndMovementDateBetween(Integer accountId) {

        Calendar calendar = Calendar.getInstance();

        // Inicio del día
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        Date startDate = calendar.getTime();

        // Fin del día
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);

        Date endDate = calendar.getTime();

        return this.iMovementRepository.findByAccountAccountIdAndMovementTypeAndMovementDateBetween(accountId, "RETIRO", startDate, endDate);
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
