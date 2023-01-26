package biz.koona.gov_poll.helpers;

import biz.koona.gov_poll.entities.FileCabinet;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Configuration
public class Helpers {
    public String fileGenerateUri(FileCabinet fileCabinet) {
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/rest/file-cabinet/downloadFile/")
                .path(fileCabinet.getId())
                .toUriString();
    }
}
