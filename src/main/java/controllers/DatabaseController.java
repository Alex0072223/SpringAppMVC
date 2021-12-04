package controllers;


import dbDAO.dbDAO;
import dbHandler.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Controller
//@ComponentScan(basePackages = {"dbDAO"})
@SpringBootApplication(scanBasePackages={"java","dbDAO"})
@RequestMapping(value = "/databaseDirectory")
public class DatabaseController {

    private final dbDAO db;

    @Autowired
    public DatabaseController(dbDAO db) {
        this.db = db;
    }


    @GetMapping("/database")
    public String database(Model model){ //dataBase
        model.addAttribute("people",db.index());
        return "databaseDirectory/database";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person",db.show(id));
        return  "databaseDirectory/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Const person) {
        return "databaseDirectory/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person")  Const person, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "databaseDirectory/new";


        db.save(person);
        return "redirect:/databaseDirectory/database";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("person", db.show(id));
        return "databaseDirectory/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Validated Const person,BindingResult bindingResult,
                         @PathVariable("id") int id){
        if (bindingResult.hasErrors())
            return "databaseDirectory/edit";
        db.update(id,person);
        return "redirect:/databaseDirectory/database";
    }

    @DeleteMapping("/{id}")
   // @RequestMapping(value = "/{id}",method=RequestMethod.GET)
    public String delete(@PathVariable("id") int id){
        db.delete(id);
        return "redirect:/databaseDirectory/database"; //database
    }

}
