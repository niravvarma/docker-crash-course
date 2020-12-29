package com.niravvarma.microservices.currencyconversionservice.resource;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service", url = "${CURRENCY_EXCHANGE_URI:http://localhost:8000}")
//@FeignClient(name = "currency-exchange-service") // it picks up from application.properties - spring.application.name for discovery
@FeignClient(name="netflix-zuul-api-gateway-server")
public interface CurrencyExchangeServiceProxy {

	// @GetMapping("/currency-exchange/from/{from}/to/{to}")
	//Zuul executes the proxy and then tries to find the service - currency-exchange-service
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}") //name of service which exposes the REST service
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from,
			@PathVariable("to") String to);
}