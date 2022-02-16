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

public class Test01 {
    public static void main(String[] args) throws InvalidAlgorithmParameterException, NoSuchPaddingException, UnsupportedEncodingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        Test01 test01 = new Test01();
    
        String param = "{\n" +
                "    \"businessKey\": \"1\",\n" +
                "    \"businessSystemCode\": \"LUOHE_ZFCG\",\n" +
                "    \"businessSystemName\": \"政府采购\",\n" +
                "    \"areaCode\": \"1\",\n" +
        
                "    \"buyProjectId\": \"1\",\n" +
                "    \"bidCode\": \"1\",\n" +
                "    \"bidName\": \"1\",\n" +
                "    \"securityFee\": \"1\",\n" +
                "    \"prePriceTotal\": \"1\",\n" +
                "    \"advice\": \"1\",\n" +
                "    \"supplyQualification\": \"1\",\n" +
                
                "    \"purPerson\": \"1\",\n" +
                "    \"purCode\": \"1\",\n" +
                "    \"contact\": \"1\",\n" +
                "    \"contactPhone\": \"1\",\n" +
                "    \"content\": \"1\",\n" +
                "    \"purType\": \"1\",\n" +
                "    \"entrustType\": \"1\",\n" +
                "    \"purOrg\": \"1\",\n" +
                "    \"purMethod\": \"1\",\n" +
                
                "    \"tZfcgBidDetailList\":[{\"bidId\":\"1\",\"count\":1,\"specifications\":1,\"unit\":\"1\"},{\"bidId\":\"2\",\"count\":2,\"unit\":\"2\"}],\n" +
                
                "    \"agencyName\": \"1\"\n" +
                "}";
        String number = "TOC0602";
        
        
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
