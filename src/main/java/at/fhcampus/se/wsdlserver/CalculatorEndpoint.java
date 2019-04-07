package at.fhcampus.se.wsdlserver;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CalculatorEndpoint {

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addRequest")
    @ResponsePayload
    public AddResponse add(@RequestPayload AddRequest request) {
        AddResponse ret = new AddResponse();
        System.out.println("1 -> " + request.getInputRecord().getFirstNum());
        System.out.println("2 -> " + request.getInputRecord().getSecondNum());
        ret.setOut(request.getInputRecord().getFirstNum() + request.getInputRecord().getSecondNum());
        System.out.println("out -> " + ret.getOut());
        return ret;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "subtractRequest")
    @ResponsePayload
    public SubtractResponse subtract(@RequestPayload SubtractRequest requestV2) {
        SubtractResponse ret = new SubtractResponse();
        ret.setOut(requestV2.getInputRecord().getFirstNum() - requestV2.getInputRecord().getSecondNum());
        return ret;
    }

}
