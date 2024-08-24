package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.PeichexinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.PeichexinxiView;


/**
 * 配车信息
 *
 * @author 
 * @email 
 * @date 2024-01-09 19:39:02
 */
public interface PeichexinxiService extends IService<PeichexinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PeichexinxiView> selectListView(Wrapper<PeichexinxiEntity> wrapper);
   	
   	PeichexinxiView selectView(@Param("ew") Wrapper<PeichexinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PeichexinxiEntity> wrapper);
   	

}

