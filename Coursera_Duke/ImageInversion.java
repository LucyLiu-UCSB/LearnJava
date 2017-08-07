
/**
 * A pixel’s red, blue, and green components are modified to be the exact opposite within the 0 to 255 range.
 * 
 * @author Lucy Liu
 */

import edu.duke.*;
import java.io.File;

public class ImageInversion {
    public ImageResource makeInversion(ImageResource inimage){
        ImageResource outimage = new ImageResource (inimage.getWidth(),inimage.getHeight());
        for (Pixel pixel:outimage.pixels()){
            Pixel inpixel=inimage.getPixel(pixel.getX(),pixel.getY());
            pixel.setRed(255-inpixel.getRed());
            pixel.setGreen(255-inpixel.getGreen());
            pixel.setBlue(255-inpixel.getBlue());
        }
        return outimage;
    }
    
    public void SelectInversionAndSave(){
        DirectoryResource dr= new DirectoryResource();
        for (File f:dr.selectedFiles()){
            ImageResource inimage=new ImageResource(f);
            ImageResource inversion=makeInversion(inimage);
            String fname=inimage.getFileName();
            String newName="inverted-"+fname;
            inversion.setFileName(newName);
            inversion.save();      
        }
    }

}
