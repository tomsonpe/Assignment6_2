package com.assignment_6_2.services.serviceImplementation;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.assignment_6_2.appConfig.util.App;
import com.assignment_6_2.domain.payment.Cash;
import com.assignment_6_2.repositories.repository.payments.CashRepository;
import com.assignment_6_2.repositories.repositoryImplem.payments.CashRepositoryImplem;
import com.assignment_6_2.services.CashService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Phinda Encore Tomson on 2016/05/07.
 */
public class CashServiceImplem extends IntentService implements CashService {
    private final CashRepository repository;
    private static  CashServiceImplem service = null;


    private static final String ACTION_ADD ="package com.assignment_6_2.services.serviceImplementation.action.ADD";
    private static final String ACTION_UPDATE="package com.assignment_6_2.services.serviceImplementation.action.Update";

    private static final String EXTRA_ADD = "package com.assignment_6_2.services.serviceImplementation.extra.ADD";

    public CashServiceImplem() {
        super("CashServiceImplem");
        repository = new CashRepositoryImplem(App.getContext());
    }

    private static CashServiceImplem getInstance(){
        if(service == null)
            service = new CashServiceImplem();
        return service;
    }

    @Override
    public void addCash(Context context,Cash cash){
        Intent intent = new Intent(context,CashServiceImplem.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD,cash);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent){

        Cash customerResources = (Cash)intent.getSerializableExtra(EXTRA_ADD);
        Cash cash = new Cash.Builder()
                .id(customerResources.getId())
                .name(customerResources.getName())
                .amount(customerResources.getAmount())
                .build();
        try {
            repository.save(cash);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Toast.makeText(getApplicationContext(),"Customer has been added", Toast.LENGTH_LONG).show();
    }

}
