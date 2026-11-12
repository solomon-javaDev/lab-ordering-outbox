package io.sol.laborderingoutbox.controller;


import io.sol.laborderingoutbox.entity.LabOrder;
import io.sol.laborderingoutbox.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class LabOrderController {

    private final OrderService orderService;

    public LabOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create_lab_order")
    public String createOrder(@RequestBody LabOrder labOrder){
        orderService.createLabOrder(labOrder);
        return "Success";
    }
}
