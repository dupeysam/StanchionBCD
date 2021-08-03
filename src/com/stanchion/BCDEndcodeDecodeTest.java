package com.stanchion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class BCDEndcodeDecodeTest {
    private BCDEndcodeDecode bcdEndcodeDecode = new BCDEndcodeDecode();

    @Test
    void encode() {
        byte[] result = bcdEndcodeDecode.encode("54321");
        byte[] expectedResult = new byte[]{80, 52, 18};
        assertEquals( Arrays.toString(expectedResult), Arrays.toString(result) );
    }

    @Test
    void decode() {
        String result = bcdEndcodeDecode.decode(bcdEndcodeDecode.encode("54321"));
        String expectedResult = "054321";
        assertEquals(expectedResult, result);
    }
}