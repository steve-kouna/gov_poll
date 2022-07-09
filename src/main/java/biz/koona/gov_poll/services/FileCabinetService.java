package biz.koona.gov_poll.services;

import biz.koona.gov_poll.entities.FileCabinet;
import biz.koona.gov_poll.exceptions.fileCabinet.FileStorageException;
import biz.koona.gov_poll.exceptions.fileCabinet.MyFileNotFoundException;
import biz.koona.gov_poll.repositories.FileCabinetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileCabinetService {
    @Autowired
    private FileCabinetRepository fileCabinetRepository;

    public FileCabinet storeFile(MultipartFile file, String ownerId, String ownerType) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

//            DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getBytes(), ownerId, ownerType);
            FileCabinet fileCabinet = new FileCabinet(fileName, file.getContentType(), file.getBytes());

            return fileCabinetRepository.save(fileCabinet);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public FileCabinet getFile(String fileId) {
        return fileCabinetRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }
}
