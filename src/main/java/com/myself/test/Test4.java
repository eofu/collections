package com.myself.test;

import com.alibaba.fastjson.JSONObject;

public class Test4 {
    public static void main(String[] args) {
        String test = "{\n" +
                "   \"proficient_info_callback\": {\n" +
                "       \"businessCode\": \"XXXXXX\",\n" +
                "       \"businessName\": \"XXXXXX\",\n" +
                "       \"experts\":[\n" +
                "\t {\n" +
                "            profType: \"1\",\n" +
                "\t   profName:\"XXX\",\n" +
                "\t   profIdcard:\"XXX\",\n" +
                " \t   phone:\"XXX\",\n" +
                " \t   beRemoved:\"1\"\n" +
                "}\n" +
                "]\n" +
                "   }\n" +
                "}";

        JSONObject jsonObject = JSONObject.parseObject(test);
        System.out.println(jsonObject);
        Object proficient_info_callback = jsonObject.get("proficient");
        System.out.println(proficient_info_callback);

    }
}
