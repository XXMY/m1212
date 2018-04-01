package com.cfw.m1212.server.description.service;

import com.cfw.m1212.api.DescriptionService;
import com.cfw.m1212.model.db.Description;
import com.cfw.m1212.server.description.dao.DescriptionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Fangwei_Cai
 * @time since 2016年4月2日 下午5:55:41
 */
@Service("descriptionService")
public class DescriptionServiceImpl implements DescriptionService {
	
	@Autowired
	private DescriptionDao descriptionDao;
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年4月8日 下午4:45:40
	 */
	@Override
	public Integer addDescription(Description description) {
		return descriptionDao.insertDescription(description);
	}

	@Override
	public boolean modifyDescription(Description description) {
		return this.descriptionDao.updateOne(description) > 0;
	}

}
