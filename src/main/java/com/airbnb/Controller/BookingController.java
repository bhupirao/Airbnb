package com.airbnb.Controller;

import com.airbnb.Exception.BookingException;
import com.airbnb.Exception.HostException;
import com.airbnb.Model.Booking;
import com.airbnb.Model.Host;
import com.airbnb.Service.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookings")
public class BookingController {


    @Autowired
    private BookingService bookingService;


    @PostMapping
    public ResponseEntity<Booking> createBookingHandler(@Valid @RequestBody Booking booking){

        Booking booking1=bookingService.createBooking(booking);

        return new ResponseEntity<>(booking1, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Booking>> getBookingByIdHandler(@PathVariable Integer id)throws BookingException{

        Optional<Booking> opt=bookingService.getBookingById(id);

        return new ResponseEntity<>(opt,HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookingHandler()throws BookingException{

        List<Booking> bookingList=bookingService.getAllBookings();

        return new ResponseEntity<>(bookingList,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBookingHandler(@PathVariable Integer id)throws BookingException{

        String host=bookingService.deleteBooking(id);

        return new ResponseEntity<>(host,HttpStatus.ACCEPTED);

    }


}
