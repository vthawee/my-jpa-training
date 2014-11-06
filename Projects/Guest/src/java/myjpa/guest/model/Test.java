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
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                "web/WEB-INF/applicationContext.xml", "web/WEB-INF/dispatcher-servlet.xml");

        Guests guests = ctx.getBean("guests", Guests.class);

//        int guestId = guests.insert(new Guest("Hello World", "Wee"));
//        System.out.println("Guest Id:" + guestId);
        
        for(Guest g :guests.findAll(2,3)){
            System.out.println(g);
        }
    }
}
