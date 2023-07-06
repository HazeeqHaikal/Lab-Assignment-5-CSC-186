public class Vehicle {
    private String carType;
    private String carPlateNumber;
    private String carPrice;

    public Vehicle(String carType, String carPlateNumber, String carPrice) {
        this.carType = carType;
        this.carPlateNumber = carPlateNumber;
        this.carPrice = carPrice;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarPlateNumber() {
        return carPlateNumber;
    }

    public void setCarPlateNumber(String carPlateNumber) {
        this.carPlateNumber = carPlateNumber;
    }

    public String getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(String carPrice) {
        this.carPrice = carPrice;
    }

    public String toString() {
        return "Car Type: " + carType + "\nCar Plate Number: " + carPlateNumber + "\nCar Price: " + carPrice;
    }
}
