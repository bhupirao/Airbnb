package com.airbnb.Service;

import com.airbnb.Exception.GuestException;
import com.airbnb.Model.Guest;
import com.airbnb.Repo.GuestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestServiceImpl implements GuestService{


    @Autowired
    private GuestRepo guestRepo;


    @Override
    public Guest createGuest(Guest guest) {
        return guestRepo.save(guest);
    }

    @Override
    public Optional<Guest> getGuestById(Integer id) throws GuestException {
        Optional<Guest> opt=guestRepo.findById(id);
        if(opt.isPresent()){
            return opt;
        }
        throw new GuestException("Guest Id not found");
    }

    @Override
    public List<Guest> getAllGuests() {
        return guestRepo.findAll();
    }

    @Override
    public Guest updateGuest(Integer id, Guest guestDetails) throws GuestException {
        Optional<Guest> optionalGuest = guestRepo.findById(id);
        if (optionalGuest.isPresent()) {
            Guest guest = optionalGuest.get();
            guest.setName(guestDetails.getName());

            return guestRepo.save(guest);
        }
        throw new GuestException("Guest Id not found");
    }

    @Override
    public String deleteGuest(Integer id) throws GuestException {
        Optional<Guest> opt=guestRepo.findById(id);
        if(opt.isPresent()){
            Guest guest=opt.get();
            guestRepo.delete(guest);
            return "Successfully deleted";
        }
        throw new GuestException("Guest Id not found");
    }
}
