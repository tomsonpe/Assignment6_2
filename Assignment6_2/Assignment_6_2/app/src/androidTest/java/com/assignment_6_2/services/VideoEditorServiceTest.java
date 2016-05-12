package com.assignment_6_2.services;

import android.content.Intent;
import android.test.AndroidTestCase;

import com.assignment_6_2.appConfig.util.App;
import com.assignment_6_2.domain.employees.PhotoEditor;
import com.assignment_6_2.domain.employees.VideoEditor;
import com.assignment_6_2.factory.employeesFactory.VideoEditorFactory;
import com.assignment_6_2.repositories.repository.employees.VideoEditorRepository;
import com.assignment_6_2.repositories.repositoryImplem.employees.VideoEditorRepositoryImplem;
import com.assignment_6_2.services.serviceImplementation.VideoEditorServiceImplem;

import junit.framework.Assert;

import java.util.List;

/**
 * Created by Phinda Encore Tomson on 2016/05/07.
 */
public class VideoEditorServiceTest extends AndroidTestCase {
    private VideoEditorService service;
    private VideoEditorRepository repo;
    private VideoEditor vEditor;

    public void setUp() throws Exception {
        super.setUp();
        repo = new VideoEditorRepositoryImplem(this.getContext());
    }

    public void testAddCredit() throws Exception {
        Long id;
        Intent intent = new Intent(App.getContext(), GraduationCeremonyService.class);
        VideoEditorService vEditor = new VideoEditorServiceImplem();

        PhotoEditor pEditor = new PhotoEditor.Builder()
                .first("Encore")
                .last("Tomson")
                .build();

        vEditor.addPhotoEditor(App.getContext(), pEditor);
        App.getContext().startService(intent);
        id = pEditor.getId();

        Assert.assertNotNull("CREATE", pEditor);;

    }
}
