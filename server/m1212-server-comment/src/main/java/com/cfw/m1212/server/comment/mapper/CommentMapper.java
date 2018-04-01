package com.cfw.m1212.server.comment.mapper;

import com.cfw.m1212.model.db.Comment;
import com.cfw.plugins.database.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Fangwei_Cai
 * @time since 2016年5月1日 上午11:37:55
 */
@Repository
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

	/**
	 * Select comments of one movie.
	 * @author Fangwei_Cai
	 * @time since 2016年5月7日 上午10:35:16
	 * @param mid {Long} movie id.
	 * @return
	 */
	List<Comment> selectComments(@Param("mid") Integer mid);
}
