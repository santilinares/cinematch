package org.sd.cinematch.service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import java.util.Collection;
import org.sd.cinematch.entity.Platform;
import org.springframework.stereotype.Service;

@Service
public class PlatformService {
    private ConcurrentMap<Long, Platform> platforms = new ConcurrentHashMap<>();
    private AtomicLong nextId = new AtomicLong(1);

    public PlatformService() {
    }

    public Collection<Platform> findAll() {
        return platforms.values();
    }

    public Platform findById(long id) {
        return platforms.get(id);
    }

    public void save(Platform platform) {
        if (platform.getId() == null || platform.getId() == 0) {
            long id = nextId.getAndIncrement();
            platform.setId(id);
        }

        this.platforms.put(platform.getId(), platform);
    }

    public void deleteById(long id) {
        this.platforms.remove(id);
    }
}