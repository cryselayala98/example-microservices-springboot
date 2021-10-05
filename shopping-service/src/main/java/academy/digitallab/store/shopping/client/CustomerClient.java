package academy.digitallab.store.shopping.client;

import academy.digitallab.store.shopping.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//cliente de servicio rest para comunicarse con los demas microservicios (feign)

//@RequestMapping("/customers")
@FeignClient(name="customer-service", fallback = CustomerHystrixFallbackFactory.class)
public interface CustomerClient {

    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id);

}
