package de.dracoon.model;

/**
 * @author priyatham.bolli
 */
public class Permissions {

    private Boolean manage;
    private Boolean read;
    private Boolean create;
    private Boolean change;
    private Boolean delete;
    private Boolean manageDownloadShare;
    private Boolean manageUploadShare;
    private Boolean readRecycleBin;
    private Boolean restoreRecycleBin;
    private Boolean deleteRecycleBin;

    public Boolean getManage() {
        return manage;
    }

    public void setManage(Boolean manage) {
        this.manage = manage;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    public Boolean getCreate() {
        return create;
    }

    public void setCreate(Boolean create) {
        this.create = create;
    }

    public Boolean getChange() {
        return change;
    }

    public void setChange(Boolean change) {
        this.change = change;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

    public Boolean getManageDownloadShare() {
        return manageDownloadShare;
    }

    public void setManageDownloadShare(Boolean manageDownloadShare) {
        this.manageDownloadShare = manageDownloadShare;
    }

    public Boolean getManageUploadShare() {
        return manageUploadShare;
    }

    public void setManageUploadShare(Boolean manageUploadShare) {
        this.manageUploadShare = manageUploadShare;
    }

    public Boolean getReadRecycleBin() {
        return readRecycleBin;
    }

    public void setReadRecycleBin(Boolean readRecycleBin) {
        this.readRecycleBin = readRecycleBin;
    }

    public Boolean getRestoreRecycleBin() {
        return restoreRecycleBin;
    }

    public void setRestoreRecycleBin(Boolean restoreRecycleBin) {
        this.restoreRecycleBin = restoreRecycleBin;
    }

    public Boolean getDeleteRecycleBin() {
        return deleteRecycleBin;
    }

    public void setDeleteRecycleBin(Boolean deleteRecycleBin) {
        this.deleteRecycleBin = deleteRecycleBin;
    }
}
