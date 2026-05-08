package com.devsu.banking.client.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "MOVEMENT")
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVEMENT_ID")
    private int movementId;

    @Column(name = "MOVEMENT_DATE")
    private LocalDate movementDate;

    @Column(name = "MOVEMENT_TYPE")
    private String movementType;

    @Column(name = "MOVEMENT_VALUE")
    private double movementValue;

    @Column(name = "MOVEMENT_BALANCE")
    private double movementBalance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID", nullable = false)
    private AccountEntity account;

}
