package com.airbnb.Controller;

import com.airbnb.Exception.HostException;
import com.airbnb.Exception.PropertyException;
import com.airbnb.Model.Host;
import com.airbnb.Model.Property;
import com.airbnb.Service.PropertyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping
    public ResponseEntity<Property> createPropertyHandler(@Valid @RequestBody Property property){
        Property property1=propertyService.createProperty(property);

        return new ResponseEntity<>(property1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Property>> getPropertyByIdHandler(@PathVariable Integer id)throws PropertyException {
        Optional<Property> opt=propertyService.getPropertyById(id);

        return new ResponseEntity<>(opt,HttpStatus.OK);

    }
    @GetMapping
    public ResponseEntity<List<Property>> getPropertiesByHostHandler(@RequestBody Host host)throws HostException{

        List<Property> propertyList=propertyService.getPropertiesByHost(host);

        return new ResponseEntity<>(propertyList,HttpStatus.OK);


    }
    @PutMapping("/{id}")
    public ResponseEntity<Property> updatePropertyHandler( @PathVariable Integer id,@Valid @RequestBody Property property)throws PropertyException{

        Property property1=propertyService.updateProperty(id,property);

        return new ResponseEntity<>(property1,HttpStatus.ACCEPTED);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePropertyHandler(@PathVariable Integer id)throws PropertyException{
        String prop=propertyService.deleteProperty(id);

        return new ResponseEntity<>(prop,HttpStatus.ACCEPTED);

    }



}
