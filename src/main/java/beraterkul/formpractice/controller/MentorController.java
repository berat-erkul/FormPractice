package beraterkul.formpractice.controller;

import beraterkul.formpractice.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController{

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("mentor", new Mentor());

        List<String> batchList = List.of("B1", "B2", "B3", "B4"); //This is just a dummy data
        model.addAttribute("batchList", batchList);

        return "mentor/register";
    }


    @PostMapping("/confirm")
    public String submitForm(@ModelAttribute("mentor") Mentor mentor){

        System.out.println(mentor.toString()); //Here we'll save the mentor to the database

        return "mentor/confirm.html";
      //return "redirect:/mentor/confirm.html"  --> this is also correct (it refer an endpoint)
    }


}
