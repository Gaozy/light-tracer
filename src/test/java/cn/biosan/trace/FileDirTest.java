package cn.biosan.trace;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SpringBootTest
public class FileDirTest {

    @Test
    public void test() throws ClassNotFoundException, IOException {

        // 输入文件路径，或者直接检测当前路径

        System.out.println(this.getClass().getPackageName());
        System.out.println(System.getProperty("user.dir"));

        getFileList(System.getProperty("user.dir"));
    }

    /*
     * 读取指定路径下的文件名和目录名
     */
    public void getFileList(String rootDir) throws ClassNotFoundException, IOException {
        File file = new File(rootDir.concat("/src/main/java/cn/biosan/trace"));
        recursiveFile(file);
    }

    private void recursiveFile(File file) throws ClassNotFoundException, IOException {
        File[] fileList = file.listFiles();
        for (int i = 0; i < fileList.length; i++) {
            if (fileList[i].isDirectory()) {
                String fileName = fileList[i].getName();
                System.out.println("目录：" + fileName);
                recursiveFile(fileList[i]);
            }

            if (fileList[i].isFile() && fileList[i].getName().endsWith("Class.java")) {
                String fileName = fileList[i].getName();
                System.out.println(fileList[i].getAbsolutePath());
                System.out.println(fileList[i].getCanonicalPath());
                System.out.println("文件：" + fileName);
                if(fileName.equals("TrsClass.java")){
                    Class<?> aClass = Class.forName("cn.biosan.trace."+fileName.split("\\.")[0]);
                    for (Field field: aClass.getDeclaredFields()) {
                        System.out.println(field.getName());
                    }
                    for (Method method: aClass.getDeclaredMethods()) {
                        System.out.println(method.getName());
                    }
                    System.out.println();
                }
            }
        }
    }

}

