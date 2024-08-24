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


import com.cl.dao.PeichexinxiDao;
import com.cl.entity.PeichexinxiEntity;
import com.cl.service.PeichexinxiService;
import com.cl.entity.view.PeichexinxiView;

@Service("peichexinxiService")
public class PeichexinxiServiceImpl extends ServiceImpl<PeichexinxiDao, PeichexinxiEntity> implements PeichexinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PeichexinxiEntity> page = this.selectPage(
                new Query<PeichexinxiEntity>(params).getPage(),
                new EntityWrapper<PeichexinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PeichexinxiEntity> wrapper) {
		  Page<PeichexinxiView> page =new Query<PeichexinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<PeichexinxiView> selectListView(Wrapper<PeichexinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PeichexinxiView selectView(Wrapper<PeichexinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
