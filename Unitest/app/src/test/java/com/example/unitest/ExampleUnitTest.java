package com.example.unitest;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void TestRegistrationOne() {
        String login = "";
        String password = "";
        User user = new User(login,password);

        assertEquals(CorrectUser.Correct, user.CanCreateUser(login,password));
    }
    @Test
    public void TestRegistrationTwo() {


        String login = "VeryGoodLogin@mail.ru";
        String password = "PASsword123!@#";
        User user = new User(login,password);

        assertEquals(CorrectUser.Correct, user.CanCreateUser(login,password));
    }
    @Test
    public void TestRegistrationThree() {


        String login = "VeryGoodLogin!@mail.ru";
        String password = "badpas";
        User user = new User(login,password);

        assertEquals(CorrectUser.Correct, user.CanCreateUser(login,password));
    }
    @Test
    public void TestRegistrationFour() {
        String login = "badlog";
        String password = "badpas";
        User user = new User(login,password);

        assertEquals(CorrectUser.Correct, user.CanCreateUser(login,password));
    }
}