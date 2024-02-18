package com.airbnb.Service;

import com.airbnb.Exception.BookingException;
import com.airbnb.Model.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {

    public Booking createBooking(Booking booking);

    public Optional<Booking> getBookingById(Integer id) throws BookingException;

    public List<Booking> getAllBookings() throws BookingException;

    public String deleteBooking(Integer id) throws BookingException;



}
