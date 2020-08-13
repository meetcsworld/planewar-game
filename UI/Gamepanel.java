/*     */ package UI;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import javax.swing.JPanel;
/*     */ import prop.Dj;
/*     */ import prop.Flyplane;
/*     */ import prop.bullet;
/*     */ import prop.picture;
/*     */ 
/*     */ public class Gamepanel extends JPanel
/*     */ {
/*     */   BufferedImage bg;
/*  23 */   Flyplane fly = new Flyplane();
/*     */ 
/*  26 */   List<Dj> djs = new ArrayList();
/*     */ 
/*  29 */   List<bullet> bus = new ArrayList();
/*     */   int score;
/*     */   boolean gameover;
/* 101 */   int index = 0;
/*     */ 
/* 123 */   int budex = 0;
/*     */ 
/*     */   public void action()
/*     */   {
/*  39 */     new Thread()
/*     */     {
/*     */       public void run()
/*     */       {
/*     */         while (true)
/*     */         {
/*  45 */           if (!(Gamepanel.this.gameover))
/*     */           {
/*  47 */             Gamepanel.this.djEnter();
/*  48 */             Gamepanel.this.djMove();
/*     */ 
/*  51 */             Gamepanel.this.shoot();
/*     */ 
/*  54 */             Gamepanel.this.buMove();
/*     */ 
/*  57 */             Gamepanel.this.shootDj();
/*     */ 
/*  60 */             Gamepanel.this.hit();
/*     */           }
/*  62 */           Gamepanel.this.shootDj();
/*     */           try
/*     */           {
/*  65 */             Thread.sleep(15L);
/*     */           }
/*     */           catch (InterruptedException e) {
/*  68 */             e.printStackTrace();
/*     */           }
/*     */ 
/*  71 */           Gamepanel.this.repaint(); }
/*     */       }
/*     */     }
/*  74 */     .start();
/*     */   }
/*     */ 
/*     */   protected void hit() {
/*  78 */     for (int i = 0; i < this.djs.size(); ++i)
/*     */     {
/*  80 */       Dj j = (Dj)this.djs.get(i);
/*     */ 
/*  82 */       if (!(j.hitBy(this.fly))) {
/*     */         continue;
/*     */       }
/*  85 */       this.djs.remove(j);
/*     */ 
/*  87 */       this.fly.HP -= 1;
/*     */ 
/*  89 */       this.score += 2;
/*     */ 
/*  91 */       if (this.fly.HP > 0)
/*     */         continue;
/*  93 */       this.gameover = true;
/*     */     }
/*     */   }
/*     */ 
/*     */   private void djEnter()
/*     */   {
/* 104 */     this.index += 1;
/* 105 */     if (this.index < 20)
/*     */       return;
/* 107 */     Dj D = new Dj();
/* 108 */     this.djs.add(D);
/*     */ 
/* 110 */     this.index = 0;
/*     */   }
/*     */ 
/*     */   protected void djMove()
/*     */   {
/* 115 */     for (int i = 0; i < this.djs.size(); ++i)
/*     */     {
/* 118 */       Dj D = (Dj)this.djs.get(i);
/* 119 */       D.Move();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void shoot()
/*     */   {
/* 125 */     this.budex += 1;
/* 126 */     if (this.budex < 5) {
/*     */       return;
/*     */     }
/* 129 */     bullet bu1 = new bullet(this.fly.x + 70, this.fly.y);
/*     */ 
/* 131 */     this.bus.add(bu1);
/* 132 */     bullet bu2 = new bullet(this.fly.x + 10, this.fly.y);
/*     */ 
/* 134 */     this.bus.add(bu2);
/* 135 */     this.budex = 0;
/*     */   }
/*     */ 
/*     */   private void buMove()
/*     */   {
/* 141 */     for (int i = 0; i < this.bus.size(); ++i)
/*     */     {
/* 143 */       bullet b = (bullet)this.bus.get(i);
/* 144 */       b.move();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void shootDj() {
/* 149 */     for (int i = 0; i < this.bus.size(); ++i)
/*     */     {
/* 151 */       bullet b = (bullet)this.bus.get(i);
/* 152 */       bang(b);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void bang(bullet b)
/*     */   {
/* 158 */     for (int i = 0; i < this.djs.size(); ++i)
/*     */     {
/* 161 */       Dj j = (Dj)this.djs.get(i);
/*     */ 
/* 163 */       if (!(j.shootBy(b))) {
/*     */         continue;
/*     */       }
/* 166 */       j.HP2 -= 1;
/* 167 */       if (j.HP2 <= 0)
/*     */       {
/* 170 */         this.djs.remove(j);
/*     */ 
/* 172 */         this.score += 2;
/*     */       }
/*     */ 
/* 175 */       this.bus.remove(b);
/*     */     }
/*     */   }
/*     */ 
/*     */   public Gamepanel(Gameframe frame)
/*     */   {
/* 183 */     setBackground(Color.pink);
/* 184 */     this.bg = picture.getImg("/img/bg1.jpg");
/*     */ 
/* 188 */     MouseAdapter adapter = new MouseAdapter()
/*     */     {
/*     */       public void mouseClicked(MouseEvent e)
/*     */       {
/* 193 */         if (!(Gamepanel.this.gameover)) {
/*     */           return;
/*     */         }
/* 196 */         Gamepanel.this.fly = new Flyplane();
/*     */ 
/* 198 */         Gamepanel.this.gameover = false;
/*     */ 
/* 200 */         Gamepanel.this.score = 0;
/* 201 */         Random rd = new Random();
/* 202 */         int index = rd.nextInt(5) + 1;
/* 203 */         Gamepanel.this.bg = picture.getImg("/img/bg" + index + ".jpg");
/*     */ 
/* 205 */         Gamepanel.this.repaint();
/*     */       }
/*     */ 
/*     */       public void mouseMoved(MouseEvent e)
/*     */       {
/* 213 */         int mx = e.getX();
/* 214 */         int my = e.getY();
/* 215 */         if (!(Gamepanel.this.gameover))
/*     */         {
/* 218 */           Gamepanel.this.fly.moveToMouse(mx, my);
/*     */         }
/*     */ 
/* 221 */         Gamepanel.this.repaint();
/*     */       }
/*     */     };
/* 225 */     addMouseListener(adapter);
/* 226 */     addMouseMotionListener(adapter);
/*     */ 
/* 229 */     KeyAdapter kd = new KeyAdapter()
/*     */     {
/*     */       public void keyPressed(KeyEvent e)
/*     */       {
/* 235 */         int keyCode = e.getKeyCode();
/* 236 */         if (keyCode == 38)
/*     */         {
/* 238 */           Gamepanel.this.fly.moveUp();
/* 239 */         } else if (keyCode == 40)
/*     */         {
/* 241 */           Gamepanel.this.fly.moveDown();
/* 242 */         } else if (keyCode == 37)
/*     */         {
/* 244 */           Gamepanel.this.fly.moveLeft();
/* 245 */         } else if (keyCode == 39)
/*     */         {
/* 247 */           Gamepanel.this.fly.moveRight();
/* 248 */         } else if (keyCode == 87)
/*     */         {
/* 250 */           Gamepanel.this.fly.moveUp();
/*     */         }
/* 252 */         else if (keyCode == 83)
/*     */         {
/* 254 */           Gamepanel.this.fly.moveDown();
/*     */         }
/* 256 */         else if (keyCode == 65)
/*     */         {
/* 258 */           Gamepanel.this.fly.moveLeft();
/*     */         }
/* 260 */         else if (keyCode == 68)
/*     */         {
/* 262 */           Gamepanel.this.fly.moveRight();
/*     */         }
/*     */ 
/* 265 */         Gamepanel.this.repaint();
/*     */       }
/*     */     };
/* 269 */     frame.addKeyListener(kd);
/*     */   }
/*     */ 
/*     */   public void paint(Graphics g)
/*     */   {
/* 275 */     super.paint(g);
/*     */ 
/* 278 */     g.drawImage(this.bg, 0, 0, 521, 768, null);
/*     */ 
/* 281 */     g.drawImage(this.fly.img, this.fly.x, this.fly.y, this.fly.w, this.fly.h, null);
/*     */ 
/* 283 */     for (int i = 0; i < this.djs.size(); ++i)
/*     */     {
/* 285 */       Dj dj = (Dj)this.djs.get(i);
/* 286 */       g.drawImage(dj.img, dj.x, dj.y, dj.w, dj.h, null);
/*     */     }
/*     */ 
/* 289 */     for (i = 0; i < this.bus.size(); ++i)
/*     */     {
/* 291 */       bullet bu = (bullet)this.bus.get(i);
/* 292 */       g.drawImage(bu.img, bu.x, bu.y, bu.w, bu.h, null);
/*     */     }
/*     */ 
/* 295 */     g.setColor(Color.red);
/* 296 */     g.setFont(new Font("楷体", 1, 20));
/* 297 */     g.drawString("分数【" + this.score + "】", 10, 30);
/*     */ 
/* 299 */     for (i = 0; i < this.fly.HP; ++i)
/*     */     {
/* 301 */       g.drawImage(this.fly.img, 400 + i * 35, 5, 30, 30, null);
/*     */     }
/*     */ 
/* 304 */     if (!(this.gameover))
/*     */       return;
/* 306 */     g.setColor(Color.RED);
/* 307 */     g.setFont(new Font("楷体", 1, 100));
/* 308 */     g.drawString("GAMEOVER", 20, 400);
/*     */   }
/*     */ }

/* Location:           C:\Users\DELL\Documents\飞机大战.jar
 * Qualified Name:     UI.Gamepanel
 * JD-Core Version:    0.5.3
 */