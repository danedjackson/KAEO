package com.nb.kaeo.repository;

import com.nb.kaeo.entity.WarningEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarningRepository extends JpaRepository<WarningEntity, Long> {

}
