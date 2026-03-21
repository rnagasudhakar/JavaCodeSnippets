package org.example.LLDDesigns.FileSystem.models;

import org.example.LLDDesigns.FileSystem.enums.NodeType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Folder extends FileEntityNode {
    private HashMap<String,FileEntityNode> children;
    public Folder(String id, String name, Folder parent, NodeType nodeType) {
        super(id, name, parent, nodeType);
        this.children = new HashMap<>();
    }

    public HashMap<String, FileEntityNode> getChildren() {
        return children;
    }

    public void addChildren(FileEntityNode fileEntityNode){
        children.computeIfAbsent(fileEntityNode.getId(),(K)->fileEntityNode);
        System.out.println("File/Folder has been added");
    }

    public void removeChildren(String nodeId){
        if(children.containsKey(nodeId)){
            children.remove(nodeId);
            System.out.println("File/Folder has been removed");
            return;
        }
        throw new IllegalArgumentException("file/folder is not present");
    }

    public List<String> ls(){
        return children.values().stream().map(FileEntityNode::getName).collect(Collectors.toList());
    }



}
