package org.example.LLDDesigns.FileSystem;

import org.example.LLDDesigns.FileSystem.enums.NodeType;
import org.example.LLDDesigns.FileSystem.models.File;
import org.example.LLDDesigns.FileSystem.models.FileEntityNode;
import org.example.LLDDesigns.FileSystem.models.Folder;

import java.util.HashMap;

public class FileSystem {
    private Folder root;
    private HashMap<String,FileEntityNode> nodeList;
    private Folder currentDirectory;
    private  volatile static  FileSystem fileSystemInstance;

    private FileSystem(){
        root = new Folder("root","root",null, NodeType.FOLDER);
        this.currentDirectory = root;
        this.nodeList = new HashMap<>();
    }

    public FileSystem getFileSystemInstance(){
        if(fileSystemInstance == null){
            synchronized (fileSystemInstance){
                if(fileSystemInstance==null){
                    fileSystemInstance = new FileSystem();
                }
            }
        }
        return fileSystemInstance;
    }

    public void addFolder(String id, String name, Folder parent, NodeType nodeType ){
        if(parent.getChildren().containsKey(id)){
            throw new IllegalArgumentException("Same folder is present there");
        }
        if(nodeList.containsKey(id)){
            throw new IllegalArgumentException("Same folder is present there");
        }
        if(!nodeList.containsKey(parent.getId())){
            throw new IllegalArgumentException("parent is not valid");
        }
        Folder folder = new Folder(id,name,parent,nodeType);
        nodeList.put(id,folder);
        parent.addChildren(folder);
        nodeList.compute(parent.getId(),(K,V)->parent);
        System.out.println("Folder has been created");
    }

    public void addFile(String id, String name, Folder parent, NodeType nodeType, String content ){
        if(parent.getChildren().containsKey(id)){
            throw new IllegalArgumentException("Same file is present there");
        }
        if(nodeList.containsKey(id)){
            throw new IllegalArgumentException("Same file is present there");
        }
        if(!nodeList.containsKey(parent.getId())){
            throw new IllegalArgumentException("parent is not valid");
        }
        File file = new File(id,name,parent,nodeType,content);
        parent.addChildren(file);
        nodeList.compute(parent.getId(),(K,V)->parent);
        System.out.println("File has been created");
    }

    public void removeFile(String fileId){
        FileEntityNode node = nodeList.get(fileId);
        if(node == null){
            throw new IllegalArgumentException("file is not present at all");
        }
        Folder parent = node.getParent();
        parent.removeChildren(node.getId());
        nodeList.remove(node.getId());
        nodeList.compute(parent.getId(),(K,V)->parent);
    }

    public String pwd(){
        return currentDirectory.getPath(currentDirectory);
    }

    public void changeDirectory(String path){
        // here everything stored in id
        // because I thought names can be many
        // but now user will give only path na
        // how can i justify this
    }

}
