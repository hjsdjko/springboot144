package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ChengbenhesuanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChengbenhesuanView;


/**
 * 成本核算
 *
 * @author 
 * @email 
 * @date 2024-01-09 19:39:02
 */
public interface ChengbenhesuanService extends IService<ChengbenhesuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChengbenhesuanView> selectListView(Wrapper<ChengbenhesuanEntity> wrapper);
   	
   	ChengbenhesuanView selectView(@Param("ew") Wrapper<ChengbenhesuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChengbenhesuanEntity> wrapper);
   	

}

