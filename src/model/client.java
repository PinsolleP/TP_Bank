package model;

public class Client {

    private int id;
    private String firstName;
    private String lastName;
    private String email;

    public Client(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.setEmail(email);
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        if ( email == null){
            throw new IllegalArgumentException("Le mail ne peut pas être null.");
        }

        String regexPattern = "^(.+)@(\\S+)$";

        if (!email.matches(regexPattern)){
            throw new IllegalArgumentException(("Le mail saisi est invalide"));
        }

        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}