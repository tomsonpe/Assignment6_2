package com.assignment_6_2.factory;

import com.assignment_6_2.domain.payment.Cash;
import com.assignment_6_2.factory.paymentFactory.CashFactory;

import junit.framework.Assert;


/**
 * Created by Phinda Encore Tomson on 2016/04/07.
 */
public class TestCash {
    private CashFactory factory;
    private Cash cash;
    public void setUp()
    {
        factory= CashFactory.getInstance();
    }


    public void testCreation() throws Exception
    {
        cash=CashFactory.getCash("Encore");
        Assert.assertEquals("Encore",cash.getName());

        Cash update=new Cash.Builder().copy(cash).name("Encore").build();
        Assert.assertEquals(update.getName(), cash.getName());
    }
}
