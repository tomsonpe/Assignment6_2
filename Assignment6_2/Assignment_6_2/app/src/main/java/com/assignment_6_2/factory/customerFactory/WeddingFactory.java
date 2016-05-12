package com.assignment_6_2.factory.customerFactory;


import com.assignment_6_2.domain.customer.Weddings;

/**
 * Created by Phinda Encore Tomson on 4/17/2016.
 */
public class WeddingFactory {
    public static WeddingFactory wedin=null;
    public WeddingFactory(){
    }
    public static WeddingFactory getInstance(){
        if(wedin==null){
            wedin=new WeddingFactory();
        }
        return wedin;
    }
    public static Weddings getWedding(String event_name,String eventAddress ){
        Weddings wed=new Weddings.Builder()
                .name(event_name)
                .address(eventAddress)
                .build();
        return wed;
    }
}

