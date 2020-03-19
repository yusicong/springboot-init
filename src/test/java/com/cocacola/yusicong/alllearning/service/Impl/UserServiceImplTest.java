package com.cocacola.yusicong.alllearning.service.Impl;

import com.cocacola.yusicong.alllearning.domain.dto.UserDTO;
import com.cocacola.yusicong.alllearning.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Create by idea
 *
 * @author yusicong
 * @date 2020/3/17
 * @time 23:59
 */
@SpringBootTest
@Slf4j
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void saveTest() {
        UserDTO userDTO = new UserDTO("于思聪", "123", "745953091@qq.com", 18, "110");
        int save = userService.save(userDTO);
        log.info("save result:{}", save);
    }

    /**
     * 乐观锁使用的规则.
     * 1.如果更新数据中不带有version字段:不使用乐观锁，并且version不会累加
     * 2.如果更新字段中带有version,但与数据库中不一致，更新失败
     * 3.如果带有version， 并且与数据库中一致，更新成功，并且version会累加
     */
    @Test
    public void updateTest() {
        UserDTO userDTO = new UserDTO();
        userDTO.setAge(14);
        userDTO.setVersion(1L);
        int update = userService.update(1240637736590172161L, userDTO);
        log.info("update result:{}", update);
    }

    @Test
    public void delete() {
        int delete = userService.delete(1240637736590172161L);
        log.info("delete result:{}", delete);

    }


}
