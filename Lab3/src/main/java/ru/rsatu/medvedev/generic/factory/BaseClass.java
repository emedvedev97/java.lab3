/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rsatu.medvedev.generic.factory;

/**
 *
 * @author emedvedev
 */
public class BaseClass {
    
    @Logged
    public String mA(String a) {
        System.out.println(a);
        return "mA - " + a;
    }
    
    public String mB(String b) {
        System.out.println(b);
        return "mB - " + b;
    }
    
}
