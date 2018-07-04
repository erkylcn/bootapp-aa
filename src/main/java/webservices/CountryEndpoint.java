package webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.eigames.GetCountryRequest;
import com.eigames.GetCountryResponse;
 
@Endpoint
public class CountryEndpoint {
	private static final String NAMESPACE_URI = "http://www.eigames.com";

	private CountryRepository countryRepository;
 
	@Autowired
	public CountryEndpoint(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	} 

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest1")
	@ResponsePayload
	public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
		GetCountryResponse response = new GetCountryResponse();
		response.setCountry(countryRepository.findCountry(request.getName()));

		return response;
	}
}