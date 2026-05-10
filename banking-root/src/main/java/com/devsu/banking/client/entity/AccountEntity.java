package com.devsu.banking.client.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ACCOUNT")
@Table(name = "\"ACCOUNT\"")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ACCOUNT_ID\"", nullable = false)
    private Integer accountId;

    @Column(name = "\"ACCOUNT_NUMBER\"")
    private String accountNumber;

    @Column(name = "\"ACCOUNT_TYPE\"")
    private String accountType;

    @Column(name = "\"ACCOUNT_BEGIN_BALANCE\"")
    private Double accountBeginBalance;

    @Column(name = "\"ACCOUNT_STATUS\"")
    private Boolean accountStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"CLIENT_ID\"", referencedColumnName = "\"CLIENT_ID\"", nullable = false)
    private ClientEntity client;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MovementEntity> movementEntities;

}
