/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rsatu.medvedev.generic.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author emedvedev
 */
public class ChildClass extends BaseClass {

    @Override
    public String mA(String b) {
        Logger logger = LogManager.getLogger(this);
        logger.info(" Start!");
        System.out.println(b);
        String ret = "mA - " + b;
        logger.info(" Stop!");
        return ret;
    }

}
