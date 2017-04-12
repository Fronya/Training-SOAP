package com.fronya.main;


import com.fronya.soap.FriendNotFoundException_Exception;
import com.fronya.soap.Person;
import com.fronya.soap.PersonService;
import com.fronya.soap.PersonService_Service;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Main {

    public static void main(String[] args) throws DatatypeConfigurationException {
        Person firstFriend = getPerson("Ann", 20, 5, 1995);
        Person secondFriend = getPerson("Max", 16, 7, 1995);
        Person thirdFriend = getPerson("Nik", 5, 2, 1996);

        Person person = getPerson("Andy", 4, 3, 1997);
        person.getFriends().add(firstFriend);
        person.getFriends().add(secondFriend);
        person.getFriends().add(thirdFriend);

        PersonService_Service service = new PersonService_Service();
        PersonService client = service.getPersonServiceImplPort();
        findFriendsBornSameYear(client, person, 1995);
        findFriendsBornSameYear(client, person, 2000);
    }


    private static Person getPerson(String name, int day, int month, int year) throws DatatypeConfigurationException{
        Person friend = new Person();
        friend.setName(name);
        XMLGregorianCalendar birthday = DatatypeFactory.newInstance().
                newXMLGregorianCalendar(new GregorianCalendar(year, month, day));
        friend.setBirthday(birthday);
        return friend;
    }

    private static List<Person> findFriendsBornSameYear(PersonService service, Person person, int year){
        try {
            System.out.println("Friends year " + year);
            List<Person> friends = service.getFriendsBornSameYear(person, year);
            for (Person f: friends) {
                System.out.println(f.getName() + ' ' + f.getBirthday().getYear());
            }
            return friends;
        } catch (FriendNotFoundException_Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
