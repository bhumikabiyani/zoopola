package Rough;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;



import Base.TestBase;

public class TextMeasure {
	 
	Font font;
	  FontRenderContext context;
@Test
	  public void StringMetrics() throws InterruptedException {
		  WebDriver d = new FirefoxDriver();
		  d.get("https://bingo.feature.vernons.com/");
		  GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		  Font[] allfonts = env.getAllFonts();
		  System.out.println();
		 
		  
	/*    font = g2.getFont();
	    context = g2.getFontRenderContext();
	  }

	  Rectangle2D getBounds(String message) {

	    return font.getStringBounds(message, context);
	  }

	  double getWidth(String message) {

	    Rectangle2D bounds = getBounds(message);
	    return bounds.getWidth();
	  }

	  double getHeight(String message) {

	    Rectangle2D bounds = getBounds(message);
	    return bounds.getHeight();
	    */
	  }

	}
	

	
	