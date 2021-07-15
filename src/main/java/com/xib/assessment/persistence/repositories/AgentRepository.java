package com.xib.assessment.persistence.repositories;

import com.xib.assessment.persistence.entities.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {
    @Query(value = "SELECT * FROM Agent WHERE ROWNUM <= ?1 ORDER BY ID ASC" ,nativeQuery = true)
    List<Agent> retrieveAgentsUsingPagination(@Param("size") Integer size);
}
