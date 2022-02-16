package com.innova.transactiontuto;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class TransactionTutorials {

    // Read (transaction(-))
    //DML = Create+Update+Delete
    //DDL =
    //DQL = Read

    //CUD
    //CREATE (transaction(+))
    //UPDATE (transaction(+))
    //DELETE (transaction(+))

    public static void main(String[] args) {
        try{
            int sayi = 5/0;

        }catch (Exception e){
            e.printStackTrace();
        }
        throw new ArithmeticException("Sıfıra bolum hatası");
    }
}
