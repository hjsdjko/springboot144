package com.cl.dao;

import com.cl.entity.JiehuoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiehuoxinxiView;


/**
 * 接货信息
 * 
 * @author 
 * @email 
 * @date 2024-01-09 19:39:02
 */
public interface JiehuoxinxiDao extends BaseMapper<JiehuoxinxiEntity> {
	
	List<JiehuoxinxiView> selectListView(@Param("ew") Wrapper<JiehuoxinxiEntity> wrapper);

	List<JiehuoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<JiehuoxinxiEntity> wrapper);
	
	JiehuoxinxiView selectView(@Param("ew") Wrapper<JiehuoxinxiEntity> wrapper);
	

}
