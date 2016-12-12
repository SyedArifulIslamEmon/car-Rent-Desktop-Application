/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carRent.DB.DAO;

/**
 *
 * @author noushad
 */
public class Car {

    private int id;
    private String carModel;
    private String engineNumber;
    private String registrationNumber;

    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @param carModel
     * @param engineNumber
     * @param registrationNumber
     */
    public Car(String carModel, String engineNumber, String registrationNumber) {
        //this.id = id;
        this.carModel = carModel;
        this.engineNumber = engineNumber;
        this.registrationNumber = registrationNumber;
    }

    public int getId() {
        return id;
    }

    public String getEngineNumber() {
        return this.engineNumber;
    }

    public String getregistrationNumber() {
        return this.registrationNumber;
    }

    public String getCarModel() {
        return this.carModel;
    }

}
