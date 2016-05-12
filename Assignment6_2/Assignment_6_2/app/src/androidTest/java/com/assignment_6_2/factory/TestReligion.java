package com.assignment_6_2.factory;

import android.test.AndroidTestCase;

import com.assignment_6_2.domain.customer.ReligionCeremony;
import com.assignment_6_2.factory.customerFactory.ReligionCerFactory;

import junit.framework.Assert;

/**
 * Created by Phinda Encore Tomson on 2016/04/07.
 */
public class TestReligion extends AndroidTestCase {
    private ReligionCerFactory factory;

    public void setUp()
    {
        factory= ReligionCerFactory.getInstance();
    }
    Long id = 45L;
    public void testReligion() throws Exception{
        ReligionCeremony rel=ReligionCerFactory.getReligionCeremony(id ,"Sisusa","24946");
        Assert.assertEquals("Sisusa", rel.getName());

        ReligionCeremony update=new ReligionCeremony.Builder().copy(rel).name("Sisusa").build();
        Assert.assertEquals(update.getName(), rel.getName());
        Assert.assertEquals(update.getName(), rel.getName());
    }
}
