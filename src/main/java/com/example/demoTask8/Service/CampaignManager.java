package com.example.demoTask8.Service;

import com.example.demoTask8.Entity.Campaign;
import com.example.demoTask8.Entity.Employee;
import com.example.demoTask8.Repository.CampaignRepository;
import com.example.demoTask8.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CampaignManager {
    @Autowired
    CampaignRepository campaignRepository;

    public Campaign addCampaign(Campaign campaign) {

        Campaign newCampaign = new Campaign();

        newCampaign.setCampaignName(campaign.getCampaignName());
        newCampaign.setPlatform(campaign.getPlatform());
        newCampaign.setBudget(campaign.getBudget());
        newCampaign.setIsActive(true);

        return campaignRepository.save(newCampaign);
    }

    public List<Campaign> getAllCampaign() {
        return campaignRepository.getAllActiveCampaign();
    }

    public Campaign getCampaignById(Integer id) {
        return campaignRepository.getCampaignById(id);
    }

    public Campaign getCampaignByName(String name) {
        return campaignRepository.getCampaignByName(name);
    }

    public Campaign updateCampaign(Campaign updateCampaign) throws Exception {
        Campaign existingCampaign = campaignRepository.getCampaignById(updateCampaign.getCampaignId());

        if (existingCampaign != null) {
            if (!existingCampaign.getCampaignName().equals(updateCampaign.getCampaignName())) {
                existingCampaign.setCampaignName(updateCampaign.getCampaignName());
            }
            if (!existingCampaign.getPlatform().equals(updateCampaign.getPlatform())) {
                existingCampaign.setPlatform(updateCampaign.getPlatform());
            }
            if (!existingCampaign.getBudget().equals(updateCampaign.getBudget())) {
                existingCampaign.setBudget(updateCampaign.getBudget());
            }
            return campaignRepository.save(existingCampaign);
        }
        throw new Exception ("Invalid Data");
    }

    public Boolean deleteCampaignById(Integer id) {
        Campaign campaignToDelete = campaignRepository.getCampaignById(id);

        if (campaignToDelete !=  null) {
            campaignToDelete.setIsActive(false);
            campaignRepository.save(campaignToDelete);
            return true;
        } else {
            return false;
        }
    }

}
