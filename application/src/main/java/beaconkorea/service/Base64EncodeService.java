package beaconkorea.service;

import java.util.Base64;

public class Base64EncodeService {
    public String Encode(String idandpw) {
        String encodeString = Base64.getEncoder().encodeToString(idandpw.getBytes());
        return encodeString;

    }
}
