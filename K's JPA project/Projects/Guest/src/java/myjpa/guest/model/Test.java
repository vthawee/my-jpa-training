/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjpa.guest.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author com
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("web/WEB-INF/applicationContext.xml", "web/WEB-INF/dispatcher-servlet.xml");

        Guests guests = ctx.getBean("guests", Guests.class);

//        int id = guests.insert(new Guest("TEXT3", "NAME3"));
        System.out.println("//Native query");
        for (Guest guest : guests.findAllByNativeQuery()) {
            System.out.println(guest.getId());
            System.out.println(guest.getName());
            System.out.println(guest.getText());
            System.out.println(guest.getCreated());
        }
        System.out.println("//JPQL");
        for (Guest guest : guests.findAllByJpql()) {
            System.out.println(guest.getId());
            System.out.println(guest.getName());
            System.out.println(guest.getText());
            System.out.println(guest.getCreated());
        }
        System.out.println("//Name query");
        for (Guest guest : guests.findAllByNameQuery()) {
            System.out.println(guest.getId());
            System.out.println(guest.getName());
            System.out.println(guest.getText());
            System.out.println(guest.getCreated());
        }
    }
}
