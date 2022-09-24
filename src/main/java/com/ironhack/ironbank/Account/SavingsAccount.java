package com.ironhack.ironbank.Account;

import com.ironhack.ironbank.User.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class SavingsAccount extends CheckingAccount{
    @Column(nullable = false)
    @DecimalMin(message = "less than minimum = 0.0025", value = "0.0025")
    @DecimalMax(message = "bigger than maximum = 0.5", value = "0.5")
    private double interestRate;
    @Range(message = "out of range = 100-1000", min = 100, max = 1000)
    private BigDecimal minimumBalance;

    public SavingsAccount(User primaryOwner, String name, String secretKey, User secondaryOwner) {
        super(primaryOwner, name, secretKey, secondaryOwner);
        this.interestRate = 0.0025;
        this.minimumBalance = BigDecimal.valueOf(1000);
    }

    public SavingsAccount(User primaryOwner, String name, String secretKey) {
        super(primaryOwner, name, secretKey);
        this.interestRate = 0.0025;
        this.minimumBalance = BigDecimal.valueOf(1000);
    }
}
