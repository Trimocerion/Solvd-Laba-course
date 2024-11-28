package Airfield.person;

import java.util.Date;
import java.util.UUID;

public abstract class Person {

    private String personId;
    private String name;
    private Date birthDate;


    public Person(){}

    public Person(String name, Date birthDate){
        this.personId = UUID.randomUUID().toString();
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
