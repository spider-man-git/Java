import javax.annotation.Resource;

import com.cmyzzf.TransactionMain;
import com.cmyzzf.model.User;
import com.cmyzzf.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TransactionMain.class)
public class TranslationTest {

    @Resource
    private IUserService userService;

    /**
     * 事务测试  ---- 脏读:读未提交 Isolation.READ_UNCOMMITTED
     *                读已提交 Read committed
     */
    @Test
    public void testUserInser() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    userService.insert(new User("zzf",18));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                User user = userService.selectUserUnCommit("zzf");
                System.out.println(user.getId());
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                User user1 = userService.selectUserCommit("zzf");
                System.out.println("commit="+user1.getId());
            }
        });
        //事务一    插入A ，插入成功但是事务未提交且报错会导致回滚
        thread.start();
        //事务二    查询A ，读未提交，读取到数据库中未提交的记录，当事务一回滚，则造成脏读
        thread1.start();
        //事务三    查询A，读已提交，读取出来的数据为空，因为事务一提交失败。
        thread2.start();
    }

    /**
     * 测试不可重复读
     */
    @Test
    public void testRead(){

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                User user = userService.testRepeatRead("zzf");
                System.out.println(user.getId());
            }
        });
        thread1.start();
    }
    /**
     *
     * 事务的传播行为介绍
     *
     *  Propagation
     *
     *
     */


}
