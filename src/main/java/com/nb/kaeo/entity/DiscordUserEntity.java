package com.nb.kaeo.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "DISCORD_USER")
public class DiscordUserEntity {
    @Id
    private String discordId;
    private String username;
    private String steamId;
}
