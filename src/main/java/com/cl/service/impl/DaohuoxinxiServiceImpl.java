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


import com.cl.dao.DaohuoxinxiDao;
import com.cl.entity.DaohuoxinxiEntity;
import com.cl.service.DaohuoxinxiService;
import com.cl.entity.view.DaohuoxinxiView;

@Service("daohuoxinxiService")
public class DaohuoxinxiServiceImpl extends ServiceImpl<DaohuoxinxiDao, DaohuoxinxiEntity> implements DaohuoxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DaohuoxinxiEntity> page = this.selectPage(
                new Query<DaohuoxinxiEntity>(params).getPage(),
                new EntityWrapper<DaohuoxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DaohuoxinxiEntity> wrapper) {
		  Page<DaohuoxinxiView> page =new Query<DaohuoxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DaohuoxinxiView> selectListView(Wrapper<DaohuoxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DaohuoxinxiView selectView(Wrapper<DaohuoxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
