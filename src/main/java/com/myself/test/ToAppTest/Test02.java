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

public class Test02 {
    public static void main(String[] args) throws InvalidAlgorithmParameterException, NoSuchPaddingException, UnsupportedEncodingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        Test02 test01 = new Test02();
        
        String param = "{\n" +
                "    \"businessKey\": \"1\",\n" +
                "    \"businessSystemCode\": \"LUOHE_ZFCG\",\n" +
                "    \"businessSystemName\": \"政府采购\",\n" +
                "    \"areaCode\": \"1\",\n" +
                
                "    \"buyProjectId\": \"1\",\n" +
                "    \"projectCode\": \"1\",\n" +
                "    \"projectCategoryCode\": \"1\",\n" +
                "    \"projectCategoryName\": \"1\",\n" +
                "    \"projectName\": \"1\",\n" +
                "    \"tendereeCode\": \"1\",\n" +
                "    \"tendereeName\": \"1\",\n" +
                
                "    \"buyprojectTypeCode\": \"1\",\n" +
                "    \"buyprojectTypeName\": \"1\",\n" +
                "    \"contacts\": \"1\",\n" +
                "    \"contactsPhone\": \"1\",\n" +
                "    \"investmentProjectUniCode\": \"1\",\n" +
                "    \"delegateType\": \"1\",\n" +
                "    \"purOrgForm\": \"1\",\n" +
                "    \"ppp\": \"1\",\n" +
                "    \"regulPart\": \"1\",\n" +
                "    \"regulPartCode\": \"1\",\n" +
                "    \"content\": \"1\",\n" +
                "    \"purchasingAgentCode\": \"1\",\n" +
                "    \"purchasingAgent\": \"1\",\n" +
                
                "    \"agencyCode\": \"1\",\n" +
                "    \"agencyName\": \"1\"\n" +
                "}";
        String number = "TOC0601";
        
        
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
        map.put("businessType", "APP_TO_CGV2");
        String result = HttpClientUtil.doPost("http://192.168.1.63:9527/app", map);
        String s = EncryptUtils.decryptGeneralAES(result, AppConstance.APP_REQUEST_ASE_KEY, AppConstance.IV_STRING);
        System.out.println("result: " + s);
    }
}
