package Practice.Enum;

public enum Friends {
    SUDHAKAR(1,"abcd"){
        @Override  public int getValue(){
            return this.value + 20;
        }
    },
    BHANU(1,"abcd"),
    RAJESH(1,"abcd"),
    HARSHA(1,"abcd"),
    REVATHI(1,"abcd"),
    PRASANNA(1,"abcd"),
    ROHITH(1,"abcd");

    public int value;
    private String description;

    Friends(int value, String description){
        this.value = value;
        this.description = description;
    }

    public int getValue(){
        return this.value;
    }

    public static String getDescriptionFromValue(int value){
        for(Friends friend :  Friends.values()){
            if(value == friend.value) {
                return friend.description;
            }
        }
        return "Not found";
    }

}
