package books.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class POST_TokenData {

    private String clientName;
    private String clientEmail;

    public static List<POST_TokenData> setData (DataTable table){
        List<POST_TokenData> data = new ArrayList<>();
        List<Map<String, String>> mapInfo = table.asMaps();
        for (Map<String, String> map: mapInfo){
            data.add(new ObjectMapper().convertValue(map, POST_TokenData.class));
        }
        return data;
    }

}
