package com.sse.ooseproject.controllers;

import com.sse.ooseproject.models.Room;
import com.sse.ooseproject.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Controller
public class RoomController {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomController(RoomRepository roomRepository) {

        this.roomRepository = roomRepository;
    }

    @GetMapping("/rooms")
    public String rooms(Model model, @RequestParam(value = "sort_by", defaultValue = "id", required = false) String sort_by,
                           @RequestParam(value = "sort_asc", defaultValue = "true") boolean sort_asc) {

        List<Room> roomsSorted = Collections.emptyList();
        if(sort_asc && Objects.equals(sort_by, "id")) {
            roomsSorted = roomRepository.findByOrderByIdAsc();
        }
        if(sort_asc && Objects.equals(sort_by, "number")) {
            roomsSorted = roomRepository.findByOrderByNumberAsc();
        }
        if(sort_asc && Objects.equals(sort_by, "seats")) {
            roomsSorted = roomRepository.findByOrderBySeatsAsc();
        }
        if(sort_asc && Objects.equals(sort_by, "isAuditorium")) {
            //roomsSorted = roomRepository.findByOrderByAuditoriumAsc();
        }
        if(sort_asc && Objects.equals(sort_by, "buildingId")) {
            roomsSorted = roomRepository.findByOrderByBuildingIdAsc();
        }
        if(!sort_asc && Objects.equals(sort_by, "id")) {
            roomsSorted = roomRepository.findByOrderByIdDesc();
        }
        if(!sort_asc && Objects.equals(sort_by, "number")) {
            roomsSorted = roomRepository.findByOrderByNumberDesc();
        }
        if(!sort_asc && Objects.equals(sort_by, "seats")) {
            roomsSorted = roomRepository.findByOrderBySeatsDesc();
        }
        if(!sort_asc && Objects.equals(sort_by, "isAuditorium")) {
            //roomsSorted = roomRepository.findByOrderByAuditoriumDesc();
        }
        if(!sort_asc && Objects.equals(sort_by, "buildingId")) {
            roomsSorted = roomRepository.findByOrderByBuildingIdDesc();
        }

        model.addAttribute("rooms", roomsSorted);
        model.addAttribute("sort_asc", sort_asc);
        model.addAttribute("sort_by", sort_by);

        // Returning the name of a view (found in resources/templates) as a string lets this endpoint return that view.
        return "rooms";
    }
}
