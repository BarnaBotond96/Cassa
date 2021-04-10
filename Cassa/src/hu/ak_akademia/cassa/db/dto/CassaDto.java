package hu.ak_akademia.cassa.db.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CassaDto {

	private Long id;
	private String name;
	private Long limit;
	private LocalDateTime lastEdit;

}