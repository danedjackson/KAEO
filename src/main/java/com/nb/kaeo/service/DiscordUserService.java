package com.nb.kaeo.service;

import com.nb.kaeo.entity.DiscordUserEntity;
import com.nb.kaeo.repository.DiscordUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiscordUserService {

    private DiscordUserRepository discordUserRepository;

    @Autowired
    public DiscordUserService( DiscordUserRepository discordUserRepository) {
        this.discordUserRepository = discordUserRepository;
    }

    public List<DiscordUserEntity> getAllDiscordUsers(){
        return discordUserRepository.findAll();
    }

    public Optional<DiscordUserEntity> getDiscordUser(String userId) {
        return discordUserRepository.findById(userId);
    }

}
