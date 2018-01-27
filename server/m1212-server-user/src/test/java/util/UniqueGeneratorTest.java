package util;

import com.cfw.m1212.server.commons.enums.AccountTypeEnum;
import com.cfw.m1212.server.user.ServerUserApplication;
import com.cfw.m1212.server.user.util.UniqueGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Duskrain on 2017/5/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ServerUserApplication.class)
public class UniqueGeneratorTest {

    @Autowired
    private UniqueGenerator uniqueGenerator;

    @Test
    public void test(){
        System.out.println(uniqueGenerator.newUserKey(AccountTypeEnum.MOVIE));
    }

}
