package com.assignment_6_2.factory.employeesFactory;


import com.assignment_6_2.domain.employees.VideoEditor;

/**
 * Created by Phinda Encore Tomson on 4/17/2016.
 */
public class VideoEditorFactory {
    public static VideoEditorFactory editor=null;
    public VideoEditorFactory(){
    }
    public static VideoEditorFactory getInstance(){
        if(editor==null){
            editor=new VideoEditorFactory();
        }
        return editor;
    }
    public static VideoEditor getEdit(String vEditorFirstName,String vEditorLastName){
        VideoEditor myEdit=new VideoEditor.Builder()
                .first(vEditorFirstName)
                .last(vEditorLastName)
                .build();

        return myEdit;
    }
}
