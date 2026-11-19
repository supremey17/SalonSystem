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
}
