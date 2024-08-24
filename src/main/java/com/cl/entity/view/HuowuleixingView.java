package com.cl.entity.view;

import com.cl.entity.HuowuleixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * 货物类型
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-01-09 19:39:02
 */
@TableName("huowuleixing")
public class HuowuleixingView  extends HuowuleixingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public HuowuleixingView(){
	}
 
 	public HuowuleixingView(HuowuleixingEntity huowuleixingEntity){
 	try {
			BeanUtils.copyProperties(this, huowuleixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}