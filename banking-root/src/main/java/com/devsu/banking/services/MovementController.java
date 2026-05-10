package com.devsu.banking.services;

import com.devsu.banking.client.entity.AccountEntity;
import com.devsu.banking.client.entity.MovementEntity;
import com.devsu.banking.client.service.IAccountService;
import com.devsu.banking.client.service.IMovementService;
import com.devsu.banking.vo.AccountVo;
import com.devsu.banking.vo.MovementVo;
import com.devsu.banking.vo.response.ApiResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movement")
public class MovementController {

    @Autowired
    private IMovementService iMovementService;

    @Autowired
    private IAccountService iAccountService;

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

        if ("DEBITO".equals(movementVo.getMovementType())) {
            if (currentBalance < movementVo.getMovementValue()) {
                return ResponseEntity.badRequest().body(
                        ApiResponseVo.<MovementVo>builder()
                                .message("Saldo no disponible.")
                                .build()
                );
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

}
