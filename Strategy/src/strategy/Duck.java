/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strategy;

/**
 *
 * @author M3SS1
 */
public abstract class Duck {
    
    
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;
    
    FlyBehavior fly = this.flyBehavior;
    QuackBehavior quack = this.quackBehavior;
    
    
    
    public void setFlyBehavior(FlyBehavior fly) {
        
        this.flyBehavior = fly;
    }
    
    public void setQuackBehavior(QuackBehavior quack) {
        
        this.quackBehavior = quack;
    }
    
    public void performFly() {
        flyBehavior.fly();
    }
    
    public void performQuack() {
        quackBehavior.quack();
    }
    
    public abstract void display();
    
}
