package com.example.realEstate.Service;

import com.example.realEstate.entity.Owner;

import java.util.List;

public interface OwnerService {

    public List<Owner> findAll();

    public void activateOwner(Long id);

    public void deactivateOwner(Long id);
}
