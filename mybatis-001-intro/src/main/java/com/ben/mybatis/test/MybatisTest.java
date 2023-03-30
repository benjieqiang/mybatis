package com.ben.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
    public static void main(String[] args) throws IOException {
        //1. 创建SqlSessionFactoryBuilder对象；
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //2. SqlSessionFactory对象, 需要抛出异常；
//        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        // 也可以写成一行；
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));

        //3. 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(); // 如果使用的事务管理器是JDBC的话，底层实际上会执行：conn.setAutoCommit(false);
        //4. 执行sql语句
        int res = sqlSession.insert("insertCar");
        //5. 打印结果
        System.out.println("插入结果是：" + res);
        //6. 提交结果
        sqlSession.commit();
        //7. 关闭资源
        sqlSession.close();
    }
}