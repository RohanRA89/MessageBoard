package com.ironyard.controller.rest;

import com.ironyard.data.MsgBoardUser;
import com.ironyard.repo.MsgUserRepo;
import com.ironyard.secure.TokenCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by rohanayub on 3/2/17.
 */
@RestController
public class RestUserController {
    @Autowired
    private MsgUserRepo storedUserRepo;
    //Does not work yet.
    @RequestMapping (path = "/users/createUser", method = RequestMethod.POST)
    public MsgBoardUser createUser(@RequestBody MsgBoardUser saveToDB)
    {
        storedUserRepo.save(saveToDB);
        return saveToDB;
    }

    @RequestMapping (path="/users/generateKey/{userID}",method = RequestMethod.POST)
    public String createKey(@PathVariable Long userID) throws Exception {
        MsgBoardUser foundUser = storedUserRepo.findOne(userID);

        TokenCheck tc = new TokenCheck();
        String generatedToken = tc.generateToken(foundUser);
        String generatedMessage = "Your key was generated. You will need this value for 'x-authorization-key' " +
                "on the Post Controller API:\n" + generatedToken;
        return generatedMessage;

    }


}
