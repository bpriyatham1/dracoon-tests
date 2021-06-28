package de.dracoon.model;

/**
 * @author priyatham.bolli
 */
public final class CompletedUploadResponse {

    public CompletedUploadResponse(){
    }

    public Integer id;
    public String type;
    public String name;
    public String timestampCreation;
    public String timestampModification;
    public Integer parentId;
    public String parentPath;
    public String createdAt;
    public CreatedBy createdBy;
    public String updatedAt;
    public UpdatedBy updatedBy;
    public String hash;
    public String fileType;
    public String mediaType;
    public Integer size;
    public Integer classification;
    public Permissions permissions;
    public Boolean isEncrypted;
    public EncryptionInfo encryptionInfo;
    public Integer cntDeletedVersions;
    public Integer cntComments;
    public Boolean isFavorite;
    public Long branchVersion;
    public Integer authParentId;

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

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getClassification() {
        return classification;
    }

    public void setClassification(Integer classification) {
        this.classification = classification;
    }

    public Permissions getPermissions() {
        return permissions;
    }

    public void setPermissions(Permissions permissions) {
        this.permissions = permissions;
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

    public Integer getCntDeletedVersions() {
        return cntDeletedVersions;
    }

    public void setCntDeletedVersions(Integer cntDeletedVersions) {
        this.cntDeletedVersions = cntDeletedVersions;
    }

    public Integer getCntComments() {
        return cntComments;
    }

    public void setCntComments(Integer cntComments) {
        this.cntComments = cntComments;
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

    public Integer getAuthParentId() {
        return authParentId;
    }

    public void setAuthParentId(Integer authParentId) {
        this.authParentId = authParentId;
    }
}
