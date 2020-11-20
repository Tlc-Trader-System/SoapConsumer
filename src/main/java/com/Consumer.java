package com;

import com.WsdlClasses.GetOrderRequest;
import com.WsdlClasses.GetOrderResponse;
import com.clientservice.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Consumer {
    @Autowired
    private  ClientService clientService;

    @PostMapping("/getOrder")
    public  GetOrderResponse getOrderResponse(@RequestBody GetOrderRequest request){
        return clientService.getOrderResponse(request);
    }

public static void main(String[] args){

    SpringApplication.run(Consumer.class,args);
}

}
