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


import com.cl.dao.JiehuoxinxiDao;
import com.cl.entity.JiehuoxinxiEntity;
import com.cl.service.JiehuoxinxiService;
import com.cl.entity.view.JiehuoxinxiView;

@Service("jiehuoxinxiService")
public class JiehuoxinxiServiceImpl extends ServiceImpl<JiehuoxinxiDao, JiehuoxinxiEntity> implements JiehuoxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiehuoxinxiEntity> page = this.selectPage(
                new Query<JiehuoxinxiEntity>(params).getPage(),
                new EntityWrapper<JiehuoxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiehuoxinxiEntity> wrapper) {
		  Page<JiehuoxinxiView> page =new Query<JiehuoxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JiehuoxinxiView> selectListView(Wrapper<JiehuoxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiehuoxinxiView selectView(Wrapper<JiehuoxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
