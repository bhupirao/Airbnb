package com.airbnb.Service;

import com.airbnb.Exception.HostException;
import com.airbnb.Exception.PropertyException;
import com.airbnb.Model.Host;
import com.airbnb.Model.Property;

import java.util.List;
import java.util.Optional;

public interface PropertyService {


    public Property createProperty(Property property);

    public Optional<Property> getPropertyById(Integer pId)throws PropertyException;

    public List<Property> getPropertiesByHost(Host host)throws HostException;

    public Property updateProperty(Integer id, Property propertyDetails)throws PropertyException;

    public String deleteProperty(Integer id)throws PropertyException;



}
