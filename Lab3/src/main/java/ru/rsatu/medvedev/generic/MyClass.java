/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rsatu.medvedev.generic;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emedvedev
 * @param <T>
 */
public class MyClass<T> implements MyInterface<T> {
    
    private T val;

    @Override
    public T get() {
        return val;
    }

    @Override
    public void set(T val) {
        this.val = val;
    }

    @Override
    public <K> K getValue(Class<K> o) {
        try {
            
            return o.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(MyClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
