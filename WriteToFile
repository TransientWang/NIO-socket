package com.example.test;


import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * @author 王扶摇
 * @Title: writeCSV
 * @ProjectName demo
 * @date 2018/8/27 19:10
 */

public class writeCSV {
    public static void write(List<aa> res) throws Exception {
        String s = "ActivityId,ProvinceId,USERID,PROVIDE,AREA_ID,DATA_ID,LABEL4,CUSTORMER_ID,CUST_SEX,TEL,LABEL3,LAST_NAME,LABEL2,LABEL1\n";

        ByteBuffer byteBuffer = ByteBuffer.allocate(102400);
        Field[] fields = aa.class.getDeclaredFields();

        try (FileChannel fileChannel =
                     (FileChannel) Files.newByteChannel(Paths.get("E:\\wangfuyaotwst.txt"),
                             StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            StringBuilder stringBuilder = new StringBuilder();
            byteBuffer.put(s.getBytes("utf-8"));
            for (aa a : res) {
                for (int i = 0; i < fields.length; i++) {
                    stringBuilder.append(fields[i].get(a));
                    if (i != fields.length - 1)
                        stringBuilder.append(",");

                }

                System.out.println(stringBuilder);
                byteBuffer.put(stringBuilder.toString().getBytes("utf-8"));
                byteBuffer.put("\n".getBytes("utf-8"));
                stringBuilder.delete(0, stringBuilder.length()-1);

            }

            byteBuffer.rewind();


            fileChannel.write(byteBuffer);

            byteBuffer.clear();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("结束");
        }

    }

    public static void main(String[] args) {

//        try {
//            writeCSV.write(null);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
