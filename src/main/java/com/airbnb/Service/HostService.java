package com.airbnb.Service;

import com.airbnb.Exception.HostException;
import com.airbnb.Model.Host;

import java.util.List;
import java.util.Optional;

public interface HostService {

    public Host createHost(Host host);

    public Optional<Host> getHostById(Integer hostId)throws HostException;

    public List<Host> getAllHosts()throws HostException;

    public Host updateHost(Integer hostId, Host host) throws HostException;

    public String deleteHost(Integer hostId)throws HostException;


}
