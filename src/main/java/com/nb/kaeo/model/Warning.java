package com.nb.kaeo.model;

import lombok.Data;

@Data
public class Warning {
    private String discordName;
    private String discordId;
    private String steamId;

    private String notes;
}
