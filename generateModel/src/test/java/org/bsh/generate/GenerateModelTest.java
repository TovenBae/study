package org.bsh.generate;


import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class GenerateModelTest {
	Map<String, String> pv = new HashMap<String, String>();
	Map<String, String> pv2 = new HashMap<String, String>();

	@BeforeEach
	public void setup() {
		pv.put("var1", "value1");
		pv.put("var2", "value2");
		pv.put("var3", "value3");

		pv2.put("processName", "value1");
		pv2.put("processVersion", "value2");
		pv2.put("count", "value3");
	}
	
	@Test
	void test() {
		GenerateModel genModel = new GenerateModel();
		
		// pv hashMap은 bpm api에서 조회될 프로세스 변수값.
		boolean isSuccess = genModel.generate("Process01", pv);
		Assert.assertEquals(true, isSuccess);

		isSuccess = genModel.generate("Process02", pv2);
		Assert.assertEquals(true, isSuccess);

	}

}
