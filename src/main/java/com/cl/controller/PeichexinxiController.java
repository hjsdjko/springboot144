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

import com.cl.entity.PeichexinxiEntity;
import com.cl.entity.view.PeichexinxiView;

import com.cl.service.PeichexinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MD5Util;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 配车信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-09 19:39:02
 */
@RestController
@RequestMapping("/peichexinxi")
public class PeichexinxiController {
    @Autowired
    private PeichexinxiService peichexinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PeichexinxiEntity peichexinxi,
		HttpServletRequest request){
        EntityWrapper<PeichexinxiEntity> ew = new EntityWrapper<PeichexinxiEntity>();

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
		PageUtils page = peichexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, peichexinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PeichexinxiEntity peichexinxi, 
		HttpServletRequest request){
        EntityWrapper<PeichexinxiEntity> ew = new EntityWrapper<PeichexinxiEntity>();

		PageUtils page = peichexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, peichexinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PeichexinxiEntity peichexinxi){
       	EntityWrapper<PeichexinxiEntity> ew = new EntityWrapper<PeichexinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( peichexinxi, "peichexinxi")); 
        return R.ok().put("data", peichexinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PeichexinxiEntity peichexinxi){
        EntityWrapper< PeichexinxiEntity> ew = new EntityWrapper< PeichexinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( peichexinxi, "peichexinxi")); 
		PeichexinxiView peichexinxiView =  peichexinxiService.selectView(ew);
		return R.ok("查询配车信息成功").put("data", peichexinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PeichexinxiEntity peichexinxi = peichexinxiService.selectById(id);
        return R.ok().put("data", peichexinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PeichexinxiEntity peichexinxi = peichexinxiService.selectById(id);
        return R.ok().put("data", peichexinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PeichexinxiEntity peichexinxi, HttpServletRequest request){
    	peichexinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(peichexinxi);
        peichexinxiService.insert(peichexinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody PeichexinxiEntity peichexinxi, HttpServletRequest request){
    	peichexinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(peichexinxi);
        peichexinxiService.insert(peichexinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody PeichexinxiEntity peichexinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(peichexinxi);
        peichexinxiService.updateById(peichexinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        peichexinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
