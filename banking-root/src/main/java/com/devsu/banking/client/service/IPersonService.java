package com.devsu.banking.client.service;

import com.devsu.banking.client.entity.PersonEntity;
import com.devsu.banking.vo.PersonVo;

import java.util.List;

public interface IPersonService {

    /**
     * Find all person
     * @return
     */
    List<PersonEntity> getAllPerson();

    /**
     * Save person
     * @param personVo
     */
    PersonVo savePerson(PersonVo personVo);

    /**
     * Find person by identification
     * @param personIdentification
     * @return
     */
    PersonEntity getPersonByIdentification(String personIdentification);

}
