package Class;

import java.io.*;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.out;

public class Handle implements Runnable{
    ServerSocket ss=null;
    Socket socket = null;
    @Override
    public void run() {
        try {
            ss = new ServerSocket(8888);
        }catch(IOException e){
            e.printStackTrace();
        }
        while (true) {
            try {
                socket = ss.accept();
                BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String[] lines = bf.readLine().split(" ");
                OutputStream out = socket.getOutputStream();
                String path="src//HTML//demo.html";
                System.out.println(lines[1].split(" ")[0].replace("/",""));
                if(lines[1].split(" ")[0].contains(".html")){
                    getdata(path,out);
                }else if(!(lines[1].split(" ")[0].contains(".html"))&&lines[1].split(" ")[0].contains("A")||lines[1].split(" ")[0].contains("B")){
                    String cname="Class."+lines[1].split(" ")[0].replace("/","");
                    System.out.println(cname);
                    Class clz = Class.forName(cname);
                    String mname = "GetPage"+lines[1].split(" ")[0].replace("/","");
                    System.out.println(mname);
                    Method getMethod = clz.getMethod(mname);
                    out.write((byte[]) getMethod.invoke(clz.newInstance()));
                }else{
                    path="src//HTML/404.html";
                    getdata(path,out);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                out.flush();
                out.close();
            }
        }
    }

    public static void getdata(String path,OutputStream out) throws IOException{
        String msg = "HTTP/1.1 OK\n";
        msg+="Content-Type:text/html\n\n";
        FileInputStream fileInputStream = new FileInputStream(path);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String data ="";
        while((data=bufferedReader.readLine())!=null){
            msg+=data;
        }
        out.write(msg.getBytes());
    }
}
