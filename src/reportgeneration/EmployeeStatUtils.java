package reportgeneration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

public class EmployeeStatUtils {

    public static List<EmployeeStat> deserialize(String fileContent) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        List<Document> empStatList = mapper.readValue(fileContent,
                TypeFactory.defaultInstance().constructCollectionType(List.class, Document.class));
        
        List<EmployeeStat> list = new ArrayList<>();
        for (Document item : empStatList) {
            EmployeeStat employeeStat = new EmployeeStat();
            employeeStat.setName(item.get("name",String.class));
            employeeStat.setExperienceMultiplier(item.get("experienceMultiplier",Double.class));
            employeeStat.setSalesPeriod(item.get("salesPeriod",Integer.class));
            employeeStat.setTotalSales(item.get("totalSales",Integer.class));
            list.add(employeeStat);
        }
        return list;
    }

}
