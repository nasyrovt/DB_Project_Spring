package JavaClasses;

public abstract class Client {
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCodeSecret() {
        return codeSecret;
    }
    public void setCodeSecret(int codeSecret) {
        this.codeSecret = codeSecret;
    }
    public String getNumCB() {
        return numCB;
    }
    public void setNumCB(String numCB) {
        this.numCB = numCB;
    }
    private int codeSecret;
    private String numCB;
    Client(int id,int codeSecret,String numCB){
        this.id=id;
        this.codeSecret=codeSecret;
        this.numCB=numCB;
    }
    
}
