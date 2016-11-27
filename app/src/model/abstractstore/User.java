package model.abstractstore;

/**
 * Created by oTk on 26.11.2016.
 */
public class User {
    private final String name;
    private String password;
    private Money money;

    public User(String name, String password, Money money) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return name.toLowerCase().equals(user.name.toLowerCase());

    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }
}
