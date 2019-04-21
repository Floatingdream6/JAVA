package Class;

public class B {

    public byte[] GetPageB(){
        String msg ="HTTP/1.1 200 OK\n";
        msg+="Content-Type:text/html\n\n";
        msg+="<html>\n" +
                "<head>\n" +
                "   <meta content='text/html; charset=UTF-8' http-equiv='Content-Type'> " +
                "<title>B</title>\n" +
                "</head>\n" +
                "<body> \n" +
                "<h1>B<h1>" +
                "</body></html>";
        return msg.getBytes();
    }
}
