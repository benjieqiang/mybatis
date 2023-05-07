package com.ben.bank.dao;

import com.ben.bank.pojo.Account;

/**
 * @InterfaceName: AccountDao
 * @Description: 对数据库进行crud操作
 * @Author: benjieqiang
 * @LastChangeDate: 2023/5/7 10:56 AM
 * @Version: v1.0
 */

public interface AccountDao {
    /**
     * 根据账户名查询账户
     * @param actno 账户名
     * @return 返回账户
     */
    Account selectByActno(String actno);

    /**
     * 更新用户
     * @param account 需要更新的用户
     * @return 1表示更新完成
     */
    int updateAccount(Account account);

    /**
     * 插入用户
     * @param account 需要插入的用户
     * @return 1表示插入完成
     */
    int insertAccount(Account account);
}

