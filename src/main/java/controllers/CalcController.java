package controllers;

import dbDAO.dbDAO;
import dbDAO.calcDAO;
import Calc.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/calculatorDirectory")
public class CalcController {

    private final calcDAO calcDAO;

    @Autowired
    public CalcController(calcDAO calcDAO) {
        this.calcDAO=calcDAO;
    }

    @GetMapping("/calculator")
    public String normCalc(@ModelAttribute("rss") String rss, Model model, @ModelAttribute("calculator") Calculator calculator){
        model.addAttribute("calculator", new Calculator());
        //System.out.println("im in /calculator now" + calcDAO.plus(calculator.getFirstNumber(),calculator.getSecondNumber()));
        //double result1 = request.getParameter(calculator.getResult());
        rss = String.valueOf(calculator.getResult());
        model.addAttribute("rss",rss);

        double result;
        result = calculator.getResult();
        model.addAttribute("res", result);

      //  model.addAttribute("calculator",calcDAO.plus(calculator.getFirstNumber(),calculator.getSecondNumber()));

       // System.out.println("result from calculator" + calcDAO.plus(calculator.getFirstNumber(),calculator.getSecondNumber()).getResult());
        //model.addAttribute("calculator", calcDAO.plus(calc.getFirstNumber(),calc.getSecondNumber()));
        System.out.println("GET PRINYAL");
        return "calculatorDirectory/calculator";
    }



    @PostMapping()
    public String create(@ModelAttribute("rss") String rss,Model model,@ModelAttribute("calc") Calculator calculator){
        // calcDAO.plus(calculator.getFirstNumber(),calculator.getSecondNumber());
        calcDAO.plus(calculator.getFirstNumber(),calculator.getSecondNumber(), calculator);
        rss = String.valueOf(calculator.getResult());
        model.addAttribute("rss",rss);
        double result;
        result = calculator.getResult();
        model.addAttribute("res", result);


       // System.out.println("im in post maping" + calcDAO.plus(calculator.getFirstNumber(),calculator.getSecondNumber()));
        //model.addAttribute("calculator", calcDAO.plus(calculator.getFirstNumber(),calculator.getSecondNumber()));
        // model.addAttribute("calculator",calcDAO.plus(calculator.getFirstNumber(),calculator.getSecondNumber()).getResult());

        calcDAO.save(calculator);

        System.out.println("POST SDAL");
        return "redirect:/calculatorDirectory/calcMemory";
        //return "/calculatorDirectory/calculator";
    }

    @GetMapping("/calcMemory")
    public String calcMemory(Model model){
        model.addAttribute("CalcMemory", calcDAO.calcMemory());

        return "calculatorDirectory/calcMemory";
    }

    @GetMapping("/{id}")
    public String show (@PathVariable ("id") int id, Model model){
        model.addAttribute("mem",calcDAO.show(id));
        return  "calculatorDirectory/calcShow";

    }


   /* public String createNumbers(@ModelAttribute("Calculator") Calculator calculator){
        dbDAO.saveNumbers(calculator);
        return "redirect:/normcalc";
    }*/


}
