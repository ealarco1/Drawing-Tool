package test;

import static org.junit.Assert.*;

import org.junit.Test;

import utils.Canvas;

/**
 * Test Class containing the unit tests for the methods of the program.
 * @author ealarcon
 */
public class CanvasTest {

	/**
	 * Unit test for the case of drawing an empty canvas
	 */
	@Test
	public void drawsEmptyCanvas() {
		Canvas c = new Canvas(20, 4);
		String result = c.draw();
		assertEquals("----------------------\n"
				+ "|                    |\n"
				+ "|                    |\n"
				+ "|                    |\n"
				+ "|                    |\n"
				+ "----------------------\n",result);
	}
	
	/**
	 * Unit test for the case of drawing a horizontal line
	 */
	@Test
	public void drawsHorizontalLine() {
		Canvas c = new Canvas(20,4);
		c.drawLine(1, 2, 6, 2);
		String result = c.draw();
		assertEquals("----------------------\n"
				+ "|                    |\n"
				+ "|xxxxxx              |\n"
				+ "|                    |\n"
				+ "|                    |\n"
				+ "----------------------\n", result);
	}
	
	/**
	 * Unit test for the case of drawing a vertical line
	 */
	@Test
	public void drawsVerticalLine() {
		Canvas c = new Canvas(20,4);
		c.drawLine(1, 2, 6, 2);
		c.drawLine(6, 3, 6, 4);
		String result = c.draw();
		assertEquals("----------------------\n"
				+ "|                    |\n"
				+ "|xxxxxx              |\n"
				+ "|     x              |\n"
				+ "|     x              |\n"
				+ "----------------------\n",result);
	}
	
	/**
	 * Unit test for the case of drawing a rectangle
	 */
	@Test 
	public void drawsRectangle() {
		Canvas c = new Canvas(20,4);
		c.drawLine(1, 2, 6, 2);
		c.drawLine(6, 3, 6, 4);
		c.drawRectangle(16, 1, 20, 3);
		String result = c.draw();
		assertEquals("----------------------\n"
				+ "|               xxxxx|\n"
				+ "|xxxxxx         x   x|\n"
				+ "|     x         xxxxx|\n"
				+ "|     x              |\n"
				+ "----------------------\n",result);
	}
	
	/**
	 * Unit test for the case of filling an area with a colour
	 */
	@Test
	public void fillsArea() {
		Canvas c = new Canvas(20,4);
		c.drawLine(1, 2, 6, 2);
		c.drawLine(6, 3, 6, 4);
		c.drawRectangle(16, 1, 20, 3);
		c.fillArea(10, 3, 'o');
		String result = c.draw();
		assertEquals("----------------------\n"
				+ "|oooooooooooooooxxxxx|\n"
				+ "|xxxxxxooooooooox   x|\n"
				+ "|     xoooooooooxxxxx|\n"
				+ "|     xoooooooooooooo|\n"
				+ "----------------------\n",result);
	}

}
