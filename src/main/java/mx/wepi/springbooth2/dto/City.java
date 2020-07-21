package mx.wepi.springbooth2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * City Definition
 * 
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class City {

	//City Id
	private int id;
	
	//State Id
	private int stateId;
	
	//City Name
	private String name;

}
