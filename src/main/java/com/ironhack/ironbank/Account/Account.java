package com.ironhack.ironbank.Account;

import com.ironhack.ironbank.User.User;
import lombok.*;

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
    @Column(name = "name")
    private String name;
    private BigDecimal balance;
    private static final BigDecimal penaltyFee = BigDecimal.valueOf(40);
    private Instant creationDate;
    private Status status;
}
