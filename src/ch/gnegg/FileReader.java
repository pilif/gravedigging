package ch.gnegg;

import java.awt.image.ImagingOpException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class FileReader {
    private StringAvailable notify;
    // for now doing this synchronously to spare us the hassle
    // with threading

    public FileReader(StringAvailable n){
        notify = n;
    }

    public void read(String file){
        File f = new File(file);
        Charset charset = Charset.forName("iso-8859-1");
       	try{
            FileInputStream fis = new FileInputStream(f);
            FileChannel fc = fis.getChannel();
            MappedByteBuffer byteBuffer = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
            int size = byteBuffer.capacity();
            String r;
            if (size > 0){
               byteBuffer.clear();
               byte[] bytes = new byte[size];
               byteBuffer.get(bytes, 0, bytes.length);
               r = new String(bytes, charset);
            }else{
               r = "";
            }
            fc.close();
            notify.stringRetrieved(r);
        }catch(IOException e){
            String msg = "Failed to read file: "+e.getMessage();
            notify.stringRetrieved(msg);
        }
    }
}
