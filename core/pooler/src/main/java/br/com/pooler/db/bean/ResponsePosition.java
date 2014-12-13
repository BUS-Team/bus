package br.com.pooler.db.bean;

import org.joda.time.DateTime;

import java.util.Date;
import java.util.logging.LogRecord;

/**
 * Created by breno on 13/12/14.
 */
public class ResponsePosition {
    private int busLine;
    private DateTime dateTime;
    private String content;

    public int getBusLine() {
        return busLine;
    }

    public void setBusLine(int busLine) {
        this.busLine = busLine;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
