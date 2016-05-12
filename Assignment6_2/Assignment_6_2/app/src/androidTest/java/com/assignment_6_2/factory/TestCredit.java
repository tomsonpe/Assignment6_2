package com.assignment_6_2.factory;

import android.test.AndroidTestCase;

import com.assignment_6_2.domain.payment.Credit;
import com.assignment_6_2.factory.paymentFactory.CreditFactory;

import junit.framework.Assert;


/**
 * Created by Phinda Encore Tomson on 2016/04/07.
 */
public class TestCredit extends AndroidTestCase {
    private CreditFactory factory;
    private Credit credit;
    public void setUp()
    {
        factory= CreditFactory.getInstance();
    }

    public void testCreation()
    {
        credit=factory.getCredit("4554555","Encore");

        Assert.assertEquals("4554555",credit.getNumber());
        Assert.assertEquals("Encore",credit.getName());

        Credit update=new Credit.Builder().copy(credit).no("4554555").build();
        Assert.assertEquals(update.getNumber(),credit.getNumber());
        Assert.assertEquals(update.getName(), credit.getName());
    }
}
