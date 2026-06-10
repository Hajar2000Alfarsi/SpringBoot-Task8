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

    @PostMapping("add")
    public Campaign AddCampaign(@RequestBody Campaign campaign) {
        return campaignManager.addCampaign(campaign);
    }

    @GetMapping("getAll")
    public List<Campaign> getAllCampaign(){
        return campaignManager.getAllCampaign();
    }

    @GetMapping("byId")
    public Campaign getCampaignById(@RequestParam Integer id) {
        return campaignManager.getCampaignById(id);
    }

    @GetMapping("byName")
    public Campaign getCampaignByName(@RequestParam String name) {
        return campaignManager.getCampaignByName(name);
    }

    @PutMapping("Update")
    public Campaign updateCampaign(@RequestBody Campaign campaign) throws Exception{
        return campaignManager.updateCampaign(campaign);
    }

    @DeleteMapping("Delete")
    public Boolean deleteCampaign(@RequestParam Integer id) {
        return campaignManager.deleteCampaignById(id);
    }
}
