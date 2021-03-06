package com.javarush.test.level37.lesson04.big01.male;

import com.javarush.test.level37.lesson04.big01.AbstractFactory;
import com.javarush.test.level37.lesson04.big01.Human;


/**
 * Created by alexandr on 28.01.16.
 */
public class MaleFactory implements AbstractFactory
{
    public Human getPerson(int age){
       if (age <= KidBoy.MAX_AGE){
           return new KidBoy();
       }else if(age<= TeenBoy.MAX_AGE){
           return new TeenBoy();
       }else return new Man();
    }
}
