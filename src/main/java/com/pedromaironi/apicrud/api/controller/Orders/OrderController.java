package com.pedromaironi.apicrud.api.controller.Orders;

import com.pedromaironi.apicrud.api.repository.OrderRepository;
import com.pedromaironi.apicrud.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/all")
    public List<Orders> getOrders() {
        return orderRepository.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Orders> createOrder(
            @RequestParam(value = "id_cliente", required = true) int id_cliente,
            @RequestParam(value = "fecha", required = false) LocalDate fecha,
            @RequestParam(value = "total") Double total,
            @RequestParam(value = "estado", required = false) String estado,
            @RequestParam(value = "subtotal") Double subtotal,
            @RequestParam(value = "taxes") Double taxes,
            @RequestParam(value = "pago_envio") Double pago_envio) {
        try {
            Orders order = new Orders();
            order.setId_cliente(id_cliente);
            if (fecha != null) order.setFecha(fecha);
            if (estado != null) order.setEstado(estado);
            order.setTotal(total);
            order.setSubtotal(subtotal);
            order.setTaxes(taxes);
            order.setPago_envio(pago_envio);

            Orders savedOrder = orderRepository.save(order);
            return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable("id") int id) {
        try {
            orderRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
