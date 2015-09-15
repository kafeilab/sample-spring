package edu.sample.spring.rest.controller;

import edu.sample.spring.rest.model.Member;
import edu.sample.spring.rest.model.Members;
import edu.sample.spring.rest.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Kafeilab on 9/15/15.
 */
@Controller
public class RestMemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/members")
    public String getRestMembers(Model model) {
        Members members = new Members();

        model.addAttribute("members", members);
        return "membertemplate";
    }
}
