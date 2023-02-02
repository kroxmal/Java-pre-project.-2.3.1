package web.service;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService{
    private List<Car> carList;

    {
        carList = new ArrayList<>();

        carList.add(new Car("BMW", 445, "black"));
        carList.add(new Car("Mazda", 648, "black"));
        carList.add(new Car("Ferrari", 348, "red"));
        carList.add(new Car("Mercedes", 774, "white"));
        carList.add(new Car("Ford", 365, "blue"));
    }

    @Override
    public List<Car> getCountByCar(int count) {
        List<Car> result = new ArrayList<>();
        if(count > 5) {
            count = 5;
        }
        for (int i = 0; i < count; i++) {
            result.add(carList.get(i));
        }
        return result;
    }
}
