package com.example.testeksamen.controller;

import com.example.testeksamen.model.Team;
import com.example.testeksamen.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@AllArgsConstructor
@RestController
public class TeamController {

    private TeamService teamService;


    @GetMapping("api/get/allTeams")
    public ResponseEntity<Set<Team>> fetchAllTeams(){
        Set<Team> all = teamService.findAll();

        return  new ResponseEntity<>(all, HttpStatus.OK);
    }



}
