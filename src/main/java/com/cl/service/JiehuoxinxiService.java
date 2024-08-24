package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiehuoxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiehuoxinxiView;


/**
 * 接货信息
 *
 * @author 
 * @email 
 * @date 2024-01-09 19:39:02
 */
public interface JiehuoxinxiService extends IService<JiehuoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiehuoxinxiView> selectListView(Wrapper<JiehuoxinxiEntity> wrapper);
   	
   	JiehuoxinxiView selectView(@Param("ew") Wrapper<JiehuoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiehuoxinxiEntity> wrapper);
   	

}

