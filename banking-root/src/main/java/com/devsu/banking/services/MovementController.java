package com.devsu.banking.services;

import com.devsu.banking.client.entity.AccountEntity;
import com.devsu.banking.client.entity.MovementEntity;
import com.devsu.banking.client.entity.ParameterEntity;
import com.devsu.banking.client.service.IAccountService;
import com.devsu.banking.client.service.IMovementService;
import com.devsu.banking.client.service.IParameterService;
import com.devsu.banking.vo.MovementVo;
import com.devsu.banking.vo.response.ApiResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/movement")
public class MovementController {

    @Autowired
    private IMovementService iMovementService;

    @Autowired
    private IAccountService iAccountService;

    @Autowired
    private IParameterService iParameterService;

    /**
     * Method to save movement
     * @param movementVo
     * @return
     */
    @PostMapping(path = "/saveMovement")
    public ResponseEntity<ApiResponseVo<MovementVo>> saveMovement(@RequestBody MovementVo movementVo) {

        MovementEntity movementEntity = this.iMovementService.findTopByOrderByMovementDateDesc(movementVo.getAccount().getAccountId());
        double currentBalance;

        if (movementEntity != null) {
            currentBalance = movementEntity.getMovementBalance();
        } else {
            AccountEntity accountEntity = this.iAccountService.findByAccountId(movementVo.getAccount().getAccountId());
            currentBalance = accountEntity.getAccountBeginBalance();
        }

        if ("RETIRO".equals(movementVo.getMovementType())) {
            if (currentBalance < movementVo.getMovementValue()) {
                return ResponseEntity.ok(
                        ApiResponseVo.<MovementVo>builder()
                                .message("Saldo no disponible.")
                                .build()
                );
            }
            if(this.isUnderDebitLimit(movementVo.getAccount().getAccountId(), movementVo.getMovementValue())){
                return ResponseEntity.ok(
                        ApiResponseVo.<MovementVo>builder()
                                .message("Cupo diario exedido.")
                                .build());
            }
            movementVo.setMovementValue(movementVo.getMovementValue() * -1);
        }
        movementVo.setMovementBalance(currentBalance + movementVo.getMovementValue());


        this.iMovementService.saveMovement(movementVo);
        return ResponseEntity.ok(
                ApiResponseVo.<MovementVo>builder()
                        .message("Movimiento registrado correctamente.")
                        .data(movementVo)
                        .build());
    }

    /**
     * Validate debit limit a day
     * @return
     */
    private boolean isUnderDebitLimit(Integer accountId, double newDebitValue){
        ParameterEntity parameterEntity = this.iParameterService.getParameterByCode("BA1");
        double dayLimit = parameterEntity != null? Double.parseDouble(parameterEntity.getParameterValue()): 1000.0;

        List<MovementEntity> movementDebitEntityList = this.iMovementService.findByAccountAccountIdAndMovementTypeAndMovementDateBetween(accountId);

        if (!movementDebitEntityList.isEmpty()) {
            double debitSum = movementDebitEntityList.stream().mapToDouble(MovementEntity::getMovementValue).sum() * -1;
            return (debitSum + (newDebitValue *1)) > dayLimit;
        }
        return false;
    }

    /**
     * Method to find all movements
     * @return List<MovementEntity>
     */
    @GetMapping(path = "/findAll")
    public ResponseEntity<ApiResponseVo<List<MovementEntity>>> findAll() {
        return ResponseEntity.ok(
                ApiResponseVo.<List<MovementEntity>>builder()
                        .message("Movimientos encontrados correctamente.")
                        .data(this.iMovementService.findAll())
                        .build());
    }

}
