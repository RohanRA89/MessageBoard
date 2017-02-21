package com.ironyard.controller.mvc;

import com.ironyard.data.MsgBoardUser;
import com.ironyard.repo.MsgUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by rohanayub on 2/9/17.
 */
@Controller
public class MsgBoardUserController {
    @Autowired
    private MsgUserRepo storedUserRepo;

    @Value("${upload.location}")
    private String uploadLocation;



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

@RequestMapping(path="/secure/user/delete")
    String deleteUser(@RequestParam Long id){
       MsgBoardUser found = storedUserRepo.findOne(id);
       storedUserRepo.delete(found);
       return "redirect:/secure/users";

}

@RequestMapping(path="/secure/user/select")
 String selectUser(@RequestParam Long id, Model data){
        MsgBoardUser found = storedUserRepo.findOne(id);
        String name = found.getName();
        String displayName = found.getDisplayName();
        String password = found.getPassword();
//        String profileFileName = found.getProfilePicture();
//        if(found.getProfilePicture() == null){
//            profileFileName = "user_blank.png";
//        }
        Long userID = found.getId();
        data.addAttribute("name",name);
        data.addAttribute("displayName",displayName);
        data.addAttribute("password",password);
        data.addAttribute("userID",userID);
        return "/secure/editUser";
}
@RequestMapping(path="/secure/editUser/update")
    String updateUser(@RequestParam String name, @RequestParam String displayName, @RequestParam String password,
                      @RequestParam MultipartFile userImage, @RequestParam Long id){
     MsgBoardUser found = storedUserRepo.findOne(id);
     found.setName(name);
     found.setDisplayName(displayName);
     found.setPassword(password);

     if(!userImage.getOriginalFilename().isEmpty()){
        String uploadedFileName = System.currentTimeMillis()+"_"+ userImage.getOriginalFilename();

        try {
            Files.copy(userImage.getInputStream(), Paths.get(uploadLocation + uploadedFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
       found.setProfileFileName(uploadedFileName);
    }


     storedUserRepo.save(found);
     return "redirect:/secure/users";


}

@RequestMapping(path="/secure/users")
    String showAllUsers(Model data){
        String destination = "users";
        Iterable found = storedUserRepo.findAll();
        data.addAttribute("listUsers",found);
        return destination;
}
@RequestMapping(path="/secure/logout")
    String logOutUser(HttpSession session){
        session.invalidate();
        return "redirect:/open/login.jsp";
}

}
