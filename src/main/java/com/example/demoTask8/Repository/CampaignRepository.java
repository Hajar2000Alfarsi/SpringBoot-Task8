package com.example.demoTask8.Repository;

import com.example.demoTask8.Entity.Campaign;
import com.example.demoTask8.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign,Integer> {
    @Query("Select c from Campaign c where c.isActive=true")
    List<Campaign> getAllActiveCampaign();

    @Query("Select c from Campaign c where c.isActive=true AND c.campaignId=:id")
    Campaign getCampaignById(@Param("id") Integer id);

    @Query("Select c from Campaign c where c.isActive=true AND e.campaignName=:nm")
    Campaign getCampaignByName(@Param("nm") String name);
}
