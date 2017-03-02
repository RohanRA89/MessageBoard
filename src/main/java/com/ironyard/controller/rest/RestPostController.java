package com.ironyard.controller.rest;

import com.ironyard.data.MsgBoardUser;
import com.ironyard.data.Permissions;
import com.ironyard.data.Post;
import com.ironyard.repo.MsgUserRepo;
import com.ironyard.repo.PostRepo;
import com.ironyard.secure.TokenCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by rohanayub on 2/13/17.
 */
@RestController
public class RestPostController {
    @Autowired
    private PostRepo userPostRepo;
    @Autowired
    private MsgUserRepo storedUserRepo;



@RequestMapping (path = "/rest/getPost/{id}", method = RequestMethod.GET)
public Post getPost (@PathVariable Long id) throws Exception{
    Post foundById = userPostRepo.findOne(id);
    return foundById;
}
@RequestMapping (path  = "/rest/deletePost/{postID}/{userID}", method = RequestMethod.DELETE)
public String deletePost (@PathVariable Long postID, @PathVariable Long userID)throws Exception{
    Long returnedPost = null;
    String message = null;
    MsgBoardUser usr = storedUserRepo.findOne(userID);
    Post found = userPostRepo.findOne(postID);
    if(usr.getPermissions().stream().anyMatch(p -> (p.getKey().equals(Permissions.KEY_PERM_DELETE_POST)))){
        userPostRepo.delete(found);
        returnedPost = found.getId();
        message = "Successfully deleted post with ID "+returnedPost+"!";
        return message;
    }
    returnedPost = found.getId();
    message = "You do not have the appropriate permission to delete posts. Failed to delete post with ID "+returnedPost+".";

    return message;

}

@RequestMapping (path ="/rest/editPost", method = RequestMethod.PATCH)
public Post editPost(@RequestBody Post updateToDB) throws Exception{
    if(updateToDB.getId() == 0){
        throw new Exception("Must specify ID number!");
    }
    userPostRepo.save(updateToDB);
    return updateToDB;
}

@RequestMapping (path="/rest/create/newPost" , method = RequestMethod.POST)
 public Post createPost(@RequestBody Post saveToDB, HttpServletRequest req)

{
//    String token = req.getHeader("x-authorization-key");
//    TokenCheck tc = new TokenCheck();
//    Long postID = tc.getUserIdFromToken(token);
//    Post authorizedPost = userPostRepo.findOne(postID);
//
//    userPostRepo.save(authorizedPost);
//    return authorizedPost;
    userPostRepo.save(saveToDB);
    return saveToDB;

 }
 @RequestMapping (path="/rest/allPosts" , method = RequestMethod.GET)
     public Iterable<Post> retrievePosts(){
     return userPostRepo.findAll();
    }

}
