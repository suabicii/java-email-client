package com.potato;

import com.potato.controller.services.FetchFolderService;
import com.potato.model.EmailAccount;
import com.potato.model.EmailTreeItem;
import javafx.scene.control.TreeItem;

public class EmailManager {

    // Folder handling
    private EmailTreeItem<String> foldersRoot = new EmailTreeItem<String>("");

    public EmailTreeItem<String> getFoldersRoot() {
        return foldersRoot;
    }

    public void addEmailAccount(EmailAccount emailAccount) {
        EmailTreeItem<String> treeItem = new EmailTreeItem<String>(emailAccount.getAddress());
        FetchFolderService fetchFolderService = new FetchFolderService(emailAccount.getStore(), treeItem);
        fetchFolderService.start();
        foldersRoot.getChildren().add(treeItem);
    }
}
