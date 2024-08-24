package com.cl.dao;

import com.cl.entity.HuowuleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuowuleixingView;


/**
 * 货物类型
 * 
 * @author 
 * @email 
 * @date 2024-01-09 19:39:02
 */
public interface HuowuleixingDao extends BaseMapper<HuowuleixingEntity> {
	
	List<HuowuleixingView> selectListView(@Param("ew") Wrapper<HuowuleixingEntity> wrapper);

	List<HuowuleixingView> selectListView(Pagination page,@Param("ew") Wrapper<HuowuleixingEntity> wrapper);
	
	HuowuleixingView selectView(@Param("ew") Wrapper<HuowuleixingEntity> wrapper);
	

}
