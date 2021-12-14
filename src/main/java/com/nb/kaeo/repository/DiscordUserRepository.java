package com.nb.kaeo.repository;

import com.nb.kaeo.entity.DiscordUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscordUserRepository extends JpaRepository<DiscordUserEntity, String> {
    List<DiscordUserEntity> findByUsername(String username);
}
