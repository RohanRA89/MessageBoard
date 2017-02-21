package com.ironyard.controller.mvc;

import com.ironyard.data.MsgBoardUser;
import com.ironyard.data.Post;
import com.ironyard.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by rohanayub on 2/13/17.
 */
@Controller
public class PostController {
    @Autowired
    private PostRepo userPostRepo;


@RequestMapping (path="/secure/postView/createNewPost" , method = RequestMethod.POST)
 public String createPost(Model data, HttpSession session, @RequestParam String postContent, @RequestParam String timeOfPost){


     Post createdPost = new Post();
     createdPost.setPostContent(postContent);
     createdPost.setTimeOfPost(timeOfPost);
    MsgBoardUser poster = (MsgBoardUser) session.getAttribute("user");
    String username = poster.getDisplayName();
     createdPost.setUsernameOfPoster(String.valueOf(username));
     userPostRepo.save(createdPost);

    Iterable showPost = userPostRepo.findAll();
    data.addAttribute("post",showPost);
    return "/secure/createPost";


 }
}
