package devices;

public class Car {
    public final int id;
    public final String producer;
    public final String model;
    public Double mileage;
    public int horsepower;
    public String color;
    public String fuelType;
    public Double engineVolume;
    public Double value;

    public Car(int id, String model, String producer) {
        this.id = id;
        this.model = model;
        this.producer = producer;
    }

    public String toString() {
        return id+" "+producer+" "+model+" "+mileage+ " " +
                horsepower+" "+color+" "+fuelType+" "+
                engineVolume+" "+value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return id == car.id &&
                model.equals(car.model) &&
                mileage.equals(car.mileage) &&
                horsepower == car.horsepower &&
                color.equals(car.color) &&
                fuelType.equals(car.fuelType) &&
                engineVolume.equals(car.engineVolume) &&
                value.equals(car.value) &&
                producer.equals(car.producer);
    }

    @Override
    public int hashCode() {
        return id;
    }
}
