package com.assignment_6_2.services.serviceImplementation;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.assignment_6_2.appConfig.util.App;
import com.assignment_6_2.domain.payment.Cheque;
import com.assignment_6_2.repositories.repository.payments.ChequeRepository;
import com.assignment_6_2.repositories.repositoryImplem.payments.ChequeRepositoryImplem;
import com.assignment_6_2.services.ChequeService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/05/07.
 */
public class ChequeServiceImplem extends IntentService implements ChequeService {
    private final ChequeRepository repository;
    private static  ChequeServiceImplem service = null;


    private static final String ACTION_ADD ="package com.assignment_6_2.services.serviceImplementation.action.ADD";
    private static final String ACTION_UPDATE="package com.assignment_6_2.services.serviceImplementation.action.Update";

    private static final String EXTRA_ADD = "package com.assignment_6_2.services.serviceImplementation.extra.ADD";

    public ChequeServiceImplem() {
        super("CashServiceImplem");
        repository = new ChequeRepositoryImplem(App.getContext());
    }

    private static ChequeServiceImplem getInstance(){
        if(service == null)
            service = new ChequeServiceImplem();
        return service;
    }

    @Override
    public void addCheque(Context context,Cheque cheque){
        Intent intent = new Intent(context,CashServiceImplem.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD,cheque);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent){

        Cheque customerResources = (Cheque)intent.getSerializableExtra(EXTRA_ADD);
        Cheque cash = new Cheque.Builder()
                .id(customerResources.getId())
                .no(customerResources.getNumber())
                .name(customerResources.getName())
                .build();
        try {
            repository.save(cash);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Toast.makeText(getApplicationContext(), "Customer has been added", Toast.LENGTH_LONG).show();
    }
}
