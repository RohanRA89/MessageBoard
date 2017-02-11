package com.ironyard.controller;

import com.ironyard.repo.ThreadRepo;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String createThread(Model data, @RequestParam String threadName, @RequestParam String threadDescription) {
        Thread createdThread = new Thread(threadName , threadDescription);
        userThreadRepo.save(createdThread);
    }
    return "/secure/threadView";


    }


    @RequestMapping(path = "/secure/threadView")
    public String listThreads(Model data) {
        String destination = "home";

        Iterable threadView = userThreadRepo.findAll();
        data.addAttribute("threadList;", threadView);
        return destination;
    }
}
