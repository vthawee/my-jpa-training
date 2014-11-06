/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjpa.guest.control;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import myjpa.guest.model.Guest;
import myjpa.guest.model.Guests;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author com
 */
@Controller
public class GuestController {

    @Resource
    private Guests guests;

    @RequestMapping("/show.htm")
    public String show(Model model, @RequestParam(value = "no", defaultValue = "0") int pageNo) {
        final int PAGE_SIZE = 3;
        // Calculate start record by page number and page size
        int start = pageNo * PAGE_SIZE;
        
        int numPage = (int) Math.ceil(guests.count() / PAGE_SIZE);
        
        List<Guest> list = guests.findAll(start, PAGE_SIZE);

        model.addAttribute("list", list);
        model.addAttribute("guest", new Guest());
        
        model.addAttribute("numPage", numPage);

        return "show";
    }

    @RequestMapping("/add.htm")
    public String add(Guest guest) {
        //guest.setText(getUTF8String(guest.getText()));
        guest.setCreated(new Date());
        guests.insert(guest);

        return "redirect:/show.htm";
    }

    private String getUTF8String(String text) {
        try {
            return new String(text.getBytes("ISO8859_1"), "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GuestController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
