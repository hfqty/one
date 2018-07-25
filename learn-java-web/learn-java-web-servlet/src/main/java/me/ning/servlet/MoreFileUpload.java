package me.ning.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
@MultipartConfig
public class MoreFileUpload extends HttpServlet {

    private String basePath = "D:\\Java\\uploadFiles\\";

    @Override
    public void init() throws ServletException {
        super.init();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        List<Part> parts = request.getParts().stream().collect(Collectors.toList());
        for(Part part : parts){
            String fileName = part.getSubmittedFileName();
            File file  = new File(basePath+fileName);
            if(!file.exists()){
                file.createNewFile();
            }
            InputStream inputStream = part.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bytes = new byte[1024];
            int read;
            while(( read = inputStream.read(bytes)) !=-1){
                fileOutputStream.write(bytes,0,read);
            }
            System.out.println(fileName);
        }

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet upload</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Ok</h1>");
        out.println("<p>upload some success!</p>");
        out.println("</body>");
        out.println("</html>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new ServletException("GET method used with " + getClass().getName() + "POST method required.");
    }
}
