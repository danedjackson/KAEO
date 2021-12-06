package com.nb.kaeo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "DISCORD_USER")
public class DiscordUserEntity {
    @Id
    private String discordId;
    private String username;
    private String steamId;

    @OneToMany(mappedBy = "discordUser", fetch = FetchType.LAZY)
    private Set<WarningEntity> warnings;
}
