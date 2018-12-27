package com.zzf.target;

public class Account {

    public int balance = 20;

    public boolean withdraw(int amount){
        if (balance<amount){
            return false;
        }
        balance = balance-amount;
        return true;
    }

}
