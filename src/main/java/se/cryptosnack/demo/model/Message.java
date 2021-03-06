package se.cryptosnack.demo.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="Message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long id;
    private String message;
    private LocalDateTime messageSent;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Message() {
    }

//    public Message(String message) {
//        this.message = message;
//        this.messageSent = LocalDateTime.now();
//    }

    public Message(String message, User user) {
        this.message = message;
        this.user = user;
        this.messageSent = LocalDateTime.now();
    }

    public Message(String message, LocalDateTime messageSent) {
        this.message = message;
        this.messageSent = messageSent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getMessageSent() {
        return messageSent;
    }

    public void setMessageSent(LocalDateTime messageSent) {
        this.messageSent = messageSent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return  user.getUsername() + ": " + messageSent + ": " + message;
    }
}
