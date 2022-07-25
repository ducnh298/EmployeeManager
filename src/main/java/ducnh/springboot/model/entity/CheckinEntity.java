package ducnh.springboot.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "checkin")
@NoArgsConstructor
@Getter
@Setter
public class CheckinEntity extends BaseEntity {

	@Column
	private String dayOfWeek;

	@Column
	private String status;
	
	@Column
	private int resultTime = 0; 

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;

}
