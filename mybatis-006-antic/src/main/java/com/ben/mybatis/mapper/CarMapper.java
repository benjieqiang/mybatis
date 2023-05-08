package com.ben.mybatis.mapper;

import com.ben.mybatis.pojo.Car;

import java.util.List;

/**
 * @Author: benjieqiang
 * @CreateTime: 2023-05-08  15:47
 * @Description: 对car表的crud
 * @Version: 1.0
 */
public interface CarMapper {

    int insert(Car car);

    int deleteById(Long id);

    int deleteBatch(String ids);
    int updateById(Long id);

    Car selectById(Long id);

    List<Car> selectAll();
    /**
     * @param :
     * @return Car
     * @description 根据品牌进行查询；
     * @author benjieqiang
     * @date 2023/5/8 4:04 PM
     */

    Car selectByBrand(String brand);

    //模糊查询
    List<Car> selectByBrandLike(String brand);
    /**
     * @param :
     * @return List<Car>
     * @description 根据前端传递的字段进行升序或降序；
     * @author benjieqiang
     * @date 2023/5/8 4:14 PM
     */
    List<Car> selectByType(String type);

}
