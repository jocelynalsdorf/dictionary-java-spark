import java.util.ArrayList;


public class Definition {
  private static ArrayList<Definition> instances = new ArrayList<Definition>();

  private String mDescription;
  private int mId;

  public Definition(String description) {
    mDescription = description;
    instances.add(this);
    mId = instances.size();
  }

  public String getDescription(){
    return mDescription;
  }

  public static ArrayList<Definition> all(){
    return instances;
  }

}//end of class