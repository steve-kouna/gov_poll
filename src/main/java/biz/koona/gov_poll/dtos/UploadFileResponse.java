package biz.koona.gov_poll.dtos;

public class UploadFileResponse {
    private String id;
    private String fileDownloadUri;
    private String fileType;
    private long size;

    public UploadFileResponse() {
    }

    public UploadFileResponse(String fileDownloadUri, String fileType, long size, String id) {
        this.fileDownloadUri = fileDownloadUri;
        this.fileType = fileType;
        this.size = size;
        this.id = id;
    }

    public String getFileDownloadUri() {
        return fileDownloadUri;
    }

    public void setFileDownloadUri(String fileDownloadUri) {
        this.fileDownloadUri = fileDownloadUri;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
