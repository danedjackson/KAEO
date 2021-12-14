package com.nb.kaeo.repository;

import com.nb.kaeo.entity.DiscordUserEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class DiscordUserRepositoryTest {
    @Autowired
    private DiscordUserRepository discordUserRepository;

    @AfterEach
    void tearDown() {
        discordUserRepository.deleteAll();
    }

    @Test
    void checkIfUserIdExists() {
        //given
        DiscordUserEntity userEntity = new DiscordUserEntity();
        userEntity.setDiscordId("12893712896412");
        discordUserRepository.save(userEntity);

        //when
        DiscordUserEntity user = discordUserRepository.getById("12893712896412");

        //then
        assertThat(user).hasFieldOrPropertyWithValue("discordId", "12893712896412");
    }

    @Test
    void checkIfUserIdDoesNotExist() {
        //given
        String id = "123";

        //when
        Optional<DiscordUserEntity> user = discordUserRepository.findById(id);

        //then
        assertThat(user).isEmpty();
    }

    @Test
    void checkIfIdExistsGivenAName() {
        //given
        String username = "Monarch";

        //when
        List<DiscordUserEntity> user = discordUserRepository.findByUsername(username);

        //then
        assertThat(user).isNotNull();
    }
}