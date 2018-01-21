package javademo.io;

import org.junit.Test;

import java.io.*;
import java.util.List;

/**
 * io测试类
 * Created by leochu on 2018/1/20.
 */
public class IOTest {

    // 分隔符
    private static String separator = File.separator;

    // 字符串数组添加分隔符
    private String joinSeparator(List<String> strings, String separator) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            stringBuilder.append(separator).append(string);
        }
        return stringBuilder.toString();
    }

    /**
     * 获取io绝对路径，相对路径
     */
    @Test
    public void getPath() {
        System.out.println("'' 相对路径为：" + new File("").getAbsolutePath());
        System.out.println("'.' 路径为：" + new File(".").getAbsolutePath());
        System.out.println("'/' 路径为：" + new File("/").getAbsolutePath());
        System.out.println("'./' 绝对路径为：" + new File("./").getAbsolutePath());
        System.out.println("'../' 路径为：" + new File("../").getAbsolutePath());
    }

    /**
     * 带缓冲的字符流读写文件
     */
    @Test
    public void charBufferedReaderWriter() {

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        // 绝对路径 D:\repository\learn-java\javademo\src\javademo\io\charBufferedReader.txt
        // 绝对路径 "./"表示当前项目的路径
        File readFile = new File("./src/javademo/io/charBufferedReader.txt");
        // 相对路径 src\\javademo\\io\\charBufferedWriter.txt
        File writeFile = new File("src/javademo/io/charBufferedWriter.txt");
        try {
            if (readFile.exists() && writeFile.exists()) {
                bufferedReader = new BufferedReader(new FileReader(readFile));
                // bufferedWriter = new BufferedWriter(new FileWriter(".\\charBufferedWriter.txt"));
                bufferedWriter = new BufferedWriter(new FileWriter(writeFile));
            }
            String readLine;
            // read.txt ==> bufferedReader ==> bufferedWriter ==> writer.txt
            while ((readLine = bufferedReader.readLine()) != null) {
                bufferedWriter.write(readLine + "\\G");
                bufferedWriter.newLine(); // 换行
            }
            // 刷新缓存
            bufferedWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭io流
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 带缓冲的字节流文件读写
     */
    @Test
    public void byteBufferedStream() {

        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            // 绝对路径
            bufferedInputStream = new BufferedInputStream(new FileInputStream(".\\src\\javademo\\io\\byteBufferedInputStream.txt"));
            // 相对路径
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("src\\javademo\\io\\byteBufferedOutputStream.txt"));

            byte[] buffer = new byte[1024];
            int read;
            while ((read = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, read);
                bufferedOutputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 转换流，带缓冲 输入字节流==>输入字符流==>输出字符流==>输出字节流
     */
    @Test
    public void streamToReaderAndWriter() {

        InputStreamReader inputStreamReader;
        OutputStreamWriter outputStreamWriter;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            inputStreamReader = new InputStreamReader(new FileInputStream("./src/javademo/io/inputStreamReader.txt"));
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream("./src/javademo/io/outputStreamWriter.txt"));
            // 缓冲reader,writer
            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            String readLine;

            while ((readLine = bufferedReader.readLine()) != null) {
                bufferedWriter.write(readLine + "\\G");
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 随机访问，任意位置读写
     */
    @Test
    public void randAccessFileReadAndWrite() {
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile("./src/javademo/io/randAccessFile.txt", "rw");
            // 读取文件
            randomAccessFile.seek(0);
            long filePointer = randomAccessFile.getFilePointer();
            byte[] bytes = new byte[1024];
            int len = bytes.length;
            String readLine = null;

            if ((randomAccessFile.read(bytes, 0, len) != -1)) {
                readLine = new String(bytes);
            }
            System.out.println("文件指针在 " + filePointer + " 位置，读取" + len + "字节\n" + readLine);
            randomAccessFile.seek(0);
            char firstLetter = randomAccessFile.readChar(); // 读取两个字节拼成一个字符
            System.out.println("第一个字符： " + firstLetter);
            // 写入文件
            randomAccessFile.seek(randomAccessFile.length());
            randomAccessFile.write("\n新增数据：".getBytes());
            randomAccessFile.writeChar(65);
            randomAccessFile.writeInt(67);
            randomAccessFile.writeBoolean(false);
            randomAccessFile.writeByte(66);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
