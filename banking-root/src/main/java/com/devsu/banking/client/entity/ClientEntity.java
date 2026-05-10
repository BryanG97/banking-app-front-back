package com.devsu.banking.client.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "CLIENT")
@Table(name = "\"CLIENT\"")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"CLIENT_ID\"", nullable = false)
    private Integer clientId;

    @Column(name = "\"CLIENT_PASSWORD\"")
    private String clientPassword;

    @Column(name = "\"CLIENT_STATUS\"")
    private Boolean clientStatus;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"PERSON_ID\"", referencedColumnName = "\"PERSON_ID\"", nullable = false)
    private PersonEntity person;

}
