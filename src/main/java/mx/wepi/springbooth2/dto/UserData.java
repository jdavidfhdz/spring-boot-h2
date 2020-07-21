package mx.wepi.springbooth2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * UserData definition
 *
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserData {

	//City Id
	private int cityId;
	
	//User name
	private String name;
	
	//User age
	private int age;
	
}
