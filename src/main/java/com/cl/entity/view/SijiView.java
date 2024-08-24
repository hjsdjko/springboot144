package com.cl.entity.view;

import com.cl.entity.SijiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * 司机
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-01-09 19:39:02
 */
@TableName("siji")
public class SijiView  extends SijiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public SijiView(){
	}
 
 	public SijiView(SijiEntity sijiEntity){
 	try {
			BeanUtils.copyProperties(this, sijiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}
