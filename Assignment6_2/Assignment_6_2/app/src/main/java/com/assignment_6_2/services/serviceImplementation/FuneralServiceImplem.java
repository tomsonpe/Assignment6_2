package com.assignment_6_2.services.serviceImplementation;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.assignment_6_2.appConfig.util.App;
import com.assignment_6_2.domain.customer.Funerals;
import com.assignment_6_2.repositories.repository.customer.FuneralRepository;
import com.assignment_6_2.repositories.repositoryImplem.customer.FuneralRepositoryImplem;
import com.assignment_6_2.services.FuneralService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/05/07.
 */
public class FuneralServiceImplem extends IntentService implements FuneralService {
    private final FuneralRepository repo;
    private static  FuneralServiceImplem service = null;


    private static final String ACTION_ADD ="package com.assignment_6_2.services.serviceImplementation.action.ADD";
    private static final String ACTION_UPDATE="package com.assignment_6_2.services.serviceImplementation.action.Update";

    private static final String EXTRA_ADD = "package com.assignment_6_2.services.serviceImplementation.extra.ADD";

    public FuneralServiceImplem() {
        super("FuneralServiceImplem");
        repo = new FuneralRepositoryImplem(App.getContext());
    }

    private static FuneralServiceImplem getInstance(){
        if(service == null)
            service = new FuneralServiceImplem();
        return service;
    }

    @Override
    public void addFunerals(Context context,Funerals funerals){
        Intent intent = new Intent(context,CashServiceImplem.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD,funerals);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent){

        Funerals chequeResources = (Funerals)intent.getSerializableExtra(EXTRA_ADD);
        Funerals credit = new Funerals.Builder()
                .no(chequeResources.getNo())
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
