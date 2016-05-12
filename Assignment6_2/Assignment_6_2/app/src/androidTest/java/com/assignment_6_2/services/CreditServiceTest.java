package com.assignment_6_2.services;

import android.content.Intent;
import android.test.AndroidTestCase;

import com.assignment_6_2.appConfig.util.App;
import com.assignment_6_2.domain.payment.Credit;
import com.assignment_6_2.factory.paymentFactory.CreditFactory;
import com.assignment_6_2.repositories.repository.payments.CreditRepository;
import com.assignment_6_2.repositories.repositoryImplem.payments.CreditRepositoryimplem;
import com.assignment_6_2.services.CreditService;
import com.assignment_6_2.services.serviceImplementation.CreditServiceImplem;

import junit.framework.Assert;
import java.util.List;
import java.util.Set;

/**
 * Created by Phinda Encore Tomson on 2016/05/07.
 */
public class CreditServiceTest extends AndroidTestCase{
    private CreditService service;
    private CreditRepository repo;
    private Credit credit;


    @Override
    public void setUp() throws Exception {
        super.setUp();
        repo = new CreditRepositoryimplem(this.getContext());
    }

    public void testAddCredit() throws Exception{
        Long id;
        Intent intent = new Intent(App.getContext(), CreditServiceImplem.class);
        CreditService cash = new CreditServiceImplem();

        Credit credit = new Credit.Builder()
                .name("Encore")
                .no("200")
                .build();

        cash.addCredit(App.getContext(), credit);
        App.getContext().startService(intent);
        id = credit.getId();

        Assert.assertNotNull("CREATE",credit);;
    }
}
