package SpringUebung.SpringUebung;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/")
    public String calculate(
            @RequestParam(value = "number1", defaultValue = "0") double number1,
            @RequestParam(value = "number2", defaultValue = "0") double number2,
            @RequestParam(value = "operation", defaultValue = "add") String operation,
            Model model) {

        double result = 0;
        boolean isAdd = false;
        boolean isSubtract = false;
        boolean isMultiply = false;
        boolean isDivide = false;

        switch (operation) {
            case "add":
                result = number1 + number2;
                isAdd = true;
                break;
            case "subtract":
                result = number1 - number2;
                isSubtract = true;
                break;
            case "multiply":
                result = number1 * number2;
                isMultiply = true;
                break;
            case "divide":
                if (number2 != 0) {
                    result = number1 / number2;
                } else {
                    model.addAttribute("result", "Fehler: Division durch 0!");
                    return "calculator";
                }
                isDivide = true;
                break;
        }

        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        model.addAttribute("result", result);
        model.addAttribute("isAdd", isAdd);
        model.addAttribute("isSubtract", isSubtract);
        model.addAttribute("isMultiply", isMultiply);
        model.addAttribute("isDivide", isDivide);
        
        return "calculator";
    }
}
