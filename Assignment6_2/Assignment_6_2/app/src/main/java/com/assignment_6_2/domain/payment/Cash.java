package com.assignment_6_2.domain.payment;

import java.io.Serializable;

/**
 * Created by Phinda Encore Tomson on 4/17/2016.
 */
public class Cash implements Payment,Serializable {
    private Long id;
    private String amount;
    private String company_name;

    public Long getId(){return id;}
    public String getAmount(){
        return amount;
    }

    public String getName(){
        return company_name=company_name;

    }

    public Cash(Builder builder){
        this.id=builder.id;
        this.amount=builder.amount;
        this.company_name=builder.company_name;
    }
    public static class Builder{
        private long id;
        private String amount;
        private String company_name;
        public Builder id(Long id){
            this.id=id;
            return this;
        }
        public Builder amount(String amount){
            this.amount=amount;
            return this;
        }

        public Builder name(String company_name){
            this.company_name=company_name;
            return this;
        }

        public Builder copy(Cash cash){
            this.id=cash.getId();
            this.amount=cash.getAmount();
            this.company_name=cash.getName();

            return this;
        }
        public Cash build(){
            return new Cash(this);
        }
    }

    public String getTypeOfPayment(){
        return "deposit";
    }
}
