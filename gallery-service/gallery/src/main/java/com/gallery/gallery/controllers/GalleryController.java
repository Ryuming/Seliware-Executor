package com.gallery.gallery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gallery.gallery.entities.Gallery;

@RestController
@RequestMapping("/api/gallery")
public class GalleryController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment env;

    @RequestMapping("/")
    public String home()
    {
        return "Hello from Gallery Service running at port: " + env.getProperty("local.server.port");

    }

    @RequestMapping("/{id}")  
   public Gallery getGallery(@PathVariable final int id) {  
      // create gallery object  
  Gallery gallery = new Gallery();  
      gallery.setId(id);  

      // get list of available images   
 @SuppressWarnings("unchecked")
List<Object> images = restTemplate.getForObject("http://image-service/api/image/images", List.class);  
      gallery.setImages(images);  

      return gallery;  
   }  

   // -------- Admin Area --------  
 // This method should only be accessed by users with role of 'admin' // We'll add the logic of role based auth later  @RequestMapping("/admin")  
   public String homeAdmin() {  
      return "This is the admin area of Gallery service running at port: " + env.getProperty("local.server.port");  
   }  
   
}
