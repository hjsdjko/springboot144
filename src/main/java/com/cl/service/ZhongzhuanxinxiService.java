package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZhongzhuanxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhongzhuanxinxiView;


/**
 * 中转信息
 *
 * @author 
 * @email 
 * @date 2024-01-09 19:39:02
 */
public interface ZhongzhuanxinxiService extends IService<ZhongzhuanxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhongzhuanxinxiView> selectListView(Wrapper<ZhongzhuanxinxiEntity> wrapper);
   	
   	ZhongzhuanxinxiView selectView(@Param("ew") Wrapper<ZhongzhuanxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhongzhuanxinxiEntity> wrapper);
   	

}

