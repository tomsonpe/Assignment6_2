package com.assignment_6_2.factory;



import android.test.AndroidTestCase;

import com.assignment_6_2.domain.employees.PhotoEditor;
import com.assignment_6_2.factory.employeesFactory.PhotoEditorFactory;

import junit.framework.Assert;

/**
 * Created by Phinda Encore Tomson on 2016/04/07.
 */
public class TestPhotoEditor extends AndroidTestCase {
    private PhotoEditorFactory factory;

    public void setUp()
    {
        factory= PhotoEditorFactory.getInstance();
    }

    public void testPhotoCreation() throws  Exception
    {
        PhotoEditor edit=factory.getEdit("Encore","Tomson");

        Assert.assertEquals("Encore",edit.getFirstName());
        Assert.assertEquals("Tomson",edit.getLastName());

        PhotoEditor updatePhoto=new PhotoEditor.Builder().copy(edit).first("Encore").build();

        Assert.assertEquals(updatePhoto.getFirstName(), edit.getFirstName());
        Assert.assertEquals(updatePhoto.getLastName(), edit.getLastName());
    }
}
