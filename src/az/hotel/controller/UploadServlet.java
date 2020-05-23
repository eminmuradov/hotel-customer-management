package az.hotel.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UploadServlet", value = "/upload")
public class UploadServlet extends HttpServlet {
    private static final String UPLOAD_DIRECTORY = "upload";
    private static final Integer THRESHOLD_SIZE = 1024 * 1024 * 3;
    private static final Integer MAX_FILE_SIZE = 1024 * 1024 * 10;
    private static final Integer MAX_REQUEST_SIZE = 1024 * 1024 * 50;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fileName = "";
        String filePath = "";

        if (!ServletFileUpload.isMultipartContent(request)) {
            response.getWriter().print("Unsupported content type");
            return;
        }

        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
        fileItemFactory.setSizeThreshold(THRESHOLD_SIZE);
        fileItemFactory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
        fileUpload.setSizeMax(MAX_FILE_SIZE);
        fileUpload.setSizeMax(MAX_REQUEST_SIZE);

        String uploadPath ="C://" + File.separator + UPLOAD_DIRECTORY;

        File uploadFilePath=new File(uploadPath);

        if (!uploadFilePath.exists()){
            uploadFilePath.mkdirs();
        }

        try {
            List<FileItem> fileItems= fileUpload.parseRequest(request);
            for (FileItem fileItem:fileItems){

                if (fileItem.getFieldName().equals("fileName")){
                    System.out.println(fileItem.getString());
                }

                if (!fileItem.isFormField()){
                    fileName=new File(fileItem.getName()).getName();
                    filePath=uploadPath+File.separator+fileName;

                    File uploadFile= new File(filePath);
                    fileItem.write(uploadFile);
                }
            }
            request.setAttribute("message","File upload is successfully");
            request.setAttribute("filePath",filePath);
        } catch (Exception e) {
            request.setAttribute("message","Unexpected error");
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);

    }
}