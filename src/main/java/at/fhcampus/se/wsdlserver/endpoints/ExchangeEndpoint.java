package at.fhcampus.se.wsdlserver.endpoints;

import at.fhcampus.se.wsdlserver.CurrencyResponse;
import at.fhcampus.se.wsdlserver.ExchangeCurrencyRequest;
import at.fhcampus.se.wsdlserver.ExchangeCurrencyResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ExchangeEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "exchangeCurrencyRequest")
    @ResponsePayload
    public ExchangeCurrencyResponse exchange(@RequestPayload ExchangeCurrencyRequest request) {
        CurrencyResponse response = new CurrencyResponse();

        response.setToCurrency("USD");
        response.setToCurrencyAmount(100);

        ExchangeCurrencyResponse ret = new ExchangeCurrencyResponse();
        ret.setResponse(response);
        return ret;
    }

}
