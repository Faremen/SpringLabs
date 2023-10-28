package hookah.web.controllers;

import hookah.models.data.Filler;
import hookah.models.data.Tobacco;
import hookah.models.repository.FillerRepository;
import hookah.models.repository.HookahRepository;
import hookah.models.repository.OrderRepository;
import hookah.models.repository.TobaccoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import hookah.models.data.Order;

import java.util.ArrayList;

@Controller
@RequestMapping("/order")
public class OrderController {

    private OrderRepository orderRepository;
    private FillerRepository fillerRepository;
    private TobaccoRepository tobaccoRepository;
    private HookahRepository hookahRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository,
                           FillerRepository fillerRepository,
                           TobaccoRepository tobaccoRepository,
                           HookahRepository hookahRepository) {
        this.orderRepository = orderRepository;
        this.fillerRepository = fillerRepository;
        this.tobaccoRepository = tobaccoRepository;
        this.hookahRepository = hookahRepository;
    }

    @GetMapping
    public String order(@ModelAttribute("order") Order order, Model model) {
        return "orderPage";
    }

    @PostMapping
    public String createOrder(@Valid Order order, Errors errors) {
        if (errors.hasErrors()) {
            return "orderPage";
        }

        hookahRepository.save(order.getHookah());
        orderRepository.save(order);

        return "successOrderPage";
    }

    @ModelAttribute("fillers")
    public Iterable<Filler> fillers() {
        return fillerRepository.findAll();
    }

    @ModelAttribute("tobaccos")
    public Iterable<Tobacco> tobaccos() {
        return tobaccoRepository.findAll();
    }
}
