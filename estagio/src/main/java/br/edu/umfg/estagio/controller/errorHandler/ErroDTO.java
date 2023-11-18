package br.edu.umfg.estagio.controller.errorHandler;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.Date;
import java.util.List;

public class ErroDTO {
    private Long timestamp;
    private int status;
    private String error;
    private List<String> details;



    public ErroDTO( int status, String error, List<String> details) {
        this.timestamp = new Date().getTime();
        this.status = status;
        this.error = error;
        this.details = details;
    }

    public ErroDTO( int status, String error) {
        this( status, error, null);
    }


    public Long getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public List<String> getDetails() {
        return details;
    }
}
