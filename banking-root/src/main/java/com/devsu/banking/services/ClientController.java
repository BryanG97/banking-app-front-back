package com.devsu.banking.services;

import com.devsu.banking.client.entity.PersonEntity;
import com.devsu.banking.client.service.IClientService;
import com.devsu.banking.client.service.IPersonService;
import com.devsu.banking.vo.ClientVo;
import com.devsu.banking.vo.PersonVo;
import com.devsu.banking.vo.response.ApiResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private IClientService iClientService;

    @Autowired
    private IPersonService iPersonService;

    @PostMapping(path = "/saveClient")
    public ResponseEntity<ApiResponseVo<ClientVo>> saveClient(@RequestBody ClientVo clientVo) {
        PersonEntity personEntity = this.iPersonService.getPersonByIdentification(clientVo.getPerson().getPersonIdentification());
        if (null != personEntity) {
            return ResponseEntity.badRequest().body(
                    ApiResponseVo.<ClientVo>builder()
                            .message("Ya existe un cliente con esa identificación: " + personEntity.getPersonIdentification())
                            .build());
        }


        PersonVo savedPerson = this.iPersonService.savePerson(clientVo.getPerson());
        clientVo.setPerson(savedPerson);

        this.iClientService.saveClient(clientVo);
        return ResponseEntity.ok(
                ApiResponseVo.<ClientVo>builder()
                        .message("Cliente creado correctamente.")
                        .data(clientVo)
                        .build());
    }

}
