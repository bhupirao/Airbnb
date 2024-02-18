package com.airbnb.Repo;

import com.airbnb.Model.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostRepo extends JpaRepository<Host,Integer> {

}
