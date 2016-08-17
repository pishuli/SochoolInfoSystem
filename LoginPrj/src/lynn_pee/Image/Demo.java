package lynn_pee.Image;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class Demo {
	@Test
    public void testverify() throws FileNotFoundException, IOException
    {
    	VerifyCode vc = new VerifyCode();
    	BufferedImage bi = vc.getImage();
    	VerifyCode.output(bi, new FileOutputStream("F:/xxx.jpg"));
    	System.out.println(vc.getText());
    }
}
