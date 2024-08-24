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


import com.cl.dao.HuowuleixingDao;
import com.cl.entity.HuowuleixingEntity;
import com.cl.service.HuowuleixingService;
import com.cl.entity.view.HuowuleixingView;

@Service("huowuleixingService")
public class HuowuleixingServiceImpl extends ServiceImpl<HuowuleixingDao, HuowuleixingEntity> implements HuowuleixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuowuleixingEntity> page = this.selectPage(
                new Query<HuowuleixingEntity>(params).getPage(),
                new EntityWrapper<HuowuleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuowuleixingEntity> wrapper) {
		  Page<HuowuleixingView> page =new Query<HuowuleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<HuowuleixingView> selectListView(Wrapper<HuowuleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuowuleixingView selectView(Wrapper<HuowuleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
