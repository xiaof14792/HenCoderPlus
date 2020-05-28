package com.example.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.CharBuffer;

import okio.Buffer;
import okio.Okio;
import okio.Sink;
import okio.Source;

public class IoTest {
    public static void main(String[] args) {
//        io1();
//        io2();
//        io3();
        io4();
    }

    private static void io1() {
        File file = new File("./io/text.txt");
        try (FileInputStream fileInputStream = new FileInputStream("./io/text.txt");
             Reader reader = new InputStreamReader(fileInputStream);
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            System.out.println(bufferedReader.readLine());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void io2() {
        try (FileInputStream fileInputStream = new FileInputStream("./io/text.txt");
             FileOutputStream fileOutputStream = new FileOutputStream("./io/text2.txt")) {

            byte[] bytes = new byte[1024];
            int length = fileInputStream.read(bytes);
            while (length != -1) {
                fileOutputStream.write(bytes, 0, length);
                length = fileInputStream.read(bytes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void io3() {
        try (Source source = Okio.source(new File("./io/text.txt"))) {

            Buffer buffer = new Buffer();
            source.read(buffer, 1024);
            System.out.println(buffer.readUtf8Line());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void io4() {
        try (Source source = Okio.source(new File("./io/text.txt"));
             Sink sink = Okio.sink(new File("./io/text3.txt"))) {

            Buffer buffer = new Buffer();
            long length = source.read(buffer, 1024);
            while (length != -1) {
                sink.write(buffer, length);
                length = source.read(buffer, 1024);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
