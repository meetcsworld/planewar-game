/*    */ package prop;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ public class bullet extends UFO
/*    */ {
/*    */   public bullet(int hx, int hy)
/*    */   {
/*  8 */     this.img = picture.getImg("/img/zd.png");
/*    */ 
/* 10 */     this.w = (this.img.getWidth() / 3);
/* 11 */     this.h = (this.img.getHeight() / 3);
/*    */ 
/* 13 */     this.x = hx;
/* 14 */     this.y = hy;
/*    */   }
/*    */ 
/*    */   public void move() {
/* 18 */     this.y -= 10;
/*    */   }
/*    */ }

/* Location:           C:\Users\DELL\Documents\飞机大战.jar
 * Qualified Name:     prop.bullet
 * JD-Core Version:    0.5.3
 */