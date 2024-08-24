package com.cl.dao;

import com.cl.entity.HuoyunpiaojuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuoyunpiaojuView;


/**
 * 货运票据
 * 
 * @author 
 * @email 
 * @date 2024-01-09 19:39:02
 */
public interface HuoyunpiaojuDao extends BaseMapper<HuoyunpiaojuEntity> {
	
	List<HuoyunpiaojuView> selectListView(@Param("ew") Wrapper<HuoyunpiaojuEntity> wrapper);

	List<HuoyunpiaojuView> selectListView(Pagination page,@Param("ew") Wrapper<HuoyunpiaojuEntity> wrapper);
	
	HuoyunpiaojuView selectView(@Param("ew") Wrapper<HuoyunpiaojuEntity> wrapper);
	

}
