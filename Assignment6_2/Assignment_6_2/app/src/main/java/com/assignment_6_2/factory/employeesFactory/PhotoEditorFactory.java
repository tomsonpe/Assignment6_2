package com.assignment_6_2.factory.employeesFactory;


import com.assignment_6_2.domain.employees.PhotoEditor;

/**
 * Created by Phinda Encore Tomson on 4/17/2016.
 */
public class PhotoEditorFactory {
    public static PhotoEditorFactory editor=null;
    public PhotoEditorFactory(){
    }
    public static PhotoEditorFactory getInstance(){
        if(editor==null){
            editor=new PhotoEditorFactory();
        }
        return editor;
    }
    public static PhotoEditor getEdit(String pEditorFirstName,String pEditorLastName){
        PhotoEditor myEdit=new PhotoEditor.Builder()
                .first(pEditorFirstName)
                .last(pEditorLastName)
                .build();

        return myEdit;
    }
}
