package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.HuoyunpiaojuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuoyunpiaojuView;


/**
 * 货运票据
 *
 * @author 
 * @email 
 * @date 2024-01-09 19:39:02
 */
public interface HuoyunpiaojuService extends IService<HuoyunpiaojuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuoyunpiaojuView> selectListView(Wrapper<HuoyunpiaojuEntity> wrapper);
   	
   	HuoyunpiaojuView selectView(@Param("ew") Wrapper<HuoyunpiaojuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuoyunpiaojuEntity> wrapper);
   	

}

