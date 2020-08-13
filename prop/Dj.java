/*    */ package prop;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.util.Random;
/*    */ 
/*    */ public class Dj extends UFO
/*    */ {
/*    */   int sp;
/*    */   public int HP2;
/*    */ 
/*    */   public Dj()
/*    */   {
/* 11 */     Random rd = new Random();
/*    */ 
/* 13 */     int index = rd.nextInt(15) + 1;
/*    */ 
/* 15 */     this.img = picture.getImg("/img/dj" + index + ".png");
/*    */ 
/* 17 */     this.w = this.img.getWidth();
/* 18 */     this.h = this.img.getHeight();
/*    */ 
/* 20 */     this.x = rd.nextInt(512 - this.w);
/* 21 */     this.y = 0;
/*    */ 
/* 23 */     this.sp = (17 - index);
/*    */ 
/* 25 */     this.HP2 = rd.nextInt(15);
/*    */   }
/*    */ 
/*    */   public void Move()
/*    */   {
/* 30 */     this.y += this.sp;
/*    */   }
/*    */ 
/*    */   public boolean shootBy(bullet b) {
/* 34 */     boolean hit = (this.x < b.x + b.w) && 
/* 35 */       (this.x >= b.x - this.w) && 
/* 36 */       (this.y <= b.y + b.h) && (
/* 37 */       this.y >= b.y - this.h);
/* 38 */     return hit; }
/*    */ 
/*    */   public boolean hitBy(Flyplane b) {
/* 41 */     boolean hit = (this.x < b.x + b.w) && 
/* 42 */       (this.x >= b.x - this.w) && 
/* 43 */       (this.y <= b.y + b.h) && (
/* 44 */       this.y >= b.y - this.h);
/* 45 */     return hit;
/*    */   }
/*    */ }

/* Location:           C:\Users\DELL\Documents\飞机大战.jar
 * Qualified Name:     prop.Dj
 * JD-Core Version:    0.5.3
 */