


public class Account implements IAccount, IBalanceChangeable {
    
    double balance;
    String name;
    
    public Account(String name) {
        this.name = name;
    }
    
    public Account(String name, IBalanceValidator balanceValidator) {
        this.name = name;
        //this.balanceValidator = balanceValidator;
        
    }

    @Override
    public boolean setValue(double value) {
        if(value >= 0) {
            this.balance = value;
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getValue() {
        return balance;
    }
    
}
