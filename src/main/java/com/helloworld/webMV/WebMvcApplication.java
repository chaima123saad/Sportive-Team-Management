package com.helloworld.webMV;

import com.helloworld.webMV.dao.TeamRepository;
import com.helloworld.webMV.entities.Team;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EntityScan(basePackages = "com.helloworld.webMV.entities")
public class WebMvcApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(WebMvcApplication.class, args);

        // Get the TeamRepository bean
        TeamRepository teamDao = ctx.getBean(TeamRepository.class);

        // Save sample teams
        teamDao.save(new Team("Avenir Sportif de Lala", 45000f));
        teamDao.save(new Team("Club Olympique de Transport", 60000f));
        teamDao.save(new Team("Stir Sportif Jarzouna", 40000f));

        // Display all teams
        teamDao.findAll().forEach(t -> System.out.println(t.getName()));
    }
}
