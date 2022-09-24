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
@ToString
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
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

    public Account(User primaryOwner, String name) {
        this.primaryOwner = primaryOwner;
        this.name = name;
        this.balance = BigDecimal.valueOf(0);
        this.creationDate = Instant.now();
        this.status = Status.ACTIVE;
    }


}
