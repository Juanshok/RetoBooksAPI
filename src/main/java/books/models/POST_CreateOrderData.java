package books.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class POST_CreateOrderData {

    private int bookId;
    private String customerName;

    public static List<POST_CreateOrderData> setData (DataTable table){
        List<POST_CreateOrderData> data = new ArrayList<>();
        List<Map<String, String>> mapInfo = table.asMaps();
        for (Map<String, String> map: mapInfo){
            data.add(new ObjectMapper().convertValue(map, POST_CreateOrderData.class));
        }
        return data;
    }

}
