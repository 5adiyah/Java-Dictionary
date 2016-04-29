import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class DefinitionTest {

  @Test
  public void Definition_instantiatesCorrectly_true() {
    Definition myDefinition = new Definition("Something to Write with");
    assertEquals(true, myDefinition instanceof Definition);
  }

  @Test
  public void getDefinition_getsDefinitionInput(){
    Definition myDefinition = new Definition("Something to Write with");
    String expected = "Something to Write with";
    assertEquals(expected, myDefinition.getDefinition());
  }

  @Test
   public void all_returnsAllInstancesOfDefinition_true() {
    Definition firstDefinition = new Definition("Something to Write with");
    Definition secondDefinition = new Definition("Another writing utensil");
    assertTrue(Definition.all().contains(firstDefinition));
    assertTrue(Definition.all().contains(secondDefinition));
 }

 @Test
 public void getId_definitionsInstantiateWithAnId(){
   Definition testDefinition = new Definition("Something to Write with");
   assertEquals(Definition.all().size(), testDefinition.getId());
 }

 @Test
 public void find_returnsDefinitionsWithSameId(){
   Definition firstDefinition = new Definition("Pencil");
   Definition secondDefinition = new Definition("Pen");
   assertEquals(Definition.find(secondDefinition.getId()), secondDefinition);
 }


}
