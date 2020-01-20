/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rsatu.medvedev.generic;

/**
 *
 * @author emedvedev
 * @param <T>
 */
public interface MyInterface<T>  {
    
    public T get (); 
    
    public void set(T val);
    
    public <K> K getValue(Class<K> o);
}
