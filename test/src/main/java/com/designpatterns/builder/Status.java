package com.designpatterns.builder;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class Status {
    private String status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
    private Date currentTime;
    private String application;

    private Status(Builder builder){
        this.application = builder.application;
        this.status = builder.status;
        this.currentTime = builder.currentTime;
    }

    public static class Builder{
        private String status;
        private Date currentTime;
        private String application;

        public Builder(final String status, final String application, final Date currentTime){
            this.status = status;
            this.application = application;
            this.currentTime = currentTime;
        }

        public Status.Builder status(final String status){
            this.status = status;
            return this;
        }

        public Status.Builder application(final String application){
            this.application = application;
            return this;
        }

        public Status.Builder currentTime(final Date currentTime){
            this.currentTime = currentTime;
            Date d = new Date();
            return this;
        }

        public Status build(){
           Status status = new Status(this);
            return status;
        }
    }

}
