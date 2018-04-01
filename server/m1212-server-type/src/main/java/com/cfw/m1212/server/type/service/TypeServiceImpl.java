package com.cfw.m1212.server.type.service;

import com.cfw.m1212.api.TypeService;
import com.cfw.m1212.model.db.Type;
import com.cfw.m1212.server.type.dao.TypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Fangwei_Cai
 * @time since 2016年4月2日 下午5:55:41
 */
@Service("typeService")
public class TypeServiceImpl implements TypeService {

	@Autowired
	private TypeDao typeDao;

	/**
	 * @author Fangwei_Cai
	 * @time since 2016年4月8日 下午4:35:57
	 */
	@Override
	public List<Type> getAllTypes() {
		return typeDao.selectAll();
	}
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年4月11日 上午11:44:49
	 */
	@Override
	public boolean addType(Type type) {
		return typeDao.insertType(type) > 0;
	}

}
