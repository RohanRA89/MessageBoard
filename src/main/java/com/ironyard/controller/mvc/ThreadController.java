package com.ironyard.controller;

import com.ironyard.data.Thread;
import com.ironyard.repo.ThreadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by rohanayub on 2/9/17.
 */
@Controller
public class ThreadController {
    @Autowired
    private ThreadRepo userThreadRepo;

    @RequestMapping(path ="/secure/threadView/createThread",method=RequestMethod.GET)
    public String createThread(Model data, @RequestParam (name = "nameOfThread") String threadName,
                               @RequestParam (name ="fullDescription" ) String threadDescription) {

        Thread createdThread = new Thread();
        createdThread.setThreadName(threadName);
        createdThread.setThreadDescription(threadDescription);
        userThreadRepo.save(createdThread);
        return "redirect:/secure/threadView";
    }





    @RequestMapping(path = "/secure/threadView")
    public String listThreads(@RequestParam(value = "page", required = false)Integer page,
                              @RequestParam(value = "size", required = false)Integer size, Model data) {
        String destination = "home";
        if(page == null){
            page = 0;
        }
        if(size ==null){
            size = 3;
        }
        Sort s = new Sort(Sort.Direction.DESC,"threadName");
        PageRequest pr = new PageRequest(page,size,s);
        Page<Thread> threadView = userThreadRepo.findAll(pr);

        data.addAttribute("threadList", threadView);
        return destination;
    }
}
