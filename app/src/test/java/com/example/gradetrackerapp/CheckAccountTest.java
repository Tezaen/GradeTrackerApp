package com.example.gradetrackerapp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckAccountTest {
    String un_test;
    String pw_test;
    String wrong;

    @Before
    public void setup() {
        un_test = "yvonne";
        pw_test = "cruz";
        wrong = "wrong";
    }

    @Test
    public void unTrueTest() {
        System.out.println("Testing checkUsername with username: "+ un_test);
        CheckAccount inputUP = new CheckAccount(un_test, pw_test);
        assertEquals(true, inputUP.checkUsername());
    }

    @Test
    public void unFalseTest(){
        System.out.println("Testing checkUsername with username: "+ wrong);
        CheckAccount inputUP = new CheckAccount(wrong, pw_test);
        assertEquals(false, inputUP.checkUsername());
    }

    @Test
    public void pwTrueTest(){
        System.out.println("Testing checkPassword with password: "+ pw_test);
        CheckAccount inputUP = new CheckAccount(un_test, pw_test);
        assertEquals(true, inputUP.checkPassword());
    }

    @Test
    public void pwFalseTest(){
        System.out.println("Testing checkPassword with password: "+ wrong);
        CheckAccount inputUP = new CheckAccount(un_test, wrong);
        assertEquals(false, inputUP.checkPassword());
    }
}
