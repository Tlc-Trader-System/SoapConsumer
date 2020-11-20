package com.clientservice;


import com.WsdlClasses.GetOrderRequest;
import com.WsdlClasses.GetOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;


@Service
public class ClientService extends WebServiceGatewaySupport {

    @Autowired
    private Jaxb2Marshaller marshaller;

    private WebServiceTemplate template;

    public GetOrderResponse getOrderResponse(GetOrderRequest request){
        template = new WebServiceTemplate(marshaller);
        GetOrderResponse ack =(GetOrderResponse) template.marshalSendAndReceive("http://localhost:8080/ws",request);
        return ack;
    }
}
