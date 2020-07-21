package mx.wepi.springbooth2.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_usuario")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

	// City Id
	private int cityId;

	// User name
	private String name;

	// User age
	private int edad;

	// User id
	@Id
	@GeneratedValue
	private int id;

	public User(UserData usuario) {
		this.name = usuario.getName();
		this.edad = usuario.getAge();
		this.cityId = usuario.getCityId();
	}

}
