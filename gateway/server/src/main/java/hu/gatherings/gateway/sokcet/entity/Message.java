package hu.gatherings.gateway.sokcet.entity;

import lombok.Data;

@Data
public class Message {
    private String senderName;
    private String groupId;
    private String text;
}