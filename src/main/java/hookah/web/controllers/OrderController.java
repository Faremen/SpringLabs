package hookah.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import hookah.data.Order;

import javax.validation.Valid;

@Controller
@RequestMapping("/order")
public class OrderController {

    @GetMapping
    public String order(@ModelAttribute Order order, Model model) {
        model.addAttribute("order", order);
        return "orderPage";
    }

    @PostMapping
    public String createOrder(@Valid Order order, BindingResult result) {
        if (result.hasErrors()) {
            return "orderPage";
        }

        return "successOrderPage";
    }
}