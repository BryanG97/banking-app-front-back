package com.devsu.banking.services;

import com.devsu.banking.client.entity.AccountEntity;
import com.devsu.banking.client.service.IAccountService;
import com.devsu.banking.vo.AccountVo;
import com.devsu.banking.vo.response.ApiResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private IAccountService iAccountService;

    /**
     * Method to save account
     * @param accountVo
     * @return
     */
    @PostMapping(path = "/saveAccount")
    public ResponseEntity<ApiResponseVo<AccountVo>> saveAccount(@RequestBody AccountVo accountVo) {
        this.iAccountService.saveAccount(accountVo);
        return ResponseEntity.ok(
                ApiResponseVo.<AccountVo>builder()
                        .message("Cuenta creada correctamente.")
                        .data(accountVo)
                        .build());
    }

    /**
     * Method to find accounts by client id
     * @param clientId
     * @return List<AccountVo>
     */
    @GetMapping(path = "/findByClientClientId/{clientId}")
    public ResponseEntity<ApiResponseVo<List<AccountEntity>>> findByClientClientId(@PathVariable Integer clientId) {
        List<AccountEntity> accountList = this.iAccountService.findByClientClientId(clientId);
        return ResponseEntity.ok(
                ApiResponseVo.<List<AccountEntity>>builder()
                        .message("Cuentas obtenidas correctamente.")
                        .data(accountList)
                        .build());
    }

    /**
     * Method to find all accounts
     * @return List<AccountEntity>
     */
    @GetMapping(path = "/findAll")
    public ResponseEntity<ApiResponseVo<List<AccountEntity>>> findAll() {
        List<AccountEntity> accountList = this.iAccountService.findAll();
        return ResponseEntity.ok(
                ApiResponseVo.<List<AccountEntity>>builder()
                        .message("Cuentas obtenidas correctamente.")
                        .data(accountList)
                        .build());
    }

}
