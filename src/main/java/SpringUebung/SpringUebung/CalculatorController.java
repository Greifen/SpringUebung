package SpringUebung.SpringUebung;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalculatorController {

    @GetMapping("/calculator")
    public String calculator() {
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(
            @RequestParam double operand1,
            @RequestParam String operator,
            @RequestParam double operand2,
            Model model
    ) {
        double result = 0;

        try {
            switch (operator) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                    result = operand1 - operand2;
                    break;
                case "*":
                    result = operand1 * operand2;
                    break;
                case "/":
                    if (operand2 != 0) {
                        result = operand1 / operand2;
                    } else {
                        model.addAttribute("result", "Error: Division by zero");
                        return "calculator";
                    }
                    break;
                default:
                    model.addAttribute("result", "Invalid operator");
                    return "calculator";
            }
        } catch (Exception e) {
            model.addAttribute("result", "Error: Invalid input");
            return "calculator";
        }

        model.addAttribute("result", result);
        return "calculator";
    }
}
