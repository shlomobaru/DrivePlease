package com.usdrawing.driveplease;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@JacksonXmlRootElement(localName = "QUESTIONS")

public class ExchangeQuestion {
    private Date last_update;
    @JacksonXmlElementWrapper(useWrapping = false)
  //  @JacksonXmlProperty(localName = "QUESTION")
    private ArrayList<Item> itemsAL;
    private List<Channel> channelList;

    public ExchangeQuestion() {
    }

    public Date getLast_update() {
        return last_update;
    }

    public ExchangeQuestion setLast_update(Date last_update) {
        this.last_update = last_update;
        return this;
    }

    public ArrayList<Item> getItemsAL() {
        return itemsAL;
    }

    public ExchangeQuestion setItemsAL(ArrayList<Item> items) {
        this.itemsAL = items;
        return this;
    }

    public ExchangeQuestion setChannelList(ArrayList<Channel> channels) {
        this.channelList = channels;
        return this;
    }

    @Override
    public String toString() {
        return "ExchangeQuestions{" +
                "last_update= " + last_update +
                "Channel= " + channelList +
                ", questions= " + itemsAL +
                '}';
    }
}
