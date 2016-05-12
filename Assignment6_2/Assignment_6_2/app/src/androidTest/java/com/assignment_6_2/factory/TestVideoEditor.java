package com.assignment_6_2.factory;



import android.test.AndroidTestCase;

import com.assignment_6_2.domain.employees.VideoEditor;
import com.assignment_6_2.factory.employeesFactory.VideoEditorFactory;

import junit.framework.Assert;
/**
 * Created by Phinda Encore Tomson on 2016/04/07.
 */
public class TestVideoEditor extends AndroidTestCase{
    private VideoEditorFactory factory;

    public void setUp()
    {
        factory= VideoEditorFactory.getInstance();
    }


    public void testVideoEditor()
    {
        VideoEditor edit=factory.getEdit("Encore","Tomson");

        Assert.assertEquals("Encore",edit.getFirstName());
        Assert.assertEquals("Tomson",edit.getLastName());

        VideoEditor update=new VideoEditor.Builder().copy(edit).first("Encore").build();
        Assert.assertEquals(update.getFirstName(), edit.getFirstName());
        Assert.assertEquals(update.getLastName(), edit.getLastName());
    }
}
