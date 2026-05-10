package com.devsu.banking.core.service;

import com.devsu.banking.client.entity.PersonEntity;
import com.devsu.banking.client.repository.IPersonRepository;
import com.devsu.banking.client.service.IPersonService;
import com.devsu.banking.client.util.ProjectUtil;
import com.devsu.banking.vo.PersonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {

    @Autowired
    private IPersonRepository iPersonRepository;

    @Override
    public List<PersonEntity> getAllPerson() {
        return this.iPersonRepository.findAll();
    }

    @Override
    public PersonEntity getPersonByIdentification(String personIdentification) {
        return this.iPersonRepository.findByPersonIdentification(personIdentification)
                .orElse(null);
    }


    @Override
    public PersonVo savePerson(PersonVo personVo) {
        PersonEntity personEntity = ProjectUtil.convert(personVo, PersonEntity.class);
        this.iPersonRepository.save(personEntity);
        personVo.setPersonId(personEntity.getPersonId());
        return personVo;
    }

}
