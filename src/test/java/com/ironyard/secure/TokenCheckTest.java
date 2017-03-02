package com.ironyard.secure;

import com.ironyard.data.MsgBoardUser;
import com.ironyard.repo.MsgUserRepo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by rohanayub on 3/2/17.
 */
public class TokenCheckTest {


    @Test
    public void generateToken() throws Exception {
        MsgBoardUser found = new MsgBoardUser();
        found.setName("Test");
        found.setDisplayName("Test");
        found.setPassword("Test");


        TokenCheck tc = new TokenCheck();
        String token = tc.generateToken(found);
        System.out.println(token);

    }

}