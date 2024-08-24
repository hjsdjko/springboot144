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

import com.cl.entity.JiehuoxinxiEntity;
import com.cl.entity.view.JiehuoxinxiView;

import com.cl.service.JiehuoxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MD5Util;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 接货信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-09 19:39:02
 */
@RestController
@RequestMapping("/jiehuoxinxi")
public class JiehuoxinxiController {
    @Autowired
    private JiehuoxinxiService jiehuoxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiehuoxinxiEntity jiehuoxinxi,
		HttpServletRequest request){
        EntityWrapper<JiehuoxinxiEntity> ew = new EntityWrapper<JiehuoxinxiEntity>();

        String tableName = request.getSession().getAttribute("tableName").toString();
        ew.andNew();
        if(tableName.equals("kehu")) {
            ew.eq("fahuoren", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("kehu")) {
            ew.or();
            ew.eq("kehuzhanghao", (String)request.getSession().getAttribute("username"));
        }
		PageUtils page = jiehuoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiehuoxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiehuoxinxiEntity jiehuoxinxi, 
		HttpServletRequest request){
        EntityWrapper<JiehuoxinxiEntity> ew = new EntityWrapper<JiehuoxinxiEntity>();

		PageUtils page = jiehuoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiehuoxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiehuoxinxiEntity jiehuoxinxi){
       	EntityWrapper<JiehuoxinxiEntity> ew = new EntityWrapper<JiehuoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiehuoxinxi, "jiehuoxinxi")); 
        return R.ok().put("data", jiehuoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiehuoxinxiEntity jiehuoxinxi){
        EntityWrapper< JiehuoxinxiEntity> ew = new EntityWrapper< JiehuoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiehuoxinxi, "jiehuoxinxi")); 
		JiehuoxinxiView jiehuoxinxiView =  jiehuoxinxiService.selectView(ew);
		return R.ok("查询接货信息成功").put("data", jiehuoxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiehuoxinxiEntity jiehuoxinxi = jiehuoxinxiService.selectById(id);
        return R.ok().put("data", jiehuoxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiehuoxinxiEntity jiehuoxinxi = jiehuoxinxiService.selectById(id);
        return R.ok().put("data", jiehuoxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiehuoxinxiEntity jiehuoxinxi, HttpServletRequest request){
    	jiehuoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiehuoxinxi);
        jiehuoxinxiService.insert(jiehuoxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiehuoxinxiEntity jiehuoxinxi, HttpServletRequest request){
    	jiehuoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiehuoxinxi);
        jiehuoxinxiService.insert(jiehuoxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiehuoxinxiEntity jiehuoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiehuoxinxi);
        jiehuoxinxiService.updateById(jiehuoxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiehuoxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
