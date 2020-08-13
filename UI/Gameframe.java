/*    */ package UI;
/*    */ 
/*    */ import javax.swing.JFrame;
/*    */ 
/*    */ public class Gameframe extends JFrame
/*    */ {
/*    */   public Gameframe()
/*    */   {
/* 14 */     setTitle("全民飞机大战    By项目31802班");
/*    */ 
/* 16 */     setSize(512, 768);
/*    */ 
/* 18 */     setLocationRelativeTo(null);
/*    */ 
/* 20 */     setResizable(false);
/*    */ 
/* 22 */     setDefaultCloseOperation(3);
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/* 27 */     Gameframe frame = new Gameframe();
/*    */ 
/* 29 */     Gamepanel panel = new Gamepanel(frame);
/*    */ 
/* 31 */     panel.action();
/*    */ 
/* 33 */     frame.add(panel);
/*    */ 
/* 35 */     frame.setVisible(true);
/*    */   }
/*    */ }

/* Location:           C:\Users\DELL\Documents\飞机大战.jar
 * Qualified Name:     UI.Gameframe
 * JD-Core Version:    0.5.3
 */