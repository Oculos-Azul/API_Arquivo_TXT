package models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import dto.StudioDTO;

public class Studio implements Serializable{
	UUID id = UUID.randomUUID();
	private String name;
	private LocalDate foundationDate;

	public Studio(StudioDTO studiodto) {
		this.name = studiodto.name();
		this.foundationDate = studiodto.data();
	}

	@Override
	public String toString() {
		return "Studio [id=" + id + ", name=" + name + ", foundationDate=" + foundationDate + "]";
	}

}
