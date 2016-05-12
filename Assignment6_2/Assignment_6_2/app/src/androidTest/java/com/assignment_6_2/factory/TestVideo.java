package com.assignment_6_2.factory;

import android.test.AndroidTestCase;

import com.assignment_6_2.domain.employees.Videos;
import com.assignment_6_2.factory.employeesFactory.VideoFactory;

import junit.framework.Assert;

/**
 * Created by Phinda Encore Tomson on 2016/04/07.
 */
public class TestVideo extends AndroidTestCase{
    private VideoFactory factory;

    public void setUp()
    {
        factory= VideoFactory.getInstance();
    }


    public void testVideoCreation()
    {
        Videos video=factory.getVideo("Encore", "Tomson");


        Assert.assertEquals("Encore",video.getCameramanFirstName());
        Assert.assertEquals("Tomson",video.getCameramanLastName());

        Videos updatePhoto=new Videos.Builder().copy(video).first("Encore").build();
        Assert.assertEquals(updatePhoto.getCameramanFirstName(), video.getCameramanFirstName());
        Assert.assertEquals(updatePhoto.getCameramanLastName(), video.getCameramanLastName());
    }
}
