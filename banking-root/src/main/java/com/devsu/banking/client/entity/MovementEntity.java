package com.devsu.banking.client.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "MOVEMENT")
@Table(name = "\"MOVEMENT\"")
public class MovementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"MOVEMENT_ID\"")
    private Integer movementId;

    @Column(name = "\"MOVEMENT_DATE\"")
    private Date movementDate;

    @Column(name = "\"MOVEMENT_TYPE\"")
    private String movementType;

    @Column(name = "\"MOVEMENT_VALUE\"")
    private Double movementValue;

    @Column(name = "\"MOVEMENT_BALANCE\"")
    private Double movementBalance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"ACCOUNT_ID\"", referencedColumnName = "\"ACCOUNT_ID\"", nullable = false)
    private AccountEntity account;

}
