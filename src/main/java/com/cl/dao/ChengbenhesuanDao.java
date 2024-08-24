package com.cl.dao;

import com.cl.entity.ChengbenhesuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChengbenhesuanView;


/**
 * 成本核算
 * 
 * @author 
 * @email 
 * @date 2024-01-09 19:39:02
 */
public interface ChengbenhesuanDao extends BaseMapper<ChengbenhesuanEntity> {
	
	List<ChengbenhesuanView> selectListView(@Param("ew") Wrapper<ChengbenhesuanEntity> wrapper);

	List<ChengbenhesuanView> selectListView(Pagination page,@Param("ew") Wrapper<ChengbenhesuanEntity> wrapper);
	
	ChengbenhesuanView selectView(@Param("ew") Wrapper<ChengbenhesuanEntity> wrapper);
	

}
