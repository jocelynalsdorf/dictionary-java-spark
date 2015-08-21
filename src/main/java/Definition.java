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
  
}//end of class