package config;

/**
 * Cài đặt số lượng của từng loại thực thể và quan hệ được tạo ra
 * 
 * @author Viet Hung
 *
 */
public class QuantityConfig {
	// Tổng số loại thực thể
	private static final int NUMBER_TYPE_ENTITY = 6;
	
	// Tổng số loại quan hệ
	private static final int NUMBER_TYPE_RELATIONSHIP = 7;
	
	// Tổng só lượng các thực thể cần tạo
	private int numberEntity;
	
	// Tổng số lượng các quan hệ cần tạo
	private int numberRelationship;
	
	
	// Số lượng từng loại thực thể cần tạo
	private int numberCountry;
	private int numberEvent;
	private int numberLocation;
	private int numberOrganization;
	private int numberPerson;
	private int numberTime;

	// Số lượng từng quan hệ cần tạo
	private int number_Re_Country_Event;
	private int number_Re_Event_Location;
	private int number_Re_Event_Time;
	private int number_Re_Organization_Event;
	private int number_Re_Organization_Location;
	private int number_Re_Person_Event;
	private int number_Re_Person_Location;
	
	/**
	 * Constructor
	 * Khởi tạo QuantityCofig.
	 * Số lượng thực thể của mỗi loại sẽ là (tổng số thực thể muốn tạo) / (số loại thực thể)
	 * Riêng số lượng của loại thực thể cuối sẽ bằng (tổng số lượng thực thể) - (số loại thực thể - 1) * (số lượng thực thể của mỗi loại)
	 * để đảm đúng lượng thực thể muốn tạo.
	 * Tương tự với số lượng quan hệ.
	 * 
	 * @param numberEntity		 : tổng số lượng thực thể muốn tạo.
	 * @param numberRelationship : tổng số quan hệ muốn tạo.
	 */
	public QuantityConfig(int numberEntity, int numberRelationship) {
		// Số lượng (khoảng) mỗi loại thực thể
		int numberEachTypeOfEntity = numberEntity / NUMBER_TYPE_ENTITY;
		// Số lượng (khoảng) mỗi loại quan hệ
		int numberEachTypeOfRelationship = numberRelationship / NUMBER_TYPE_RELATIONSHIP;
		
		this.numberEntity = numberEntity;
		this.numberRelationship = numberRelationship;
		
		this.numberCountry = numberEachTypeOfEntity;
		this.numberEvent = numberEachTypeOfEntity;
		this.numberLocation = numberEachTypeOfEntity;
		this.numberOrganization = numberEachTypeOfEntity;
		this.numberPerson = numberEachTypeOfEntity;
		this.numberTime = numberEntity - (NUMBER_TYPE_ENTITY - 1) * numberEachTypeOfEntity;
		
		this.number_Re_Country_Event = numberEachTypeOfRelationship;
		this.number_Re_Event_Location = numberEachTypeOfRelationship;
		this.number_Re_Event_Time = numberEachTypeOfRelationship;
		this.number_Re_Organization_Event = numberEachTypeOfRelationship;
		this.number_Re_Organization_Location = numberEachTypeOfRelationship;
		this.number_Re_Person_Event = numberEachTypeOfRelationship;
		this.number_Re_Person_Location = numberRelationship - (NUMBER_TYPE_RELATIONSHIP - 1) * numberEachTypeOfRelationship;
		
	}

	public int getNumberEntity() {
		return numberEntity;
	}

	public int getNumberRelationship() {
		return numberRelationship;
	}

	public int getNumberCountry() {
		return numberCountry;
	}

	public int getNumberEvent() {
		return numberEvent;
	}

	public int getNumberLocation() {
		return numberLocation;
	}

	public int getNumberOrganization() {
		return numberOrganization;
	}

	public int getNumberPerson() {
		return numberPerson;
	}

	public int getNumberTime() {
		return numberTime;
	}

	public int getNumber_Re_Country_Event() {
		return number_Re_Country_Event;
	}

	public int getNumber_Re_Event_Location() {
		return number_Re_Event_Location;
	}

	public int getNumber_Re_Event_Time() {
		return number_Re_Event_Time;
	}

	public int getNumber_Re_Organization_Event() {
		return number_Re_Organization_Event;
	}

	public int getNumber_Re_Organization_Location() {
		return number_Re_Organization_Location;
	}

	public int getNumber_Re_Person_Event() {
		return number_Re_Person_Event;
	}

	public int getNumber_Re_Person_Location() {
		return number_Re_Person_Location;
	}
}
