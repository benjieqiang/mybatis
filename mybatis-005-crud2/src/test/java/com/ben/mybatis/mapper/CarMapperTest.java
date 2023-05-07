package com.ben.mybatis.mapper;

import com.ben.bank.utils.SqlSessionUtil;
import com.ben.mybatis.pojo.Car;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author: benjieqiang
 * @CreateTime: 2023-05-07  15:14
 * @Description: TODO
 * @Version: 1.0
 */
public class CarMapperTest {
    @Test
    public void insert(){
        SqlSession session = SqlSessionUtil.openSession();
        CarMapper mapper = session.getMapper(CarMapper.class);
        Car car = new Car(null,"121","雅迪",1500.00,"2020.09.09","电动车");
        mapper.insert(car);
        session.commit();
    }
    @Test
    public void delete(){
        SqlSession session = SqlSessionUtil.openSession();
        CarMapper mapper = session.getMapper(CarMapper.class);
        mapper.deleteById(21L);
        session.commit();
    }
    @Test
    public void update(){
        SqlSession session = SqlSessionUtil.openSession();
        CarMapper mapper = session.getMapper(CarMapper.class);
        Car car = new Car(null,"121","台铃",1500.00,"2020.09.09","电动车");
        mapper.update(car);
        session.commit();
    }
    @Test
    public void selectById(){
        SqlSession session = SqlSessionUtil.openSession();
        CarMapper mapper = session.getMapper(CarMapper.class);
        Car car = mapper.selectById(60L);
        System.out.println(car);
    }
    @Test
    public void selectAll(){
        SqlSession session = SqlSessionUtil.openSession();
        CarMapper mapper = session.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAll();
        cars.forEach(car -> System.out.println(car));
    }
}

