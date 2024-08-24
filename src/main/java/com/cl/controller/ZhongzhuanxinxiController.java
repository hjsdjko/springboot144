package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.ZhongzhuanxinxiEntity;
import com.cl.entity.view.ZhongzhuanxinxiView;

import com.cl.service.ZhongzhuanxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MD5Util;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 中转信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-09 19:39:02
 */
@RestController
@RequestMapping("/zhongzhuanxinxi")
public class ZhongzhuanxinxiController {
    @Autowired
    private ZhongzhuanxinxiService zhongzhuanxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhongzhuanxinxiEntity zhongzhuanxinxi,
		HttpServletRequest request){
        EntityWrapper<ZhongzhuanxinxiEntity> ew = new EntityWrapper<ZhongzhuanxinxiEntity>();

        String tableName = request.getSession().getAttribute("tableName").toString();
        ew.andNew();
        if(tableName.equals("kehu")) {
            ew.eq("fahuoren", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("kehu")) {
            ew.or();
            ew.eq("kehuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("siji")) {
            ew.or();
            ew.eq("sijizhanghao", (String)request.getSession().getAttribute("username"));
        }
		PageUtils page = zhongzhuanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhongzhuanxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhongzhuanxinxiEntity zhongzhuanxinxi, 
		HttpServletRequest request){
        EntityWrapper<ZhongzhuanxinxiEntity> ew = new EntityWrapper<ZhongzhuanxinxiEntity>();

		PageUtils page = zhongzhuanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhongzhuanxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhongzhuanxinxiEntity zhongzhuanxinxi){
       	EntityWrapper<ZhongzhuanxinxiEntity> ew = new EntityWrapper<ZhongzhuanxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhongzhuanxinxi, "zhongzhuanxinxi")); 
        return R.ok().put("data", zhongzhuanxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhongzhuanxinxiEntity zhongzhuanxinxi){
        EntityWrapper< ZhongzhuanxinxiEntity> ew = new EntityWrapper< ZhongzhuanxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhongzhuanxinxi, "zhongzhuanxinxi")); 
		ZhongzhuanxinxiView zhongzhuanxinxiView =  zhongzhuanxinxiService.selectView(ew);
		return R.ok("查询中转信息成功").put("data", zhongzhuanxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhongzhuanxinxiEntity zhongzhuanxinxi = zhongzhuanxinxiService.selectById(id);
        return R.ok().put("data", zhongzhuanxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhongzhuanxinxiEntity zhongzhuanxinxi = zhongzhuanxinxiService.selectById(id);
        return R.ok().put("data", zhongzhuanxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhongzhuanxinxiEntity zhongzhuanxinxi, HttpServletRequest request){
    	zhongzhuanxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhongzhuanxinxi);
        zhongzhuanxinxiService.insert(zhongzhuanxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhongzhuanxinxiEntity zhongzhuanxinxi, HttpServletRequest request){
    	zhongzhuanxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhongzhuanxinxi);
        zhongzhuanxinxiService.insert(zhongzhuanxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhongzhuanxinxiEntity zhongzhuanxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhongzhuanxinxi);
        zhongzhuanxinxiService.updateById(zhongzhuanxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhongzhuanxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}