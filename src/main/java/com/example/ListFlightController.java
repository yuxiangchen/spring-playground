package com.example;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by trainer8 on 4/4/17.
 */
@RestController
@RequestMapping("/flights")
public class ListFlightController {

    @GetMapping("")

    public List<Flight> getFlights() {
        Flight flight1 = new Flight();
        flight1.setDeparts(new Date(2017-1900,04-1,21,14-6,34));
        List<ListFlightController.Ticket> tickets1 = new ArrayList<>();
        tickets1.add(new Ticket(new Passenger("Some name","Some other name"),200));
        flight1.setTickets(tickets1);

        Flight flight2 = new Flight();
        flight2.setDeparts(new Date(2017-1900,04-1,21,14-6,34));
        List<ListFlightController.Ticket> tickets2 = new ArrayList<>();
        tickets2.add(new Ticket(new Passenger("Some name",null),400));
        flight2.setTickets(tickets2);

        return Arrays.asList(flight1, flight2);
    }

    public static class Flight {
        private Date departs;
        private List<ListFlightController.Ticket> tickets;

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm")

        public Date getDeparts() {
            return departs;
        }

        @JsonProperty("Departs")
        public void setDeparts(Date departs) {
            this.departs = departs;
        }

        public List<ListFlightController.Ticket> getTickets() {
            return tickets;
        }

        @JsonProperty("Tickets")
        public void setTickets(List<ListFlightController.Ticket> tickets) {
            this.tickets = tickets;
        }

    }

    public static class Ticket {
        private ListFlightController.Passenger passenger;
        private int price;

        public ListFlightController.Passenger getPassenger() {
            return passenger;
        }

        @JsonProperty("Passenger")
        public void setPassenger(ListFlightController.Passenger passenger) {
            this.passenger = passenger;
        }

        public int getPrice() {
            return price;
        }

        @JsonProperty("Price")
        public void setPrice(int price) {
            this.price = price;
        }

        public Ticket(ListFlightController.Passenger passenger, int price) {
            this.passenger = passenger;
            this.price = price;
        }

        public Ticket() {
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Passenger {
        private String firstName;
        private String lastName;

        public String getFirstName() {
            return firstName;
        }

        @JsonProperty("FirstName")
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        @JsonProperty("LastName")
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
