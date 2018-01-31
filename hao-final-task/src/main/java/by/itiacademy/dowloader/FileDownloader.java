package by.itiacademy.dowloader;

import by.itiacademy.dowloader.common.Dowloader;
import by.itiacademy.exception.DownloadException;
import by.itiacademy.exception.FileException;
import by.itiacademy.exception.UrlException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FileDownloader implements Dowloader{

    private static FileDownloader instance;

    private FileDownloader() {
    }

    public static FileDownloader getInstance() {
        if (instance == null) {
            synchronized (FileDownloader.class) {
                if (instance == null) {
                    instance = new FileDownloader();
                }
            }
        }
        return instance;
    }


    @Override
    public File download(final String urlLink, final String fileName) throws FileException, UrlException, DownloadException {
        HttpURLConnection urlConnection = URLReader.getInstance().getUrlConnection(urlLink);
        File file = getFile(fileName);

        try (InputStream inputStream = urlConnection.getInputStream();
             FileOutputStream fileOutputStream = new FileOutputStream(file)) {

            int byteRead = -1;
            byte[] buffer = new byte[2048];
            while ((byteRead = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, byteRead);
            }

        } catch (IOException e) {
            throw new DownloadException("Error while downloading: " + e);
        }
        return file;
    }


    private File getFile(final String name) throws FileException {
        try {
            File file = new File(name);
            if (!file.exists()) {
                file.createNewFile();
            }
            return file;
        } catch (IOException e) {
            throw new FileException("COULD NOT CREATE FILE: " + e);
        }
    }


}
