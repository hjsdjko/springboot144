package com.cl.dao;

import com.cl.entity.PeichexinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.PeichexinxiView;


/**
 * 配车信息
 * 
 * @author 
 * @email 
 * @date 2024-01-09 19:39:02
 */
public interface PeichexinxiDao extends BaseMapper<PeichexinxiEntity> {
	
	List<PeichexinxiView> selectListView(@Param("ew") Wrapper<PeichexinxiEntity> wrapper);

	List<PeichexinxiView> selectListView(Pagination page,@Param("ew") Wrapper<PeichexinxiEntity> wrapper);
	
	PeichexinxiView selectView(@Param("ew") Wrapper<PeichexinxiEntity> wrapper);
	

}
