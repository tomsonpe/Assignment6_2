package com.assignment_6_2.factory.employeesFactory;


import com.assignment_6_2.domain.employees.Videos;

/**
 * Created by Phinda Encore Tomson on 4/17/2016.
 */
public class VideoFactory {
    public static VideoFactory video=null;
    public VideoFactory(){
    }

    public static VideoFactory getInstance(){
        if(video==null){
            video=new VideoFactory();
        }
        return video;
    }
    public static Videos getVideo(String vEditorFirstName,String vEditorLastName){
        Videos myVideo=new Videos.Builder()
                .first(vEditorFirstName)
                .last(vEditorLastName)
                .build();
        return myVideo;
    }
}