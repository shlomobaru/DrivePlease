package com.usdrawing.driveplease;
/*
<item>
<title>1759. האם אוטובוס הנוסע בנתיב שיועד לתחבורה ציבורית רשאי לעקוף רכב עוקף?</title><link></link><guid></guid>
<description><![CDATA[<div dir="rtl" style="text-align: right"><ul class="list-arrow arrow-blue"><li><span>רשאי, רק כאשר הרכב העוקף הוא רכב משא.</span></li><li><span>רשאי, רק בדרך שאינה עירונית.</span></li><li><span id="correctAnswer1759">רשאי.</span></li><li><span>רשאי, אם באוטובוס אין נוסעים.</span></li></ul><div style="padding-top: 4px;"><span><button type="button" onclick="var correctAnswer=document.getElementById('correctAnswer1759');correctAnswer.className='text-highlight'">הצג תשובה נכונה</button></span><br/><span style="float: left;">| «D» | </span></div></div>]]></description>
<author></author><category>חוקי התנועה</category><pubDate>09-11-2011 10:44:17</pubDate></item>
 */

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;

public class Item {
    private String title;
    private String link;
    private String guid;

    @JacksonXmlCData
    private String description;
    private String author;
    private String category;
    private String pubDate;

    public Item() {
    }


    public String getTitle() {
        return title;
    }

    public Item setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getLink() {
        return link;
    }

    public Item setLink(String link) {
        this.link = link;
        return this;
    }

    public String getGuid() {
        return guid;
    }

    public Item setGuid(String guid) {
        this.guid = guid;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Item setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Item setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Item setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getPubDate() {
        return pubDate;
    }

    public Item setPubDate(String pubDate) {
        this.pubDate = pubDate;
        return this;
    }



    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", guid='" + guid + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", pubDate='" + pubDate + '\'' +
                '}';
    }
}