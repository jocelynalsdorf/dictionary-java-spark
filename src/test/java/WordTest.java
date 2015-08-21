import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;


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

  

}