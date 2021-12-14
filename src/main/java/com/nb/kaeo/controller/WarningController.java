package com.nb.kaeo.controller;

import com.nb.kaeo.entity.DiscordUserEntity;
import com.nb.kaeo.model.Warning;
import com.nb.kaeo.service.WarningService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/warning")
public class WarningController {
    @Autowired
    private WarningService warningService;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/add")
    public ResponseEntity addWarning(@RequestBody Warning warning) {
        logger.info("Adding warning for user: " + warning.getDiscordName());

        warningService.addWarning(warning);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{discordName}")
    public ResponseEntity<DiscordUserEntity> getUser(@PathVariable("discordName") String name) {
        logger.info("Retrieving information for user: {}", name);
        return new ResponseEntity(warningService.getUserByName(name), HttpStatus.OK);
    }
}
