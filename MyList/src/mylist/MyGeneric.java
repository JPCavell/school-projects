/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mylist;

import java.util.ArrayList;

/**
 *
 * @author M3SS1
 */
public class MyGeneric<T> {
    
    ArrayList<T> theseThings = new ArrayList<>();
    
    public T getTheThing() {
        return theseThings.get(0);
    }
    
    public void putTheThing(T s) {
        
    }
    
}
