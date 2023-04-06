package com.ben.mybatis.test;

import com.ben.mybatis.pojo.Car;
import com.ben.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarMapperTest {
    @Test
    public void testInsertCar() {
        //        insert into t_car(id,car_num,brand,guide_price,produce_time,car_type)
        //        values(#{id}, #{carNum}, #{brand}, #{guidePrice}, #{produceTime}, #{carType});
        Map<String, Object> map = new HashMap<>();
        map.put("id", 60L);
        map.put("carNum", 1004);
        map.put("brand", "大众POLO");
        map.put("guidePrice", 14);
        map.put("produceTime", "2023-01-01");
        map.put("carType", "燃油车");

        SqlSession sqlSession = SqlSessionUtil.openSession();
        // 执行sql
        int res = sqlSession.insert("fdsafdsa.insertCar", map);
        System.out.println("插入了记录：" + res);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertCarByPojo() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Car car = new Car(61L, "1005","比亚迪汉", 15.00, "2023-02-02","新能源");
        // 执行sql
        int res = sqlSession.insert("fdsafdsa.insertCarByPojo", car);
        System.out.println("插入了记录：" + res);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteCarById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // 执行sql
        int res = sqlSession.delete("fdsafdsa.deleteById", 10);
        System.out.println("删除了记录：" + res); //1表示删除成功；
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateById(){
        SqlSession session = SqlSessionUtil.openSession();
        Car car = new Car(61L,"1222","新比亚迪汉",20.00,"2023-04-01","新能源");
        int count = session.update("updateById", car);
        System.out.println(count);
        session.commit();
        session.close();
    }

    @Test
    public void selectOneById(){
        SqlSession session = SqlSessionUtil.openSession();
        Car car = session.selectOne("selectOneById",61L);
        System.out.println(car); //Car{id=1222, carNum='1222', brand='新比亚迪汉', guidePrice=20.0, produceTime='2023-04-01', carType='新能源'}
        session.close();
    }
    @Test
    public void selectAll(){
        SqlSession session = SqlSessionUtil.openSession();
        List<Car> cars = session.selectList("selectAll");
        cars.forEach(car -> System.out.println(car));
        session.close();
    }
}
