package ua.org.crazy.microjson.domain;

import javax.persistence.*;

@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "count_id")
    private Long count_id;
    @Column(name = "hash")
    private String hash;
    @Column(name = "description")
    private String description;
    @Column(name = "format")
    private String format;
    @Column(name = "url")
    private String url;
    @Column(name = "title")
    private String title;

    @Column(name = "document_of")
    private String documentOf;

    @Column(name = "date_published")
    private String datePublished;

    @Column(name = "document_type")
    private String documentType;

    @Column (name = "date_modified")
    private String dateModified;

    @Column (name = "json_id")
    private String id;

    public Document() {
    }

    public Document(String hash, String description, String format, String url, String title, String documentOf, String datePublished, String documentType, String dateModified, String id) {
        this.hash = hash;
        this.description = description;
        this.format = format;
        this.url = url;
        this.title = title;
        this.documentOf = documentOf;
        this.datePublished = datePublished;
        this.documentType = documentType;
        this.dateModified = dateModified;
        this.id = id;
    }

    public String getHashData(){
        return hash != null ? getHash() : "";
    }

    public String getDescriptionData(){
        return description != null ? getDescription() : "";
    }

    public String getFormatData(){
        return format != null ? getFormat() : "";
    }

    public String getUrlData(){
        return url != null ? getUrl() : "";
    }

    public String getTitleData(){
        return title != null ? getTitle() : "";
    }

    public String getDocumentOfData(){
        return documentOf != null ? getDocumentOf() : "";
    }

    public String getDatePublishedData(){
        return datePublished != null ? getDatePublished() : "";
    }

    public String getDocumentTypeData(){
        return documentType != null ? getDocumentType() : "";
    }

    public String getDateModifiedData(){
        return dateModified != null ? getDateModified() : "";
    }

    public String getIdData(){
        return id != null ? getId() : "";
    }

    public Long getCount_id() {
        return count_id;
    }

    public void setCount_id(Long count_id) {
        this.count_id = count_id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDocumentOf() {
        return documentOf;
    }

    public void setDocumentOf(String documentOf) {
        this.documentOf = documentOf;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Document{" +
                "count_id=" + count_id +
                ", hash='" + hash + '\'' +
                ", description='" + description + '\'' +
                ", format='" + format + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", documentOf='" + documentOf + '\'' +
                ", datePublished='" + datePublished + '\'' +
                ", documentType='" + documentType + '\'' +
                ", dateModified='" + dateModified + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
