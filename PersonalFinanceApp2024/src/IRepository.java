/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author M3SS1
 * @param <T>
 */
public interface IRepository<T extends IEntity> {
    
    public boolean Add(T value);
    public T getByName(String value);
}
