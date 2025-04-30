
public class Cash extends Account {
    
    public Cash() {
        super("Cash", new NonNegativeBalanceValidator());
    }
}
