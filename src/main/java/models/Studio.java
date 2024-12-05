package models;

import java.time.LocalDate;
import java.util.UUID;

import dto.StudioDTO;

public class Studio {
	UUID id = UUID.randomUUID();
	private String name;
	private LocalDate foundationDate;

	public Studio(StudioDTO studiodto) {
		this.name = studiodto.name();
		this.foundationDate = studiodto.data();
	}

}
