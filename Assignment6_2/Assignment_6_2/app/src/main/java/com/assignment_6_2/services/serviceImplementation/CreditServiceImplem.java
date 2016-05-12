package com.assignment_6_2.services.serviceImplementation;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.assignment_6_2.appConfig.util.App;
import com.assignment_6_2.domain.payment.Credit;
import com.assignment_6_2.repositories.repository.payments.ChequeRepository;
import com.assignment_6_2.repositories.repository.payments.CreditRepository;
import com.assignment_6_2.repositories.repositoryImplem.payments.CreditRepositoryimplem;
import com.assignment_6_2.services.CreditService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/05/07.
 */
public class CreditServiceImplem extends IntentService implements CreditService {

    private final CreditRepository repo;
    private static  CreditServiceImplem service = null;


    private static final String ACTION_ADD ="package com.assignment_6_2.services.serviceImplementation.action.ADD";
    private static final String ACTION_UPDATE="package com.assignment_6_2.services.serviceImplementation.action.Update";

    private static final String EXTRA_ADD = "package com.assignment_6_2.services.serviceImplementation.extra.ADD";

    public CreditServiceImplem() {
        super("CashServiceImplem");
        repo = new CreditRepositoryimplem(App.getContext());
    }

    private static CreditServiceImplem getInstance(){
        if(service == null)
            service = new CreditServiceImplem();
        return service;
    }

    @Override
    public void addCredit(Context context,Credit credit){
        Intent intent = new Intent(context,CashServiceImplem.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD,credit);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent){

        Credit chequeResources = (Credit)intent.getSerializableExtra(EXTRA_ADD);
        Credit credit = new Credit.Builder()
                .id(chequeResources.getId())
                .no(chequeResources.getNumber())
                .name(chequeResources.getName())
                .build();
        try {
            repo.save(credit);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Toast.makeText(getApplicationContext(), "Customer has been added", Toast.LENGTH_LONG).show();
    }
}
