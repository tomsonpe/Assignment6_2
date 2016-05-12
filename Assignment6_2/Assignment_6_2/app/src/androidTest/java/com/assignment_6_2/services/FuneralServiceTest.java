package com.assignment_6_2.services;

import android.content.Intent;
import android.test.AndroidTestCase;

import com.assignment_6_2.appConfig.util.App;
import com.assignment_6_2.domain.customer.Funerals;
import com.assignment_6_2.factory.customerFactory.FuneralFactory;
import com.assignment_6_2.repositories.repository.customer.FuneralRepository;
import com.assignment_6_2.repositories.repositoryImplem.customer.FuneralRepositoryImplem;
import com.assignment_6_2.services.serviceImplementation.FuneralServiceImplem;

import junit.framework.Assert;

import java.util.List;
import java.util.Set;

/**
 * Created by Phinda Encore Tomson on 2016/05/07.
 */
public class FuneralServiceTest extends AndroidTestCase {
    private FuneralService service;
    private FuneralRepository repo;
    private Funerals funerals;


    @Override
    public void setUp() throws Exception {
        super.setUp();
        repo = new FuneralRepositoryImplem(this.getContext());
    }

    public void testAddCredit() throws Exception{
        Long id;
        Intent intent = new Intent(App.getContext(), FuneralServiceImplem.class);
       FuneralService fun = new FuneralServiceImplem();

        Funerals funeral = new Funerals.Builder()
                .name("Encore")
                .no("200")
                .build();

        fun.addFunerals(App.getContext(), funeral);
        App.getContext().startService(intent);
        id = funeral.getId();

        Assert.assertNotNull("CREATE",funeral);;
    }
}
