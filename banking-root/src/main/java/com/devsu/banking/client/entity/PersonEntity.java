package com.devsu.banking.client.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PERSON")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERSON_ID", nullable = false)
    private int personId;

    @Column(name = "PERSON_NAME")
    private String personName;

    @Column(name = "PERSON_GENDER")
    private String personGender;

    @Column(name = "PERSON_AGE")
    private int personAge;

    @Column(name = "PERSON_IDENTIFICATION")
    private String personIdentification;

    @Column(name = "PERSON_ADDRESS")
    private String personAddress;

    @Column(name = "PERSON_PHONE")
    private String personPhone;

}
