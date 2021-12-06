package com.nb.kaeo.controller;

import com.nb.kaeo.model.Warning;
import com.nb.kaeo.service.WarningService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/warning")
public class WarningController {
    @Autowired
    private WarningService warningService;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/add")
    public void addWarning(@RequestBody Warning warning) {
        logger.info("Adding warning for user: " + warning.getDiscordName());

        warningService.addWarning(warning);
    }

}
