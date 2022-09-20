package com.ironhack.ironbank.Account;

import lombok.Getter;
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
public class SavingsAccount extends CheckingAccount{
    @Column(nullable = false)
    @DecimalMin(message = "less than minimum = 0.025", value = "0.025")
    @DecimalMax(message = "bigger than maximum = 0.5", value = "0.5")
    private double interestRate;
    @Range(message = "out of range = 100-1000", min = 100, max = 1000)
    private BigDecimal minimumBalance;
}
