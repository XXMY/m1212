package com.cfw.m1212.server.type.dao;

import com.cfw.m1212.model.db.Type;
import com.cfw.m1212.server.type.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Fangwei_Cai
 * @time since 2016年4月2日 下午5:52:09
 */
@Repository("typeDao")
public class TypeDao {
	
	@Autowired
	private TypeMapper typeMapper;
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年4月2日 下午5:52:09
	 */
	public List<Type> selectAll() {
		return typeMapper.selectAll();
	}

	/**
	 * @author Fangwei_Cai
	 * @time since 2016年4月11日 上午11:46:33
	 */
	public int insertType(Type type) {
		return this.typeMapper.insertOne(type);
	}

}
