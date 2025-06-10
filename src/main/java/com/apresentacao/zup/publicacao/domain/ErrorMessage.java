package com.apresentacao.zup.publicacao.domain;

public class ErrorMessage {

    private Long timestamp;

    private Integer status;

    private String message;

    private String path;

    public ErrorMessage() {
    }

    public ErrorMessage(Long timestamp, Integer status, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.path = path;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long timestamp;

        private Integer status;

        private String message;

        private String path;

        public Builder setTimestamp(Long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder setStatus(Integer status) {
            this.status = status;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setPath(String path) {
            this.path = path;
            return this;
        }

        public ErrorMessage build() {
            return new ErrorMessage(timestamp, status, message, path);
        }
    }
}
