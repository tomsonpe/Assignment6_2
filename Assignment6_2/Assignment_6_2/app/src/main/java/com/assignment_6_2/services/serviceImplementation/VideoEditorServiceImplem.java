package com.assignment_6_2.services.serviceImplementation;

import com.assignment_6_2.domain.employees.VideoEditor;
import com.assignment_6_2.repositories.repository.employees.VideoEditorRepository;
import com.assignment_6_2.services.VideoEditorService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/05/07.
 */
public class VideoEditorServiceImplem implements VideoEditorService {
    private VideoEditorRepository repo;

    public List<VideoEditor> getAllVideoEditors(){
        List<VideoEditor> allVideoEditor=new ArrayList<VideoEditor>();

        Iterable<VideoEditor> vEditor= null;
        try {
            vEditor = repo.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(VideoEditor vEditor1:vEditor){
            allVideoEditor.add(vEditor1);
        }
        return allVideoEditor;
    }
}
