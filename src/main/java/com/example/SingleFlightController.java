package com.example;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by trainer8 on 4/3/17.
 */
@RestController
@RequestMapping("/flights")
public class SingleFlightController {

    @GetMapping("/flight")
    public Flight getFlight() {
        Flight flight = new Flight();
        flight.setDeparts(new Date(2017-1900,04-1,21,14-6,34));
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(new Passenger("Some name","Some other name"),200));
        flight.setTickets(tickets);
        return flight;
    }


    public static class Flight {
        private Date departs;
        private List<Ticket> tickets;

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
        public Date getDeparts() {
            return departs;
        }

        public void setDeparts(Date departs) {
            this.departs = departs;
        }

        public List<Ticket> getTickets() {
            return tickets;
        }

        public void setTickets(List<Ticket> tickets) {
            this.tickets = tickets;
        }

    }

    public static class Ticket {
        private Passenger passenger;
        private int price;

        public Passenger getPassenger() {
            return passenger;
        }

        public void setPassenger(Passenger passenger) {
            this.passenger = passenger;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public Ticket(Passenger passenger, int price) {
            this.passenger = passenger;
            this.price = price;
        }

        public Ticket() {
        }
    }

    public static class Passenger {
        private String firstName;
        private String lastName;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public Passenger(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Passenger() {
        }
    }
}
