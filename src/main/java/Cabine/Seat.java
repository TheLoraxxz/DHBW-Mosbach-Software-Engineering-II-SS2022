package Cabine;


import Driver.DriverSection;
import FLF.PositionType;
import Operator.OperatorSection;
import Person.Driver;
import Person.Operator;
import Person.Person;

public class Seat {
    private PositionType position;
    private Person person;
    private Respirators respirators;

    private OperatorSection operator;
    private DriverSection driver;

    public Seat(PositionType position) {
        this.position = position;
        respirators = new Respirators();
    }

    public Seat(PositionType position,OperatorSection section) {
        this.position = position;
        respirators = new Respirators();
        operator = section;
    }
    public Seat(PositionType position,DriverSection section) {
        this.position = position;
        respirators = new Respirators();
        driver = section;
    }
    public Respirators getRespirators() {
        return respirators;
    }


    public Operator getOperator()
    {
        if(operator != null)
            return (Operator)person;
        return null;
    }

    public Driver getDriver()
    {
        if(driver != null)
            return (Driver) person;
        return null;
    }

    public boolean setPerson(Person person) {
        if (this.person == null) {
            if (this.driver!=null && person instanceof Driver) {
                    Driver driverP = (Driver) person;
                    driverP.sitDown(driver);
                    driver.setDriver(driverP);
                    this.person = person;

            }
            if(this.operator!=null&&person instanceof Operator) {
                Operator operatorP = (Operator) person;
                operatorP.sitDown(operator);
                operator.setOperator(operatorP);
                this.person = person;
            }
        }
        return true;
    }
    public PositionType getPosition() {
        return this.position;
    }
    public boolean isTaken()
    {
        return person != null;
    }
}
