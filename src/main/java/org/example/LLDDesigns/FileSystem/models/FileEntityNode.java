package org.example.LLDDesigns.FileSystem.models;

import org.example.LLDDesigns.FileSystem.enums.NodeType;

import java.time.LocalDateTime;

public  abstract class FileEntityNode {
    private String id;
    private String name;
    private Folder parent;
    private NodeType nodeType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public FileEntityNode(String id, String name, Folder parent, NodeType nodeType) {
        this.id = id;
        this.name = name;
        this.parent = parent;
        this.nodeType = nodeType;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();;
    }

    public String getPath( FileEntityNode node){
        if(node.getParent() == null){
            return "/";
        }
        return node.getName() + getPath(node.getParent());
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void reName(String name) {
        this.name = name;
        this.updatedAt = LocalDateTime.now();;
    }

    public Folder getParent() {
        return parent;
    }

    public void setParent(Folder parent) {
        this.parent = parent;
    }

    public NodeType getNodeType() {
        return nodeType;
    }

    public void setNodeType(NodeType nodeType) {
        this.nodeType = nodeType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
