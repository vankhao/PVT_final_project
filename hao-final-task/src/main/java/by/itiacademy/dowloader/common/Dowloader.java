package by.itiacademy.dowloader.common;

import by.itiacademy.exception.DownloadException;
import by.itiacademy.exception.FileException;
import by.itiacademy.exception.UrlException;

import java.io.File;

public interface Dowloader {
    File download(final String urlLink, final String fileName) throws FileException, UrlException, DownloadException;
}
