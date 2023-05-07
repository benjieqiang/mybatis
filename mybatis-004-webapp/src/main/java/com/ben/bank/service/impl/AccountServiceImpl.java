package com.ben.bank.service.impl;


import com.ben.bank.dao.AccountDao;
import com.ben.bank.dao.impl.AccountDaoImpl;
import com.ben.bank.exceptions.MoneyNotEnoughException;
import com.ben.bank.exceptions.TransferNotSuccessException;
import com.ben.bank.pojo.Account;
import com.ben.bank.service.AccountService;

// 只处理业务逻辑，数据库crud都在dao层进行；
public class AccountServiceImpl implements AccountService {
    AccountDao accountDao = new AccountDaoImpl();

    @Override
    public void transfer(String fromActno, String toActno, Double money) throws MoneyNotEnoughException, TransferNotSuccessException {
        //1. 判断转出账户的余额是否充足
        Account fromAccount = accountDao.selectByActno(fromActno);
        //2. 余额不足，则报余额不足异常；
        if (fromAccount.getBalance() < money) {
            throw new MoneyNotEnoughException("对不起，余额不足！");
        }
        //3. 更新内存中Java对象 转出对象余额（* - money）和 转入对象的余额（* + money）
        Account toAccount = accountDao.selectByActno(toActno);
        fromAccount.setBalance(fromAccount.getBalance() - money);
        toAccount.setBalance(toAccount.getBalance() + money);
        //4. 更新转出账户和转入账户的余额；
        int count = accountDao.updateAccount(fromAccount);
        count += accountDao.updateAccount(toAccount);
        //5. 判断结果是否转账成功，否则报转账异常;
        if (count != 2) {
            throw new TransferNotSuccessException("转账失败！");
        }
    }
}
