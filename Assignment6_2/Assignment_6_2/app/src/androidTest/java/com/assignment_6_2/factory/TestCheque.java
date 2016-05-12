package com.assignment_6_2.factory;



import android.test.AndroidTestCase;

import com.assignment_6_2.domain.payment.Cheque;
import com.assignment_6_2.factory.paymentFactory.ChequeFactory;

import junit.framework.Assert;
/**
 * Created by Phinda Encore Tomson on 2016/04/07.
 */

public class TestCheque extends AndroidTestCase {
    private ChequeFactory factory;

    public void setUp()
    {
        factory= ChequeFactory.getInstance();
    }


    public void testCreation()
    {
        Cheque cheque=factory.getCheque("4151D", "Encore");

        Assert.assertEquals("4151D",cheque.getNumber());
        Assert.assertEquals("Encore",cheque.getName());

        Cheque update=new Cheque.Builder().copy(cheque).no("4151D").build();
        Assert.assertEquals(update.getNumber(),cheque.getNumber());
        Assert.assertEquals(update.getName(), cheque.getName());
    }
}
