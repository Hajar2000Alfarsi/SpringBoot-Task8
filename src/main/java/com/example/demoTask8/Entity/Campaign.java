package com.example.demoTask8.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Campaign {
    private String campaignId;
    private String campaignName;
    private String platform;
    private Double budget;

}
