package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 成本核算
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-01-09 19:39:02
 */
@TableName("chengbenhesuan")
public class ChengbenhesuanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ChengbenhesuanEntity() {
		
	}
	
	public ChengbenhesuanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 核算名称
	 */
					
	private String hesuanmingcheng;
	
	/**
	 * 营业外收入
	 */
					
	private Double yingyewaishouru;
	
	/**
	 * 营业收入
	 */
					
	private Double yingyeshouru;
	
	/**
	 * 管理费用
	 */
					
	private Double guanlifeiyong;
	
	/**
	 * 财务费用
	 */
					
	private Double caiwufeiyong;
	
	/**
	 * 利润
	 */
					
	private String lirun;
	
	/**
	 * 核算时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date hesuanshijian;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：核算名称
	 */
	public void setHesuanmingcheng(String hesuanmingcheng) {
		this.hesuanmingcheng = hesuanmingcheng;
	}
	/**
	 * 获取：核算名称
	 */
	public String getHesuanmingcheng() {
		return hesuanmingcheng;
	}
	/**
	 * 设置：营业外收入
	 */
	public void setYingyewaishouru(Double yingyewaishouru) {
		this.yingyewaishouru = yingyewaishouru;
	}
	/**
	 * 获取：营业外收入
	 */
	public Double getYingyewaishouru() {
		return yingyewaishouru;
	}
	/**
	 * 设置：营业收入
	 */
	public void setYingyeshouru(Double yingyeshouru) {
		this.yingyeshouru = yingyeshouru;
	}
	/**
	 * 获取：营业收入
	 */
	public Double getYingyeshouru() {
		return yingyeshouru;
	}
	/**
	 * 设置：管理费用
	 */
	public void setGuanlifeiyong(Double guanlifeiyong) {
		this.guanlifeiyong = guanlifeiyong;
	}
	/**
	 * 获取：管理费用
	 */
	public Double getGuanlifeiyong() {
		return guanlifeiyong;
	}
	/**
	 * 设置：财务费用
	 */
	public void setCaiwufeiyong(Double caiwufeiyong) {
		this.caiwufeiyong = caiwufeiyong;
	}
	/**
	 * 获取：财务费用
	 */
	public Double getCaiwufeiyong() {
		return caiwufeiyong;
	}
	/**
	 * 设置：利润
	 */
	public void setLirun(String lirun) {
		this.lirun = lirun;
	}
	/**
	 * 获取：利润
	 */
	public String getLirun() {
		return lirun;
	}
	/**
	 * 设置：核算时间
	 */
	public void setHesuanshijian(Date hesuanshijian) {
		this.hesuanshijian = hesuanshijian;
	}
	/**
	 * 获取：核算时间
	 */
	public Date getHesuanshijian() {
		return hesuanshijian;
	}

}
