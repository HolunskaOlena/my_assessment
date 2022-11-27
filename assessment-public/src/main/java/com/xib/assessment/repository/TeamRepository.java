package com.xib.assessment.repository;

import com.xib.assessment.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query(value = "select t.name from Team t where t.agentList is empty and t.managerList is empty")
    List<Team> getAllEmptyTeams();
}
