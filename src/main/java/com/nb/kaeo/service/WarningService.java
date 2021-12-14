package com.nb.kaeo.service;

import com.nb.kaeo.entity.DiscordUserEntity;
import com.nb.kaeo.entity.WarningEntity;
import com.nb.kaeo.model.Warning;
import com.nb.kaeo.repository.WarningRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WarningService {
    @Autowired
    private WarningRepository warningRepository;
    @Autowired
    private DiscordUserService discordUserService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public void addWarning(Warning warning) {
        logger.info("Attempting to add warning to the database. . .");

        try {
            //If the user does not exist, add them to the DISCORD_USER Table
            if (discordUserService.getDiscordUser(warning.getDiscordId()).isEmpty()) {
                DiscordUserEntity discordUserEntity = new DiscordUserEntity();
                discordUserEntity.setDiscordId(warning.getDiscordId());
                discordUserEntity.setUsername(warning.getDiscordName());
                discordUserEntity.setSteamId(warning.getSteamId());

                discordUserService.addDiscordUser(discordUserEntity);
            }

            //Creating warning object to save
            WarningEntity warningEntity = new WarningEntity();
            warningEntity.setDiscordUserId(warning.getDiscordId());
            warningEntity.setNotes(warning.getNotes());
            warningEntity.setEntryDate(LocalDateTime.now());
            warningEntity.setCurrent(false);

            warningRepository.save(warningEntity);
        } catch (NullPointerException nullPointerException) {
            logger.error("Something went wrong accessing object fields");
        } catch (DataAccessException dataAccessException) {
            logger.error("Something went wrong in the database processes");
        }
    }

    public List<WarningEntity> getUserByName(String name) {
//        List<DiscordUserEntity> discordUsers = discordUserService.getAllDiscordUsers();

//        DiscordUserEntity discordUserEntity = discordUsers.stream()
//                .filter(user -> name.equalsIgnoreCase(user.getUsername()))
//                .findAny()
//                .orElse(null);

        DiscordUserEntity discordUserEntity = discordUserService.getDiscordUserByName(name).get(0);
        logger.info(discordUserEntity.toString());

        if (discordUserEntity != null) {
            return warningRepository.findByDiscordUserId(discordUserEntity.getDiscordId());
        }

        return null;
    }
}
