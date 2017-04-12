package com.fronya.soap;


import com.fronya.exception.FriendNotFoundException;
import com.fronya.model.Person;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@WebService(endpointInterface = "com.fronya.soap.PersonService", serviceName = "PersonService")
public class PersonServiceImpl implements PersonService {

    public PersonServiceImpl() {
    }

    @Override
    public List<Person> getFriendsBornSameYear(Person person, int year) throws FriendNotFoundException {
        List<Person> friends = new ArrayList<>();
        for (Person friend: person.getFriends()) {
            if(friend.getBirthday().get(Calendar.YEAR) == year){
                friends.add(friend);
            }
        }
        if(friends.size() == 0){
            throw new FriendNotFoundException();
        }
        return friends;
    }
}
