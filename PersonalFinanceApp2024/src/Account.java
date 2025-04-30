
public class Account implements IAccount, IBalanceChangeable, IEntity {

    double balance;
    String name;
    IBalanceValidator balanceValidator;

    public Account(String name) {
        this.name = name;
    }

    public Account(String name, IBalanceValidator balanceValidator) {
        this.name = name;
        this.balanceValidator = balanceValidator;

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getValue() {
        return balance;
    }

    @Override
    public boolean setValue(double value) {
        if (balanceValidator != null) 
        {
        if (this.balanceValidator.isValid(value)) {
            this.balance = value;
            return true;
        } 
        else {
            return false;
        }
        }
        else {
             return false;   
                }
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

}
