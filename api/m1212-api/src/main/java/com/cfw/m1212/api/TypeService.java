package com.cfw.m1212.api;

import com.cfw.m1212.model.Type;

import java.util.List;

/**
 * @author Fangwei_Cai
 * @time since 2016年4月2日 下午5:54:26
 */
public interface TypeService {

	/**
	 * @author Fangwei_Cai
	 * @time since 2016年4月2日 下午5:54:52
	 */
	List<Type> getAllTypes();

	/**
	 * @author Fangwei_Cai
	 * @time since 2016年4月11日 上午11:44:22
	 */
	boolean addType(Type type);
}
