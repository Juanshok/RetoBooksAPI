package books.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class DELETE_OrderData {

    private String orderId;

    public static List<DELETE_OrderData> setData (DataTable table){
        List<DELETE_OrderData> data = new ArrayList<>();
        List<Map<String, String>> mapInfo = table.asMaps();
        for (Map<String, String> map: mapInfo){
            data.add(new ObjectMapper().convertValue(map, DELETE_OrderData.class));
        }
        return data;
    }

}
