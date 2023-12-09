package hookah.controller;

import hookah.entity.Filler;
import hookah.entity.Order;
import hookah.entity.Tobacco;
import hookah.repository.FillerRepository;
import hookah.repository.HookahRepository;
import hookah.repository.OrderRepository;
import hookah.repository.TobaccoRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderRepository orderRepository;
    private final FillerRepository fillerRepository;
    private final TobaccoRepository tobaccoRepository;
    private final HookahRepository hookahRepository;

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
