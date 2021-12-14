package com.nb.kaeo.controller;

import com.nb.kaeo.entity.DiscordUserEntity;
import com.nb.kaeo.service.DiscordUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class DiscordUserController {
    private DiscordUserService discordUserService;
    Logger logger = LoggerFactory.getLogger(DiscordUserController.class);

    @Autowired
    public DiscordUserController(DiscordUserService discordUserService) {
        this.discordUserService = discordUserService;
    }

    @GetMapping("/all")
    public List<DiscordUserEntity> getAllDiscordUsers() {
        return discordUserService.getAllDiscordUsers();
    }

    @GetMapping("/{userId}")
    public Optional<DiscordUserEntity> getUserById(@PathVariable("userId") String userId) {
        logger.info("Searching for user ID: " + userId);
        return discordUserService.getDiscordUser(userId);
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody DiscordUserEntity discordUserEntity) {
        logger.info("Adding user {} to the database. . .", discordUserEntity.getUsername());
        boolean response = discordUserService.addDiscordUser(discordUserEntity);
        if(response) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
