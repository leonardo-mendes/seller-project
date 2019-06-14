package br.com.srm.service;

import br.com.srm.client.PhoneClient;
import br.com.srm.client.dto.Phone;
import br.com.srm.exception.BusinessServiceException;
import br.com.srm.model.Order;
import br.com.srm.model.OrderItem;
import br.com.srm.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class OrderService {

    private OrderRepository orderRepository;

    private PhoneClient phoneClient;

    public Order create(Order order) {
        log.info("m=create, order={}", order);
        validateItensExists(order);
        order.setCreateDate(new Date());
        order.setStatus(Order.Status.CREATED);
        return orderRepository.save(order);
    }

    public Order findById(String id) {
        return getOrderById(id);
    }

    public List<Order> findByClient(String cpf) {
        return orderRepository.findByClient_CpfOrderByCreateDateAsc(cpf);
    }

    public Order finish(String id) {
        log.info("m=finish, id={}", id);
        Order order = getOrderById(id);
        order.setFinishDate(new Date());
        order.setStatus(Order.Status.FINISHED);
        return orderRepository.save(order);
    }

    public Order cancel(String id) {
        log.info("m=cancel, id={}", id);
        Order order = getOrderById(id);
        order.setFinishDate(new Date());
        order.setStatus(Order.Status.CANCELED);
        return orderRepository.save(order);
    }


    private void validateItensExists(Order order) {
        for (OrderItem item : order.getItens()) {
            Phone product = phoneClient.findById(item.getAmount().longValue());
            if (product == null)
                throw new BusinessServiceException("Produto nao encontrado");
        }
    }

    private Order getOrderById(String id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (!optionalOrder.isPresent())
            throw new BusinessServiceException("Pedido não encontrado");
        return optionalOrder.get();
    }

}
