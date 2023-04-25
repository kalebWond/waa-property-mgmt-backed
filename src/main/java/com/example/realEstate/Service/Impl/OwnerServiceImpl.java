package com.example.realEstate.Service.Impl;

import com.example.realEstate.Repository.OwnerRepository;
import com.example.realEstate.Service.OwnerService;
import com.example.realEstate.entity.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    OwnerRepository ownerRepository;


    @Override
    public List<Owner> findAll() {
        return ownerRepository.findAllOwnerByRegistration();
    }


    @Override
    public void activateOwner(Long id) {
        var isOwner= ownerRepository.findById(id);
        if(isOwner.isPresent()){
            isOwner.get().setActivated(true);
            ownerRepository.save(isOwner.get());
        }
    }


    @Override
    public void deactivateOwner(Long id) {
        var isOwner= ownerRepository.findById(id);
        if(isOwner.isPresent()){
            isOwner.get().setActivated(false);
            ownerRepository.save(isOwner.get());
        }
    }
}
