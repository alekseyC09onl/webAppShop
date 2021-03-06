package com.tms.webappshop.restControllers;

import com.tms.webappshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class CalculationTest {
    private Integer paramA;
    private Integer paramB;
    private String paramAction;
    private double result;
    private final ProductService productService;

    @GetMapping("/calc")
    public String calculate(@RequestParam(value = "a", required = false) Integer a,
                            @RequestParam(value = "b", required = false) Integer b,
                            @RequestParam(value = "action", required = false) String action,
                            Model model) {
        switch (action) {
            case ("addition"):
                result = a + b;
                break;
            case ("subtraction"):
                result = a - b;
                break;
            case ("multiplication"):
                result = a * b;
                break;
            case ("division"):
                result = (double) a / b;
                break;
            default:
                return null;
        }

        paramA = a;
        paramB = b;
        paramAction = action;

        model.addAttribute("result", result);
        model.addAttribute("a", paramA);
        model.addAttribute("b", paramB);
        model.addAttribute("action", paramAction);

        return "calculationTest";
    }

}
