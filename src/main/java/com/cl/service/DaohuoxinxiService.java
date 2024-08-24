package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DaohuoxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DaohuoxinxiView;


/**
 * 到货信息
 *
 * @author 
 * @email 
 * @date 2024-01-09 19:39:02
 */
public interface DaohuoxinxiService extends IService<DaohuoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DaohuoxinxiView> selectListView(Wrapper<DaohuoxinxiEntity> wrapper);
   	
   	DaohuoxinxiView selectView(@Param("ew") Wrapper<DaohuoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DaohuoxinxiEntity> wrapper);
   	

}

