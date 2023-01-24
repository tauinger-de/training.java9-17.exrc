package ordering.model;

public sealed class Beverage extends Product permits AlcoholicBeverage, NonalcoholicBeverage {

    public Beverage(Integer id, String name) {
        super(id, name);
    }
}
