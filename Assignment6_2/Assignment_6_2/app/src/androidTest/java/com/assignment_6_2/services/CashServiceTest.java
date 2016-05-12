package com.assignment_6_2.services;

import android.content.Intent;
import android.test.AndroidTestCase;

import com.assignment_6_2.appConfig.util.App;
import com.assignment_6_2.domain.payment.Cash;
import com.assignment_6_2.domain.payment.Cheque;
import com.assignment_6_2.factory.paymentFactory.CashFactory;
import com.assignment_6_2.factory.paymentFactory.ChequeFactory;
import com.assignment_6_2.repositories.repository.payments.CashRepository;
import com.assignment_6_2.repositories.repository.payments.ChequeRepository;
import com.assignment_6_2.repositories.repositoryImplem.payments.CashRepositoryImplem;
import com.assignment_6_2.services.serviceImplementation.CashServiceImplem;

import junit.framework.Assert;

import java.util.List;
import java.util.Set;

/**
 * Created by Phinda Encore Tomson on 2016/05/07.
 */
public class CashServiceTest extends AndroidTestCase {
    private CashService service;
    private CashRepository repo;
    private Cash cash;


    @Override
    public void setUp() throws Exception {
        super.setUp();
        CashRepository repo = new CashRepositoryImplem(this.getContext());
    }

    public void testAddCash() throws Exception{
        Long id;
        Intent intent = new Intent(App.getContext(), CashServiceImplem.class);
        CashService cash = new CashServiceImplem();

        Cash cash1 = new Cash.Builder()
                .name("Encore")
                .amount("200.00")
                .build();

        cash.addCash(App.getContext(), cash1);
        App.getContext().startService(intent);
        id = cash1.getId();

        Assert.assertNotNull("CREATE",cash1);;
    }
}
