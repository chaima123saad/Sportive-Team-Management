package com.helloworld.webMV.web;

import com.helloworld.webMV.dao.TeamRepository;
import com.helloworld.webMV.entities.Team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teams") // Grouping routes for better design
public class TeamController {

    @Autowired
    private TeamRepository teamDao;

    /**
     * Search teams by keyword.
     */
    @GetMapping("/search")
    public String search(Model model, @RequestParam(name = "motCle", defaultValue = "") String mc) {
        List<Team> teams = teamDao.findByName("%" + mc + "%");
        model.addAttribute("teams", teams);
        model.addAttribute("motCle", mc);
        return "myteams"; // View for displaying the list of teams
    }

    /**
     * Add a new team.
     */
    @GetMapping("/add")
public String showAddForm() {
    return "addTeam"; // Vue contenant le formulaire d'ajout
}
    @PostMapping("/add")
    public String add(@RequestParam(name = "name") String name,
                      @RequestParam(name = "budget", defaultValue = "0") float budget) {
        if (!name.isBlank()) {
            teamDao.save(new Team(name, budget));
        }
        return "redirect:/teams/search"; // Redirect to search page after adding
    }

    /**
     * Delete a team by ID.
     */
    @GetMapping("/delete")
    public String delete(@RequestParam(name = "ref") Long idTeam,
                         @RequestParam(name = "mc", defaultValue = "") String mc) {
        if (teamDao.existsById(idTeam)) {
            teamDao.deleteById(idTeam);
        }
        return "redirect:/teams/search?motCle=" + mc; // Redirect to search with filter
    }

    /**
     * Edit a team (pre-fill form or update).
     */
    @GetMapping("/edit")
    public String preFillEditForm(Model model,
                                  @RequestParam(name = "ref") Long idTeam,
                                  @RequestParam(name = "mc", defaultValue = "") String mc) {
        Team team = teamDao.findById(idTeam).orElse(null);
        if (team != null) {
            model.addAttribute("idTeam", idTeam);
            model.addAttribute("name", team.getName());
            model.addAttribute("budget", team.getBudget());
            model.addAttribute("motCle", mc);
        }
        return "editTeam"; // View for editing team
    }

    @PostMapping("/edit")
    public String edit(@RequestParam(name = "ref") Long idTeam,
                       @RequestParam(name = "name") String name,
                       @RequestParam(name = "budget", defaultValue = "0") float budget,
                       @RequestParam(name = "mc", defaultValue = "") String mc) {
        Team team = teamDao.findById(idTeam).orElse(null);
        if (team != null) {
            team.setName(name);
            team.setBudget(budget);
            teamDao.save(team);
        }
        return "redirect:/teams/search?motCle=" + mc; // Redirect to search after update
    }
}
