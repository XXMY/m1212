package mapper;

import com.cfw.m1212.server.comment.ServerCommentApplication;
import com.cfw.m1212.server.comment.mapper.CommentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Duskrain on 2017/5/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ServerCommentApplication.class)
public class CommentMapperTest {

    @Autowired
    private CommentMapper commentMapper;

    @Test
    public void test(){
        System.out.println(commentMapper.selectComments(2100));
    }
}
