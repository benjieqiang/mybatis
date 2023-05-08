package com.ben.mybatis.mapper;

import com.ben.mybatis.pojo.Car;
import com.ben.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author: benjieqiang
 * @CreateTime: 2023-05-08  15:50
 * @Description: TODO
 * @Version: 1.0
 */
public class CarMapperTest {

    @Test
    public void testInsert() {
        SqlSession session = SqlSessionUtil.openSession();
        CarMapper mapper = session.getMapper(CarMapper.class);
        mapper.insert(new Car(63L,"11","雅迪小王子",12.00,"2022-01-01", "电动车"));
        session.commit();
        session.close();
    }

    @Test
    public void testSelectById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectById(63L);
        System.out.println(car);
        sqlSession.close();
    }

    @Test
    public void testSelectByBrand() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectByBrand("雅迪小王子");
        System.out.println(car);
        sqlSession.close();
    }

    @Test
    public void testSelectByType() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> carList = mapper.selectByType("desc");
        System.out.println(carList);
        sqlSession.close();
    }

    //批量删除
    @Test
    public void testDeleteBatch() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int res = mapper.deleteBatch("1,2,3"); //3
        System.out.println(res);
        sqlSession.close();
    }

    //模糊查询

    @Test
    public void testSelectByBrandLike() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByBrandLike("奔驰");
        System.out.println(cars);
        sqlSession.close();
    }
}
