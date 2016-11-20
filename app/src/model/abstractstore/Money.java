package model.abstractstore;

import java.math.BigDecimal;

public final class  Money implements Comparable {
    private final BigDecimal  amount;

    public Money(String amount){
        this(new BigDecimal(amount));
    }

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public Money add(Money other){
        return newMoney(amount.add(other.amount));
    }

    public Money add(String amount){
        return  this.add(new Money(amount));
    }

    public Money subtract(Money other){
        return newMoney(amount.subtract(other.amount));
    }

    public Money subtract(String amount){
        return  this.subtract(new Money(amount));
    }
    
    private Money newMoney(BigDecimal  amount) {
        return new Money(amount);
    }

    public BigDecimal getAmount() {
        return amount.setScale(2, BigDecimal.ROUND_FLOOR);
    }

    @Override
    public String toString() {
        return getAmount().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        return amount.equals(money.amount);

    }

    @Override
    public int hashCode() {
        return amount.hashCode();
    }

    @Override
    public int compareTo(Object o) {
        return amount.compareTo(((Money)o).getAmount());
    }
}
