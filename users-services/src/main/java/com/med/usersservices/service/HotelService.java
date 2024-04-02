package com.med.usersservices.service;

import com.med.usersservices.entity.Hotel;
import com.med.usersservices.feignRepo.OffersRepo;
import com.med.usersservices.repository.HotelRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    HotelRepo hotelRepo ;
    OffersRepo offersRepo ;
    public HotelService(HotelRepo hotelRepo , OffersRepo offersRepo ) {
        this.hotelRepo = hotelRepo ;
        this.offersRepo = offersRepo ;
    }
    public Hotel registerNewHotel(Hotel hotel) {
        return hotelRepo.save(hotel) ;
    }
    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = hotelRepo.findAll() ;
        hotels.forEach(hotel -> {
            hotel.setRooms(offersRepo.getAllRoomsByHotelId(hotel.getId()));
        });
        return hotels ;
    }
}
