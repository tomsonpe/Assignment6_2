package com.assignment_6_2.services;

import android.content.Intent;
import android.test.AndroidTestCase;

import com.assignment_6_2.appConfig.util.App;
import com.assignment_6_2.domain.customer.GraduationCeremony;
import com.assignment_6_2.factory.customerFactory.GraduationCerFactory;
import com.assignment_6_2.repositories.repository.customer.GraduationRepository;
import com.assignment_6_2.repositories.repositoryImplem.customer.GraduationRepositoryImplem;
import com.assignment_6_2.services.serviceImplementation.GraduationCeremonyServiceImplem;

import junit.framework.Assert;

import java.util.List;
import java.util.Set;

/**
 * Created by Phinda Encore Tomson on 2016/05/08.
 */
public class GraduationCeremonyServiceTest extends AndroidTestCase{
    private GraduationCeremonyService service;
    private GraduationRepository repo;
    private GraduationCeremony graduation;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        repo = new GraduationRepositoryImplem(this.getContext());
    }

    public void testAddCredit() throws Exception{
        Long id;
        Intent intent = new Intent(App.getContext(), GraduationCeremonyService.class);
        GraduationCeremonyService fun = new GraduationCeremonyServiceImplem();

        GraduationCeremony grad = new GraduationCeremony.Builder()
                .name("Encore")
                .no("200")
                .build();

        fun.addGrad(App.getContext(), grad);
        App.getContext().startService(intent);
        id = grad.getId();

        Assert.assertNotNull("CREATE",grad);;
    }
}
