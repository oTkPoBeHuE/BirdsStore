package services;

import exceptions.UserException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by oTk on 29.11.2016.
 */
public class UserServiceTest {


    static String incorrectUsername = "1#@%";
    static String correctUsername = "user1";
    static String correctPassword = "password";
    static String incorrectPassword = "";


    @Test
    @Before
    public void clear(){
        UserService.clear();
    }

    @Test
    public void addUserCorrect() throws Exception {
        UserService.addUser(correctUsername, correctPassword);
        assertEquals(1,UserService.size());
    }

    @Test(expected = UserException.class)
    public void addUserIncorrect() throws Exception {
        UserService.clear();
        UserService.addUser(incorrectUsername, correctPassword);
    }

    @Test(expected = UserException.class)
    public void addPasswordIncorrect() throws Exception {
        UserService.addUser(correctUsername, incorrectPassword );
    }

    @Test(expected = UserException.class)
    public void addUserNull() throws Exception {
        UserService.addUser(null, correctPassword);
    }

    @Test(expected = UserException.class)
    public void addPasswordNull() throws Exception {
        UserService.addUser(correctUsername, null);
    }

    @Test
    public void size() throws Exception {
        int count = 4242;
        for(int i = 0; i < count; i++){
            UserService.addUser(correctUsername + i, correctPassword);
        }
        assertEquals(count,UserService.size());
    }



}