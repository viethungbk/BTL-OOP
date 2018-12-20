package create.data;

import java.time.LocalDate;

import config.EntityConfig;
import entities.Time;

/**
 * Tạo ngẫu nhiên một thực thể Time
 * 
 * @author Viet Hung
 *
 */
public class TimeCreator {
	public Time createTime(String id, String name, String description) {
		String link = EntityConfig.TIME_LINK + id;
		// Random ngày trích rút bằng thời gian hiện tại của hệ thống
		LocalDate date = java.time.LocalDate.now();
		
		Time time = new Time(id, name, description, link, date);
		return time;
	}
}
