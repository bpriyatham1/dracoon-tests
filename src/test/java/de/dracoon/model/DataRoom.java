package de.dracoon.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author priyatham.bolli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataRoom {

    private Integer id;
    private String type;
    private String name;
    private String timestampCreation;
    private String timestampModification;
    private Integer parentId;
    private String parentPath;
    private String createdAt;
    private CreatedBy createdBy;
    private String updatedAt;
    private UpdatedBy updatedBy;
    private String expireAt;
    private String hash;
    private String fileType;
    private String mediaType;
    private Long size;
    private Long classification;
    private String notes;
    private Permissions permissions;
    private Boolean inheritPermissions;
    private Boolean isEncrypted;
    private EncryptionInfo encryptionInfo;
    private Long cntDeletedVersions;
    private Long cntComments;
    private Long cntDownloadShares;
    private Long cntUploadShares;
    private Long recycleBinRetentionPeriod;
    private Boolean hasActivitiesLog;
    private Long quota;
    private Boolean isFavorite;
    private Long branchVersion;
    private String mediaToken;
    private Boolean isBrowsable;
    private Long cntRooms;
    private Long cntFolders;
    private Long cntFiles;
    private Long authParentId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimestampCreation() {
        return timestampCreation;
    }

    public void setTimestampCreation(String timestampCreation) {
        this.timestampCreation = timestampCreation;
    }

    public String getTimestampModification() {
        return timestampModification;
    }

    public void setTimestampModification(String timestampModification) {
        this.timestampModification = timestampModification;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getParentPath() {
        return parentPath;
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public CreatedBy getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(CreatedBy createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public UpdatedBy getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(UpdatedBy updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(String expireAt) {
        this.expireAt = expireAt;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getClassification() {
        return classification;
    }

    public void setClassification(Long classification) {
        this.classification = classification;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Permissions getPermissions() {
        return permissions;
    }

    public void setPermissions(Permissions permissions) {
        this.permissions = permissions;
    }

    public Boolean getInheritPermissions() {
        return inheritPermissions;
    }

    public void setInheritPermissions(Boolean inheritPermissions) {
        this.inheritPermissions = inheritPermissions;
    }

    public Boolean getEncrypted() {
        return isEncrypted;
    }

    public void setEncrypted(Boolean encrypted) {
        isEncrypted = encrypted;
    }

    public EncryptionInfo getEncryptionInfo() {
        return encryptionInfo;
    }

    public void setEncryptionInfo(EncryptionInfo encryptionInfo) {
        this.encryptionInfo = encryptionInfo;
    }

    public Long getCntDeletedVersions() {
        return cntDeletedVersions;
    }

    public void setCntDeletedVersions(Long cntDeletedVersions) {
        this.cntDeletedVersions = cntDeletedVersions;
    }

    public Long getCntComments() {
        return cntComments;
    }

    public void setCntComments(Long cntComments) {
        this.cntComments = cntComments;
    }

    public Long getCntDownloadShares() {
        return cntDownloadShares;
    }

    public void setCntDownloadShares(Long cntDownloadShares) {
        this.cntDownloadShares = cntDownloadShares;
    }

    public Long getCntUploadShares() {
        return cntUploadShares;
    }

    public void setCntUploadShares(Long cntUploadShares) {
        this.cntUploadShares = cntUploadShares;
    }

    public Long getRecycleBinRetentionPeriod() {
        return recycleBinRetentionPeriod;
    }

    public void setRecycleBinRetentionPeriod(Long recycleBinRetentionPeriod) {
        this.recycleBinRetentionPeriod = recycleBinRetentionPeriod;
    }

    public Boolean getHasActivitiesLog() {
        return hasActivitiesLog;
    }

    public void setHasActivitiesLog(Boolean hasActivitiesLog) {
        this.hasActivitiesLog = hasActivitiesLog;
    }

    public Long getQuota() {
        return quota;
    }

    public void setQuota(Long quota) {
        this.quota = quota;
    }

    public Boolean getFavorite() {
        return isFavorite;
    }

    public void setFavorite(Boolean favorite) {
        isFavorite = favorite;
    }

    public Long getBranchVersion() {
        return branchVersion;
    }

    public void setBranchVersion(Long branchVersion) {
        this.branchVersion = branchVersion;
    }

    public String getMediaToken() {
        return mediaToken;
    }

    public void setMediaToken(String mediaToken) {
        this.mediaToken = mediaToken;
    }

    public Boolean getBrowsable() {
        return isBrowsable;
    }

    public void setBrowsable(Boolean browsable) {
        isBrowsable = browsable;
    }

    public Long getCntRooms() {
        return cntRooms;
    }

    public void setCntRooms(Long cntRooms) {
        this.cntRooms = cntRooms;
    }

    public Long getCntFolders() {
        return cntFolders;
    }

    public void setCntFolders(Long cntFolders) {
        this.cntFolders = cntFolders;
    }

    public Long getCntFiles() {
        return cntFiles;
    }

    public void setCntFiles(Long cntFiles) {
        this.cntFiles = cntFiles;
    }

    public Long getAuthParentId() {
        return authParentId;
    }

    public void setAuthParentId(Long authParentId) {
        this.authParentId = authParentId;
    }

}
