package com.example.testeksamen.controller;



import com.example.testeksamen.model.Team;
import com.example.testeksamen.service.TeamService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@Transactional
@SpringBootTest
class TeamControllerTest {

    private MockMvc mockMvc;
    @Autowired
    private TeamService teamService;


    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new TeamController(teamService)).build();
    }

    @Test
    void fetchAllTeams() throws Exception {
        Team team1 = new Team();
        team1.setName("SAXO BANK");
        Team team2 = new Team();
        team2.setName("SAXO BANK");
        teamService.save(team1);
        teamService.save(team2);


        ResultActions resultActions = mockMvc.perform(get("/api/get/allTeams").contentType(APPLICATION_JSON)
                        .content("").characterEncoding("utf-8"))
                        .andExpect(status().isOk())
                        .andDo(print());
    }


}