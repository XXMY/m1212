package com.cfw.m1212.server.description.mapper;

import com.cfw.m1212.model.Description;
import com.cfw.plugins.database.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Fangwei_Cai
 * @time since 2016年4月8日 下午3:12:44
 */
@Repository("descriptionMapper")
@Mapper
public interface DescriptionMapper extends BaseMapper<Description> {
	
}
