package com.example.demoTask8.Service;

import com.example.demoTask8.Entity.Campaign;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CampaignManager {
    List<Campaign> campaignList = new ArrayList<>();

    public void addData(){
        campaignList.add(new Campaign("C101", "Summer Sale", "Instagram",500.0));
        campaignList.add(new Campaign("C102", "Black Friday", "Google Ads",1000.0));
        campaignList.add(new Campaign("C103", "Email Promo", "Email",500.0));
    }
}
