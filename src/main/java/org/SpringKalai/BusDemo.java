package org.SpringKalai;

import java.sql.SQLException;


import java.util.Scanner;

public class BusDemo {
    public static void main(String[] args) throws SQLException {

        BusDAO busDAO = new BusDAO();
        try {
                busDAO.dispalyBusInfo();
                int useroption = 1;
                Scanner scanner = new Scanner(System.in);

                while (useroption == 1) {
                    System.out.println("Enter 1 to Book And Enter 2 To Exit:");
                    useroption = scanner.nextInt();

                    if (useroption == 1) {
                        Booking booking = new Booking();

                        if (booking.isAvailable()) {
                            BookingDAO bookingDAO = new BookingDAO();
                            bookingDAO.addBooking(booking);

                            System.out.println("Your Booking Is Confirmed");
                        } else System.out.println("Sorry.Bus is Full.Try Another Bus Or Date.");
                    }

                }
                scanner.close();
            } catch(Exception e){
                System.out.println(e);
        }
    }
}


