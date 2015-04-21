package utils;
/**
 * Class that implements the methods for drawing lines and rectangles in a canvas.
 * @author ealarcon
 */
public class Canvas {
	
	//Width of the canvas
	private int width;
	//Height of the canvas
	private int height;
	//Array that maps the content of the canvas
	private char[][] canvas;
	
	/**
	 * Constructor for the canvas with defined width and height
	 * @param width of the canvas
	 * @param height of the canvas
	 */
	public Canvas(int width, int height) {
		this.setWidth(width);
		this.setHeight(height);
		canvas = new char[height+2][width+2];
		for (int i = 0; i<canvas.length; i++) {
			for (int j = 0; j < canvas[0].length; j++) {
					canvas[0][j] = '-';
					if (i<canvas.length-2){
						canvas[i+1][0] = '|';
						canvas[i+1][canvas[0].length-1] = '|';
					}
					if (i > 0 && j<=canvas[0].length-2
							&& i <=canvas.length-2	 && j > 0) {
						canvas[i][j] = ' ';
 					}
					canvas[canvas.length-1][j] = '-';
			}
		}
	}
	
	/**
	 * Constructor for a canvas without params
	 */
	public Canvas() {
		setWidth(0);
		setHeight(0);
	}

	/**
	 * Draws the content of the canvas in the command line
	 */
	public String draw() {
		String canvasToDraw = "";
		for (int i = 0; i < canvas.length; i++) {
			for (int j = 0; j < canvas[0].length; j++) {
				//System.out.print(canvas[i][j]);
				canvasToDraw += canvas[i][j];
			}
			//System.out.print("\n");
			canvasToDraw += "\n";
		}
		return canvasToDraw;
	}
	
	/**
	 * Given two coordinates draws horizontal or vertical lines in the canvas,
	 * by storing them in the array.
	 * @param x1 Coordinate of point 1
	 * @param y1 Coordinate of point 1
	 * @param x2 Coordinate of point 2
	 * @param y2 Coordinate of pint 2
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		canvas[y1][x1] = 'x';
		canvas[y2][x2] = 'x';
		if (x1 == x2) {
			if (y1 < y2) {
				for (int i = y1+1; i < y2; i++) {
					canvas[i][x1] = 'x';
				}
			} else {
				for (int i = y1-1; i > y2; i--) {
					canvas[i][x1] = 'x';
				}
			}
		} else if (y1 == y2) {
			if (x1 < x2) {
				for (int j = x1+1; j < x2; j++) {
					canvas[y1][j] = 'x';
				}
			} else {
				for (int j = x1-1; j > x2; j--) {
					canvas[y1][j] = 'x';
				}
			}
		}
	}
	
	/**
	 * Given two corners draws a rectangle that matches them. Reuses the drawLine
	 * method to draw the lines between the four corners.
	 * @param x1 Upper left corner coordinate
	 * @param y1 Upper left corner coordinate
	 * @param x2 Lower right corner coordinate
	 * @param y2 Lower right corner coordinate
	 */
	public void drawRectangle(int x1, int y1, int x2, int y2) {
		drawLine(x1, y1, x1, y2);
		drawLine(x1, y1, x2, y1);
		drawLine(x1, y2, x2, y2);
		drawLine(x2, y1, x2, y2);
	}
	
	/**
	 * Given a point coordinates fills the area surrounding it with the 'colour'
	 * passed as param. Is an implementation based on the flood fill algorithm
	 * (http://en.wikipedia.org/wiki/Flood_fill).
	 * @param x Coordinate
	 * @param y Coordinate
	 * @param colour to fill
	 */
	public void fillArea(int x, int y, char colour) {
		 int maxX = canvas.length - 1;
	     int maxY = canvas[0].length - 1;
	     int[][] stack = new int[(maxX+1)*(maxY+1)][2];
	     int index = 0;         

	     stack[0][0] = x;
	     stack[0][1] = y;
	     canvas[x][y] = colour;

	     while (index >= 0){
	         x = stack[index][0];
	         y = stack[index][1];
	         index--;            

	         if ((x > 0) && (canvas[x-1][y] == ' ')){
	        	 canvas[x-1][y] = colour;
	             index++;
	             stack[index][0] = x-1;
	             stack[index][1] = y;
	         }

	         if ((x < maxX) && (canvas[x+1][y] == ' ')){
	        	 canvas[x+1][y] = colour;
	             index++;
	             stack[index][0] = x+1;
	             stack[index][1] = y;
	         }

	         if ((y > 0) && (canvas[x][y-1] == ' ')){
	        	 canvas[x][y-1] = colour;
	             index++;
	             stack[index][0] = x;
	             stack[index][1] = y-1;
	         }                

	         if ((y < maxY) && (canvas[x][y+1] == ' ')){
	        	 canvas[x][y+1] = colour;
	             index++;
	             stack[index][0] = x;
	             stack[index][1] = y+1;
	         }                          
	     }
	}

	/**
	 * Getter method for the canvas width
	 * @return width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Setter method for the canvas width
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Getter method for the canvas height
	 * @return height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Setter method for the canvas height
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Getter method for the canvas array
	 * @return canvas
	 */
	public char[][] getCanvas() {
		return canvas;
	}

	/**
	 * Setter method for the canvas array
	 * @param canvas
	 */
	public void setCanvas(char[][] canvas) {
		this.canvas = canvas;
	}
}
