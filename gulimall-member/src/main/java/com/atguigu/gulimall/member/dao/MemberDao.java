package com.atguigu.gulimall.member.dao;

import com.atguigu.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author Jintao
 * @email jintaofu0329@gmail.com
 * @date 2024-03-03 17:01:10
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
