
public class Category implements ICategory, IEntity {
    String name;
    TransactionType type;
    
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public TransactionType getType() {
        return this.type;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    public boolean setType(TransactionType type) {
        this.type = type;
        return true;
    }
    
    
    
}
