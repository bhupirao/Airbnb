package com.airbnb.Service;

import com.airbnb.Exception.GuestException;
import com.airbnb.Model.Guest;

import java.util.List;
import java.util.Optional;

public interface GuestService {



    public Guest createGuest(Guest guest);

    public Optional<Guest> getGuestById(Integer id) throws GuestException;

    public List<Guest> getAllGuests();

    public Guest updateGuest(Integer id, Guest guestDetails)throws GuestException;

    public String deleteGuest(Integer id)throws GuestException;





}
