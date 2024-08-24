package com.cl.dao;

import com.cl.entity.DaohuoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DaohuoxinxiView;


/**
 * 到货信息
 * 
 * @author 
 * @email 
 * @date 2024-01-09 19:39:02
 */
public interface DaohuoxinxiDao extends BaseMapper<DaohuoxinxiEntity> {
	
	List<DaohuoxinxiView> selectListView(@Param("ew") Wrapper<DaohuoxinxiEntity> wrapper);

	List<DaohuoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DaohuoxinxiEntity> wrapper);
	
	DaohuoxinxiView selectView(@Param("ew") Wrapper<DaohuoxinxiEntity> wrapper);
	

}
