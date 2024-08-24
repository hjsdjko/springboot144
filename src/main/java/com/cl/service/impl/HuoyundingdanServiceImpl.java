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


import com.cl.dao.HuoyundingdanDao;
import com.cl.entity.HuoyundingdanEntity;
import com.cl.service.HuoyundingdanService;
import com.cl.entity.view.HuoyundingdanView;

@Service("huoyundingdanService")
public class HuoyundingdanServiceImpl extends ServiceImpl<HuoyundingdanDao, HuoyundingdanEntity> implements HuoyundingdanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuoyundingdanEntity> page = this.selectPage(
                new Query<HuoyundingdanEntity>(params).getPage(),
                new EntityWrapper<HuoyundingdanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuoyundingdanEntity> wrapper) {
		  Page<HuoyundingdanView> page =new Query<HuoyundingdanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<HuoyundingdanView> selectListView(Wrapper<HuoyundingdanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuoyundingdanView selectView(Wrapper<HuoyundingdanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
