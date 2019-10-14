
package client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class Client {

  
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        String host = "10.3.39.53";//Atılacak olan kişinin ip adresi

        socket = new Socket(host, 4444); //ip ve port adresi   port olarak 300 de kullanılabilir

        File file = new File("C:\\Users\\hardrez\\Desktop\\server\\test1.rar"); //Gönderilecek Dosya
       
        long length = file.length(); //Dosyanın uzunluğu
        byte[] bytes = new byte[16 *1024]; // Kaç bytelik paketlerde atacak olduğumuzu belirliyoruz 16KB
        InputStream in = new FileInputStream(file); // Dosyayı input nesnesi ile bağlıyoruz
        OutputStream out = socket.getOutputStream(); //output nesnesini Sockete bağlıyoruz

        int count;
        while ((count = in.read(bytes)) > 0) {  //Okuma işlemi bitinceye kadar çalış
            out.write(bytes, 0, count);
        }
        //
        out.close();
        in.close();
        socket.close();
    }
    
}
