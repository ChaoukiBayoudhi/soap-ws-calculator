package com.isg.soa.wscalculator.EndPoint;


import isg.soa.calculator.schema.AddRequest;
import isg.soa.calculator.schema.AddResponse;
import isg.soa.calculator.schema.MinusRequest;
import isg.soa.calculator.schema.MunisResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class calulatorEndPoint {
    public static final String NAMESPACE_URI = "http://wscalculator.soa.isg.com/schema";

    private static final Logger log =
            LoggerFactory.getLogger(calulatorEndPoint.class);


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addRequest")
    @ResponsePayload
    public AddResponse getAdd(@RequestPayload AddRequest request) {

        log.info("A request for adding: " + request.getX() + " + " + request.getY());
        AddResponse response = new AddResponse();
        response.setResult(request.getX().add(request.getY()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "minusRequest")
    @ResponsePayload
    public MunisResponse getMinus(@RequestPayload MinusRequest request) {

        log.info("A request for soustraction: " + request.getX() + " + " + request.getY());
        MunisResponse response = new MunisResponse();
        response.setResult(request.getX().subtract(request.getY()));
        return response;
    }

}
