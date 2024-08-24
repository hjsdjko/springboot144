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

import com.cl.entity.HuowuleixingEntity;
import com.cl.entity.view.HuowuleixingView;

import com.cl.service.HuowuleixingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MD5Util;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 货物类型
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-09 19:39:02
 */
@RestController
@RequestMapping("/huowuleixing")
public class HuowuleixingController {
    @Autowired
    private HuowuleixingService huowuleixingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HuowuleixingEntity huowuleixing,
		HttpServletRequest request){
        EntityWrapper<HuowuleixingEntity> ew = new EntityWrapper<HuowuleixingEntity>();

		PageUtils page = huowuleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huowuleixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuowuleixingEntity huowuleixing, 
		HttpServletRequest request){
        EntityWrapper<HuowuleixingEntity> ew = new EntityWrapper<HuowuleixingEntity>();

		PageUtils page = huowuleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huowuleixing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuowuleixingEntity huowuleixing){
       	EntityWrapper<HuowuleixingEntity> ew = new EntityWrapper<HuowuleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huowuleixing, "huowuleixing")); 
        return R.ok().put("data", huowuleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuowuleixingEntity huowuleixing){
        EntityWrapper< HuowuleixingEntity> ew = new EntityWrapper< HuowuleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huowuleixing, "huowuleixing")); 
		HuowuleixingView huowuleixingView =  huowuleixingService.selectView(ew);
		return R.ok("查询货物类型成功").put("data", huowuleixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuowuleixingEntity huowuleixing = huowuleixingService.selectById(id);
        return R.ok().put("data", huowuleixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuowuleixingEntity huowuleixing = huowuleixingService.selectById(id);
        return R.ok().put("data", huowuleixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HuowuleixingEntity huowuleixing, HttpServletRequest request){
    	huowuleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huowuleixing);
        huowuleixingService.insert(huowuleixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HuowuleixingEntity huowuleixing, HttpServletRequest request){
    	huowuleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huowuleixing);
        huowuleixingService.insert(huowuleixing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HuowuleixingEntity huowuleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huowuleixing);
        huowuleixingService.updateById(huowuleixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        huowuleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
