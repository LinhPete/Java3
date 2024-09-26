package util.convert;

import java.io.*;

public class WordToHtmlConverter {
	public static void convertWordToHtml(String inputFilePath, String outputFilePath) throws IOException {
	    ProcessBuilder processBuilder = new ProcessBuilder("libreoffice", "--headless", "--convert-to", "html", inputFilePath, "--outdir", new File(outputFilePath).getParent());
	    Process process = processBuilder.start();
	    
	    try {
	        int exitCode = process.waitFor();
	        if (exitCode != 0) {
	            throw new IOException("Conversion failed with exit code " + exitCode);
	        }
	    } catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	        throw new IOException("Conversion interrupted", e);
	    }
	}
}
