package com.example.demoTask8.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
@Entity
@Table(name = "Campaign")
public class Campaign {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private String campaignId;
    @NonNull
    private String campaignName;
    private String platform;
    private Double budget;

}
