package io.javabrains.coronavirustracker.Controllers;

import io.javabrains.coronavirustracker.models.LocationStats;
import io.javabrains.coronavirustracker.services.CorornaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CorornaVirusDataService corornaVirusDataService;

    @GetMapping("/")
    public String home(Model model) {
                List<LocationStats> allStats = corornaVirusDataService.getAllstats();
             int totalReportedCases =   allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
                model.addAttribute("locationStats", allStats);
                model.addAttribute( "totalReportedCases", totalReportedCases);

        return "home";
    }
}