package com.example.demoTask8.Repository;

import com.example.demoTask8.Entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign,Integer> {
}
