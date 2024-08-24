package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.ChengbenhesuanDao;
import com.cl.entity.ChengbenhesuanEntity;
import com.cl.service.ChengbenhesuanService;
import com.cl.entity.view.ChengbenhesuanView;

@Service("chengbenhesuanService")
public class ChengbenhesuanServiceImpl extends ServiceImpl<ChengbenhesuanDao, ChengbenhesuanEntity> implements ChengbenhesuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChengbenhesuanEntity> page = this.selectPage(
                new Query<ChengbenhesuanEntity>(params).getPage(),
                new EntityWrapper<ChengbenhesuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChengbenhesuanEntity> wrapper) {
		  Page<ChengbenhesuanView> page =new Query<ChengbenhesuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ChengbenhesuanView> selectListView(Wrapper<ChengbenhesuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChengbenhesuanView selectView(Wrapper<ChengbenhesuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
