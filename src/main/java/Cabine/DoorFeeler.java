package Cabine;

import Person.Person;

public class DoorFeeler implements IDoorFeeler{
    private final BusDoor busDoor;
    private final boolean isInside;
    private final Seat[] seats;


    public DoorFeeler(BusDoor busDoor, boolean position, Seat[] seats) {
        this.isInside = position;
        this.busDoor = busDoor;
        this.seats = seats;

    }
    @Override
    public void press(Person person) {
        if(!isInside) {
            busDoor.setOpen(!busDoor.isOpen());
        } else {
            if(seats.equals(person)) {
                busDoor.setOpen(!busDoor.isOpen());
            }
        }
    }
}
