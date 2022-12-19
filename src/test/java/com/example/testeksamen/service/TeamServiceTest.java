package com.example.testeksamen.service;

import com.example.testeksamen.model.Rider;
import com.example.testeksamen.model.Team;
import com.example.testeksamen.repository.RiderRepository;
import com.example.testeksamen.repository.TeamRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;



@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest
@Transactional
class TeamServiceTest {
    @Autowired
    private TeamService teamService;

    @Test
    void findAll() {
        Team team1 = new Team();
        team1.setName("SAXO BANK");
        Team team2 = new Team();
        team2.setName("SAXO BANK");

        teamService.save(team1);
        teamService.save(team2);


        Set<Team> all = teamService.findAll();
        assertEquals(2, all.size());
    }


    @Test
    void findById() {
        Team team1 = new Team();
        team1.setName("SAXO BANK");
        Team team2 = new Team();
        team2.setName("SAXO BANK");
        teamService.save(team1);
        teamService.save(team2);

        Optional<Team> byId = teamService.findById(2L);
        Team team = byId.orElse(null);
        System.out.println("riders: " + team.getRiders().size());

    }


    @Test
    void save() {
        Team team1 = new Team();
        team1.setName("SAXO BANK");
        Team team2 = new Team();
        team2.setName("SAXO BANK");
        teamService.save(team1);
        teamService.save(team2);




        Team team = new Team();
        team.setName("DANSKE BANK");
        teamService.save(team);
        Optional<Team> byId = teamService.findById(3L);
        Team team3 = byId.orElse(null);
        assertEquals(team, team3);

    }


    @Test
    void delete() {
        Team team1 = new Team();
        team1.setName("SAXO BANK");
        Team team2 = new Team();
        team2.setName("SAXO BANK");
        teamService.save(team1);
        teamService.save(team2);



        Optional<Team> byId = teamService.findById(1L);
        Team team3 = byId.orElse(null);
        teamService.delete(team3);
        Optional<Team> byId2 = teamService.findById(1L);
        assertTrue(byId2.isEmpty());
    }

    @Test
    void deleteById() {
        Team team1 = new Team();
        team1.setName("SAXO BANK");
        Team team2 = new Team();
        team2.setName("SAXO BANK");
        teamService.save(team1);
        teamService.save(team2);



        Optional<Team> byId = teamService.findById(1L);
        assertTrue(byId.isPresent());
        teamService.deleteById(1L);
        Optional<Team> byIdAfterDelete = teamService.findById(1L);
        assertTrue(byIdAfterDelete.isEmpty());
    }


}