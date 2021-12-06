package com.nb.kaeo.service;

import com.nb.kaeo.entity.DiscordUserEntity;
import com.nb.kaeo.repository.DiscordUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiscordUserService {

    private DiscordUserRepository discordUserRepository;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public DiscordUserService( DiscordUserRepository discordUserRepository) {
        this.discordUserRepository = discordUserRepository;
    }

    public List<DiscordUserEntity> getAllDiscordUsers(){
        return discordUserRepository.findAll();
    }

    public Optional<DiscordUserEntity> getDiscordUser(String userId) {
        logger.info("Fetching user info by user ID " + userId);
        return discordUserRepository.findById(userId);
    }

    public void addDiscordUser(DiscordUserEntity discordUserEntity) {
        logger.info("Attempting to add discord user. . . ");
        discordUserRepository.save(discordUserEntity);
    }

}
