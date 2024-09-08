package com.gallery.gallery.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "gallery")
public class Gallery {
    @JsonSerialize(using = ToStringSerializer.class)
    @Id
    private int id;
    private List<Object> images;

    public Integer getId() {  
        return id;  
    }  

    public void setId(Integer id) {  
        this.id = id;  
    }  

    public List<Object> getImages() {  
        return images;  
    }  

    public void setImages(List<Object> images) {  
        this.images = images;  
    }  
    
}
