/*    */ package prop;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ public class Flyplane extends UFO
/*    */ {
/*    */   public int HP;
/*    */ 
/*    */   public Flyplane()
/*    */   {
/*  6 */     this.img = picture.getImg("/img/zj.png");
/*    */ 
/*  8 */     this.x = 200;
/*  9 */     this.y = 500;
/*    */ 
/* 11 */     this.w = this.img.getWidth();
/* 12 */     this.h = this.img.getHeight();
/* 13 */     this.HP = 3;
/*    */   }
/*    */ 
/*    */   public void moveToMouse(int mx, int my)
/*    */   {
/* 18 */     this.x = (mx - (this.w / 2));
/* 19 */     this.y = (my - (this.h / 2));
/*    */   }
/*    */ 
/*    */   public void moveUp()
/*    */   {
/* 24 */     this.y -= 100;
/*    */   }
/*    */ 
/*    */   public void moveDown() {
/* 28 */     this.y += 100;
/*    */   }
/*    */ 
/*    */   public void moveLeft() {
/* 32 */     this.x -= 100;
/*    */   }
/*    */ 
/*    */   public void moveRight() {
/* 36 */     this.x += 100;
/*    */   }
/*    */ }

/* Location:           C:\Users\DELL\Documents\飞机大战.jar
 * Qualified Name:     prop.Flyplane
 * JD-Core Version:    0.5.3
 */