package mapper;

import com.cfw.m1212.server.user.ServerUserApplication;
import com.cfw.m1212.server.user.mapper.UsersMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ServerUserApplication.class)
public class UsersMapperTest {

    @Autowired
    private UsersMapper usersMapper;

    @Test
    public void testSelectUserByName(){
        this.usersMapper.selectUserByName("cfw");
        this.usersMapper.selectUserByName("cfw");
    }
}
