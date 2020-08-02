package co.kesti.smartcity.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {

    public static File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException
    {
        File convFile = new File( multipart.getOriginalFilename());
        multipart.transferTo(convFile);
        return convFile;
    }

    public static BufferedImage getImage(String path, String fileName) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(path + "/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }
    public static String getCurrentPath() {
        return System.getProperty("user.dir");
    }


    public static boolean deleteFile(String pathName) {
        File file = new File(pathName);
        boolean result = file.delete();
//        CommonUtil.print("# DELETE : "+pathName+" -> "+result);
        return result;
    }

    public static String writeMultipartFile(MultipartFile file, String path, String fileName){

        String result = "";

        makeDirectory(path);

        FileOutputStream fos = null;
        try{

            byte fileData[] = file.getBytes();

            fos = new FileOutputStream(path + "/" + fileName);

            fos.write(fileData);


            result = path + "/" + fileName;


        }catch(Exception e){

            e.printStackTrace();

        }finally{

            if(fos != null){

                try{
                    fos.close();
                }catch(Exception e){}

            }
        }

        return result;
    }



    @Deprecated
    public static String writeFile(File file, String path, String fileName){

        String result = "";

        makeDirectory(path);

        FileOutputStream fos = null;
        try{

            byte fileData[] = FileUtils.readFileToByteArray(file);

            fos = new FileOutputStream(path + "/" + fileName);

            fos.write(fileData);


            result = path + "/" + fileName;



        }catch(Exception e){

            e.printStackTrace();

        }finally{

            if(fos != null){

                try{
                    fos.close();
                }catch(Exception e){}

            }
        }

        return result;
    }


    public static boolean makeDirectory(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return file.mkdir();
        } else {
            return true;
        }
    }

    public static void listFiles() {
        File file = new File("./");

        File[] list = file.listFiles();
        for(File des : list){

        }
    }


    public static String loadFile(String fileName) {
        String result = "";
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(fileName);
            result = IOUtils.toString(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(inputStream);
        }

        return result;
    }


    public static boolean isExist(String pathName) {
        File file = new File(pathName);
        if (file.isFile()) {
            return true;
        } else {
            return false;
        }
    }
}
