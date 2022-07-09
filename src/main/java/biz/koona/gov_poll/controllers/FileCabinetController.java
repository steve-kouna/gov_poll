package biz.koona.gov_poll.controllers;

import biz.koona.gov_poll.dtos.UploadFileResponse;
import biz.koona.gov_poll.entities.FileCabinet;
import biz.koona.gov_poll.services.FileCabinetService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/file-cabinet")
@Api(description = "File cabinet")
public class FileCabinetController {
    private static final Logger logger = LoggerFactory.getLogger(FileCabinetController.class);

    @Autowired
    private FileCabinetService fileCabinetService;

    @PostMapping("/uploadFile")
    @Transactional
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("ownerId") String ownerId, @RequestParam("ownerType") String ownerType) {
        FileCabinet dbFile = fileCabinetService.storeFile(file, ownerId, ownerType);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/rest/file-cabinet/downloadFile/")
                .path(dbFile.getId())
                .toUriString();

        return new UploadFileResponse(fileDownloadUri,
                file.getContentType(), file.getSize(), dbFile.getId());
    }

    @PostMapping("/uploadMultipleFiles")
    @Transactional
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files, @RequestParam("ownerId") String ownerId, @RequestParam("ownerType") String ownerType) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file, ownerId, ownerType))
                .collect(Collectors.toList());
    }

    @GetMapping("/downloadFile/{fileId}")
    @Transactional
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
        FileCabinet dbFile = fileCabinetService.getFile(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
                .body(new ByteArrayResource(dbFile.getData()));
    }
}
