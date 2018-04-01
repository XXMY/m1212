package com.cfw.m1212.api;

import com.cfw.m1212.model.db.Description;

/**
 * @author Fangwei_Cai
 * @time since 2016年4月2日 下午5:54:26
 */
public interface DescriptionService {

	/**
	 * @author Fangwei_Cai
	 * @time since 2016年4月8日 下午4:44:47
	 */
	Integer addDescription(Description description);

	boolean modifyDescription(Description description);

}
