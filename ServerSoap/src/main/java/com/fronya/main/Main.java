package com.fronya.main;


import com.fronya.soap.PersonService;
import com.fronya.soap.PersonServiceImpl;

import javax.xml.ws.Endpoint;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Server");
        PersonService service = new PersonServiceImpl();
        String address = "http://localhost:9001/personService";
        Endpoint.publish(address, service);
    }
}
