package com.med.accountservice.usersManagement.web;

import com.med.accountservice.offersManagement.entity.Room;
import com.med.accountservice.usersManagement.dto.HotelPosition;
import com.med.accountservice.usersManagement.dto.ProviderResponse;
import com.med.accountservice.usersManagement.entity.Amenitie;
import com.med.accountservice.usersManagement.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/hotels")
@CrossOrigin("http://localhost:5173")
public class HotelController {
    @Autowired
    private HotelService hotelService ;
    @PostMapping("/rooms/createRoom")
    public List<Room> addNewRoom(@RequestPart("image")MultipartFile image , @RequestPart("room") Room room )  {
        return hotelService.addNewRoom(image , room) ;
    }
    @GetMapping("/rooms")
    public List<Room> getAllRooms() {
        return hotelService.getAllRooms();
    }
    @PostMapping ("/rooms/{room_id}")
    public void deleteRoom( @PathVariable int room_id ) {
        hotelService.deleteRoom(room_id) ;
    }
    @GetMapping("/rooms/{room_id}")
    public Room getRoomById(@PathVariable int room_id) {
        return hotelService.getRoomById(room_id) ;
    }
    @PostMapping("/rooms/update")
    public Room updateRoom(@RequestBody Room room ) {
        return this.hotelService.updateRoom(room) ;
    }
    @PostMapping("/setPosition")
    public void setPosition(float lng , float lat) {
        hotelService.setPosition(lng , lat) ;
    }
    @PostMapping("/amenities")
    public void addAmenities(@RequestBody List<Integer> amenities) {
        hotelService.addAmenities(amenities) ;
    }
    @GetMapping("/amenities")
    public List<Amenitie> getAmenities() {
        return hotelService.getAmenities() ;
    }
    @GetMapping("/amenities/unselected")
    public List<Amenitie> getUnselectedAmenities() {
        return hotelService.getUnselectedAmenities() ;
    }
}

