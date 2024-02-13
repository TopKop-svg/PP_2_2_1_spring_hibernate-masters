package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    private Long carId;
    private User user;
    private String model;
    private int series;

    public Car () {

    }

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cars")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id", nullable = false, insertable = true, updatable = true)
    public Long getCarId () {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }



    @Basic
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    @Basic
    @Column(name = "series")
    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", series=" + series +
                '}';
    }
}