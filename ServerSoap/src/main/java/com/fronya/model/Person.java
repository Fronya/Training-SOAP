package com.fronya.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Calendar;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Person implements Serializable {
    @XmlElement
    private String name;
    @XmlElement
    private Calendar birthday;

    @XmlElement
    private Person[] friends;

    public Person() {
    }

    public Person(String name, Calendar birthday, Person[] friends) {
        this.name = name;
        this.birthday = birthday;
        this.friends = friends;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public Person[] getFriends() {
        return friends;
    }

    public void setFriends(Person[] friends) {
        this.friends = friends;
    }
}
