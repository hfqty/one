package me.ning.servlet;



import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
@MultipartConfig
public class UploadServlet extends HttpServlet {

    private boolean isMultipart;
    private String basePath = new String("D:\\Java\\uploadFiles\\");
    private String filePath;
    private int maxFileSize = 50*1024;
    private int maxMemSize = 4*1024;
    private File file;


    @Override
    public void init() throws ServletException {
      filePath = getServletConfig().getInitParameter("file-uplaod");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       throw new ServletException("GET method used with " +getClass().getName() + "POST method required.");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        try{
            Part filePart = request.getPart("file");
            String fileName = filePart.getSubmittedFileName();
            System.out.println(fileName);
            File file = new File(basePath+fileName);
            if(!file.exists()){
                file.createNewFile();
            }
            InputStream inputStream  = filePart.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bytes = new byte[1024];
            int read;
            while((read = inputStream.read(bytes)) !=-1){
                fileOutputStream.write(bytes,0,read);
            }
            inputStream.close();
            fileOutputStream.close();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet upload</title>");
            out.println("</head>");
            out.println("<body>");
           out.println("<h1>Ok</h1>");
           out.println("<p>upload success!</p>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
