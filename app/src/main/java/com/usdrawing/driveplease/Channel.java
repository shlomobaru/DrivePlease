package com.usdrawing.driveplease;

/* <channel><title>מאגר השאלות והתשובות הרשמי למבחן נהיגה עיוני ממוחשב</title>
<description>משרד התחבורה, מאגר השאלות והתשובות הרשמי למבחן נהיגה עיוני ממוחשב - תאוריה</description><link></link>
<lastBuildDate>09-11-2011 10:44:17</lastBuildDate><generator></generator><language>he-IL</language>*/


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "channel")
public class Channel {
    private String title;
    private String description;
    private String link;
    private String lastBuildDate;
    private String generator;
    private String language;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "item")
    private ArrayList<Item> items;

    public Channel() {
    }

    public String getTitle() {
        return title;
    }

    public Channel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Channel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getLink() {
        return link;
    }

    public Channel setLink(String link) {
        this.link = link;
        return this;
    }

    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public Channel setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
        return this;
    }

    public String getGenerator() {
        return generator;
    }

    public Channel setGenerator(String generator) {
        this.generator = generator;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public Channel setLanguage(String language) {
        this.language = language;
        return this;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public Channel setItems(ArrayList<Item> items) {
        this.items = items;
        return this;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                ", lastBuildDate='" + lastBuildDate + '\'' +
                ", generator='" + generator + '\'' +
                ", language='" + language + '\'' +
                ", items=" + items +
                '}';
    }
}