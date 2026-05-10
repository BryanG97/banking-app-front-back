package com.devsu.banking.services;

import com.devsu.banking.client.entity.ClientEntity;
import com.devsu.banking.client.entity.PersonEntity;
import com.devsu.banking.client.service.IClientService;
import com.devsu.banking.client.service.IPersonService;
import com.devsu.banking.vo.ClientVo;
import com.devsu.banking.vo.PersonVo;
import com.devsu.banking.vo.response.ApiResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private IClientService iClientService;

    @Autowired
    private IPersonService iPersonService;

    @GetMapping(path = "/getAllClient")
    public ResponseEntity<ApiResponseVo<List<ClientEntity>>> getAllClients() {
        String message;
        List<ClientEntity> cleintList = this.iClientService.findAll();

        message = cleintList.isEmpty() ? "No se encontraron clientes." : "Listado de clientes obtenido correctamente.";

        return ResponseEntity.ok(
                ApiResponseVo.<List<ClientEntity>>builder()
                        .message(message)
                        .data(cleintList)
                        .build());

    }

    @PostMapping(path = "/saveClient")
    public ResponseEntity<ApiResponseVo<ClientVo>> saveClient(@RequestBody ClientVo clientVo) {
        PersonEntity personEntity = this.iPersonService.getPersonByIdentification(clientVo.getPerson().getPersonIdentification());
        if (null != personEntity) {
            return ResponseEntity.ok(
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
