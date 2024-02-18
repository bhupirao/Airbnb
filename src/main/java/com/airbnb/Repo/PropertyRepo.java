package com.airbnb.Repo;

import com.airbnb.Model.Host;
import com.airbnb.Model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepo extends JpaRepository<Property,Integer> {

    List<Property> findByHost(Host host);
}
