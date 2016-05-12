package com.assignment_6_2.services;

import android.content.Intent;
import android.test.AndroidTestCase;

import com.assignment_6_2.appConfig.util.App;
import com.assignment_6_2.domain.employees.PhotoEditor;
import com.assignment_6_2.factory.employeesFactory.PhotoEditorFactory;
import com.assignment_6_2.repositories.repository.employees.PhotoEditorRepository;
import com.assignment_6_2.repositories.repositoryImplem.employees.PhotoEditorRepositoryImplem;
import com.assignment_6_2.services.serviceImplementation.PhotoEditorServiceImplem;

import junit.framework.Assert;

import java.util.List;
import java.util.Set;

/**
 * Created by Phinda Encore Tomson on 2016/05/07.
 */
public class PhotoEditorServiceTest extends AndroidTestCase {
    private PhotoEditorService service;
    private PhotoEditorRepository repo;
    private PhotoEditor pEditor;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        repo = new PhotoEditorRepositoryImplem(this.getContext());
    }

    public void testAddCredit() throws Exception {
        Long id;
        Intent intent = new Intent(App.getContext(), GraduationCeremonyService.class);
        PhotoEditorService fun = new PhotoEditorServiceImplem();

        PhotoEditor pEditor = new PhotoEditor.Builder()
                .first("Encore")
                .last("Tomson")
                .build();

        fun.addPhotoEditor(App.getContext(), pEditor);
        App.getContext().startService(intent);
        id = pEditor.getId();

        Assert.assertNotNull("CREATE",pEditor);;

    }
}
