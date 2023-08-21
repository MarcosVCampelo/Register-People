package br.com.mysite.peopleregister.controller;


import br.com.mysite.peopleregister.model.People;
import br.com.mysite.peopleregister.model.PeopleEditRC;
import br.com.mysite.peopleregister.model.PeopleRC;
import br.com.mysite.peopleregister.model.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mysite")
public class RegisterController {


    @Autowired
    private PeopleRepository peopleRepository;


    @GetMapping("/register")
    public String registerPag(Long id, Model model){
        if (id != null){
            var people = peopleRepository.getReferenceById(id);
            model.addAttribute("people", people);
        }
        return "create/registerPag";
    }

    @GetMapping("/list")
    public String listPag(Model model){
        model.addAttribute("list", peopleRepository.findAll());
        return"create/listPag";
    }
    @PostMapping("/list")
    public String dateItens(PeopleRC peopleRC) {
        var people = new People(peopleRC);
        peopleRepository.save(people);
        return "redirect:/mysite/list";


    }

    @PutMapping("/list")
    @Transactional
    public String editPeople(PeopleEditRC peopleEditRC){
        var people = peopleRepository.getReferenceById(peopleEditRC.id());
        people.update(peopleEditRC);
        return "redirect:/mysite/list";

    }
    @DeleteMapping("/list")
    public String deletePeople(Long id){
        peopleRepository.deleteById(id);
        return "redirect:/mysite/list";
    }


}
