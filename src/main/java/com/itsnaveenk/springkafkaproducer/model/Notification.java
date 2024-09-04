package com.itsnaveenk.springkafkaproducer.model;

import jakarta.validation.constraints.NotNull;


public class Notification {

    @NotNull
    int user_id;

    @NotNull
    String message;

    @NotNull
    int recipient_id;


    @NotNull
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(@NotNull int user_id) {
        this.user_id = user_id;
    }

    public @NotNull String getMessage() {
        return message;
    }

    public void setMessage(@NotNull String message) {
        this.message = message;
    }

    @NotNull
    public int getRecipient_id() {
        return recipient_id;
    }

    public void setRecipient_id(@NotNull int recipient_id) {
        this.recipient_id = recipient_id;
    }

}
