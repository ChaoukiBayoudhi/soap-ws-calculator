package com.isg.soa.wscalculator.EndPoint;


import isg.soa.calculator.schema.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.math.BigDecimal;


@Endpoint
public class calulatorEndPoint {
    public static final String NAMESPACE_URI = "http://wscalculator.soa.isg.com/schema";

    private static final Logger log =
            LoggerFactory.getLogger(calulatorEndPoint.class);

    //The payload is the part of that response that is communicating
    // directly to you. In soap is a part of the xml response data.
    // In REST APIs this is usually some JSON formatted data.
    //You can also send payload to the server as well.
    // This is known as the body of your request
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

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "multiplicationRequest")
    @ResponsePayload
    public MultipResponse getMultiply(@RequestPayload MultiplicationRequest request) {

        log.info("A request for soustraction: " + request.getX() + " + " + request.getY());
        MultipResponse response = new MultipResponse();
        response.setResult(request.getX().multiply(request.getY()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "divisionRequest")
    @ResponsePayload
    public DivisionResponse getDivision(@RequestPayload DivisionRequest request) throws Exception {

        log.info("A request for soustraction: " + request.getX() + " + " + request.getY());
        DivisionResponse response = new DivisionResponse();
        if(request.getY().compareTo(BigDecimal.ZERO) == 0)
            throw new Exception("Error ! Trying to Divide by Zero");
        response.setResult(request.getX().divide(request.getY()));
        return response;
    }

}
