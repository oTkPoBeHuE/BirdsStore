package model;

import com.sun.xml.internal.bind.v2.TODO;

import java.math.BigDecimal;

public final class  Money {
    final BigDecimal  amount;

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public Money add(Money other){
        //// TODO: Реализовать адекватную логику позже  + тесты
        return newMoney(amount.add(other.amount));
    }

    public Money subtract(Money other){
        ////TODO: Реализовать позже
        return newMoney(amount.subtract(other.amount));
    }
    
    private Money newMoney(BigDecimal  amount) {
        //// TODO: Реализовать позже
        return new Money(amount);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return amount.toString();
    }
}
