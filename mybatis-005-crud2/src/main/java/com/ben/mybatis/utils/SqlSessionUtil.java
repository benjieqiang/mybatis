package com.ben.bank.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class SqlSessionUtil {
    // 1. 私有化构造方法；
    // 2. 工具类中的方法都是静态的，类名.方法名进行调用；
    private SqlSessionUtil() {
    }

    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 使用ThreadLocal来控制事务，一个服务器只需要定义一个；
    public static ThreadLocal<SqlSession> local = new ThreadLocal<>();


    /**
     * @param :
     * @return SqlSession
     * @description 开启一个会话
     * @author benjieqiang
     * @date 2023/5/7 12:11 PM
     */
    public static SqlSession openSession() {
        SqlSession session = local.get();
        if (session == null) {
            session = sqlSessionFactory.openSession();
            // 将sqlsession对象绑定到当前线程；
            local.set(session);
        }
        return session;
    }

    /**
     * @param session:
     * @return void
     * @description 关闭sqlsession对象
     * @author benjieqiang
     * @date 2023/5/7 12:12 PM
     */
    public static void close(SqlSession session) {
        if (session != null) {
            session.close();
            // 移除sqlsession对象和当前线程的关系；
            local.remove();
        }
    }
}
