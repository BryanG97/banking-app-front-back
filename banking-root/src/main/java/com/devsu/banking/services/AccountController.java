package com.devsu.banking.services;

import com.devsu.banking.client.service.IAccountService;
import com.devsu.banking.vo.AccountVo;
import com.devsu.banking.vo.response.ApiResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private IAccountService iAccountService;

    @PostMapping(path = "/saveAccount")
    public ResponseEntity<ApiResponseVo<AccountVo>> saveAccount(@RequestBody AccountVo accountVo) {
        this.iAccountService.saveAccount(accountVo);
        return ResponseEntity.ok(
                ApiResponseVo.<AccountVo>builder()
                        .message("Cuenta creada correctamente.")
                        .build());
    }

}
