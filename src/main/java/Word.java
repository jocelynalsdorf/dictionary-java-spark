import java.util.ArrayList;

public class Word{
  private static ArrayList<Word> instances = new ArrayList<Word>();

  private String mName;
  private int mId;
  private ArrayList<Definition> mDefinitions;

  public Word(String name){
    mName = name;
    instances.add(this);
    mId = instances.size();
    mDefinitions = new ArrayList<Definition>();
  }

  public String getName(){
    return mName;
  }

}//end class