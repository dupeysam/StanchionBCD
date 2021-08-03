package com.stanchion;

public class BCDEndcodeDecode implements BCD {

    public byte[] encode(String decimalNumber) {
        decimalNumber = validateString(decimalNumber);
        int size = decimalNumber.length() / 2;

        byte[] responseValue = new byte[size];

        for (int i = 0; i < size; i++)
        {
            int low = Integer.parseInt(decimalNumber.substring(2 * i, 2 * i + 1));
            int high = Integer.parseInt(decimalNumber.substring(2 * i + 1, 2 * i + 2));
            responseValue[i] = (byte)((high << 4) | low);
        }

        return responseValue;
    }

    public String decode(byte[] bcdData) {
        if (null == bcdData || bcdData.length == 0) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bcdData.length; i++) {

                int low = (bcdData[i] & 0x0f);
                sb.append(low);

                int high = ((bcdData[i] & 0xf0) >> 4);

                if (high != 0xf) {
                    sb.append(high);
                }
            }

            return sb.toString();

        }
    }

    private String validateString(String decimalNumber){
        if(decimalNumber!= null && !decimalNumber.isEmpty()){
            if(decimalNumber.length() % 2 != 0){
                decimalNumber = "0" + decimalNumber;
            }
            try {
                double d = Double.parseDouble(decimalNumber);
            } catch (NumberFormatException nfe) {
                System.out.print("Invalid number format");

            }
        }else{
            System.out.print("Invalid number format");
            System.exit(0);
        }

        return decimalNumber;
    }
}
