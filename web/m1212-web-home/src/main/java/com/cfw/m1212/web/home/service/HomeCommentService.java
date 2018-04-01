package com.cfw.m1212.web.home.service;

import com.cfw.m1212.api.CommentService;
import com.cfw.m1212.model.db.Comment;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Duskrain on 2017/9/9.
 */
@Service
public class HomeCommentService {

    private Log logger = LogFactory.getLog(HomeCommentService.class);

    @Autowired
    private CommentService remoteCommentService;

    public List<Comment> getCommentsOfMovie(Integer id) {
        try {
            return this.remoteCommentService.getCommentsOfMovie(id);
        } catch (Exception e) {
            this.logger.error(e.getMessage(),e);
        }

        return null;
    }
}
