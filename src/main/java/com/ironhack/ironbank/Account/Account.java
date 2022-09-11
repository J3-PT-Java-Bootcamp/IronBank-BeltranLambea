package com.ironhack.ironbank.Account;

import com.ironhack.ironbank.User.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
            @JoinColumn(name = "owner_id")
    private User primaryOwner;
    private String name;
    private BigDecimal balance;
    private BigDecimal penaltyFee;
    private Instant creationDate;
    private Status status;
}
