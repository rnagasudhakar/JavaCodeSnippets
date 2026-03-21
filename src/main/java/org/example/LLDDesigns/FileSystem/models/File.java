package org.example.LLDDesigns.FileSystem.models;

import org.example.LLDDesigns.FileSystem.enums.NodeType;

import java.time.LocalDateTime;

public class File extends FileEntityNode {
    private String content;
    public File(String id, String name, FileEntityNode parent, NodeType nodeType,String content) {
        super(id, name, parent, nodeType);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.setUpdatedAt(LocalDateTime.now());
        this.content = content;
    }
}
