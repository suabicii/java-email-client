package com.potato.controller.services;

import com.potato.model.EmailTreeItem;
import jakarta.mail.Folder;
import jakarta.mail.MessagingException;
import jakarta.mail.Store;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class FetchFolderService extends Service<Void> {

    private Store store;
    private EmailTreeItem<String> foldersRoot;

    public FetchFolderService(Store store, EmailTreeItem<String> foldersRoot) {
        this.store = store;
        this.foldersRoot = foldersRoot;
    }

    @Override
    protected Task<Void> createTask() {
        return new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                fetchFolders();
                return null;
            }
        };
    }

    private void fetchFolders() throws MessagingException {
        Folder[] folders = store.getDefaultFolder().list();
        handleFolders(folders, foldersRoot);
    }

    private void handleFolders(Folder[] folders, EmailTreeItem<String> foldersRoot) {
        for(Folder folder: folders) {
            EmailTreeItem<String> emailTreeItem = new EmailTreeItem<>(folder.getName());
            foldersRoot.getChildren().add(emailTreeItem);
        }
    }
}
