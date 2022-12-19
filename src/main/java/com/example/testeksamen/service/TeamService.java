package com.example.testeksamen.service;

import com.example.testeksamen.model.Team;
import com.example.testeksamen.repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class TeamService implements CrudInterface<Team, Long>{

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Set<Team> findAll() {
        return new HashSet<>(teamRepository.findAll());
    }

    @Override
    public Team save(Team object) {
        return teamRepository.save(object);
    }

    @Override
    public void delete(Team object) {
        teamRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        teamRepository.deleteById(aLong);
    }
    @Override
    public Optional<Team> findById(Long aLong) {
        return teamRepository.findById(aLong);
    }
}
