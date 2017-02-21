package com.ironyard.controller.rest;

import com.ironyard.data.MsgBoardUser;
import com.ironyard.data.Post;
import com.ironyard.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by rohanayub on 2/13/17.
 */
@RestController
public class RestPostController {
    @Autowired
    private PostRepo userPostRepo;

@RequestMapping (path = "/rest/getPost/{id}", method = RequestMethod.GET)
public Post getPost (@PathVariable Long id) throws Exception{
    Post foundById = userPostRepo.findOne(id);
    return foundById;
}
@RequestMapping (path  = "/rest/deletePost/{id}", method = RequestMethod.DELETE)
public void deletePost (@PathVariable Long id)throws Exception{
    Post found = userPostRepo.findOne(id);
    userPostRepo.delete(found);
    return;

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
 public Post createPost(@RequestBody Post saveToDB)
        //(@RequestParam Post timeOfPost, @RequestParam Post postContent, @PathVariable MsgBoardUser displayName){
//    Post restFound = new Post();
//    restFound.setPostContent(String.valueOf((Post)postContent));
//    restFound.setTimeOfPost(String.valueOf((Post)timeOfPost));
//    restFound.setUsernameOfPoster(String.valueOf((MsgBoardUser)displayName));
//    userPostRepo.save(restFound);
//    return String.valueOf(restFound);
{
    userPostRepo.save(saveToDB);
    return saveToDB;

 }
 @RequestMapping (path="/rest/allPosts" , method = RequestMethod.GET)
     public Iterable<Post> retrievePosts(){
     return userPostRepo.findAll();
    }

}
