package com.example.testeksamen.service;

import com.example.testeksamen.model.Rider;

import java.util.Optional;
import java.util.Set;

public class RiderService implements CrudInterface<Rider, Long> {


    @Override
    public Set<Rider> findAll() {
        return null;
    }

    @Override
    public Rider save(Rider object) {
        return null;
    }

    @Override
    public void delete(Rider object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Rider> findById(Long aLong) {
        return Optional.empty();
    }
}
