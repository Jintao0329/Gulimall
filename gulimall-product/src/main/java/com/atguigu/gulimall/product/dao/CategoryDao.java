package com.atguigu.gulimall.product.dao;

import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author Jintao
 * @email jintaofu0329@gmail.com
 * @date 2024-03-01 16:21:18
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
