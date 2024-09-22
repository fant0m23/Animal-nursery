package models;

public class Horse extends PackAnimals{
    public Horse(String name, String birthdate) {
        super(name, birthdate);
        super.type = "horse";
    }
}
