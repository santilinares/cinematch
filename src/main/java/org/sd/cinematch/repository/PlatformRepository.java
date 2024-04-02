package org.sd.cinematch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sd.cinematch.model.Platform;

public interface PlatformRepository extends JpaRepository<Platform, Long>{
    
}