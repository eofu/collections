package com.myself.test;

import org.apache.xpath.operations.String;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Base64;

public class Test11 {
    public static void main(String[] args) throws Exception {
        Base64.Encoder encoder = Base64.getEncoder();
        File file = new File("D:\\swskf.log");
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int) file.length()];
        inputFile.read(buffer);
        inputFile.close();
        byte[] encode = encoder.encode(buffer);
        System.out.println(Arrays.toString(encode));
    }
}
