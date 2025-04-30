
import java.util.Collection;
import java.util.Date;
import java.util.Map;


public class PersonalFinanceApp2024 implements IPersonalFinance {
    
    private Account cash;
    private AccountRepository creditCards;
    private AccountRepository debitAccounts;
    private CategoryRepository categories;
    
    private static PersonalFinanceApp2024 instance = new PersonalFinanceApp2024();
    
    private PersonalFinanceApp2024() {
    cash = new Cash();
    creditCards = new AccountRepository();
    debitAccounts = new AccountRepository();
    categories = new CategoryRepository();
    }
    
    public static PersonalFinanceApp2024 getInstance(){
    return instance;
    }

    @Override
    public double getCash() {
        return cash.getValue();
    }

    @Override
    public boolean updateCash(double newAmount) {
        return cash.setValue(newAmount);
    }

    @Override
    public Collection<IAccount> getCreditCards() {
        return creditCards.getAll();
    }

    private boolean addAccount(String name, Double debt, AccountRepository repo) {
        Account a = new Account(name,new NonNegativeBalanceValidator());
        if (a.setValue(debt)) {
        return repo.Add(a);   
        }
        else {
            return false;
        }
    }
    
    @Override
    public boolean addCreditCard(String name, double debt) {
        return addAccount(name, debt, creditCards);
    }
    
    /**
     *
     * @param name
     * @return
     */
    @Override
    public boolean removeCreditCard(String name) {
        return creditCards.remove(name);
    }

    @Override
    public boolean updateCreditCardName(String name, String newName) {
        return creditCards.updateName(name, newName);
    }
    
    private boolean updateBalance(String name, double Balance, AccountRepository repo) {
        Account account = (Account) repo.getByName(name);
        if (account != null) {
            return account.setValue(Balance);
        }
        else
            return false;
    }
    
    @Override
    public boolean updateCreditCardDebt(String name, double newDebt) {
        Account account = (Account) creditCards.getByName(name);
        if(account != null) {
            return account.setValue(newDebt);
        }
        else 
            return false;
    }

    @Override
    public Collection<IAccount> getDebitAccounts() {
        return debitAccounts.getAll();
    }

    @Override
    public boolean addDebitAccount(String name, double balance) {
        return addAccount(name, balance, debitAccounts);
    }

    @Override
    public boolean removeDebitAccount(String name) {
        return debitAccounts.remove(name);
    }

    @Override
    public boolean updateDebitAccountName(String name, String newName) {
        return debitAccounts.updateName(name, newName);    
    }

    @Override
    public boolean updateDebitAccountBalance(String name, double newBalance) {
        return updateBalance(name, newBalance, debitAccounts);
    }

    @Override
    public Collection<ICategory> getCategories() {
        return categories.getAll();
    }

    @Override
    public boolean addCategory(String name, ICategory.TransactionType transactionType) {
        if (transactionType == null)
            return false;
        
        Category category = new Category();
        category.setName(name);
        category.setType(transactionType);
        return categories.Add(category);
    }

    @Override
    public boolean removeCategory(String name) {
        return categories.remove(name);
    }

    @Override
    public boolean updateCategoryName(String name, String newName) {
        return categories.updateName(newName, newName);
    }

    @Override
    public boolean updateCategoryType(String name, ICategory.TransactionType newType) {
        if (newType != null)
            return false;
        
        Category category = (Category) categories.getByName(name);
        if (categories != null) {
            category.setType(newType);
        }
        return false;
    }

    @Override
    public Collection<IBudget> getBudgets() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addBudget(String name, Date startDate, Date endDate, Map<String, Double> items) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean removeBudget(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateBudgetName(String name, String newName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateBudgetStartDate(String name, Date newStartDate) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateBudgetEndDate(String name, Date newEndDate) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addOrUpdateBudgetItem(String name, String categoryName, double value) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean removeBudgetItem(String name, String categoryName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<ITransaction> getTransactions(Date startDate, Date endDate) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int addTransaction(Date date, String description, double amount, String categoryName, String accountName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean removeTransaction(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateTransactionDate(int id, Date newDate) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateTransactionDescription(int id, String newDescription) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateTransactionAmount(int id, double newAmount) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateTransactionCategory(int id, String newCategoryName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean getStatus(String budgetName, Map<ICategory, Double> projected, Map<ICategory, Double> actual) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
