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

    public FileCabinet storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            FileCabinet fileCabinet = new FileCabinet(fileName, file.getContentType(), file.getBytes());

            return fileCabinetRepository.save(fileCabinet);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public FileCabinet getFile(String fileId) {
        System.out.println(fileId);
        return fileCabinetRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }
}
