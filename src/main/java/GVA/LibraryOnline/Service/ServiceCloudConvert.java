package GVA.LibraryOnline.Service;

import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Created by Vsevolod on 08.01.2016.
 */

@Service
public class ServiceCloudConvert {
    private String urlString = "https://api.cloudconvert.com/convert";
    //private String urlString = "http://127.0.0.1:2000";
    private String apikey = "BEXsi5_MBed5kqxr_X0CBtkbBuBxhMiuCo-FonJDb38obT0P0zsH8d8iE5GkEjiZDmNIbytNYtDuyDhd4Wltmg";
    String boundary = "---" + System.currentTimeMillis();
    String lineFeed = "\r\n";

    private String postRequest(InputStream inputStream) throws IOException {
        String input = "upload";
        String filename = "djvu.djvu";
        String download = "false";
        String inputformat = "djvu";
        String outputformat = "pdf";
        byte[] data = new byte[inputStream.available()];
        inputStream.read(data);
        inputStream.close();
        String quality = "25";

        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type",
                "multipart/form-data; boundary=" + boundary);
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.connect();
        OutputStream outputStream = connection.getOutputStream();

        sendParameter(outputStream, "apikey", apikey);
        sendParameter(outputStream, "input", input);
        sendParameter(outputStream, "filename", filename);
        sendParameter(outputStream, "download", download);
        sendParameter(outputStream, "inputformat", inputformat);
        sendParameter(outputStream, "outputformat", outputformat);
        sendParameter(outputStream, "converteroptions[quality]", quality);
        sendFile(outputStream, filename, data);
        endPostRequest(outputStream);
        outputStream.flush();
        outputStream.close();

        connection.getHeaderFields();

        InputStream is = connection.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(is);
        byte[] responseBytes = new byte[bufferedInputStream.available()];
        bufferedInputStream.read(responseBytes);

        System.out.println(new String(responseBytes));

        return data.toString();
    }

    private void sendParameter(OutputStream outputStream, String name, String value) throws IOException {
        StringBuffer buffer = new StringBuffer();
        buffer.append("--" + boundary).append(lineFeed);
        buffer.append("Content-Disposition: form-data; name=\"" + name + "\"").append(lineFeed);
        buffer.append(lineFeed);
        buffer.append(value).append(lineFeed);
        outputStream.write(buffer.toString().getBytes());
    }

    private void sendFile(OutputStream outputStream, String filename, byte[] data) throws IOException {
        StringBuffer buffer = new StringBuffer();
        buffer.append("--" + boundary).append(lineFeed);
        buffer.append("Content-Disposition: form-data; name=\"file\"; filename=\"" +
                filename + "\"").append(lineFeed);
        buffer.append("Content-Type: application/octet-stream").append(lineFeed);
        buffer.append(lineFeed);
        outputStream.write(buffer.toString().getBytes());
        outputStream.write(data);
        outputStream.write(lineFeed.getBytes());
    }

    private void endPostRequest(OutputStream outputStream) throws IOException {
        StringBuffer buffer = new StringBuffer();
        buffer.append("--" + boundary + "--").append(lineFeed);
        buffer.append(lineFeed);
        outputStream.write(buffer.toString().getBytes());
    }

    public byte[] getPdfFromDjvu(InputStream inputStream) throws IOException {
        return postRequest(inputStream).getBytes();
    }


}
