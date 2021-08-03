package com.stanchion;

public interface BCD {
    byte[] encode(String decimalNumber);
    String decode(byte[] bcdData);

}
