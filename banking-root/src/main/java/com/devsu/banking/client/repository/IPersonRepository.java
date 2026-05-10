package com.devsu.banking.client.repository;

import com.devsu.banking.client.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPersonRepository extends JpaRepository<PersonEntity, Integer> {

    /**
     * Find person by identification
     * @param personIdentification
     * @return
     */
    Optional<PersonEntity> findByPersonIdentification(String personIdentification);

}
