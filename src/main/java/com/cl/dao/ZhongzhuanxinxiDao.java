package com.cl.dao;

import com.cl.entity.ZhongzhuanxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhongzhuanxinxiView;


/**
 * 中转信息
 * 
 * @author 
 * @email 
 * @date 2024-01-09 19:39:02
 */
public interface ZhongzhuanxinxiDao extends BaseMapper<ZhongzhuanxinxiEntity> {
	
	List<ZhongzhuanxinxiView> selectListView(@Param("ew") Wrapper<ZhongzhuanxinxiEntity> wrapper);

	List<ZhongzhuanxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ZhongzhuanxinxiEntity> wrapper);
	
	ZhongzhuanxinxiView selectView(@Param("ew") Wrapper<ZhongzhuanxinxiEntity> wrapper);
	

}
