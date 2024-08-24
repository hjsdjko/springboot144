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


import com.cl.dao.HuoyunpiaojuDao;
import com.cl.entity.HuoyunpiaojuEntity;
import com.cl.service.HuoyunpiaojuService;
import com.cl.entity.view.HuoyunpiaojuView;

@Service("huoyunpiaojuService")
public class HuoyunpiaojuServiceImpl extends ServiceImpl<HuoyunpiaojuDao, HuoyunpiaojuEntity> implements HuoyunpiaojuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuoyunpiaojuEntity> page = this.selectPage(
                new Query<HuoyunpiaojuEntity>(params).getPage(),
                new EntityWrapper<HuoyunpiaojuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuoyunpiaojuEntity> wrapper) {
		  Page<HuoyunpiaojuView> page =new Query<HuoyunpiaojuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<HuoyunpiaojuView> selectListView(Wrapper<HuoyunpiaojuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuoyunpiaojuView selectView(Wrapper<HuoyunpiaojuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
