package com.assignment_6_2.services.serviceImplementation;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.assignment_6_2.appConfig.util.App;
import com.assignment_6_2.domain.employees.PhotoEditor;
import com.assignment_6_2.repositories.repository.employees.PhotoEditorRepository;
import com.assignment_6_2.repositories.repositoryImplem.employees.PhotoEditorRepositoryImplem;
import com.assignment_6_2.services.PhotoEditorService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/05/07.
 */
public class PhotoEditorServiceImplem extends IntentService implements PhotoEditorService {
    private PhotoEditorRepository repo;
    private static  PhotoEditorServiceImplem service = null;


    private static final String ACTION_ADD ="package com.assignment_6_2.services.serviceImplementation.action.ADD";
    private static final String ACTION_UPDATE="package com.assignment_6_2.services.serviceImplementation.action.Update";

    private static final String EXTRA_ADD = "package com.assignment_6_2.services.serviceImplementation.extra.ADD";

    public PhotoEditorServiceImplem() {
        super("FuneralServiceImplem");
        repo = new PhotoEditorRepositoryImplem(App.getContext());
    }

    private static PhotoEditorServiceImplem getInstance(){
        if(service == null)
            service = new PhotoEditorServiceImplem();
        return service;
    }

    @Override
    public void addPhotoEditor(Context context,PhotoEditor pEditor){
        Intent intent = new Intent(context,PhotoEditorServiceImplem.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD,pEditor);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent){

        PhotoEditor gradResources = (PhotoEditor)intent.getSerializableExtra(EXTRA_ADD);
        PhotoEditor grad = new PhotoEditor.Builder()
                .first(gradResources.getFirstName())
                .last(gradResources.getLastName())
                .build();
        try {
            repo.save(grad);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Toast.makeText(getApplicationContext(), "Customer has been added", Toast.LENGTH_LONG).show();
    }
}
