/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carRent.BLL;

import carRent.DB.DAO.Car;
import carRent.DB.DAO.CarBookingDetails;
import carRent.DB.DLL.CarDLL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author noushad
 */
public class CarBLL {

    CarDLL aCarDLL = new CarDLL();

    public String save(Car aCar) throws Exception {

        if (aCar.getCarModel().equals("") || aCar.getEngineNumber().equals("") || aCar.getregistrationNumber().equals("")) {
            throw new Exception("Please fill All Required Fields.");
        }
        if (aCarDLL.checkCarAllreadyExists(aCar)) {
            throw new Exception("Duplicate Entry Not Allowed");
        }
        if (aCarDLL.saveCar(aCar)) {
            return "Car Added Successfully";
        }
        return "some error occured";
    }

    public List<Car> getAllCars() throws SQLException {
        return aCarDLL.getAllCars();
    }

    public List<String> getAllCarsRegNo() throws SQLException {
        return aCarDLL.getAllCarsRegNo();
    }

    public ArrayList<String> findCustomer(int customerId) throws SQLException {
        ArrayList<String> customerInfo = aCarDLL.findCustomer(customerId);
        return customerInfo;
    }

    public String saveClient(String name, String mobileNo) throws Exception {
        if (name.equals("") || mobileNo.equals("")) {
            throw new Exception("Please fill All Required Fields");
        }
        if (aCarDLL.checkPhoneAllreadyExists(mobileNo)) {
            throw new Exception("Customer With Same Phone Number Allready in Database. ");

        }
        if (aCarDLL.saveClient(name, mobileNo)) {
            return "Client added Successfully";
        }
        return "some error occured";
    }

    public String BookCar(String carRegNo, int customerId, String customerName, String customerPhoneNo, String location, Date fromDate, Date toDate, double totalCost) throws Exception {

        if (carRegNo.equals("") || customerId == 0 || customerName.equals("") || customerPhoneNo.equals("") || fromDate == null || toDate == null || totalCost == 0) {
            throw new Exception("Please fill All Required Fields");
        }
        if (aCarDLL.checkBookingExists(carRegNo, fromDate, toDate)) {
            throw new Exception("Date Allready Booked For This Car");
        }
        if (aCarDLL.bookCar(carRegNo, customerId, customerName, customerPhoneNo, location, fromDate, toDate, totalCost)) {
            return "Booking Added Successfully";
        }
        return "some error occured";
    }

    public ArrayList<CarBookingDetails> getDefinedCars(String carRegNo, Date fromDate, Date toDate) throws SQLException {

        return aCarDLL.getDefinedCars(carRegNo, fromDate, toDate);
    }

    public ArrayList<CarBookingDetails> getDefinedInfo(Date fromDate, Date toDate) throws SQLException {

        return aCarDLL.getDefinedInfo(fromDate, toDate);
    }

    public Double getTotalIncome(Date fromDate, Date toDate) throws SQLException {
        
        return aCarDLL.getTotalIncome(fromDate,toDate);
    }

  
}
