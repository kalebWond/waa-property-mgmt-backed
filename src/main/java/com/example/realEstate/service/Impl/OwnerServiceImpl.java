package com.example.realEstate.service.Impl;

import com.example.realEstate.entity.Owner;
import com.example.realEstate.repository.OwnerRepository;
import com.example.realEstate.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepository;
    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public Owner getOwnerById(long id) {
        return ownerRepository.findById(id).orElseThrow();
    }

    @Override
    public Owner updateOwnerById(long id, Owner owner) {
        Owner updated = ownerRepository.findById(id).get();
        updated=owner;
        return ownerRepository.save(updated);
    }

    @Override
    public void deleteById(long id) {
        ownerRepository.deleteById(id);

    }
}
