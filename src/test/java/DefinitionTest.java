import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;


public class DefinitionTest {

  @Rule
   public ClearRule clearRule = new ClearRule();

  @Test
  public void definition_instantiatesCorrectly_true() {
    Definition myDefinition = new Definition("booger");
    assertEquals(true, myDefinition instanceof Definition);
  }

}