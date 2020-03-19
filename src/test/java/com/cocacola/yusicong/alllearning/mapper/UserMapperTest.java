package com.cocacola.yusicong.alllearning.mapper;

import com.cocacola.yusicong.alllearning.domain.entity.UserDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Create by idea
 *
 * @author yusicong
 * @date 2020/3/17
 * @time 22:59
 */
@SpringBootTest
@Slf4j
public class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void find() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("username", "username1");
        List<UserDO> userDOS = userMapper.selectByMap(hashMap);
        log.info("{}", userDOS);
    }
}
