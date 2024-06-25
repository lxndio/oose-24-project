package com.sse.ooseproject;

import com.sse.ooseproject.models.Chair;
import com.sse.ooseproject.models.Employee;
import com.sse.ooseproject.models.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChairRepository extends JpaRepository<Chair, Long> {

    List<Chair> findByChairOwner(Employee chairOwner);

    List<Chair> findByBuilding(Building building);

}