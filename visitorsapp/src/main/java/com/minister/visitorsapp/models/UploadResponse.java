package com.minister.visitorsapp.models;

public class UploadResponse {
    private int status;
    private String fileURL;

    public UploadResponse(int status, String fileURL) {
        this.status = status;
        this.fileURL = fileURL;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getFileURL() {
        return fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
    }
}
