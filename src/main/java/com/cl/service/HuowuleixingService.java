package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.HuowuleixingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuowuleixingView;


/**
 * 货物类型
 *
 * @author 
 * @email 
 * @date 2024-01-09 19:39:02
 */
public interface HuowuleixingService extends IService<HuowuleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuowuleixingView> selectListView(Wrapper<HuowuleixingEntity> wrapper);
   	
   	HuowuleixingView selectView(@Param("ew") Wrapper<HuowuleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuowuleixingEntity> wrapper);
   	

}

