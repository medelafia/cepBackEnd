package com.med.accountservice.usersManagement.web;

import com.med.accountservice.messagesManagement.entity.Message;
import com.med.accountservice.messagesManagement.service.MessageService;
import com.med.accountservice.offersManagement.dto.AvailabilityResponse;
import com.med.accountservice.offersManagement.entity.*;
import com.med.accountservice.offersManagement.service.*;
import com.med.accountservice.reviewsManagement.entity.Review;
import com.med.accountservice.reviewsManagement.service.ReviewService;
import com.med.accountservice.stationsManagement.entity.Airport;
import com.med.accountservice.stationsManagement.entity.Gate;
import com.med.accountservice.stationsManagement.entity.TrainStation;
import com.med.accountservice.stationsManagement.service.GateService;
import com.med.accountservice.usersManagement.dto.HotelPosition;
import com.med.accountservice.usersManagement.dto.HotelResponse;
import com.med.accountservice.usersManagement.dto.ProviderResponse;
import com.med.accountservice.usersManagement.entity.Amenitie;
import com.med.accountservice.usersManagement.repository.AmenitieRepo;
import com.med.accountservice.usersManagement.service.CostumerService;
import com.med.accountservice.usersManagement.service.HotelService;
import com.med.accountservice.usersManagement.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/public")
@CrossOrigin("http://localhost:5173")
public class PublicController {
    @Autowired
    HotelService hotelService  ;
    @Autowired
    GateService gateService ;
    @Autowired
    CarService carService ;
    @Autowired
    FlightService flightService ;
    @Autowired
    RoomService roomService ;
    @Autowired
    OrganizedTravelsService organizedTravelsService ;
    @Autowired
    TrainTravelService trainTravelService ;
    @Autowired
    ProviderService providerService ;
    @Autowired
    ReviewService reviewService ;
    @Autowired
    MessageService messageService ;
    @Autowired
    AmenitieRepo amenitieRepo ;
    @Autowired
    CostumerService costumerService ;
    @GetMapping("/providers/")
    public List<ProviderResponse> getAllProviders(){
        return providerService.getAllProviders() ;
    }
    @GetMapping("/providers/{id}")
    public ProviderResponse getProviderById(@PathVariable  int id) {
        return providerService.getProviderInfo(id);
    }
    @GetMapping("/gates")
    public List<Gate> getAllGates() {
        return gateService.getAllGates() ;
    }
    @GetMapping("/gates/airports/")
    public List<Airport> getAllAirports() {
        return gateService.getAllAirports() ;
    }
    @GetMapping("/gates/trainStations/")
    public List<TrainStation> getAllTrainStations(){
        return gateService.getAllTrainStations() ;
    }
    @GetMapping("/cars")
    public List<Car> getAllAvailableCars(@RequestParam int airportId , @RequestParam int nbSeats ) {
        return carService.getAllCars(airportId , nbSeats );
    }
    @GetMapping("/flights/getRoundTrip")
    public List<Flight> findAllRoundFlight(@RequestParam int from  ,
                                           @RequestParam int to ,
                                           @RequestParam Date depDate ,
                                           @RequestParam Date returnDate ) {
        return flightService.findAllRoundFlight(from , to , depDate , returnDate ) ;
    }
    @GetMapping("/flights/getOneWayTrip")
    public List<Flight> findAllOneWayFlights(@RequestParam int from ,
                                             @RequestParam int to ,
                                             @RequestParam Date depDate)  {
        return flightService.findAllOneWayFlights(from , to , depDate) ;
    }
    @GetMapping("/trainTravel/getRoundTrip")
    public List<TrainTravel> findAllRoundTrainTravel(@RequestParam int from  ,
                                           @RequestParam int to ,
                                           @RequestParam Date depDate ,
                                           @RequestParam Date returnDate ) {
        return trainTravelService.getRoundTrainTravels(from , to ,depDate , returnDate);
    }
    @GetMapping("/trainTravels/getOneWayTrip")
    public List<TrainTravel> findAllOneWayTrainTravels(@RequestParam int from ,
                                             @RequestParam int to ,
                                             @RequestParam Date depDate)  {
        return trainTravelService.getOneWayTrainTravels(from, to , depDate ) ;
    }
    @GetMapping("/organizedTravels")
    public List<OrganizedTravel> findAllOrganizedTravels(@RequestParam String origin , @RequestParam String destination , @RequestParam Date date) {
        return organizedTravelsService.getAllOrganizedTravels(origin , destination , date) ;
    }
    @GetMapping("/rooms/getAvailableRooms/{id}")
    public List<Room> findAllAvailableRoomsByHotelId(@PathVariable int id) {
        return roomService.findAllAvailableRooms(id);
    }
    @GetMapping("/trainTravels")
    public List<TrainTravel> getAllTrainTravels() {
        return trainTravelService.getAllTrainTravels() ;
    }
    @GetMapping("/reviews/{id}")
    public List<Review> getReviews(@PathVariable int id) {
        return reviewService.getReviewsByProviderId(id) ;
    }
    @PostMapping("/contactAdmin")
    public void contactAdmin(@RequestBody Message message) {
        messageService.send(message) ;
    }
    @GetMapping("/hotels/getNearby")
    public List<ProviderResponse> getNearbyHotels(@RequestParam float lng , @RequestParam float lat) {
        return hotelService.getNearbyHotels(lng , lat) ;
    }
    @GetMapping("/hotels/{keyword}")
    public List<HotelResponse> getAllHotelsContainsKeyword(@PathVariable String keyword) {
        return hotelService.getAllHotelsContainsKeyword(keyword) ;
    }
    @GetMapping("/hotels/getHotelsPosition")
    public List<HotelPosition> getAllHotelsPositions() {
        return hotelService.getAllHotelsPositions() ;
    }
    @GetMapping("/hotel/{id}")
    public HotelResponse getHotel(@PathVariable int id) {
        return hotelService.getHotel(id) ;
    }
    @GetMapping("/costumers")
    public List<Integer> getUsersIds() {
        return costumerService.findAllCostumersIds() ;
    }
}
