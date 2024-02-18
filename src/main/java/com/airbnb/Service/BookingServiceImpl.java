package com.airbnb.Service;

import com.airbnb.Exception.BookingException;
import com.airbnb.Model.Booking;
import com.airbnb.Repo.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepo bookingRepo;



    @Override
    public Booking createBooking(Booking booking) {
        return bookingRepo.save(booking);
    }

    @Override
    public Optional<Booking> getBookingById(Integer id) throws BookingException {
         Optional<Booking> opt=bookingRepo.findById(id);

         if(opt.isPresent()){
             return opt;
         }
        throw new BookingException("Id is Wrong" );
    }

    @Override
    public List<Booking> getAllBookings() throws BookingException {
        return bookingRepo.findAll();
    }

    @Override
    public String deleteBooking(Integer id) throws BookingException {
        Optional<Booking> opt=bookingRepo.findById(id);
        if(opt.isPresent()){
            Booking booking=opt.get();
            bookingRepo.delete(booking);
            return "Successfully deleted";
        }
        throw new BookingException("Booking id wrong");
    }
}
