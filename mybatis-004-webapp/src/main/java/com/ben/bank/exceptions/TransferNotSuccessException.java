package com.ben.bank.exceptions;

/**
 * @Author: benjieqiang
 * @CreateTime: 2023-05-07  11:04
 * @Description: TODO
 * @Version: 1.0
 */
public class TransferNotSuccessException extends Exception{
    public TransferNotSuccessException(){};
    public TransferNotSuccessException(String msg){
        super(msg);
    }
}
