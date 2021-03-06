package com.cfw.m1212.server.comment.dao;

import com.cfw.m1212.model.Comment;
import com.cfw.m1212.server.comment.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Fangwei_Cai
 * @time since 2016年5月1日 上午11:44:42
 */
@Repository("commentDao")
public class CommentDao {

	@Autowired
	private CommentMapper commentMapper;

	/**
	 * (non-Javadoc)
	 * @author Fangwei_Cai
	 * @time since 2016年5月1日 上午11:45:08
	 */
	public int insertComment(Comment comment) {

		return this.commentMapper.insertOne(comment);
	}

	/**
	 * (non-Javadoc)
	 * @author Fangwei_Cai
	 * @time since 2016年5月7日 上午11:02:05
	 */
	public List<Comment> selectCommentsOfMovie(Integer mid) {
		return this.commentMapper.selectComments(mid);
	}

}
