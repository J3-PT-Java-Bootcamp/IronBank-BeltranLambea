package com.ironhack.ironbank.Account;

import com.ironhack.ironbank.User.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import javax.persistence.Entity;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class CreditAccount extends CheckingAccount{
    @Range(message = "out of range, 100-100000", min = 100, max = 100000)
    private BigDecimal creditLimit;
    @DecimalMin(message = "less than minimum = 0.1", value = "0.1")
    @DecimalMax(message = "bigger than maximum = 0.2", value = "0.2")
    private double interestRate;

    public CreditAccount(User primaryOwner, String name, String secretKey, User secondaryOwner) {
        super(primaryOwner, name, secretKey, secondaryOwner);
        this.creditLimit = BigDecimal.valueOf(100);
        this.interestRate = 0.2;
    }

    public CreditAccount(User primaryOwner, String name, String secretKey) {
        super(primaryOwner, name, secretKey);
        this.creditLimit = BigDecimal.valueOf(100);
        this.interestRate = 0.2;
    }
}
