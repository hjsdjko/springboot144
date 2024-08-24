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
 * 中转信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-01-09 19:39:02
 */
@TableName("zhongzhuanxinxi")
public class ZhongzhuanxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ZhongzhuanxinxiEntity() {
		
	}
	
	public ZhongzhuanxinxiEntity(T t) {
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
	 * 票据单号
	 */
					
	private String piaojudanhao;
	
	/**
	 * 货物名称
	 */
					
	private String huowumingcheng;
	
	/**
	 * 起始点
	 */
					
	private String qishidian;
	
	/**
	 * 目的地
	 */
					
	private String mudedi;
	
	/**
	 * 货物数量
	 */
					
	private Integer huowushuliang;
	
	/**
	 * 货物重量
	 */
					
	private Double huowuzhongliang;
	
	/**
	 * 货物价格
	 */
					
	private Double huowujiage;
	
	/**
	 * 发货人
	 */
					
	private String fahuoren;
	
	/**
	 * 发货人姓名
	 */
					
	private String fahuorenxingming;
	
	/**
	 * 客户账号
	 */
					
	private String kehuzhanghao;
	
	/**
	 * 客户姓名
	 */
					
	private String kehuxingming;
	
	/**
	 * 货物运费
	 */
					
	private Double huowuyunfei;
	
	/**
	 * 司机账号
	 */
					
	private String sijizhanghao;
	
	/**
	 * 司机姓名
	 */
					
	private String sijixingming;
	
	/**
	 * 手机号码
	 */
					
	private String shoujihaoma;
	
	/**
	 * 车牌号
	 */
					
	private String chepaihao;
	
	/**
	 * 中转地点
	 */
					
	private String zhongzhuandidian;
	
	/**
	 * 中转时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date zhongzhuanshijian;
	
	
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
	 * 设置：票据单号
	 */
	public void setPiaojudanhao(String piaojudanhao) {
		this.piaojudanhao = piaojudanhao;
	}
	/**
	 * 获取：票据单号
	 */
	public String getPiaojudanhao() {
		return piaojudanhao;
	}
	/**
	 * 设置：货物名称
	 */
	public void setHuowumingcheng(String huowumingcheng) {
		this.huowumingcheng = huowumingcheng;
	}
	/**
	 * 获取：货物名称
	 */
	public String getHuowumingcheng() {
		return huowumingcheng;
	}
	/**
	 * 设置：起始点
	 */
	public void setQishidian(String qishidian) {
		this.qishidian = qishidian;
	}
	/**
	 * 获取：起始点
	 */
	public String getQishidian() {
		return qishidian;
	}
	/**
	 * 设置：目的地
	 */
	public void setMudedi(String mudedi) {
		this.mudedi = mudedi;
	}
	/**
	 * 获取：目的地
	 */
	public String getMudedi() {
		return mudedi;
	}
	/**
	 * 设置：货物数量
	 */
	public void setHuowushuliang(Integer huowushuliang) {
		this.huowushuliang = huowushuliang;
	}
	/**
	 * 获取：货物数量
	 */
	public Integer getHuowushuliang() {
		return huowushuliang;
	}
	/**
	 * 设置：货物重量
	 */
	public void setHuowuzhongliang(Double huowuzhongliang) {
		this.huowuzhongliang = huowuzhongliang;
	}
	/**
	 * 获取：货物重量
	 */
	public Double getHuowuzhongliang() {
		return huowuzhongliang;
	}
	/**
	 * 设置：货物价格
	 */
	public void setHuowujiage(Double huowujiage) {
		this.huowujiage = huowujiage;
	}
	/**
	 * 获取：货物价格
	 */
	public Double getHuowujiage() {
		return huowujiage;
	}
	/**
	 * 设置：发货人
	 */
	public void setFahuoren(String fahuoren) {
		this.fahuoren = fahuoren;
	}
	/**
	 * 获取：发货人
	 */
	public String getFahuoren() {
		return fahuoren;
	}
	/**
	 * 设置：发货人姓名
	 */
	public void setFahuorenxingming(String fahuorenxingming) {
		this.fahuorenxingming = fahuorenxingming;
	}
	/**
	 * 获取：发货人姓名
	 */
	public String getFahuorenxingming() {
		return fahuorenxingming;
	}
	/**
	 * 设置：客户账号
	 */
	public void setKehuzhanghao(String kehuzhanghao) {
		this.kehuzhanghao = kehuzhanghao;
	}
	/**
	 * 获取：客户账号
	 */
	public String getKehuzhanghao() {
		return kehuzhanghao;
	}
	/**
	 * 设置：客户姓名
	 */
	public void setKehuxingming(String kehuxingming) {
		this.kehuxingming = kehuxingming;
	}
	/**
	 * 获取：客户姓名
	 */
	public String getKehuxingming() {
		return kehuxingming;
	}
	/**
	 * 设置：货物运费
	 */
	public void setHuowuyunfei(Double huowuyunfei) {
		this.huowuyunfei = huowuyunfei;
	}
	/**
	 * 获取：货物运费
	 */
	public Double getHuowuyunfei() {
		return huowuyunfei;
	}
	/**
	 * 设置：司机账号
	 */
	public void setSijizhanghao(String sijizhanghao) {
		this.sijizhanghao = sijizhanghao;
	}
	/**
	 * 获取：司机账号
	 */
	public String getSijizhanghao() {
		return sijizhanghao;
	}
	/**
	 * 设置：司机姓名
	 */
	public void setSijixingming(String sijixingming) {
		this.sijixingming = sijixingming;
	}
	/**
	 * 获取：司机姓名
	 */
	public String getSijixingming() {
		return sijixingming;
	}
	/**
	 * 设置：手机号码
	 */
	public void setShoujihaoma(String shoujihaoma) {
		this.shoujihaoma = shoujihaoma;
	}
	/**
	 * 获取：手机号码
	 */
	public String getShoujihaoma() {
		return shoujihaoma;
	}
	/**
	 * 设置：车牌号
	 */
	public void setChepaihao(String chepaihao) {
		this.chepaihao = chepaihao;
	}
	/**
	 * 获取：车牌号
	 */
	public String getChepaihao() {
		return chepaihao;
	}
	/**
	 * 设置：中转地点
	 */
	public void setZhongzhuandidian(String zhongzhuandidian) {
		this.zhongzhuandidian = zhongzhuandidian;
	}
	/**
	 * 获取：中转地点
	 */
	public String getZhongzhuandidian() {
		return zhongzhuandidian;
	}
	/**
	 * 设置：中转时间
	 */
	public void setZhongzhuanshijian(Date zhongzhuanshijian) {
		this.zhongzhuanshijian = zhongzhuanshijian;
	}
	/**
	 * 获取：中转时间
	 */
	public Date getZhongzhuanshijian() {
		return zhongzhuanshijian;
	}

}
