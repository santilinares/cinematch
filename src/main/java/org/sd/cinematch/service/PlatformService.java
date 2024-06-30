package org.sd.cinematch.service;

import java.util.List;
import java.util.Optional;

import org.sd.cinematch.entity.Platform;
import org.sd.cinematch.repository.PlatformRepository;
import org.springframework.stereotype.Service;

@Service 
public class PlatformService {

    private final PlatformRepository platformRepository;
    public PlatformService(PlatformRepository platformRepository) {
        this.platformRepository = platformRepository;
    }    
    
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
        platformRepository.save(platform);
    }

    public void deleteById(long id){
        platformRepository.deleteById(id);
    }
 }
