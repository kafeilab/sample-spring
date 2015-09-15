package edu.sample.spring.rest.controller;

import edu.sample.spring.rest.model.Member;
import edu.sample.spring.rest.model.Members;
import edu.sample.spring.rest.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Kafeilab on 9/15/15.
 */
@Controller
public class RestMemberController {

    @Autowired
    private MemberService memberService;

    /*
     * Use @RequestMapping("/members/* /{memberid}") for pretty URLs or
     * SEO (search engine optimization)
     *
     * In this case, the wildcard does not have any influent, but it will match,
     * for example: /members/Jonh+Smith/353 => for member with id 353
     */
    @RequestMapping("/members")
    public String getRestMembers(Model model) {
        Members members = new Members();    // TODO use service

        model.addAttribute("members", members);
        return "membertemplate";
    }

    /*
     * Using the ResponseEntity to inform the client
     */
    @RequestMapping("/members/{memberid}")
    public ResponseEntity<Member> getMember(@PathVariable("memberid") long memberId) {
        Member member = new Member();   // TODO use service
        if (member != null) {
            return new ResponseEntity<Member>(member, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    /*
     * ---------------
     * InitBinder
     * ---------------
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
    }

    @RequestMapping("/reservations/{date}")
    public void getReservation(@PathVariable("date") Date date) {

    }
}
