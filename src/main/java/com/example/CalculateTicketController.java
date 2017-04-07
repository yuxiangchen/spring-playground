package com.example;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by trainer8 on 4/5/17.
 */
@RestController
public class CalculateTicketController {
    @PostMapping("/flights/tickets/total")
    public Result postJSONData(@RequestBody Total total){
        return new Result(sumPrice(total.tickets));
    }

    public int sumPrice(CalculateTicketController.Tickets[] tickets){
        int totalPrice=0;

        for(int i=0;i<tickets.length;i++){
            totalPrice += tickets[i].getPrice();
        }
        return totalPrice;
    }

    public static class Total{
        private Tickets[] tickets;

        public Total(){

        }

        public Total(Tickets[] tickets) {
            this.tickets = tickets;
        }

        public Tickets[] getTickets() {
            return tickets;
        }

        public void setTickets(Tickets[] tickets) {
            this.tickets = tickets;
        }

    }


    public static class Tickets {
        private Passenger passenger;
        private int price;

        public Tickets(){

        }

        public Tickets(Passenger passenger, int price) {
            this.passenger = passenger;
            this.price = price;
        }

        public Tickets(List<Tickets> ticketList) {
        }

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
