



public class NonNegativeBalanceValidator implements IBalanceValidator {

    @Override
    public boolean isValid(double balance) {
        return balance >= 0;
    }
    
}
