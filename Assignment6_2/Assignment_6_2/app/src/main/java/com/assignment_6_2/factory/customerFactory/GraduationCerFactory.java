package com.assignment_6_2.factory.customerFactory;


import com.assignment_6_2.domain.customer.GraduationCeremony;

/**
 * Created by Phinda Encore Tomson on 4/17/2016.
 */
public class GraduationCerFactory {
    public static GraduationCerFactory graduate=null;
    public GraduationCerFactory(){
    }
    public static GraduationCerFactory getInstance(){
        if(graduate==null){
            graduate=new GraduationCerFactory();
        }
        return graduate;
    }
    public static GraduationCeremony getCeremony(String event_id,String event_name){
        GraduationCeremony grad=new GraduationCeremony.Builder()
                .no(event_id)
                .name(event_name)
                .build();
        return grad;
    }
}