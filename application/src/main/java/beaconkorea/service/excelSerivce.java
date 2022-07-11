package beaconkorea.service;

import beaconkorea.DTO.TestDto;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.util.List;

@Service
public class excelSerivce {

    public void excelSer(TestDto param) throws ParseException {
        String stringParam = param.getExcelStringData();
        JSONArray jsonArray= new JSONArray(stringParam);
        Gson gson = new Gson();
        List<TestDto> testDto = gson.fromJson(stringParam, new TypeToken<List<TestDto>>(){}.getType());
        RestAPI(testDto);
    }

    public void RestAPI(List<TestDto> testDto) throws ParseException {
        //Base64Encode Service 를 통한 Auth 생성
        String Username = "_WEB";
        String Password = "dlwlsgh1595A";
        String idandpw = Username + ":" + Password;
        Base64EncodeService base64EncodeService = new Base64EncodeService();
        String Auth = "Basic " + base64EncodeService.Encode(idandpw);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add("Authorization", Auth);
        httpHeaders.add("Content-Type", "application/json");

        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObjectItem = new JSONObject();


        for (int i=0; i<testDto.size(); i++) {
            String url = "https://my353278.sapbydesign.com/sap/byd/odata/cust/v1/zwebtest/ZWebTestRootCollection";
            jsonObject.put("ZID", testDto.get(i).getZID());
            HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
            ResponseEntity<String> res = new RestTemplate().postForEntity(url, entity, String.class);

            JSONObject obj = new JSONObject(res.getBody());
            JSONArray jsonArray = new JSONArray();
            jsonArray.put(obj);
            String ObjectID = obj.getJSONObject("d").getJSONObject("results").get("ObjectID").toString();
            System.out.println("Root : " + res.getBody());
            System.out.println("Root : " + res.getStatusCodeValue());
        }

    }
}
