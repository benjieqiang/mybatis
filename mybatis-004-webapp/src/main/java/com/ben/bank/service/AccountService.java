package com.ben.bank.service;


import com.ben.bank.exceptions.MoneyNotEnoughException;
import com.ben.bank.exceptions.TransferNotSuccessException;

import java.io.IOException;

public interface AccountService {
    /**
     * @param fromActno: 转出账户
     * @param toActno: 转入账户
     * @param money: 转账金额
     * @return void
     * @description TODO
     * @author benjieqiang
     * @date 2023/5/7 10:45 AM
     */
    void transfer(String fromActno, String toActno, Double money) throws MoneyNotEnoughException, TransferNotSuccessException;
}