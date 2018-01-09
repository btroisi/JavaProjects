import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Displays a Parking Garage graphically using Swing.  The parking garage
 * can be displayed at any scale factor.
 * @author bseastwo
 */
public class ParkingGarageDisplay extends JFrame
{
    protected ParkingGarage garage;
    private ParkingGaragePanel canvas;
    private int gridScale; // width (and height) of each square in the grid

    /**
     * Initializes a display window for a parking garage .
     * @param scape the parking garage  to display
     * @param scale controls the relative size of the display
     */
    public ParkingGarageDisplay(ParkingGarage garage, int scale)
    {
        // setup the window
        super("Parking Simulation");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.garage = garage;
        this.gridScale = scale;

        // create a panel in which to display the Parking Garage
        this.canvas = new ParkingGaragePanel( (int) this.garage.getNumLanes() * this.gridScale,
                                        (int) this.garage.getMaxLaneSize() * this.gridScale);

        // add the panel to the window, layout, and display
        this.add(this.canvas, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
    }

    /**
     * Saves an image of the display contents to a file.  The supplied
     * filename should have an extension supported by javax.imageio, e.g.
     * "png" or "jpg".
     *
     * @param filename  the name of the file to save
     */
    public void saveImage(String filename)
    {
        // get the file extension from the filename
        String ext = filename.substring(filename.lastIndexOf('.') + 1, filename.length());

        // create an image buffer to save this component
        Component tosave = this.getRootPane();
        BufferedImage image = new BufferedImage(tosave.getWidth(), tosave.getHeight(), 
                                                BufferedImage.TYPE_INT_RGB);

        // paint the component to the image buffer
        Graphics g = image.createGraphics();
        tosave.paint(g);
        g.dispose();

        // save the image
        try
                {
                        ImageIO.write(image, ext, new File(filename));
                }
        catch (IOException ioe)
                {
                        System.out.println(ioe.getMessage());
                }
    }

    /**
     * This inner class provides the panel on which parking garage  elements
     * are drawn.
     */
    private class ParkingGaragePanel extends JPanel
    {
        /**
         * Creates the panel.
         * @param width     the width of the panel in pixels
         * @param height        the height of the panel in pixels
         */
        public ParkingGaragePanel(int width, int height)
        {
                super();
                this.setPreferredSize(new Dimension(width, height));
                this.setBackground(Color.white);
        }

        /**
         * Method overridden from JComponent that is responsible for
         * drawing components on the screen.  The supplied Graphics
         * object is used to draw.
         * 
         * @param g     the Graphics object used for drawing
         */
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            garage.draw( g, gridScale );    
        } // end paintComponent
        
    } // end parking garage Panel

    public void update() {
        Graphics g = canvas.getGraphics();
        this.requestFocus();
        canvas.paintComponent( g );
    }


    public static void main(String[] args) throws InterruptedException {
        ParkingGarage garage = new ParkingGarage(5,10);
        Random gen = new Random();
        for(int i=0; i<50; i++){
        	Color color = new Color( gen.nextFloat(), gen.nextFloat(), gen.nextFloat() ); 
        	Car c = new Car(i+1, color);
        	garage.parkCar(c);
        }
        
      
       
       
    
	
        
        
        ParkingGarageDisplay display = new ParkingGarageDisplay(garage, 5);

        display.repaint();
        }
}
