package com.image.image.controllers;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.image.image.entities.Image;

@RestController
@RequestMapping("/api/image")
public class HomeController {
    @Autowired
    private Environment env;

    @RequestMapping("/")
    public String home()
    {
        return "Hello from Image Service running at port: " + env.getProperty("local.server.port");  
    }

    @RequestMapping("/images")
    public ResponseEntity<List<Image>> getImage()
    {
        List<Image> images = Arrays.asList(
            new Image(1, "Treehouse of Horror V", "https://www.imdb.com/title/tt0096697/mediaviewer/rm3842005760"),
            new Image(2, "The Town", "https://www.imdb.com/title/tt0096697/mediaviewer/rm3698134272"),
            new Image(3, "The Last Traction Hero", "https://www.imdb.com/title/tt0096697/mediaviewer/rm1445594112")
        );
        return new ResponseEntity<>(images, HttpStatus.OK);
    }
}
