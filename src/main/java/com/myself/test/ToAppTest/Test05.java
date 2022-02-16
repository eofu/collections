package com.myself.test.ToAppTest;

import com.myself.test.ToAppTest.TestUtil.AppConstance;
import com.myself.test.ToAppTest.TestUtil.DateUtil;
import com.myself.test.ToAppTest.TestUtil.EncryptUtils;
import com.myself.test.ToAppTest.TestUtil.HttpClientUtil;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Test05 {
    public static void main(String[] args) throws InvalidAlgorithmParameterException, NoSuchPaddingException, UnsupportedEncodingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        Test05 test01 = new Test05();
        
        String param = "{\n" +
                "    \"businessKey\": \"1\",\n" +
                "    \"businessSystemCode\": \"LUOHE_ZFCG\",\n" +
                "    \"businessSystemName\": \"政府采购\",\n" +
                "    \"areaCode\": \"1\",\n" +
                
                "    \"bidId\": \"1\",\n" +
                "    \"agencyId\": \"1\",\n" +
                "    \"agencyName\": \"2022-02-15\",\n" +
            
                "    \"disposalmethod\": \"1\",\n" +
                "    \"reason\": \"2022-02-14\",\n" +
                "    \"submitDate\": \"2022-02-14\",\n" +
                "    \"approvalResult\": \"2022-02-14\",\n" +
                "    \"approvalDate\": \"2022-02-14\",\n" +
                "    \"content\": \"1\"\n" +
                "}";
        String number = "TOC0027";
        
        
        test01.doPost(param,number);
        
    }
    
    public void doPost(String param,String number) throws InvalidAlgorithmParameterException, NoSuchPaddingException, UnsupportedEncodingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        
        System.out.println(param);
        String aesTimeStamp = DateUtil.formatData(new Date(), "yyyyMMddHHmm");
        String sign = EncryptUtils.md5Encrypt(AppConstance.APP_REQUEST_MD5_KEY, param + aesTimeStamp);
        String timeStamp = DateUtil.formatData(new Date(), "yyyyMMddHHmmss");
        System.out.println(timeStamp);
        System.out.println(sign);
        String paramData = EncryptUtils.encryptGeneralAES(sign + param + aesTimeStamp, AppConstance.APP_REQUEST_ASE_KEY, AppConstance.IV_STRING);
        System.out.println(paramData);
        Map<String, String> map = new HashMap<>();
        map.put("apiCode", number);
        map.put("timeStamp", timeStamp);
        map.put("sign", sign);
        map.put("paramData", paramData);
        map.put("businessType", "APP_TO_TRADDING");
        String result = HttpClientUtil.doPost("http://192.168.1.63:9527/app", map);
        String s = EncryptUtils.decryptGeneralAES(result, AppConstance.APP_REQUEST_ASE_KEY, AppConstance.IV_STRING);
        System.out.println("result: " + s);
    }
}
