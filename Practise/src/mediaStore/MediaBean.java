package mediaStore;

import java.sql.Timestamp;

public class MediaBean {
	int id;
	String types;
	String namemedia;
	Timestamp addDate;
	boolean isloan;
	String lentdate;
	String borrowed;
	public MediaBean(int id, String type, String namemedia, Timestamp addDate,
			boolean isloan, String lentdate, String borrowed) {
		super();
		this.id = id;
		this.types = type;
		this.namemedia = namemedia;
		this.addDate = addDate;
		this.isloan = isloan;
		this.lentdate = lentdate;
		this.borrowed = borrowed;
	}
	public int getId() {
		return id;
	}
	public String getTypes() {
		return types;
	}
	public String getNamemedia() {
		return namemedia;
	}
	public Timestamp getAddDate() {
		return addDate;
	}
	public boolean isIsloan() {
		return isloan;
	}
	public String getLentdate() {
		return lentdate;
	}
	public String getBorrowed() {
		return borrowed;
	}
	
	

}
