package com.airbnb.Service;

import com.airbnb.Exception.HostException;
import com.airbnb.Exception.PropertyException;
import com.airbnb.Model.Host;
import com.airbnb.Model.Property;
import com.airbnb.Repo.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService{


    @Autowired
    private PropertyRepo propertyRepo;

    @Override
    public Property createProperty(Property property) {
        return propertyRepo.save(property);
    }

    @Override
    public Optional<Property> getPropertyById(Integer pId) throws PropertyException {
        Optional<Property> opt=propertyRepo.findById(pId);

        if(opt.isPresent()){
            return opt;
        }
        throw new PropertyException("Property Id wrong");
    }

    @Override
    public List<Property> getPropertiesByHost(Host host) throws HostException {

        return propertyRepo.findByHost(host);
    }

    @Override
    public Property updateProperty(Integer id, Property propertyDetails) throws PropertyException {
        Optional<Property> optionalProperty = propertyRepo.findById(id);
        if (optionalProperty.isPresent()) {
            Property property = optionalProperty.get();
            property.setName(propertyDetails.getName());
            return propertyRepo.save(property);
        }
        throw new PropertyException("Property Id is wrong");
    }

    @Override
    public String deleteProperty(Integer id) throws PropertyException {
       Optional<Property> opt=propertyRepo.findById(id);
       if(opt.isPresent()){
           Property property=opt.get();
           propertyRepo.delete(property);
           return "Successfully deleted";
       }
       throw new PropertyException("Property ID wrong ");
    }
}
