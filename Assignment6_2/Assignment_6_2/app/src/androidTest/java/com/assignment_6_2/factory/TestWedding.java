package com.assignment_6_2.factory;

import android.test.AndroidTestCase;

import com.assignment_6_2.domain.customer.Weddings;
import com.assignment_6_2.factory.customerFactory.WeddingFactory;

import junit.framework.Assert;

/**
 * Created by Phinda Encore Tomson on 2016/04/07.
 */
public class TestWedding extends AndroidTestCase {
    private WeddingFactory factory;

    public void setUp()
    {
        factory= WeddingFactory.getInstance();
    }


    public void TestCreation()
    {
        Weddings wed=factory.getWedding("PETomson", "24946 katali street 7100");

        Assert.assertEquals("PETomson",wed.getName());
        Assert.assertEquals("24946 katali street 7100",wed.getAddress());

        Weddings update=new Weddings.Builder().copy(wed).name("Encore").build();

        Assert.assertEquals(update.getName(), wed.getName());
        Assert.assertEquals(update.getAddress(), wed.getAddress());
    }
}
