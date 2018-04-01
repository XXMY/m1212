package com.cfw.m1212.server.description.dao;

import com.cfw.m1212.model.db.Description;
import com.cfw.m1212.server.description.mapper.DescriptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Fangwei_Cai
 * @time since 2016年4月8日 下午4:33:33
 */
@Repository("descriptionDao")
public class DescriptionDao {

	@Autowired
	private DescriptionMapper descriptionMapper;
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年4月8日 下午4:32:37
	 */
	public int insertDescription(Description description) {
		return this.descriptionMapper.insertOne(description);
	}

	/**
	 * (non-Javadoc)
	 * @author Fangwei_Cai
	 * @time since 2016年6月1日 下午4:43:05
	 */
	public int updateOne(Description description) {
		return this.descriptionMapper.updateOne(description);
	}

}
