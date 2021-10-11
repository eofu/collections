package com.myself.pattern.pattern4proxy.staticproxy;

import com.myself.pattern.pattern4proxy.staticproxy.Person;

public class YellowMoww {

    public void replaceBuyTicket(Person person) {
        person.buyTicket();
        System.out.println("kill any person");
    }
}
