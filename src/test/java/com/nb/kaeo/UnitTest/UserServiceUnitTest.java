package com.nb.kaeo.UnitTest;

import com.nb.kaeo.entity.DiscordUserEntity;
import com.nb.kaeo.service.DiscordUserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceUnitTest {

    @Autowired
    private DiscordUserService discordUserService;

    public UserServiceUnitTest(){}

    @Test
    public void whenApplicationStarts_thenHibernateCreatesInititalRecords() {
        List<DiscordUserEntity> discordUserEntities = discordUserService.getAllDiscordUsers();
        Assert.assertEquals(discordUserEntities.size(), 3);
    }
}
