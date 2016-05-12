package com.assignment_6_2.services.serviceImplementation;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.assignment_6_2.appConfig.util.App;
import com.assignment_6_2.domain.customer.GraduationCeremony;
import com.assignment_6_2.repositories.repository.customer.GraduationRepository;
import com.assignment_6_2.repositories.repositoryImplem.customer.GraduationRepositoryImplem;
import com.assignment_6_2.services.GraduationCeremonyService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/05/07.
 */
public class GraduationCeremonyServiceImplem extends IntentService implements GraduationCeremonyService {
    private final GraduationRepository repo;
    private static  GraduationCeremonyServiceImplem service = null;


    private static final String ACTION_ADD ="package com.assignment_6_2.services.serviceImplementation.action.ADD";
    private static final String ACTION_UPDATE="package com.assignment_6_2.services.serviceImplementation.action.Update";

    private static final String EXTRA_ADD = "package com.assignment_6_2.services.serviceImplementation.extra.ADD";

    public GraduationCeremonyServiceImplem() {
        super("FuneralServiceImplem");
        repo = new GraduationRepositoryImplem(App.getContext());
    }

    private static GraduationCeremonyServiceImplem getInstance(){
        if(service == null)
            service = new GraduationCeremonyServiceImplem();
        return service;
    }

    @Override
    public void addGrad(Context context,GraduationCeremony grad){
        Intent intent = new Intent(context,CashServiceImplem.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD,grad);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent){

        GraduationCeremony gradResources = (GraduationCeremony)intent.getSerializableExtra(EXTRA_ADD);
        GraduationCeremony grad = new GraduationCeremony.Builder()
                .no(gradResources.getNo())
                .name(gradResources.getName())
                .build();
        try {
            repo.save(grad);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Toast.makeText(getApplicationContext(), "Customer has been added", Toast.LENGTH_LONG).show();
    }
}
