package com.nb.kaeo.repository;

import com.nb.kaeo.entity.WarningEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarningRepository extends JpaRepository<WarningEntity, Long> {
    List<WarningEntity> getWarningByDiscordUser(String user);
}
