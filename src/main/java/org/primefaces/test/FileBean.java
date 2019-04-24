package org.primefaces.test;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class FileBean {

    public void handleFileUpload(FileUploadEvent event) {
        try {
            UploadedFile file = event.getFile();
            String fileName = file.getFileName();
            String destinationPath = System.getProperty("user.dir") + "/uploaded/" + fileName;

            System.out.println("Trying to upload file to: " + destinationPath);
            file.write(destinationPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
