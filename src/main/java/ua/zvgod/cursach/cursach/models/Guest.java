package ua.zvgod.cursach.cursach.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "guest")
public class Guest {

    public Guest() {
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setLastVisited(LocalDateTime lastVisited) {
        this.lastVisited = lastVisited;
    }

    public String getSessionId() {
        return sessionId;
    }

    public LocalDateTime getLastVisited() {
        return lastVisited;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "session_id")
    private String sessionId;

    @Column(name="last_visited")
    private LocalDateTime lastVisited;

    @Column(name="number_of_visits")
    private Integer numberOfVisits;

    public void setQaForms(List<QAForm> qaForms) {
        this.qaForms = qaForms;
    }

    public List<QAForm> getQaForms() {
        return qaForms;
    }

    @OneToMany(mappedBy = "guest")
//    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<QAForm> qaForms;

    public void setJobForms(List<JobForm> jobForms) {
        this.jobForms = jobForms;
    }

    public List<JobForm> getJobForms() {
        return jobForms;
    }

    @OneToMany(mappedBy = "guest")
//    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<JobForm> jobForms;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setNumberOfVisits(Integer numberOfVisits) {
        this.numberOfVisits = numberOfVisits;
    }

    public Integer getNumberOfVisits() {
        return numberOfVisits;
    }
}
