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

import com.cl.entity.ChengbenhesuanEntity;
import com.cl.entity.view.ChengbenhesuanView;

import com.cl.service.ChengbenhesuanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MD5Util;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 成本核算
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-09 19:39:02
 */
@RestController
@RequestMapping("/chengbenhesuan")
public class ChengbenhesuanController {
    @Autowired
    private ChengbenhesuanService chengbenhesuanService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChengbenhesuanEntity chengbenhesuan,
		HttpServletRequest request){
        EntityWrapper<ChengbenhesuanEntity> ew = new EntityWrapper<ChengbenhesuanEntity>();

		PageUtils page = chengbenhesuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chengbenhesuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChengbenhesuanEntity chengbenhesuan, 
		HttpServletRequest request){
        EntityWrapper<ChengbenhesuanEntity> ew = new EntityWrapper<ChengbenhesuanEntity>();

		PageUtils page = chengbenhesuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chengbenhesuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChengbenhesuanEntity chengbenhesuan){
       	EntityWrapper<ChengbenhesuanEntity> ew = new EntityWrapper<ChengbenhesuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chengbenhesuan, "chengbenhesuan")); 
        return R.ok().put("data", chengbenhesuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChengbenhesuanEntity chengbenhesuan){
        EntityWrapper< ChengbenhesuanEntity> ew = new EntityWrapper< ChengbenhesuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chengbenhesuan, "chengbenhesuan")); 
		ChengbenhesuanView chengbenhesuanView =  chengbenhesuanService.selectView(ew);
		return R.ok("查询成本核算成功").put("data", chengbenhesuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChengbenhesuanEntity chengbenhesuan = chengbenhesuanService.selectById(id);
        return R.ok().put("data", chengbenhesuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChengbenhesuanEntity chengbenhesuan = chengbenhesuanService.selectById(id);
        return R.ok().put("data", chengbenhesuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChengbenhesuanEntity chengbenhesuan, HttpServletRequest request){
    	chengbenhesuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chengbenhesuan);
        chengbenhesuanService.insert(chengbenhesuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChengbenhesuanEntity chengbenhesuan, HttpServletRequest request){
    	chengbenhesuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chengbenhesuan);
        chengbenhesuanService.insert(chengbenhesuan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChengbenhesuanEntity chengbenhesuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chengbenhesuan);
        chengbenhesuanService.updateById(chengbenhesuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chengbenhesuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
