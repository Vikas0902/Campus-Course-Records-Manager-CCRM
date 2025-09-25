package edu.ccrm.domain;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Person {
    protected final String id;
    protected Name name;
    protected String email;
    protected LocalDate dateOfBirth;
    protected LocalDate createdDate;
    protected LocalDate lastModified;

    protected Person(String id, Name name, String email, LocalDate dateOfBirth) {
        this.id = Objects.requireNonNull(id, "ID cannot be null");
        this.name = Objects.requireNonNull(name, "Name cannot be null");
        this.email = Objects.requireNonNull(email, "Email cannot be null");
        this.dateOfBirth = dateOfBirth;
        this.createdDate = LocalDate.now();
        this.lastModified = LocalDate.now();
    }
    
    public abstract String getPersonType();
    public abstract void displayProfile();
    
    public String getId() {
        return id;
    }
    public Name getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = Objects.requireNonNull(email, "Email cannot be null");
        updateLastModified();
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        updateLastModified();
    }
    public LocalDate getCreatedDate() {
        return createdDate;
    }
    public LocalDate getLastModified() {
        return lastModified;
    }
    protected void updateLastModified() {
        this.lastModified = LocalDate.now();
    }
    public int getAge() {
        if (dateOfBirth == null) return 0;
        return LocalDate.now().getYear() - dateOfBirth.getYear();
    }
    



    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return Objects.equals(id, person.id);
    }
    



    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    


    
    @Override
    public String toString() {
        return getPersonType() + "{" +
               "id='" + id + "', " +
               "name=" + name +
               ", email='" + email + "'" +
               "}";
    }
}