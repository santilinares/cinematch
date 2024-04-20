package org.sd.cinematch.repository;

import org.sd.cinematch.entity.Platform;
import org.springframework.data.jpa.repository.JpaRepository; 

public interface PlatformRepository  extends JpaRepository<Platform, Long> {
    
}