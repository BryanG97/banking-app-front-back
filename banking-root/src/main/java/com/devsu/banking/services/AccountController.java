package com.devsu.banking.services;

import com.devsu.banking.client.service.IAccountService;
import com.devsu.banking.vo.AccountVo;
import com.devsu.banking.vo.response.ApiResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
                        .build());
    }

}
