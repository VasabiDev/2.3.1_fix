package web.model;


import javax.persistence.*;
import java.util.Objects;

import static java.util.Objects.hash;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String model;


    @Column(name = "series")
    private int series;




    public Car(int series, String model) {
        this.series = series;
        this.model = model;
    }

    public Car() {

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }



    @Override
    public String toString() {
        return ("The car with series = " + getSeries() + " and model = " + getModel());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Car car = (Car) obj;
        return
                (Objects.equals(series, car.series)
                        || (series != 0 && series == (car.getSeries()))) && (Objects.equals(model, car.model)
                        || (model != null && model.equals(car.getModel())
                ));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((series == 0) ? 0 : series * prime);
        result = (prime * result + (hash(series) + hash(model)));
        result = prime * result + ((model == null) ? 0 : (model.hashCode() >>> 31));
        return result;
    }
}

