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

  @Test
  public void definition_instantiatesNameWithDescription_true(){
    Definition myDefinition = new Definition("slimey clump of goodness");
    assertEquals("slimey clump of goodness", myDefinition.getDescription());
  }

  @Test
  public void definition_returnsAllInstancesOfDefinitioin_true(){
    Definition myDefinitionOne = new Definition("slimey clump of goodness");
    Definition myDefinitionTwo = new Definition("green clump of goodness");
    assertTrue(Definition.all().contains(myDefinitionOne));
    assertTrue(Definition.all().contains(myDefinitionTwo));
  }

}