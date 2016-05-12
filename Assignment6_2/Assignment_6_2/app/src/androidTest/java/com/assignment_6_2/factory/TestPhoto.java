package com.assignment_6_2.factory;

import android.test.AndroidTestCase;


import com.assignment_6_2.domain.employees.Photos;
import com.assignment_6_2.factory.employeesFactory.PhotoFactory;

import junit.framework.Assert;

/**
 * Created by Phinda Encore Tomson on 2016/04/07.
 */
public class TestPhoto extends AndroidTestCase {
    private PhotoFactory factory;

    public void setUp()
    {
        factory= PhotoFactory.getInstance();
    }


    public void testPhotoCreation()
    {
        Photos photo=factory.getPhoto("Encore","Tomson");

        Assert.assertEquals("Encore",photo.getCameramanFirstName());
        Assert.assertEquals("Tomson",photo.getCameramanLastName());

        Photos updatePhoto=new Photos.Builder().copy(photo).first("Encore").build();

        Assert.assertEquals(updatePhoto.getCameramanFirstName(),photo.getCameramanFirstName());
        Assert.assertEquals(updatePhoto.getCameramanLastName(),photo.getCameramanLastName());
    }
}
