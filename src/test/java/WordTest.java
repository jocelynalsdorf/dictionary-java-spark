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

}