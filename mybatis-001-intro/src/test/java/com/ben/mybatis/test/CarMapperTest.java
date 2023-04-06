package com.ben.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;

public class CarMapperTest {

    @Test
    public void testInsertCar() throws IOException {
        SqlSession sqlSession = null;
        try {
            //1. 创建SqlSessionFactoryBuilder对象；
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            //2. SqlSessionFactory对象, 需要抛出异常；
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
            //3. 创建SqlSession对象
            sqlSession = sqlSessionFactory.openSession(); // 如果使用的事务管理器是JDBC的话，底层实际上会执行：conn.setAutoCommit(false);
            //4. 执行sql语句
            int res = sqlSession.insert("insertCar");
            System.out.println("插入结果是：" + res);
            //5. 提交结果
            sqlSession.commit();

        } catch (Exception e) {
            // 回滚
            if (sqlSession != null) {
                sqlSession.rollback();
            }
        } finally {
            // 6.关闭资源
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
