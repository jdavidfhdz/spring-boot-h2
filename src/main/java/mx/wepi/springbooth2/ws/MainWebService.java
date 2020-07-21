package mx.wepi.springbooth2.ws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponses;
import com.wordnik.swagger.annotations.ApiResponse;

import mx.wepi.springbooth2.dao.UserRepository;
import mx.wepi.springbooth2.dto.City;
import mx.wepi.springbooth2.dto.UserData;
import mx.wepi.springbooth2.dto.State;
import mx.wepi.springbooth2.dto.Country;
import mx.wepi.springbooth2.dto.User;

@RestController
@RequestMapping("/service")
@Api(value = "main", description = "User API")
public class MainWebService {

	//Countries List
	List<Country> countries = new ArrayList<>();
	//Cities List
	List<City> cities = new ArrayList<>();
	//States List
	List<State> states = new ArrayList<>();
	
	//User Repository Reference
	@Autowired
	UserRepository usrRepo;
	
	@PostConstruct
	public void init(){
		countries.add(new Country(1, "México"));
		countries.add(new Country(2, "Estados Unidos"));
		countries.add(new Country(3, "Canadá"));
		
		states.add(new State(1, 1, "Chihuahua"));
		states.add(new State(2, 1, "Nayarit"));
		states.add(new State(3, 2, "Ohio"));
		states.add(new State(4, 2, "Texas"));
		states.add(new State(5, 3, "Manitoba"));
		states.add(new State(6, 3, "Alberta"));
		
		
		cities.add(new City(1, 1, "Juárez"));
		cities.add(new City(2, 1, "Chihuahua"));
		cities.add(new City(3, 2, "La palma"));
		cities.add(new City(4, 2, "Tepic"));
		cities.add(new City(5, 3, "Columbus"));
		cities.add(new City(6, 3, "Springfield"));
		cities.add(new City(7, 4, "San Antonio"));
		cities.add(new City(8, 4, "Austin"));
		cities.add(new City(9, 5, "Winnipeg"));
		cities.add(new City(10, 5, "Winkler"));
		cities.add(new City(11, 6, "Lacombe"));
		cities.add(new City(12, 6, "Calgary"));

	}
	

    @ApiOperation(value = "find all countries", notes = "find all countries")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK") })
	@CrossOrigin(origins="*")
	@RequestMapping(value="/findAllCountries", method=RequestMethod.GET)
	public ResponseEntity<List<Country>> findAllCountries(){
		return new ResponseEntity<List<Country>>(countries, HttpStatus.OK);
	}
	

    @ApiOperation(value = "find All States", notes = "find All States of a Country. Recieves the country id")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK") })
	@CrossOrigin(origins="*")
	@RequestMapping(value="/findAllStates", method=RequestMethod.POST)
	public ResponseEntity<List<State>> findAllStates(@RequestBody @Valid Integer countryId){
		List<State> result = new ArrayList<>();
		for (State state : states) {
			if(countryId == state.getCountryId()){
				result.add(state);
			}
		}
		return new ResponseEntity<List<State>>(result, HttpStatus.OK);
	}

    @ApiOperation(value = "find All Cities", notes = "find All cities of a state. Recieves the state id")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK") })
	@CrossOrigin(origins="*")
	@RequestMapping(value="/findAllCities", method=RequestMethod.POST)
	public ResponseEntity<List<City>> findAllCities(@RequestBody @Valid Integer stateId){
		List<City> result = new ArrayList<>();
		for (City city : cities) {
			if(stateId == city.getStateId()){
				result.add(city);
			}
		}
		return new ResponseEntity<List<City>>(result, HttpStatus.OK);
	}
	
    @ApiOperation(value = "saveUser", notes = "Save the user {username, age, cityId}")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 400, message = "JSON bad form ") })
	@CrossOrigin(origins="*")
	@RequestMapping(value="/saveUser", method=RequestMethod.POST)
	public ResponseEntity<Map<String, String>> saveUser(@RequestBody @Valid UserData data, BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
		System.out.println(data);
		
		//Persist the user in a H2 DB
		usrRepo.save(new User(data));
		
		Map<String, String> result = new HashMap<>();
		result.put("result", "User created");
		return new ResponseEntity<Map<String, String>>(result,HttpStatus.OK);
	}
	
	
	
}
