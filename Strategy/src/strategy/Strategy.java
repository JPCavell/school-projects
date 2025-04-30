package strategy;

public class Strategy {
    
    public static void main(String[]args) {
        
        Duck duck = new BlackDuck();
        FlyBehavior fb = new FlyReallyFast();
        QuackBehavior qb = new DefaultQuack();
        
        duck.display();
        duck.setFlyBehavior(fb);
        duck.setQuackBehavior(qb);
        duck.performFly();
        duck.performQuack();
        
        
    }
    
}
