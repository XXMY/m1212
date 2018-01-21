package com.cfw.m1212.server.comment.service;

import com.cfw.m1212.api.CommentService;
import com.cfw.m1212.api.UserService;
import com.cfw.m1212.model.Comment;
import com.cfw.m1212.model.User;
import com.cfw.m1212.server.comment.dao.CommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Cfw on 2017/5/5.
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Resource(name = "commentDao")
    private CommentDao commentDao;

    @Autowired
    private UserService remoteUserService;

    /**
     * Add a new comment.
     *
     * @param movieId
     * @param username
     * @param comment
     * @param score
     * @return
     * @author Fangwei_Cai
     * @time since 2016年5月1日 上午11:48:13
     */
    @Override
    public boolean addComment(Integer movieId, String username, String comment, float score) {
        Comment c = new Comment();
        c.setMid(movieId);

        User user = this.remoteUserService.getBriefInfo(username);
        c.setUser(user);
        c.setComment(comment);
        c.setScore(score);

        return this.commentDao.insertComment(c) > 0;
    }

    /**
     * @param movieId
     * @return
     * @author Fangwei_Cai
     * @time since 2016年5月7日 上午11:08:55
     */
    @Override
    public List<Comment> getCommentsOfMovie(Integer movieId) {
        return this.commentDao.selectCommentsOfMovie(movieId);
    }
}
