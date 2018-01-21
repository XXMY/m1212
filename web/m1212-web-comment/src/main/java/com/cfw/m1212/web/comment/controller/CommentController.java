package com.cfw.m1212.web.comment.controller;

import com.cfw.m1212.api.CommentService;
import com.cfw.m1212.model.Comment;
import com.cfw.m1212.web.commons.controller.BaseController;
import com.cfw.m1212.web.commons.enums.ResponseTypeEnum;
import com.cfw.m1212.web.commons.vo.MoviesResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cfw on 2017/5/10.
 */
@Controller
@RequestMapping("/Comment")
public class CommentController extends BaseController {

    @Autowired
    private CommentService remoteCommentService;

    private Log logger = LogFactory.getLog(CommentController.class);

    @RequestMapping("/comment")
    @ResponseBody
    public MoviesResponse comment(@RequestParam("mid") Integer movieId, String username, String comment, float score){
        this.logger.info("[Comment/comment] Received Request: movieId=" + movieId
                + ", username=" + username + ", comment=" + comment + ", score=" + score);

        MoviesResponse response = new MoviesResponse();

        try{
            if(this.remoteCommentService.addComment(movieId,username,comment,score))
                response = buildResponse(ResponseTypeEnum.SUCCESS);
            else
                response = buildResponse(ResponseTypeEnum.COMMENT_FAILED);
        }catch (Exception e){
            this.logger.error(e.getMessage(),e);
            response = buildResponse(ResponseTypeEnum.COMMENT_FAILED);
        }

        return response;
    }

    @RequestMapping("/fetch")
    @ResponseBody
    public MoviesResponse fetchComent(Integer movieId){
        this.logger.info("[Comment/fetch] Received Request: movieId=" + movieId);

        MoviesResponse response = new MoviesResponse();

        List<Comment> commentList = new ArrayList<Comment>();
        try{
            commentList = this.remoteCommentService.getCommentsOfMovie(movieId);
            response = buildResponse(ResponseTypeEnum.SUCCESS);
        }catch(Exception e){
            this.logger.error(e.getMessage(),e);
            response = buildResponse(ResponseTypeEnum.FAILED);
        }

        response.setData(commentList);

        return response;
    }

}
