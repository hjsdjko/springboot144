package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.HuoyundingdanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuoyundingdanView;


/**
 * 货运订单
 *
 * @author 
 * @email 
 * @date 2024-01-09 19:39:02
 */
public interface HuoyundingdanService extends IService<HuoyundingdanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuoyundingdanView> selectListView(Wrapper<HuoyundingdanEntity> wrapper);
   	
   	HuoyundingdanView selectView(@Param("ew") Wrapper<HuoyundingdanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuoyundingdanEntity> wrapper);
   	

}

