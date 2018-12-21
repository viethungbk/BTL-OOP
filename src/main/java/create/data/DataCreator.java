package create.data;

import config.QuantityConfig;

public class DataCreator {
	
	public DataCreator() {
		
	}

	/**
	 * Sinh ngẫu nhiên các thực thể và các quan hệ
	 * 
	 * @param numberEntity
	 *            : Số lượng thực thể muốn tạo
	 * @param numberRelationship
	 *            : Số lượng quan hệ giữa các thực thể muốn tạo
	 */
	public void createData(int numberEntity, int numberRelationship) {
		QuantityConfig quantityConfig = new QuantityConfig(numberEntity, numberRelationship);
		
	}

}
