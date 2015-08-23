import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;


public class WordTest {

  @Rule
   public ClearRule clearRule = new ClearRule();

  @Test
  public void word_instantiatesCorrectly_true() {
    Word myWord = new Word("booger");
    assertEquals(true, myWord instanceof Word);
  }

  @Test
  public void word_returnsName_true() {
    Word testWord = new Word("booger");
    assertEquals("booger", testWord.getName());
  }

  @Test
  public void getId_returnsWordId() {
    Word testWord = new Word("booger");
    assertTrue(Word.all().size() == testWord.getId());
  }

  @Test
  public void getDefinitions_initiallyReturnsEmptyArrayList() {
    Word testWord = new Word("booger");
    assertTrue(testWord.getDefinitions() instanceof ArrayList);
  }

  @Test
  public void all_returnsAllInstancesOfWord_true() {
    Word testWord1 = new Word("booger");
    Word testWord2 = new Word("goober");
    assertTrue(Word.all().contains(testWord1));
    assertTrue(Word.all().contains(testWord2));
  }

  @Test
  public void addDefinition_addsDefToWord() {
    Word testWord = new Word("booger");
    Definition testDefinition = new Definition("green");
    testWord.addDefinition(testDefinition);
    assertTrue(testWord.getDefinitions().contains(testDefinition));
  }

  @Test
  public void clear_removesAllWordInstancesFromMemory() {
    Word testWord = new Word("booger");
    Word.clear();
    assertEquals(Word.all().size(), 0);
  }

  @Test
  public void adddef_addsDefinitionToWord() {
    Word testWord = new Word("fart");
    Definition testDefinition = new Definition("smelly");
    testWord.addDefinition(testDefinition);
    assertTrue(testWord.getDefinitions().contains(testDefinition));
  }

  @Test
  public void find_returnsNullWhenNoWordFound_null() {
    assertTrue(Word.find(999) == null);
  }

}