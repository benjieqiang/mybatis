package com.ben.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class SqlSessionUtil {
    // 1. 私有化构造方法；
    // 2. 工具类中的方法都是静态的，类名.方法名进行调用；
    private SqlSessionUtil() {}

    // 一个SqlSessionFactory对象对于于matbis-config.xml里的<environments default="development">，一个environment对应一个数据库，所以放在类加载时执行；
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static SqlSession openSession() {
        return sqlSessionFactory.openSession();
    }
}
