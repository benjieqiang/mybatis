package com.ben.mybatis.mapper;

import com.ben.mybatis.pojo.Car;

import java.util.List;

/**
 * @InterfaceName: CarMapper
 * @Description: 等于CarDao, 直接采用sqlSession的getMapper方法，不用写实现类
 * @Author: benjieqiang
 * @LastChangeDate: 2023/5/7 3:07 PM
 * @Version: v1.0
 */

public interface CarMapper {
    int insert(Car car);
    int deleteById(Long id);

    int update(Car car);

    Car selectById(Long id);

    List<Car> selectAll();
}

