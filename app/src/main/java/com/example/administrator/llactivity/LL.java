package com.example.administrator.llactivity;

import android.support.v7.app.AppCompatActivity;

import java.util.UUID;

/**
 * Created by Administrator on 2018/4/14.
 */
public class LL extends AppCompatActivity{
    private UUID Id;
    private String image;
    private String destext;
    private String course;

    public LL(){
        this(UUID.randomUUID());
    }
    public LL(UUID id)
    {
        Id=id;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID mId) {
        this.Id = mId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDestext() {
        return destext;
    }

    public void setDestext(String destext) {
        this.destext = destext;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
