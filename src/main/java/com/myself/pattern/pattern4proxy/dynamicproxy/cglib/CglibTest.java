package com.myself.pattern.pattern4proxy.dynamicproxy.cglib;

import com.myself.pattern.pattern4proxy.dynamicproxy.cglib.Customer;
import com.myself.pattern.pattern4proxy.dynamicproxy.cglib.PaoTui;

public class CglibTest {
    public static void main(String[] args) {
        com.myself.pattern.pattern4proxy.dynamicproxy.cglib.Customer customer = new com.myself.pattern.pattern4proxy.dynamicproxy.cglib.Customer();
        com.myself.pattern.pattern4proxy.dynamicproxy.cglib.PaoTui paoTui = new PaoTui();
        com.myself.pattern.pattern4proxy.dynamicproxy.cglib.Customer instance = (com.myself.pattern.pattern4proxy.dynamicproxy.cglib.Customer) paoTui.getInstance(Customer.class);
        instance.buy();
    }
}
