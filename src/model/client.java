package model;

/**
 * Represents a bank client.
 * Stores personal information and provides methods to manage client details.
 */
public class Client {

    private int id;
    private String firstName;
    private String lastName;
    private String email;

    /**
     * Creates a client with personal information.
     *
     * @param id the client identifier
     * @param firstName the client's first name
     * @param lastName the client's last name
     * @param email the client's email address
     */
    public Client(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.setEmail(email);
    }

    /**
     * Returns the client identifier.
     *
     * @return the client ID
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the client's email address.
     *
     * @return the email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Updates the client's email address after validation.
     *
     * @param email the new email address
     * @throws IllegalArgumentException if the email is null or invalid
     */
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

    /**
     * Returns the client's first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Updates the client's first name.
     *
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the client's last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Updates the client's last name.
     *
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the client's full name.
     *
     * @return the first name followed by the last name
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }
}