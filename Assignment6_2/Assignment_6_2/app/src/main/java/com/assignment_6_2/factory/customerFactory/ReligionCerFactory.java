package com.assignment_6_2.factory.customerFactory;


import com.assignment_6_2.domain.customer.ReligionCeremony;

/**
 * Created by Phinda Encore Tomson on 4/17/2016.
 */
public class ReligionCerFactory {
    public static ReligionCerFactory religion=null;
    public ReligionCerFactory(){
    }
    public static ReligionCerFactory getInstance(){
        if(religion==null){
            religion=new ReligionCerFactory();
        }
        return religion;
    }
    public static ReligionCeremony getReligionCeremony(Long id,String event_name,String eventAddress){
        ReligionCeremony rel=new ReligionCeremony.Builder().id(id)
                .name(event_name)
                .address(eventAddress)
                .build();
        return rel;
    }
}