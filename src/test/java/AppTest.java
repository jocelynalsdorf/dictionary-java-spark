import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest{
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver(){
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
   goTo("http://localhost:4567/");
   assertThat(pageSource()).contains("Yay! Another Dictionary!!");
 	}

 	@Test
	public void wordIsCreatedTest() {
	  goTo("http://localhost:4567/");
	  click("a", withText("Add a new Word"));
	  fill("#name").with("booger");
	  submit(".btn");
	  assertThat(pageSource()).contains("Success!");
	}

 	@Test
	public void wordIsShownTest() {
	  goTo("http://localhost:4567/");
	  click("a", withText("Add a new Word"));
	  fill("#name").with("booger");
	  submit(".btn");
	  click("a", withText("View All Words"));
	  assertThat(pageSource()).contains("booger");
	}

	@Test
	public void wordDefinitionsFormIsDisplayed() {
	  goTo("http://localhost:4567/words/new");
	  fill("#name").with("booger");
	  submit(".btn");
	  click("a", withText("View All Words"));
	  click("a", withText("booger"));
	  click("a", withText("Add a new definition"));
	  assertThat(pageSource()).contains("Add a new definition for booger");
	}

	@Test
	public void definitionsAreDisplayed() {
	  goTo("http://localhost:4567/words/new");
	  fill("#name").with("mice");
	  submit(".btn");
	  click("a", withText("View All Words"));
	  click("a", withText("mice"));
	  click("a", withText("Add a new definition"));
	  fill("#description").with("green");
	  submit(".btn-default");
	  assertThat(pageSource()).contains("green");
	}

	@Test
	public void definitionisDisplayedonSingleDefpage() {
	  goTo("http://localhost:4567/words/new");
	  fill("#name").with("snot");
	  submit(".btn");
	  click("a", withText("View All Words"));
	  click("a", withText("snot"));
	  click("a", withText("Add a new definition"));
	  fill("#description").with("slime");
	  submit(".btn-default");
	  click("a", withText("slime"));
	  assertThat(pageSource()).contains("slime");
	}

}	