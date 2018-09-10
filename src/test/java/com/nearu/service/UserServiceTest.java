package com.nearu.service;

import com.nearu.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserServiceTest {

    private final UserService userService;

    public UserServiceTest() {
        userService = new UserService();
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void createUser() throws Exception {
        long id = 1;
        User user = userService.getUserById(id);
        Assert.assertNotNull(user);
    }

    @Test
    public void writeOffUser() throws Exception {
        long id = 1;
        User user = new User();
        boolean ret = userService.writeOffUser();
        Assert.assertTrue(ret);
    }

    @Test
    public void updateUserInfo() throws Exception {
        long id = 1;
        User user = new User();
        boolean ret = userService.updateUserInfo();
        Assert.assertTrue(ret);
    }

    @Test
    public void getUserById() throws Exception {
        User user = userService.getUserById(1);
        Assert.assertNotNull(user);
    }

    @Test
    public void getUsersByKeys() throws Exception {
        List<User> userList = userService.getUsersByKeys(null);
        Assert.assertEquals(1, userList.size());
    }

    /*ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();


    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final UserServiceTest test = new UserServiceTest();


        test.set();
        System.out.println(test.getLong());
        System.out.println(test.getString());


        Thread thread1 = new Thread(){
            public void run() {
                test.set();
                System.out.println(test.getLong());
                System.out.println(test.getString());
            };
        };
        thread1.start();
        thread1.join();

        System.out.println(test.getLong());
        System.out.println(test.getString());
    }*/

}