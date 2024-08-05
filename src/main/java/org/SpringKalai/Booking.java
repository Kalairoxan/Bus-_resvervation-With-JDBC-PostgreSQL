package org.SpringKalai;

import java.sql.SQLException;
import java.text.ParseException;

import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Booking {
    String passengerName;
    int busNo;
    Date date;

    Booking()  {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name(Passenger): ");
        passengerName = scanner.next();

        System.out.println("Enter The Bus No:");
        busNo = scanner.nextInt();

        System.out.println("Enter Date dd--mm--yyyy");
        String dateInput = scanner.next();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd--MM--yyyy");
        try {
            date  =  dateFormat.parse(dateInput);
        } catch (ParseException e) {
            throw new RuntimeException(e);
    }

    }
    public boolean isAvailable() throws SQLException {
        BusDAO busDAO = new BusDAO();
        BookingDAO bookingDAO = new BookingDAO();

        int capacity = busDAO.getCapacity(busNo) ;

        int booked = bookingDAO.getBookedCount(busNo,date);

        return  booked<capacity;
    }
}
