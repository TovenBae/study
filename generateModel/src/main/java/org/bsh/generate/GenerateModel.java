package org.bsh.generate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GenerateModel {
	private final static String MODEL_PATH = "/Users/baesunghan/git/study/generateModel/src/main/java/org/bsh/generate/model/";
	
	// Model class를 생성한다.
	public boolean generate(String procName, Map<String, String> pv) {
		StringBuffer sb = new StringBuffer();
		sb.append("package org.bsh.generate.model; \n\n");
		sb.append("public class ").append(procName).append(" {\n\n");
		
		Set keyset = pv.keySet();
		Iterator iter = keyset.iterator();
		while(iter.hasNext()) {
			sb.append("\t").append("public String ").append((String)iter.next()).append(";\n");
		}
		sb.append("\n");
		sb.append("}\n");
		
		writeFile(procName, sb);
		return true;
	}

	// java 파일을 생성한다.
	public boolean writeFile(String procName, StringBuffer sb) {
		String filePath = MODEL_PATH + procName + ".java";
		File file = new File(filePath);
		FileWriter writer = null;
		
		try {
			writer = new FileWriter(file, false);
			writer.write(sb.toString());
			writer.flush();
			
			System.out.println("created model file : " + filePath);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			try { if (writer != null) writer.close(); } catch(Exception e) { e.printStackTrace(); }
		}
		return true;
	}
}
