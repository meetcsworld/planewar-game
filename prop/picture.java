/*    */ package prop;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.IOException;
/*    */ import javax.imageio.ImageIO;
/*    */ 
/*    */ public class picture
/*    */ {
/*    */   public static BufferedImage getImg(String path)
/*    */   {
/*    */     try
/*    */     {
/* 15 */       BufferedImage img = ImageIO.read(picture.class.getResource(path));
/* 16 */       return img;
/*    */     }
/*    */     catch (IOException e) {
/* 19 */       e.printStackTrace();
/*    */     }
/* 21 */     return null;
/*    */   }
/*    */ }

/* Location:           C:\Users\DELL\Documents\飞机大战.jar
 * Qualified Name:     prop.picture
 * JD-Core Version:    0.5.3
 */