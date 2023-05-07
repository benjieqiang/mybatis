package com.ben.bank.exceptions;

/**
 * @Author: benjieqiang
 * @CreateTime: 2023-05-07  11:04
 * @Description: MoneyNotEnoughException
 * @Version: 1.0
 */
public class MoneyNotEnoughException extends Exception{
    public MoneyNotEnoughException(){};
    public MoneyNotEnoughException(String msg){
        super(msg);
    }
}
