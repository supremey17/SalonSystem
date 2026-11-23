package edu.secourse.salonapp.models;

public class Stylist extends User {
    private String specialty;

    public Stylist(int id, String name, String email, String phone) {
        super(id, name, email, phone);
        this.specialty = specialty;
    }
    public String getSpecialty() {
        return specialty;
    }
    public void setSpecialty(String specialty) {
        this.specialty= specialty;
    }

    @Override
    public String toString(){
        return super.toString() + " | specialty: " + specialty;
    }
}
