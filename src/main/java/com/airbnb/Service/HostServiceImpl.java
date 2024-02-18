package com.airbnb.Service;

import com.airbnb.Exception.HostException;
import com.airbnb.Model.Host;
import com.airbnb.Repo.HostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostServiceImpl implements HostService{

    @Autowired
    private HostRepo hostRepo;



    @Override
    public Host createHost(Host host) {
        return hostRepo.save(host);
    }

    @Override
    public Optional<Host> getHostById(Integer hostId) throws HostException {

        Optional<Host> host=hostRepo.findById(hostId);

        if(host.isPresent()){
            return host;
        }
         throw new HostException("Host Id wrong");
    }

    @Override
    public List<Host> getAllHosts() throws HostException {
        return hostRepo.findAll();
    }

    @Override
    public Host updateHost(Integer hostId, Host host) throws HostException {
        Optional<Host> optionalHost = hostRepo.findById(hostId);
        if (optionalHost.isPresent()) {
            Host host1 = optionalHost.get();
            host1.setName(host.getName());
            host1.setActive(host.getActive());
            host1.setLocation(host.getLocation());
            host1.setPropertyType(host.getPropertyType());
            host1.setAbout(host.getAbout());
            host1.setHostingSince(host.getHostingSince());
            return hostRepo.save(host);
        }
        throw new HostException("Host Id is wrong please try again!");
    }

    @Override
    public String deleteHost(Integer hostId) throws HostException {
        Optional<Host> h1=hostRepo.findById(hostId);
        if(h1.isPresent()){
            Host host=h1.get();
            hostRepo.delete(host);
            return "Delete Successfully";
        }
        throw new HostException("Host Id wrong please try again");
    }
}
