package com.cfw.m1212.web.home.service;

import com.cfw.m1212.model.Comment;
import com.cfw.plugins.mq.rabbitmq.rpc.client.dispatch.OutboundDispatcher;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Duskrain on 2017/9/9.
 */
@Service
@Deprecated
public class CommentClientService {

    @Value("${movies.remote.comment}")
    private String remoteServer;

    @Value("${movies.remote.commentService}")
    private String remoteService;

    @Value("${movies.remote.commentService.getCommentsOfMovie}")
    private String remoteGetCommentsOfMovie;

    private Log logger = LogFactory.getLog(CommentClientService.class);

    @Autowired
    private OutboundDispatcher outboundDispatcher;

    public List<Comment> getCommentsOfMovie(Integer id) {
        try {
            return this.outboundDispatcher.dispatch(remoteServer,remoteService,remoteGetCommentsOfMovie,List.class,id);
        } catch (Exception e) {
            this.logger.error(e.getMessage(),e);
        }

        return null;
    }
}
