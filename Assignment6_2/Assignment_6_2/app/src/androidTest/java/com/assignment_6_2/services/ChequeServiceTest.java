package com.assignment_6_2.services;

import android.content.Intent;
import android.test.AndroidTestCase;

import com.assignment_6_2.appConfig.util.App;
import com.assignment_6_2.domain.payment.Cheque;
import com.assignment_6_2.factory.paymentFactory.ChequeFactory;
import com.assignment_6_2.repositories.repository.payments.ChequeRepository;
import com.assignment_6_2.repositories.repositoryImplem.payments.ChequeRepositoryImplem;
import com.assignment_6_2.services.serviceImplementation.ChequeServiceImplem;

import junit.framework.Assert;

import java.util.List;
import java.util.Set;

/**
 * Created by Phinda Encore Tomson on 2016/05/07.
 */
public class ChequeServiceTest extends AndroidTestCase {
    private CashService service;
    private ChequeRepository repo;
    private Cheque cheque;


    @Override
    public void setUp() throws Exception {
        super.setUp();
         repo = new ChequeRepositoryImplem(this.getContext());
    }

    public void testAddCash() throws Exception{
        Long id;
        Intent intent = new Intent(App.getContext(), ChequeServiceImplem.class);
        ChequeService cash = new ChequeServiceImplem();

        Cheque cheque1 = new Cheque.Builder()
                .name("Encore")
                .no("200")
                .build();

        cash.addCheque(App.getContext(), cheque1);
        App.getContext().startService(intent);
        id = cheque1.getId();

        Assert.assertNotNull("CREATE",cheque1);
    }
}
