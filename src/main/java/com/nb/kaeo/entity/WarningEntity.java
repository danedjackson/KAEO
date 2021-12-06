package com.nb.kaeo.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "WARNINGS")
@Data
public class WarningEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long warningId;
    private String discordUserId;
    private String notes;
    private LocalDateTime entryDate;
    private Boolean current;
}
