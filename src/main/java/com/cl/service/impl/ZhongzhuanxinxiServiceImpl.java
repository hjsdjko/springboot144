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


import com.cl.dao.ZhongzhuanxinxiDao;
import com.cl.entity.ZhongzhuanxinxiEntity;
import com.cl.service.ZhongzhuanxinxiService;
import com.cl.entity.view.ZhongzhuanxinxiView;

@Service("zhongzhuanxinxiService")
public class ZhongzhuanxinxiServiceImpl extends ServiceImpl<ZhongzhuanxinxiDao, ZhongzhuanxinxiEntity> implements ZhongzhuanxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhongzhuanxinxiEntity> page = this.selectPage(
                new Query<ZhongzhuanxinxiEntity>(params).getPage(),
                new EntityWrapper<ZhongzhuanxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhongzhuanxinxiEntity> wrapper) {
		  Page<ZhongzhuanxinxiView> page =new Query<ZhongzhuanxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZhongzhuanxinxiView> selectListView(Wrapper<ZhongzhuanxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhongzhuanxinxiView selectView(Wrapper<ZhongzhuanxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
