package com.example.demoTask8.Controller;

import com.example.demoTask8.Entity.Campaign;
import com.example.demoTask8.Service.CampaignManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CampaignController {

    @Autowired
    CampaignManager campaignManager;

    @PutMapping("addCampaign")
    public String addCampaign(@RequestParam Integer campaignId,
                              @RequestParam String campaignName,
                              @RequestParam String platform,
                              @RequestParam Double budget) {
        Campaign campaign = new Campaign(campaignId, campaignName, platform, budget);
        return campaignManager.addCampaign(campaign);
    }

    @GetMapping("displayCampaign")
    public List<Campaign> displayCampaign() {
        return campaignManager.displayCampaign();
    }

}
