package org.sd.cinematch.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.sd.cinematch.entity.Platform;
import org.sd.cinematch.repository.PlatformRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor; 
@Service 
public class PlatformService {

    private final PlatformRepository platformRepository;
    public PlatformService(PlatformRepository platformRepository) {
        this.platformRepository = platformRepository;
    }
    private AtomicLong nextId = new AtomicLong(1);
    public List<Platform> findAll(){
        return platformRepository.findAll();
    }

    public Platform findById(final long id){
       Optional<Platform> optionalPlatform = platformRepository.findById(id);
       if (optionalPlatform.isPresent()) {
        return optionalPlatform.get();
       } else {
        throw new RuntimeException("Platform not found");
       }
    }

    public void save(Platform platform) {

        if (platform.getId()== null || platform.getId() == 0){
            long id = nextId.getAndIncrement();
            platform.setId(id);
        }
        platformRepository.save(platform);
    }

    public void deleteById(long id){
        platformRepository.deleteById(id);
    }
 }
