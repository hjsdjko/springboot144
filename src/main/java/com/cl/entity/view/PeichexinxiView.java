package com.cl.entity.view;

import com.cl.entity.PeichexinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * 配车信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-01-09 19:39:02
 */
@TableName("peichexinxi")
public class PeichexinxiView  extends PeichexinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public PeichexinxiView(){
	}
 
 	public PeichexinxiView(PeichexinxiEntity peichexinxiEntity){
 	try {
			BeanUtils.copyProperties(this, peichexinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}
