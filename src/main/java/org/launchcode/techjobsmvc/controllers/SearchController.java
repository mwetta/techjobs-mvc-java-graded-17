package org.launchcode.techjobsmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.launchcode.techjobsmvc.controllers.ListController.columnChoices;


/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @GetMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    // TODO #3 Create a handler to process a search request and render the updated search view.
    /* TODO #3.1 Use the correct annotation for the method. To configure the correct mapping type and mapping  route,
        refer to the form tag in the search.html template. Use @GetMapping or @PostMapping rather than @Request Mapping
     */
    // TODO #3.2 - The displaySearchResults method should take in a Model parameter
    // TODO #3.3 The method should also take in two other parameters, specifying the type of search and the search term.
    /* TODO #3.4 In order for these last two parameters to be properly passed into Spring Boot, you need to use the
        correct annotation. Also, you need to name them appropriately, based on the corresponding form field names
        defined in search.html
     */
    /* TODO #3.5 If the user enters "all" in the search box, or if they leave the box empty, call the findAll() method
        from JobData. Otherwise, send the search information to findByColumnAndValue. In either case, store results
        in a jobs ArrayList.
     */
    // TODO #3.6 Pass jobs into the search.html view via the model parameter
    // TODO #3.7 Pass ListController.columnChoices into the view, as the existing search handler does

}

