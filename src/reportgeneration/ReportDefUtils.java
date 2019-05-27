package reportgeneration;

import org.bson.Document;

public class ReportDefUtils {

    public static ReportDefinition deserialize(String fileContent) {

     Document doc = Document.parse(fileContent);
     
     ReportDefinition reportDefinition = new ReportDefinition();
     reportDefinition.setPeriodLimit(doc.get("periodLimit",Integer.class));
     reportDefinition.setTopPerformersThreshold(doc.get("topPerformersThreshold",Integer.class));
     reportDefinition.setUseExprienceMultiplier(doc.get("useExprienceMultiplier",Boolean.class));
     return  reportDefinition;
    }
    
   

}
