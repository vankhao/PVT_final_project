package by.itiacademy.dowloader;

import by.itiacademy.exception.FileException;
import by.itiacademy.exception.UrlException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class URLReader {

    private static URLReader instance;

    private URLReader() {
    }

    public static URLReader getInstance() {
        if (instance == null) {
            synchronized (URLReader.class) {
                if (instance == null) {
                    instance = new URLReader();
                }
            }
        }
        return instance;
    }

    public HttpURLConnection getUrlConnection(final String url) throws UrlException {
        URL urlConnection = null;
        try {
            urlConnection = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection.openConnection();
            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                return httpURLConnection;
            }
        } catch (IOException e) {
            throw new UrlException("URL BLA BLA");
        }
        throw new UrlException("URL BLA BLA");
    }






}
