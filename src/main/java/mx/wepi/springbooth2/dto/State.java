package mx.wepi.springbooth2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * State definition
 * 
 *
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class State {

	//State Id
	private int id;
	
	//Country Id
	private int countryId;
	
	//State name
	private String name;
	
}
