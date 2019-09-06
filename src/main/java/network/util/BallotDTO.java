/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network.util;

import com.google.api.client.util.Key;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Hudson
 */
public class BallotDTO {

    //private String state;
    //private String city;
    @Key("title")
    private String title;
    @Key("dateOpen")
    private String dateOpen;
    @Key("dateClosed")
    private String dateClosed;
    @Key("candidates")
    private List<CandidateDTO> candidates;

    public BallotDTO() {
        this.candidates = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateOpen() {
        return dateOpen;
    }

    public void setDateOpen(String dateOpen) {
        this.dateOpen = dateOpen;
    }

    public String getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(String dateClosed) {
        this.dateClosed = dateClosed;
    }

    public List<CandidateDTO> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<CandidateDTO> candidates) {
        this.candidates = candidates;
    }

}
