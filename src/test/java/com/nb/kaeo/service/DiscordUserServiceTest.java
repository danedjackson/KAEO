package com.nb.kaeo.service;

import com.nb.kaeo.entity.DiscordUserEntity;
import com.nb.kaeo.repository.DiscordUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/*
 * We know that our repository works from the previous testing.
 * We can now use Mockito to mock our repository instead of autowiring an instance.
 */

@ExtendWith(MockitoExtension.class)
class DiscordUserServiceTest {
    @Mock
    DiscordUserRepository discordUserRepository;

    DiscordUserService discordUserService;

    @BeforeEach
    void setUp() {
        discordUserService = new DiscordUserService(discordUserRepository);
    }

    @Test
    void getAllDiscordUsers() {
        //when
        discordUserService.getAllDiscordUsers();
        //then
        verify(discordUserRepository).findAll();
    }

    @Test
    void getDiscordUserById() {
        //given
        String id = "1234567890";

        //when
        discordUserService.getDiscordUser(id);

        //then
        verify(discordUserRepository).findById(id);
    }

    @Test
    void addDiscordUser() {
        //given
        DiscordUserEntity user = new DiscordUserEntity();
        user.setDiscordId("0214u8091284869");
        user.setUsername("Dane");
        user.setSteamId("7567817231765t124");

        //when
        discordUserService.addDiscordUser(user);

        //then
        ArgumentCaptor<DiscordUserEntity> discordUserArgumentCaptor =
                ArgumentCaptor.forClass(DiscordUserEntity.class);
        verify(discordUserRepository).save(discordUserArgumentCaptor.capture());

        assertThat(user).isEqualTo(discordUserArgumentCaptor.getValue());
    }
}