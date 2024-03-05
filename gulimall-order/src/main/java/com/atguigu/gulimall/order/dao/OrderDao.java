package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author Jintao
 * @email jintaofu0329@gmail.com
 * @date 2024-03-03 18:42:29
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
