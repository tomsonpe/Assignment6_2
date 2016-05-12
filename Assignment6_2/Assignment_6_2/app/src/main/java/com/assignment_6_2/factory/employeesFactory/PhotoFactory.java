package com.assignment_6_2.factory.employeesFactory;

import com.assignment_6_2.domain.employees.Photos;

/**
 * Created by Phinda Encore Tomson on 4/17/2016.
 */
public class PhotoFactory {
    public static PhotoFactory photo=null;
    public PhotoFactory(){
    }
    public static PhotoFactory getInstance(){
        if(photo==null){
            photo=new PhotoFactory();
        }
        return photo;
    }
    public static Photos getPhoto(String cameramanFirstName,String cameramanLastName){
        Photos myphoto=new Photos.Builder()
                .first(cameramanFirstName)
                .last(cameramanLastName)
                .build();
        return myphoto;
    }
}
