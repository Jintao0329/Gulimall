package com.atguigu.gulimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    //这段代码的主要目的是从所有分类中提取一级菜单，为它们设置子菜单，并根据排序值进行排序。
    // 最终结果是一个经过排序的一级菜单列表，每个菜单项包含其子菜单的层级结构。
    @Override
    public List<CategoryEntity> listWithTree() {
        //1、查出所有分类
        List<CategoryEntity> entities = baseMapper.selectList(null);
        //2、组装成父子树形结构
        //1)找到所有一级分类
        List<CategoryEntity> level1Menus = entities.stream().filter((categoryEntity) -> {
            return categoryEntity.getParentCid() == 0;
        }).map((menu)->{
            menu.setChildren(getChildren(menu,entities));
            return  menu;
        }).sorted((menu1,menu2)->{
            return (menu1.getSort() == null?0:menu1.getSort()) - (menu2.getSort() == null?0:menu2.getSort());
        }).collect(Collectors.toList());




        return level1Menus;
    }
    //递归查找所有菜单的子菜单
    private List<CategoryEntity> getChildren(CategoryEntity root, List<CategoryEntity> all){
        List<CategoryEntity> children = all.stream().filter(categoryEntity -> {
            return categoryEntity.getParentCid() == root.getCatId();
        }).map(categoryEntity -> {
            //1, 找到子菜单，递归
            categoryEntity.setChildren(getChildren(categoryEntity,all));
            return categoryEntity;
        }).sorted((menu1,menu2) -> {
            //2， 菜单的排序
            return (menu1.getSort() == null?0:menu1.getSort()) - (menu2.getSort() == null?0:menu2.getSort());
        }).collect(Collectors.toList());
        return children;
    }


}