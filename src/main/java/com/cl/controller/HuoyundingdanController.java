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

import com.cl.entity.HuoyundingdanEntity;
import com.cl.entity.view.HuoyundingdanView;

import com.cl.service.HuoyundingdanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MD5Util;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 货运订单
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-09 19:39:02
 */
@RestController
@RequestMapping("/huoyundingdan")
public class HuoyundingdanController {
    @Autowired
    private HuoyundingdanService huoyundingdanService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HuoyundingdanEntity huoyundingdan,
		HttpServletRequest request){
        EntityWrapper<HuoyundingdanEntity> ew = new EntityWrapper<HuoyundingdanEntity>();

        String tableName = request.getSession().getAttribute("tableName").toString();
        ew.andNew();
        if(tableName.equals("kehu")) {
            ew.eq("fahuoren", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("kehu")) {
            ew.or();
            ew.eq("kehuzhanghao", (String)request.getSession().getAttribute("username"));
        }
		PageUtils page = huoyundingdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huoyundingdan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuoyundingdanEntity huoyundingdan, 
		HttpServletRequest request){
        EntityWrapper<HuoyundingdanEntity> ew = new EntityWrapper<HuoyundingdanEntity>();

		PageUtils page = huoyundingdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huoyundingdan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuoyundingdanEntity huoyundingdan){
       	EntityWrapper<HuoyundingdanEntity> ew = new EntityWrapper<HuoyundingdanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huoyundingdan, "huoyundingdan")); 
        return R.ok().put("data", huoyundingdanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuoyundingdanEntity huoyundingdan){
        EntityWrapper< HuoyundingdanEntity> ew = new EntityWrapper< HuoyundingdanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huoyundingdan, "huoyundingdan")); 
		HuoyundingdanView huoyundingdanView =  huoyundingdanService.selectView(ew);
		return R.ok("查询货运订单成功").put("data", huoyundingdanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuoyundingdanEntity huoyundingdan = huoyundingdanService.selectById(id);
        return R.ok().put("data", huoyundingdan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuoyundingdanEntity huoyundingdan = huoyundingdanService.selectById(id);
        return R.ok().put("data", huoyundingdan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HuoyundingdanEntity huoyundingdan, HttpServletRequest request){
    	huoyundingdan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huoyundingdan);
        huoyundingdanService.insert(huoyundingdan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HuoyundingdanEntity huoyundingdan, HttpServletRequest request){
    	huoyundingdan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huoyundingdan);
        huoyundingdanService.insert(huoyundingdan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HuoyundingdanEntity huoyundingdan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huoyundingdan);
        huoyundingdanService.updateById(huoyundingdan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        huoyundingdanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
