
/**
 * Convert any number of images to a gray scale version by setting all color components of each pixel to the same value.
 * 
 * @author Lucy Liu
 */

import edu.duke.*;
import java.io.File;

public class GrayScaleConverter {
    public ImageResource makeGray(ImageResource inimage){
        ImageResource outimage = new ImageResource(inimage.getWidth(),inimage.getHeight());
        for (Pixel pixel: outimage.pixels()){
            Pixel inpixel=inimage.getPixel(pixel.getX(),pixel.getY());
            int average=(inpixel.getRed()+inpixel.getBlue()+inpixel.getGreen())/3;
            pixel.setRed(average);
            pixel.setGreen(average);
            pixel.setBlue(average);
    }
    return outimage;
   }
   public void SelectConvertAndSave(){
       DirectoryResource dr = new DirectoryResource();
       for (File f: dr.selectedFiles()){
        ImageResource inimage = new ImageResource(f);
        ImageResource gray=makeGray(inimage);
        String fname = inimage.getFileName();
        String newName="gray-"+fname;
        gray.setFileName(newName);
        gray.save();
    }
   }
}

