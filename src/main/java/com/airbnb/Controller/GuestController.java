package com.airbnb.Controller;

import com.airbnb.Exception.GuestException;
import com.airbnb.Exception.HostException;
import com.airbnb.Model.Guest;
import com.airbnb.Model.Host;
import com.airbnb.Service.GuestService;
import io.swagger.models.auth.In;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/guests")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @PostMapping
    public ResponseEntity<Guest> createGuestHandler (@Valid @RequestBody Guest guest){

        Guest guest1=guestService.createGuest(guest);
        return new ResponseEntity<>(guest1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Guest>> getGuestByIdHandler(@PathVariable Integer id)throws GuestException{

        Optional<Guest> opt=guestService.getGuestById(id);

        return new ResponseEntity<>(opt,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Guest>> getAllGuestHandler(){

        List<Guest> guestList=guestService.getAllGuests();

        return new ResponseEntity<>(guestList,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Guest> updateGuestHandler(@PathVariable Integer id, @Valid @RequestBody Guest guest)throws GuestException {

        Guest guest1=guestService.updateGuest(id,guest);

        return new ResponseEntity<>(guest1,HttpStatus.ACCEPTED);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGuestHandler(@PathVariable Integer id)throws GuestException{

        String guest=guestService.deleteGuest(id);

        return new ResponseEntity<>(guest,HttpStatus.ACCEPTED);

    }




}
