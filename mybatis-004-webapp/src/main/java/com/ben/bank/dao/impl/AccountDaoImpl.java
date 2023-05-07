package com.ben.bank.dao.impl;

import com.ben.bank.dao.AccountDao;
import com.ben.bank.pojo.Account;
import com.ben.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @Author: benjieqiang
 * @CreateTime: 2023-05-07  10:58
 * @Description: crud具体实现类，如果想利用GenerateDaoProxy这种代理机制，
 * mybatis强行规定：*Mapper.xml文件的namespace必须为DAO层接口的包名（全限定名 ），sqlId必须为DAO层接口中的方法名；
 * java程序员面向接口编程，通过sqlSession中的getMapper方法来获取接口的实现对象，再调用各种方法进行crud。
 * @Version: 1.0
 */
public class AccountDaoImpl implements AccountDao {
    @Override
    public Account selectByActno(String actno) {
        SqlSession session = SqlSessionUtil.openSession();
        Account account = session.selectOne("com.ben.bank.dao.AccountDao.selectByActno", actno);
        return account;
    }

    @Override
    public int updateAccount(Account account) {
        SqlSession session = SqlSessionUtil.openSession();
        int count = session.update("com.ben.bank.dao.AccountDao.updateByActno", account);
        return count;
    }

    @Override
    public int insertAccount(Account account) {
        SqlSession session = SqlSessionUtil.openSession();
        int count = session.insert("com.ben.bank.dao.AccountDao.insertAct", account);
        return count;
    }
}
