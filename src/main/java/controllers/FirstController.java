package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FirstController {





    @GetMapping("/hello")
    public String helloPage(){
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(){
        return "first/goodbye";
    }






    @GetMapping("/calculator")
    public String calculator(/*@RequestParam("a")*//* int a,*//* @RequestParam("b")*//* int b,
                             *//*@RequestParam("action")*//* String action,*/ Model model) {

        double result;
        String action = null;
        int a=0,b=0, first=a,second=b;


        switch (action) {
            case "mp":
                result = a * b;
                break;
            case "dv":
                result = a / (double) b;
                break;
            case "st":
                result = a - b;
                break;
            case "add":
                result = a + b;
                break;
            default:
                result = 0;
                break;
        }
        model.addAttribute("first",first);
        model.addAttribute("second",second);
        model.addAttribute("result", result);

        return "calculator/calculator";
    }





   /* @RequestMapping(value = "/files/{file_name:.+}", method = RequestMethod.GET)
    public void getFile(@PathVariable("file_name") String fileName, HttpServletResponse response) {
        // Прежде всего стоит проверить, если необходимо, авторизован ли пользователь и имеет достаточно прав на скачивание файла. Если нет, то выбрасываем здесь Exception

        //Авторизованные пользователи смогут скачать файл
        Path file = Paths.get(PathUtil.getUploadedFolder(), fileName);
        if (Files.exists(file)){
            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
            response.setContentType("application/vnd.ms-excel");

            try {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            } catch (IOException e) {
                LOG.info("Error writing file to output stream. Filename was '{}'" + fileName, e);
                throw new RuntimeException("IOError writing file to output stream");
            }
        }
    }*/

}
