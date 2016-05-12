package com.assignment_6_2.factory;



import android.test.AndroidTestCase;

import com.assignment_6_2.domain.customer.GraduationCeremony;
import com.assignment_6_2.factory.customerFactory.GraduationCerFactory;

import junit.framework.Assert;
/**
 * Created by Phinda Encore Tomson on 2016/04/07.
 */
public class TestGraduation extends AndroidTestCase{
    private GraduationCerFactory factory;

    public void setUp()
    {
        factory= GraduationCerFactory.getInstance();
    }


    public void testCreation()
    {
        GraduationCeremony grad=factory.getCeremony("1452","BDP");
        Assert.assertEquals("1452", grad.getNo());
        Assert.assertEquals("BDP", grad.getName());

        GraduationCeremony update=new GraduationCeremony.Builder().copy(grad).no("1452").build();
        Assert.assertEquals(update.getNo(), grad.getNo());
        Assert.assertEquals(update.getName(), grad.getName());
    }
}
