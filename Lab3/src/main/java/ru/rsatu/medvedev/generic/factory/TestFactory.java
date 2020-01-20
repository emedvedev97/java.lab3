/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rsatu.medvedev.generic.factory;

import java.lang.reflect.Method;
import javassist.util.proxy.MethodFilter;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author emedvedev
 */
public class TestFactory {

    public <K> K make(Class<K> o) throws InstantiationException, IllegalAccessException {
        ProxyFactory f = new ProxyFactory();
        f.setSuperclass(o);
        f.setFilter(new MyFilter());
        Class<K> c = f.createClass();
        K k = c.newInstance();
        ((ProxyObject) k).setHandler(new MyHandler());
        return k;
    }

    private class MyFilter implements MethodFilter {

        @Override
        public boolean isHandled(Method method) {
            Logged ld = method.getAnnotation(Logged.class);
            return ld != null;
        }

    }

    private class MyHandler implements MethodHandler {

        @Override
        public Object invoke(Object self, Method m, Method proceed,
                Object[] args) throws Throwable {
            Logger logger = LogManager.getLogger(self.getClass().getSuperclass());
            logger.info(m.getName() + " Start!");
            Object invokk = proceed.invoke(self, args);
            logger.info(m.getName() + " Stop!");
            return invokk;
        }

    }

}
