package org.launchcode.techjobsmvc.controllers;

import org.launchcode.techjobsmvc.models.Job;
import org.launchcode.techjobsmvc.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

import static org.launchcode.techjobsmvc.controllers.ListController.columnChoices;


/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {
    //Render the search page with column choices using search.html template
    @GetMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    @PostMapping ("results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam(required = false) String searchTerm) {
        ArrayList<Job> jobs;
        //TODO: Test that all with Ruby works
        if (searchType.equals("all") && (!searchTerm.isEmpty())){
            jobs = JobData.findByValue(searchTerm);
        } else if (searchType.equals("all")){
            jobs = JobData.findAll();
            model.addAttribute("title", "All Jobs");
        }
        else {
            jobs = JobData.findByColumnAndValue(searchType, searchTerm);
            model.addAttribute("title", "Jobs with " + columnChoices.get(searchType) + ": " + searchTerm);
        }
        model.addAttribute("columns", columnChoices);
        model.addAttribute("jobs", jobs);

        return "search";
    }

}

