/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Font;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kasun
 */
public class LoadKalani {
      public static Font loadFont(float size,int style){
            Font font=null;
        try {
           // InputStream is=j.getClass().getResourceAsStream("Assets/Kelani Plain.ttf");
             InputStream is= new FileInputStream("Assets/Kelani Plain.ttf");
            font=Font.createFont(Font.TRUETYPE_FONT,is);
            font=font.deriveFont(size);
            font=font.deriveFont(style);
            
        } catch (FontFormatException ex) {
            Logger.getLogger(FontLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FontLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return font;
    }
}
