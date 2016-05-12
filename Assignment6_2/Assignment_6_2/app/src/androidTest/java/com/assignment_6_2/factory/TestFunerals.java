package com.assignment_6_2.factory;

import com.assignment_6_2.domain.customer.Funerals;
import com.assignment_6_2.factory.customerFactory.FuneralFactory;

import junit.framework.Assert;

/**
 * Created by Phinda Encore Tomson on 2016/04/07.
 */
public class TestFunerals {
    private FuneralFactory factory;

    public void setUp()
    {
        factory= FuneralFactory.getInstance();
    }

    public void testCreation()
    {
        Funerals fun=factory.getFuneral("45455","Funeral");
        Assert.assertEquals("45455", fun.getNo());
        Assert.assertEquals("Funeral",fun.getName());

        Funerals update=new Funerals.Builder().copy(fun).no("45455").build();
        Assert.assertEquals(update.getNo(), fun.getNo());
        Assert.assertEquals(update.getName(), fun.getName());
    }
}
