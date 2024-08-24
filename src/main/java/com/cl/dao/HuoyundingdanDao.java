package com.cl.dao;

import com.cl.entity.HuoyundingdanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuoyundingdanView;


/**
 * 货运订单
 * 
 * @author 
 * @email 
 * @date 2024-01-09 19:39:02
 */
public interface HuoyundingdanDao extends BaseMapper<HuoyundingdanEntity> {
	
	List<HuoyundingdanView> selectListView(@Param("ew") Wrapper<HuoyundingdanEntity> wrapper);

	List<HuoyundingdanView> selectListView(Pagination page,@Param("ew") Wrapper<HuoyundingdanEntity> wrapper);
	
	HuoyundingdanView selectView(@Param("ew") Wrapper<HuoyundingdanEntity> wrapper);
	

}
