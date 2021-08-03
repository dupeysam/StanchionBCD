package com.stanchion;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        BCDEndcodeDecode bcdEndcodeDecode = new BCDEndcodeDecode();
        System.out.println(Arrays.toString(bcdEndcodeDecode.encode("54321")));
        System.out.println(bcdEndcodeDecode.decode(bcdEndcodeDecode.encode("54321")));
    }
}
