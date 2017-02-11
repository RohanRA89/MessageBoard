package com.ironyard.controller;

import com.ironyard.data.MsgBoardUser;
import com.ironyard.repo.MsgUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by rohanayub on 2/9/17.
 */
@Controller
public class MsgBoardUserController {
    @Autowired
    private MsgUserRepo storedUserRepo;

    @RequestMapping(path = "/open/authenticate", method = RequestMethod.POST)
    public String login(HttpSession session, Model data, @RequestParam String displayName,
                        @RequestParam String password){
        MsgBoardUser found = storedUserRepo.findByDisplayNameAndPassword(displayName, password);
        String destinationView = "home";
        if(found == null){

            destinationView = "login";
            data.addAttribute("message", "User/Pass combination not found.");
        }else{
            session.setAttribute ("user", found);
            destinationView = "redirect:/secure/threadView";
        }
        return destinationView;
    }

    @RequestMapping(path="/open/usercreation", method = RequestMethod.GET)
    public String createUser(HttpSession createdUser, Model createdUserData, @RequestParam String name,
                             @RequestParam String password, @RequestParam String displayName){
        MsgBoardUser created = new MsgBoardUser();
        created.setName(name);
        created.setPassword(password);
        created.setDisplayName(displayName);
        storedUserRepo.save(created);
        String loginDestination = "home";
        if(created == null){
            loginDestination = "login";
            createdUserData.addAttribute("accountCreateMessage", "Your account was not created. Make sure to enter information in to all fields");
        }else{
            createdUser.setAttribute("user", created);
            loginDestination = "redirect:/secure/threadView";
        }
        return loginDestination;
    }

//    @RequestMapping(path = "/secure/movies")
//    public String listMovies(Model xyz) {
//        String destination = "home";
//
//
//        Iterable found = movieRepo.findAll();
//
//
//        // put list into model
//        xyz.addAttribute("mList", found);
//
//        // go to jsp
//        return destination;
//    }
}
