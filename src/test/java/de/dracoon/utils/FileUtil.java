package de.dracoon.utils;

import javax.imageio.ImageIO;

import java.awt.image.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Arrays;

/**
 * @author priyatham.bolli
 */
public class FileUtil {

    private FileUtil() {
    }

    public static BufferedImage getImage(byte[] image) {
        InputStream in = new ByteArrayInputStream(image);
        BufferedImage scaledImage;
        try {
            scaledImage = ImageIO.read(in);
            return scaledImage;
        } catch (IOException ioException) {
            throw new RuntimeException("could not get file from " + Arrays.toString(image));
        }
    }

    public static byte[] extractBytes(String imageName) {
        byte[] fileContent = new byte[0];
        try {
            File file = new File(imageName);
            fileContent = Files.readAllBytes(file.toPath());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return fileContent;
    }

    public static String getContentLength(String file) {
        int fileLength = extractBytes(file).length;
        long decrement = fileLength - 1;
        return "bytes 0-" + decrement + "/" + fileLength;
    }

}
