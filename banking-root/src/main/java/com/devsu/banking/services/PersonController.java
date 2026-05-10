package com.devsu.banking.services;

import com.devsu.banking.client.entity.PersonEntity;
import com.devsu.banking.client.service.IPersonService;
import com.devsu.banking.vo.PersonVo;
import com.devsu.banking.vo.response.ApiResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private IPersonService iPersonService;

    @GetMapping(path = "/getAllPerson")
    public ResponseEntity<ApiResponseVo<List<PersonEntity>>> getAllPerson() {
        String message;
        List<PersonEntity> personList = this.iPersonService.getAllPerson();

        message = personList.isEmpty() ? "No se encontraron personas." : "Listado de personas obtenido correctamente.";

        return ResponseEntity.ok(
                ApiResponseVo.<List<PersonEntity>>builder()
                        .message(message)
                        .data(this.iPersonService.getAllPerson())
                        .build());
    }

    @PostMapping(path = "/savePerson")
    public ResponseEntity<ApiResponseVo<PersonVo>> savePerson(@RequestBody PersonVo personVo) {
        PersonEntity personEntity = this.iPersonService.getPersonByIdentification(personVo.getPersonIdentification());
        if (null != personEntity) {
            return ResponseEntity.badRequest().body(
                    ApiResponseVo.<PersonVo>builder()
                            .message("Persona ya existe con la identificación: " + personVo.getPersonIdentification())
                            .build());
        }

        this.iPersonService.savePerson(personVo);
        return ResponseEntity.ok(
                ApiResponseVo.<PersonVo>builder()
                        .message("Persona creada correctamente.")
                        .data(personVo)
                        .build());
    }

}
