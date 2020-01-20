/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rsatu.medvedev.generic;

import ru.rsatu.medvedev.generic.factory.TestFactory;
import ru.rsatu.medvedev.generic.factory.BaseClass;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import ru.rsatu.medvedev.generic.factory.ChildClass;

/**
 *
 * @author emedvedev
 */
public class App {

    /**
     * @param args the command line arguments
     * @throws java.io.UnsupportedEncodingException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws java.lang.NoSuchMethodException
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.reflect.InvocationTargetException
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws UnsupportedEncodingException, InstantiationException, IllegalAccessException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        // TODO code application logic here
        /*
        MyClassLoader loader1 = new MyClassLoader();
        MyClassLoader loader2 = new MyClassLoader();
        
        Class cl1 = loader1.findClass("ru.rsatu.medvedev.classloaders.MyClass");
        Class cl2 = loader2.findClass("ru.rsatu.medvedev.classloaders.MyClass");

        MyInterface<String> ci1 =  (MyInterface) cl2.newInstance();
        MyInterface<Integer> ci2 =  (MyInterface) cl2.newInstance();
        ci1.set("Test");
        ci2.set(123);
        System.out.println(ci1.get() + "  " + ci2.get());
        TestClass tc = ci1.getValue(TestClass.class);
        System.out.println(tc.getS());
         */
        TestFactory tf = new TestFactory();
        BaseClass bc = tf.make(BaseClass.class);
        System.out.println(bc.mA("it's A"));
        System.out.println(bc.mB("it's B"));

        System.out.println("Class name - " + bc.getClass().getName());
        System.out.println("Super class name - " + bc.getClass().getSuperclass().getName());
        System.out.println(bc.getClass().toGenericString().getBytes().length);
        System.out.println(BaseClass.class.toGenericString().getBytes().length);
        
        System.out.println("Базовый класс");
        
        for (byte b: BaseClass.class.toGenericString().getBytes()) {
            System.out.print(b);
        }
        
        System.out.println("\n Наследник через фабрику");
        
        for (byte b: bc.getClass().toGenericString().getBytes()) {
            System.out.print(b);
        }
        
        System.out.println("\n Просто наследник");
        
        for (byte b: ChildClass.class.toGenericString().getBytes()) {
            System.out.print(b);
        }
        
        System.out.println();
        
        ChildClass cl = new ChildClass();
        System.out.println(cl.mA("it's A"));

        /*
        Info info = new Info();
        String out = info.getAllInfo(cl1);
        System.out.println("Class 1 info:");
        System.out.println(out);
        out = info.getAllInfo(cl2);
        System.out.println("Class 2 info:");
        System.out.println(out);
         */
    }

}
