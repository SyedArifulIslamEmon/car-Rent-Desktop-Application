/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carRent.DB.DAO;

import java.sql.Date;

/**
 *
 * @author noushad
 */
public class CarBookingDetails {
    
    private String customerName;
    private String carRegNo;
    private Date rentDate;
    private Date returnDate;
    private String location;
    private Double price;

    public CarBookingDetails(String customerName, String carRegNo, Date rentDate, Date returnDate, String location, Double price) {
        this.customerName = customerName;
        this.carRegNo = carRegNo;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.location = location;
        this.price = price;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCarRegNo() {
        return carRegNo;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public String getLocation() {
        return location;
    }

    public Double getPrice() {
        return price;
    }
    
    
}
