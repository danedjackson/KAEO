package com.nb.kaeo.controller;

import com.nb.kaeo.entity.DiscordUserEntity;
import com.nb.kaeo.service.DiscordUserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class DiscordUserControllerTest {

    @Autowired
    private DiscordUserController discordUserController;

    @Test
    void whenApplicationStarts_thenHibernateCreatesInititalRecords() {
        List<DiscordUserEntity> users = discordUserController.getAllDiscordUsers();
        assertEquals(users.size(), 3);
    }

    @Test
    void whenApplicationStarts_thenHibernateCreatesInitialRecords() {
        Optional<DiscordUserEntity> user = discordUserController.getUserById("1234567890");
        assertEquals("Monarch", user.get().getUsername());
    }
}