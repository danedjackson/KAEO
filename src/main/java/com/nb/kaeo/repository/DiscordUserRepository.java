package com.nb.kaeo.repository;

import com.nb.kaeo.entity.DiscordUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscordUserRepository extends JpaRepository<DiscordUserEntity, String> {}
