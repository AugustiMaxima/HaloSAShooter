package SAss;

import hsa_ufa.Console;

import java.awt.*;
import java.net.URL;
import java.applet.AudioClip;
import java.applet.Applet;
import java.util.*;
import java.io.*;

public class HSA {
	static Console c = new Console(800, 480, "HALO : DAWN OF REACH");
	static hCombatEvolved CE = new hCombatEvolved();
	static level_specific lv=new level_specific();
	public static int player[]={200,350,1,4,120,72};
	public static void main(String[] args) throws InterruptedException {
		int s = 0,level=1;
		File inFile = new File("C:\\save.txt");
		try {
			Scanner in = new Scanner(inFile);
			level = in.nextInt();
			int x = in.nextInt();
			int y = in.nextInt();
			int w1 = in.nextInt();
			int w2 = in.nextInt();
			int a1 = in.nextInt();
			int a2 = in.nextInt();
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Image Title = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/REACH.jpg"));
		Image Menu = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/Menu.PNG"));
		AudioClip opening = Applet.newAudioClip(HSA.class.getResource("Opening.wav"));
		AudioClip MenuMix = Applet.newAudioClip(HSA.class.getResource("HaloMenusSet.wav"));
		opening.play();
		c.drawImage(Title, 0, 0, 800, 480);
		Thread.sleep(11640);
		MenuMix.play();// title,opening and other stuff
		while (true) {// menu,selection etc.
			Thread.sleep(100);
			if (c.isKeyDown(Console.VK_UP)) {
				if (s > 0)
					s--;
			} else if (c.isKeyDown(Console.VK_DOWN)) {
				if (s < 2)
					s++;
			} else if (c.isKeyDown(Console.VK_ENTER)) {
				MenuMix.stop();
				if (s == 0) 
					lv.mapimport(level);
				else if (s == 1)
					credit();
				else if (s == 2)
					exit(player[0],player[1],player[2],player[3],player[4],player[5],level);
			}
			synchronized (c) {
				c.clear();
				c.drawImage(Menu, 0, 0, 800, 480);
				c.setFont(new Font("Arial", Font.BOLD, 20));
				c.setColor(new Color(221, 147, 147, 150));
				c.fillRect(580, 220, 140, 140);
				c.setColor(new Color(159, 223, 255));
				c.drawString("CAMPAIGN", 600, 250);
				c.drawString("CREDITS", 600, 290);
				c.drawString("QUIT", 600, 330);
				c.setFont(new Font("Arial", Font.BOLD, 22));
				c.setColor(new Color(30, 109, 180, 80));
				switch (s) {// selection special effects
				case 0:
					c.drawString("CAMPAIGN", 598, 248);
					break;
				case 1:
					c.drawString("CREDITS", 598, 288);
					break;
				case 2:
					c.drawString("QUIT", 598, 328);
					break;
				}
			}
		}

	}

static void HSAFramework(int level,int map[][]) throws InterruptedException {//loading resources
		Image R1 = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/1.gif"));
		Image R2 = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/2.gif"));
		Image R3 = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/3.gif"));
		Image R4 = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/4.gif"));
		Image R5 = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/5.gif"));
		Image e1 = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/e1.gif"));
		Image e2 = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/e2.gif"));
		Image e3 = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/e3.gif"));
		Image e4 = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/e4.gif"));
		Image e5 = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/e5.gif"));
		Image ed1 = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/ed1.gif"));
		Image ed2 = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/ed2.gif"));
		Image ed3 = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/ed3.gif"));
		Image Rc1 = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/c1.gif"));
		Image Rc2 = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/c2.gif"));
		Image Rc3 = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/c3.gif"));
		Image Rj1 = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/J1.gif"));
		Image Rj2 = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/J2.gif"));
		Image Rj3 = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/J3.gif"));
		Image Rj4 = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/J4.gif"));
		Image Rj5 = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/J5.gif"));
		Image plasma = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/plasma.gif"));
		Image rocket = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/rock.gif"));
		Image scarab = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/scarab.png"));
		Image plex = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/plex.png"));
		Image exp[]={Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/exp3.png")),Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/exp2.png")),Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/exp1.png"))};
		Image bt[] ={null,Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/bl1.png")),Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/bl2.png")),Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/bl3.png")),Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/bl4.png"))};
		Image item_weapon[]={null,Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/pistol.gif")),Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/smg.gif")),Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/BR.gif")),Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/shotgun.gif")),Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/roclaus.gif"))};
		Image weapon[][] = {{null,Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/M6D.gif")),Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/M7.gif")),Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/XBR55.gif")),Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/M90.gif")),Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/Rocket.gif")) },{null,Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/f_m6d.png")),Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/f_m7.png")),Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/f_XBR.png")),Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/f_M90.png")),Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("SAss/f_rocket.gif"))}};
		AudioClip wsfx[] = {Applet.newAudioClip(HSA.class.getResource("plasma.wav")),Applet.newAudioClip(HSA.class.getResource("pistol.wav")),Applet.newAudioClip(HSA.class.getResource("SMG.wav")),Applet.newAudioClip(HSA.class.getResource("BR.wav")),Applet.newAudioClip(HSA.class.getResource("shotgun.wav")),Applet.newAudioClip(HSA.class.getResource("rocket.wav"))};
		AudioClip exs=Applet.newAudioClip(HSA.class.getResource("exp.wav"));
		AudioClip rec = Applet.newAudioClip(HSA.class.getResource("rech.wav"));
		AudioClip warn = Applet.newAudioClip(HSA.class.getResource("w.wav"));
		AudioClip e_die=Applet.newAudioClip(HSA.class.getResource("elitedie.wav"));
		AudioClip scfe = Applet.newAudioClip(HSA.class.getResource("scarfire.wav"));
		int vx[] = { 0 }, vy[] = { 0 }, x[] = { 0 }, y[] = { 0 }, fstat = 0, dx[] = { 0 }, dy = 0, rel = 0, pin[] = { 0 }, weapon1 = 0, weapon2 = 0, weapon3 = 0, regp[] = { 70 }, wdx[] = {0, 36, 32, 45, 54, 52 }, ai[] = { 0 }, sh[] = {160}, ammo1, ammo2, clip1, clip2, ammo3, clip3, fp[] = { 0 }, fp2 = 5, sstat = 0, ex[] = {0}, ey[] ={0}, ext[]={0}, ammov[] = {10, 30, 20, 35, 15, 8 }, fpin[] = { 2, 15, 1, 5, 45, 100 }, alert[] = { 0 }, c_hud = 0,pccd=0, scarh=150000, scex=0,scey=0;
		int ammox[][] = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },{ 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },{ 0, 0, 0, 0, 0 } }, ammoy[][] = { { 0, 0, 0, 0, 0 },{ 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },{ 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } }, ammod[][] = {{ 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },{ 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } }, ammos[][] = {{ 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },{ 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } }, cmax[] = {0, 12, 60, 36, 12, 2 }, shotgun[] = { 0, 0, 0, 0, 0 };
		x[0]=player[0];y[0]=player[1];weapon1=player[2];weapon2=player[3];ammo1=player[4];ammo2=player[5];clip1=cmax[weapon1];clip2=cmax[weapon2];
		Boolean rels = false;
		c.setFont(new Font("SansSerif",Font.CENTER_BASELINE, 15));// everything from xy vectors,sprite pin to reloading and clips
		Random rangen = new Random();
		level_specific lvl=new level_specific(x[0],y[0],map);
		while (true) {
			sstat = 0;//reinitialization of shield
			if (c.isKeyDown('W')) {// the following things are all player oriented
				if (map[(y[0] + 400) / 20][(x[0] + 180) / 20]%10 > 0 && dy != 2) {
					vy[0] = -16;//vectors
					dy = 1;
				}
			} else if (c.isKeyDown('S')) {
				if (dy != 1) {
					if (dy != 2)
						pin[0] = 0;//sprite animation
					else if (pin[0] < 9 || vx[0] != 0)
						pin[0]++;
					dy = 2;
				}
			} else {
				if (pin[0] > 0 && dy != 0) {
					pin[0]--;
				} else if (dy != 0 && pin[0] == 0)
					dy = 0;
			}
			if (c.isKeyDown('D')) {
				if (vx[0] < 7 && dy != 1)
					vx[0]++;
				dx[0] = 0;
				if (dy == 2 && pin[0] >= 9)
					pin[0] = 9;
				else
					pin[0]++;
			} else if (c.isKeyDown('A')) {
				if (vx[0] > -7 && dy != 1)
					vx[0]--;
				dx[0] = 1;
				if (dy == 2 && pin[0] >= 9)
					pin[0] = 9;
				else
					pin[0]++;
			} else {
				if (vx[0] > 0)
					vx[0]--;
				else if (vx[0] < 0)
					vx[0]++;
				if (dy == 0)
					pin[0] = 0;
				else if (dy == 2 && pin[0] >= 9)
					pin[0] = 9;
			}// motions, left right and up down has correlations but not necessarily restrict each other
			if (c.isKeyDown(' ') && fp[0] < 0 && clip1 > 0) {// fire + adding elements in case there isn't enough spot for ammo
				if (CE.fire(ammox[weapon1], ammoy[weapon1], ammod[weapon1],ammos[weapon1], shotgun, 0, x[0], y[0], 50, 25, dx[0],dy, weapon1) == 0) {
					int nbx[] = new int[ammox[weapon1].length + 5];
					int nby[] = new int[ammox[weapon1].length + 5];
					int nbd[] = new int[ammox[weapon1].length + 5];
					int nbs[] = new int[ammox[weapon1].length + 5];
					int ns[] = new int[shotgun.length + 5];
					for (int b = -1; b++ < nbx.length - 1;) {
						nbx[b] = (b < ammox[weapon1].length) ? ammox[weapon1][b]: 0;
						nby[b] = (b < ammox[weapon1].length) ? ammoy[weapon1][b]: 0;
						nbd[b] = (b < ammox[weapon1].length) ? ammod[weapon1][b]: 0;
						nbs[b] = (b < ammox[weapon1].length) ? ammos[weapon1][b]: 0;
						if (weapon1 == 4) {
							ns[b] = (b < shotgun.length) ? shotgun[b] : 0;
						}
					}
					nbx[ammox[weapon1].length] = x[0] + 200 - 50 * dx[0];
					nby[ammox[weapon1].length] = (dy == 2) ? y[0] + 340 + 25: y[0] + 320 + 25;
					nbd[ammox[weapon1].length] = dx[0];
					nbs[ammox[weapon1].length] = 0;
					if (weapon1 == 4)
						ns[shotgun.length] = 0;
					ammox[weapon1] = nbx;
					ammoy[weapon1] = nby;
					ammod[weapon1] = nbd;
					ammos[weapon1] = nbs;
					if (weapon1 == 4)
						shotgun = ns;//shotgun need to be kept track of to approximate its power
				}
				clip1--;
				fp[0] = fpin[weapon1];
				fp2 = 5;
				fstat = 1;
			wsfx[weapon1].play();}
			fp2--;
			if (fp2 == 0)
				fstat = 0;
			if (c.isKeyDown('Q')) {// hyper awesome weapons switching
				weapon3 = weapon1;
				ammo3 = ammo1;
				clip3 = clip1;
				weapon1 = weapon2;
				ammo1 = ammo2;
				clip1 = clip2;
				weapon2 = weapon3;
				ammo2 = ammo3;
				clip2 = clip3;
			}
			if (c.isKeyDown('E')&& map[(y[0]+390)/20][(x[0]+160)/20]/100>0) {//pick up weapons when available, as detected by the third digit
				weapon3 = weapon1;
				ammo3 = ammo1;
				clip3 = clip1;
				weapon1 = map[(y[0]+390)/20][(x[0]+160)/20]/100;
				ammo1 = rangen.nextInt(450);
				clip1 = cmax[weapon1];
				map[(y[0]+390)/20][(x[0]+160)/20] =map[(y[0]+390)/20][(x[0]+160)/20]%100+weapon3*100;
			}
			int reload[] = { 0, 16, 24, 40, (12 - clip1) * 8, 52 };// reload time for each weapon,shotgun reloading depends on number of ammo left in the magazine
			if (((c.isKeyDown('R') && clip1 < cmax[weapon1]) || clip1 == 0)&& ammo1 > 0)// reload
				rels = true;
			if (rels == true)
				rel--;
			if (rel <= 0) {
				if (ammo1 >= cmax[weapon1] - clip1) {
					ammo1 -= cmax[weapon1] - clip1;
					clip1 = cmax[weapon1];
				} else {
					clip1 += ammo1;
					ammo1 = 0;
				}
				rels = false;
				rel = reload[weapon1] * 8;
			}
			if(c.isKeyDown(Console.VK_ESCAPE))
				exit(x[0],y[0],weapon1,weapon2,ammo1,ammo2,level);
			if (dy == 0 && pin[0] == 25)// used for controlling the sprites animation and keep them in place
				pin[0] = 0;
			else if (dy == 2 && vx[0] != 0 && pin[0] > 21)
				pin[0] = 7;
			else if (vy[0] < 0)
				pin[0]++;
			else if (vy[0] > 0)
				pin[0]--;
			for (int iy = -1; iy++ < 24;) {
			for (int ix = -1; ix++ < 40;) {
				if (map[y[0]/20+iy][x[0]/20+ix]/10%10>0) {// creating new enemy according to the second digit of the map arrays
					int nx[] = new int[x.length + 1];
					int ny[] = new int[x.length + 1];
					int ndx[] = new int[x.length + 1];
					int nvx[] = new int[x.length + 1];
					int nvy[] = new int[x.length + 1];
					int nsh[] = new int[x.length + 1];
					int nregp[] = new int[x.length + 1];
					int npin[] = new int[x.length + 1];
					int nai[] = new int[x.length + 1];
					int nfp[] = new int[x.length + 1];
					int nalert[] = new int[x.length + 1];
					for (int b = -1; b++ < x.length - 1;) {
						nx[b] = x[b];
						ny[b] = y[b];
						ndx[b] = dx[b];
						nvx[b] = vx[b];
						nvy[b] = vy[b];
						nsh[b] = sh[b];
						nregp[b] = regp[b];
						npin[b] = pin[b];
						nai[b] = ai[b];
						nfp[b] = fp[b];
						nalert[b] = alert[b];
					}
					nx[x.length] = x[0] + 20 * ix;
					ny[x.length] = y[0] + 20*iy;
					ndx[x.length] = 0;
					nvx[x.length] = 0;
					nvy[x.length] = 0;
					nsh[x.length] = 150;
					nregp[x.length] = 70;
					npin[x.length] = 0;
					nai[x.length] = rangen.nextInt(3);
					nfp[x.length] = 0;
					nalert[x.length] = 0;
					x = nx;
					y = ny;
					dx = ndx;
					vx = nvx;
					vy = nvy;
					sh = nsh;
					regp = nregp;
					pin = npin;
					ai = nai;
					fp = nfp;
					alert = nalert;
					sh[x.length - 1] -= ai[x.length - 1] * 30;
					map[y[0]/20+iy][x[0] / 20 + ix]=map[y[0]/20+iy][x[0] / 20 + ix]/100+map[y[0]/20+iy][x[0] / 20 + ix]%10;
				}}
			}
			for (int p = -1; p++ < x.length - 1;) {//deleting dead enemies
				if ((x[p] - x[0] > 800 || x[p] - x[0] < 0) && sh[p] <= 0) {
					x[p] = x[x.length - 1];
					y[p] = y[x.length - 1];
					dx[p] = dx[x.length - 1];
					vx[p] = vx[x.length - 1];
					vy[p] = vy[x.length - 1];
					sh[p] = sh[x.length - 1];
					regp[p] = regp[x.length - 1];
					pin[p] = pin[x.length - 1];
					int nx[] = new int[x.length - 1];
					int ny[] = new int[x.length - 1];
					int ndx[] = new int[x.length - 1];
					int nvx[] = new int[x.length - 1];
					int nvy[] = new int[x.length - 1];
					int nsh[] = new int[x.length - 1];
					int nregp[] = new int[x.length - 1];
					int npin[] = new int[x.length - 1];
					int nai[] = new int[x.length - 1];
					int nfp[] = new int[x.length - 1];
					int nalert[] = new int[x.length - 1];
					for (int b = -1; b++ < nx.length - 1;) {
						nx[b] = x[b];
						ny[b] = y[b];
						ndx[b] = dx[b];
						nvx[b] = vx[b];
						nvy[b] = vy[b];
						nsh[b] = sh[b];
						nregp[b] = regp[b];
						npin[b] = pin[b];
						nai[b] = ai[b];
						nfp[b] = fp[b];
						nalert[b] = alert[b];
					}
					x = nx;
					y = ny;
					dx = ndx;
					vx = nvx;
					vy = nvy;
					sh = nsh;
					regp = nregp;
					pin = npin;
					ai = nai;
					fp = nfp;
					alert = nalert;
					break;
				}
				// AI's number represents classes, with 0 being aggresive "brute",1 being "tactician" and 2 being "scouts" that aren't good at fighting
				if (p != 0 && sh[p] > 0) {
					if (x[p] - x[0] - 160 > -100 - ai[p] * 300
							&& x[p] - x[0] - 160 < 100 + ai[p] * 300) {
						if (ai[p] != 0)
							alert[p] = 1;
					}
					if (sh[p] < 30 * ai[p] && p != 0) {// if enemy health is drained to a specific point for each class they will flee
						dx[p] = (x[p] - x[0] - 160 > 0) ? 1 : 0;
						if (x[p] - x[0] - 160 < 0 && vx[p] > -5)
							vx[p]--;
						else if (x[p] - x[0] - 160 > 0 && vx[p] < 5)
							vx[p]++;
						pin[p]++;
					} else {// within line of sight,the ais will fire at player
						int fa = rangen.nextInt(25);
						if (CE.blockdetect(map, x[p], y[p], x[0]) != 1&& sh[p] > 0&& y[p] < y[0] + 400&& y[0] < y[p] + 82&& fp[p] <= 0&& ((x[p] - x[0] - 160 < 0 && dx[p] == 0) || (x[p]- x[0] - 160 > 0 && dx[p] == 1))&& (alert[p] == 1 || (x[p] - x[0] - 160 > -100- ai[p] * 250 || x[p] - x[0] - 160 < 100 + ai[p] * 250))&& fa==1) {
							if (CE.Efire(ammox[0], ammoy[0], ammod[0],ammos[0], 1, x[p], y[p], 50, 25, dx[p],x[0]) == 0) {
								int nbx[] = new int[ammox[0].length + 5];
								int nby[] = new int[ammox[0].length + 5];
								int nbd[] = new int[ammox[0].length + 5];
								int nbs[] = new int[ammox[0].length + 5];
								for (int b = -1; b++ < nbx.length - 1;) {
									nbx[b] = (b < ammox[0].length) ? ammox[0][b]: 0;
									nby[b] = (b < ammox[0].length) ? ammoy[0][b]: 0;
									nbd[b] = (b < ammox[0].length) ? ammod[0][b]: 0;
									nbs[b] = (b < ammox[0].length) ? ammos[0][b]: 0;
								}
								nbx[ammox[0].length] = x[p] + 50 - 50 * dx[p];
								nby[ammox[0].length] = y[p] + 25;
								nbd[ammox[0].length] = dx[p];
								nbs[ammox[0].length] = 1;
								ammox[0] = nbx;
								ammoy[0] = nby;
								ammod[0] = nbd;
								ammos[0] = nbs;
							}
							fp[p] = ai[p] * 2 ^ ai[p];// Different Rate of fire for different class
							wsfx[0].play();
						}
					}
					if (alert[p] == 1) {//if the enemy is alert it will focus on the player and advance or retreat
						dx[p] = (x[p] - x[0] - 160 > 0) ? 1 : 0;
						if (ai[p] == 0) {
							pin[p]++;
							vx[p] = (x[p] - x[0] - 160 > 0) ? -1 : 1;
						} else if (vx[p] < 5 && vx[p] > -5) {
							int mov = rangen.nextInt(10);
							if (mov > 3) {
								pin[p]++;
								vx[p] += (x[p] - x[0] - 160 > 0) ? -1 : 1;
							} else if (mov < 3) {
								pin[p]++;
								vx[p] = (x[p] - x[0] - 160 > 0) ? 1 : -1;
							}
						}
					}
				} else if (p != 0) {//if enemy is dead plays dying animation and sound
					if (pin[p] < 100){
						pin[p] = 100;
						e_die.play();
						}
					else
						pin[p]++;
					if (pin[p] > 105)
						vx[p] = 0;
				}
				fp[p]--;//firing cooldown
				if (regp[p] < 0 && sh[p] > 0) {
					if ((p == 0 && sh[p] < 160) || (p != 0 && sh[p] < 80))
						sh[p]++;
				}
				regp[p]--; //reduce wait time for shield recharge
				if (p != 0) {
					if (pin[p] > 25 && sh[p] > 0)
						pin[p] = 0;
					int vd = (vx[p] >= 0) ? 0 : 1;// basic map collisions
					if (map[(y[p]) / 20][(x[p] + 40 - 40 * vd) / 20]%10 <= 0&& map[(y[p] + 20) / 20][(x[p] + 40 - 40 * vd) / 20]%10 <= 0&& map[(y[p] + 40) / 20][(x[p] + 40 - 40 * vd) / 20]%10 <= 0) {
						x[p] += vx[p];//if the blocks ahead of enemy isn't solid he can go
						if (map[(y[p] + 60) / 20][(x[p] + 40 - 40 * vd) / 20]%10 > 0&& vx[p] != 0)
							y[p] -= 20;//if the block near the enemy feet is solid he will acsend like climbing stairs
					}
					for(int i=-1;i++<ex.length-1;){
					if (ext[i]>0&& CE.collision(x[p], y[p], ex[i], ey[i], 40,80, 160, 160) == 1){ 
						sh[p] -= 100;
						regp[p] = 70;}
					}//if enemies are hit by explosions they receive damage
					if ((map[(y[p] - 20) / 20][(x[p] + 20) / 20]%10 <= 0 && vy[p] < 0)|| (map[(y[p] + 80) / 20][(x[p] + 20) / 20]%10 <= 0 && vy[p] > 0)) {
						y[p] += vy[p];//if the block below or above enemy isn't solid he can rise/fall
					}
					if (map[(y[p] + 80) / 20][(x[p] + 20) / 20]%10 <= 0) {
						vy[p]++;//gravity
					} else if (map[(y[p] + 80) / 20][(x[p] + 20) / 20]%10 > 0) {
						vy[p] = 0;//normal force
					}
				}
			}//same thing over again, this time for the player
			int vd = (vx[0] >= 0) ? 0 : 1;
			if (map[(y[0] + 320) / 20][(x[0] + 200 - 40 * vd) / 20]%10 <= 0&& map[(y[0] + 340) / 20][(x[0] + 200 - 40 * vd) / 20]%10 <= 0&& map[(y[0] + 360) / 20][(x[0] + 200 - 40 * vd) / 20]%10 <= 0) {
				if (dy == 2)
					x[0] += vx[0] / 2;
				else
					x[0] += vx[0];
				if (map[(y[0] + 380) / 20][(x[0] + 200 - 40 * vd) / 20] > 0&& vx[0] != 0)
					y[0] -= 20;
			} else if (map[(y[0] + 360) / 20][(x[0] + 200 - 40 * vd) / 20]%10 <= 0&& map[(y[0] + 380) / 20][(x[0] + 200 - 40 * vd) / 20]%10 <= 0&& map[(y[0] + 340) / 20][(x[0] + 200 - 40 * vd) / 20]%10 <= 0) {
				if (dy == 2) {
					x[0] += vx[0] / 2;
					pin[0] = 10;
				}
			}for(int i=-1;i++<ex.length-1;){
			if (ext[i] > 0&& CE.collision(x[0] + 160, y[0] + 320, ex[i], ey[i],40, 80, 160, 160) == 1){
				sh[0] -= 10;
				regp[0] = 70;}
			}
			if ((map[(y[0] + 300) / 20][(x[0] + 180) / 20]%10 <= 0 && vy[0] < 0)|| (map[(y[0] + 400) / 20][(x[0] + 180) / 20]%10 <= 0 && vy[0] > 0)) {
				y[0] += vy[0];
			}
			if (map[(y[0] + 400) / 20][(x[0] + 180) / 20]%10 <= 0) {
				vy[0]++;
				if (dy != 1) {
					dy = 1;
					pin[0] = 16;
				}
			} else if (map[(y[0] + 400) / 20][(x[0] + 180) / 20]%10 > 0) {
				vy[0] = 0;
				if (dy != 2) {
					if (dy == 1)
						pin[0] = 0;
					dy = 0;
				}
			}
			if(regp[0]==0 && sh[0]<160)
				rec.play();
			if(sh[0]<40 && c_hud==5)
				warn.play();
			for (int a = -1; a++ < 5;) {// sorting/deleting empty slot from the majestic 2d ballistics
				int n = 0;
				for (int b = -1; b++ < ammox[a].length - 1;) {
					int dmg[] = { 6, 30, 8, 18, 0, 50 };
					if (a == 4)
						dmg[4] = 60 - (shotgun[b] - 50);
					if (ammox[a][b]!=0 &&ammos[a][b] != 0&& CE.collision(x[0] + 160, y[0] + 320,ammox[a][b], ammoy[a][b], 40, 80, 2, 2) == 1) {
						if (a == 5) {
							if(CE.rocketexp(ex, ey, ext, x[0], y[0],ammox[a][b],ammoy[a][b])==0){
								int nx[]=new int[ex.length+1];
								int ny[]=new int[ex.length+1];
								int nt[]=new int[ex.length+1];
								for (int i = -1; i++ < nx.length-1;) {
									nx[i] = (i < ex.length) ? ex[i]: 0;
									ny[i] = (i < ex.length) ? ey[i]: 0;
									nt[i] = (i < ex.length) ? ext[i]: 0;
								}
								nx[ex.length]=ammox[a][b]-80;
								ny[ex.length]=ammoy[a][b]-80;
								nt[ex.length]=5;
								ex=nx;
								ey=ny;
								ext=nt;
							}
						exs.play();}
						sh[0] -= dmg[a];
						regp[0] = 70;
						sstat = 2;
						ammox[a][b] = 0;
					}

					for (int p = 0; p++ < vx.length - 1;) {
						if (ammox[a][b]!=0&&sh[p] > 0&& ammos[a][b] == 0&& CE.collision(x[p], y[p], ammox[a][b],ammoy[a][b], 40, 80, 2, 2) == 1) {
							if (a == 5) {
								if(CE.rocketexp(ex, ey, ext, x[0], y[0],ammox[a][b],ammoy[a][b])==0){
									int nx[]=new int[ex.length+1];
									int ny[]=new int[ex.length+1];
									int nt[]=new int[ex.length+1];
									for (int i = -1; i++ < nx.length-1;) {
										nx[i] = (i < ex.length) ? ex[i]: 0;
										ny[i] = (i < ex.length) ? ey[i]: 0;
										nt[i] = (i < ex.length) ? ext[i]: 0;
									}
									nx[ex.length]=ammox[a][b]-80;
									ny[ex.length]=ammoy[a][b]-80;
									nt[ex.length]=5;
									ex=nx;
									ey=ny;
									ext=nt;
								}
							exs.play();}
							sh[p] -= dmg[a];
							regp[p] = 70;
							alert[p] = 1;
							ammox[a][b] = 0;
						}
					}
					if (ammod[a][b] == 0 && ammox[a][b] - x[0] < 810
							&& ammox[a][b] - x[0] > 0)
						ammox[a][b] += ammov[a];
					else if (ammod[a][b] == 1 && ammox[a][b] - x[0] > 0)
						ammox[a][b] -= ammov[a];
					if (map[ammoy[a][b] / 20][ammox[a][b] / 20] > 0) {
						if (a == 5&&ammox[a][b]!=0) {
							if(CE.rocketexp(ex, ey, ext, x[0], y[0],ammox[a][b],ammoy[a][b])==0){
								int nx[]=new int[ex.length+1];
								int ny[]=new int[ex.length+1];
								int nt[]=new int[ex.length+1];
								for (int i = -1; i++ < nx.length-1;) {
									nx[i] = (i < ex.length-1) ? ex[i]: 0;
									ny[i] = (i < ex.length-1) ? ey[i]: 0;
									nt[i] = (i < ex.length-1) ? ext[i]: 0;
								}
								nx[ex.length]=ammox[a][b]-80;
								ny[ex.length]=ammoy[a][b]-80;
								nt[ex.length]=5;
								ex=nx;
								ey=ny;
								ext=nt;
							}
						exs.play();}
						ammox[a][b] = 0;
					}
					if (ammox[a][b] - x[0] > 800 || ammox[a][b] - x[0] < 0) {
						ammox[a][b] = ammox[a][ammox[a].length - (++n)];
						ammoy[a][b] = ammoy[a][ammox[a].length - (n)];
						ammod[a][b] = ammod[a][ammox[a].length - (n)];
						ammox[a][ammox[a].length - (n)] = 0;
						ammoy[a][ammox[a].length - (n)] = 0;
						ammod[a][ammox[a].length - (n)] = 0;
					}
					if (a == 4)
						shotgun[b]++;
				}

				if (n > 5 && ammox[a].length > 5) {
					int nbx[] = new int[ammox[a].length - n];
					int nby[] = new int[ammox[a].length - n];
					int nbd[] = new int[ammox[a].length - n];
					for (int b = -1; b++ < nbx.length - 1;) {
						nbx[b] = ammox[a][b];
						nby[b] = ammoy[a][b];
						nbd[b] = ammod[a][b];
					}
					ammox[a] = nbx;
					ammoy[a] = nby;
					ammod[a] = nbd;
				}
			}for (int i = -1; i++ < ex.length-1;){
				if(ext[i]>0)
					ext[i]--;
				else if(ext[i]==0&&ex.length>3){
					ext[i]=ext[ex.length-1];
					ex[i]=ex[ex.length-1];
					ey[i]=ey[ex.length-1];
					int nx[]=new int[ex.length-1];
					int ny[]=new int[ex.length-1];
					int nt[]=new int[ex.length-1];
					for (int e = -1; e++ < nx.length-1;) {
						nx[i] = ex[i];
						ny[i] = ey[i];
						nt[i] = ext[i];
					}
					ex=nx;
					ey=ny;
					ext=nt;
				}}
			if (c_hud == 0)
				c_hud = 6;
			if (c_hud == 10)
				c_hud = 5;
			else if (c_hud < 6)
				c_hud--;
			else if (c_hud > 5)
				c_hud++;
			Thread.sleep(10);
			if (sh[0] < 0)
				restart(level);
			if(level==3){
				level_specific.l3(c,scarh);
				if(x[0]>1000 && pccd==0){
				scex=x[0]+180-30+rangen.nextInt(60);
				scey=y[0]+360-20+rangen.nextInt(40);
				pccd=300;
			}
				if(pccd>0)
				pccd--;
				if(pccd==120)
					scfe.play();
			if(CE.collision(x[0] + 160, y[0] + 320, scex, scey,40, 80, 160, 160) == 1 && pccd<4){
				sh[0]-=25;
				regp[0] = 70;}
			for(int a=-1;a++<5;){
				for(int b=-1;b++<ammox[a].length-1;){
			if(CE.collision(1700, 470, ammox[a][b],ammoy[a][b],339,429, 2, 2) == 1){
			if (a == 5) {
				if(CE.rocketexp(ex, ey, ext, x[0], y[0],ammox[a][b],ammoy[a][b])==0){
					int nx[]=new int[ex.length+1];
					int ny[]=new int[ex.length+1];
					int nt[]=new int[ex.length+1];
					for (int i = -1; i++ < nx.length-1;) {
						nx[i] = (i < ex.length) ? ex[i]: 0;
						ny[i] = (i < ex.length) ? ey[i]: 0;
						nt[i] = (i < ex.length) ? ext[i]: 0;
					}
					nx[ex.length]=ammox[a][b]-80;
					ny[ex.length]=ammoy[a][b]-80;
					nt[ex.length]=5;
					ex=nx;
					ey=ny;
					ext=nt;
				}
			exs.play();}
			int dmg[] = { 6, 30, 8, 18, 0, 50 };
			if (a == 4)
				dmg[4] = 60 - (shotgun[b] - 50);
			scarh -= dmg[a];
			ammox[a][b] = 0;}
			for(int i=-1;i++<ex.length-1;){
				if (ext[i]>0&& CE.collision(1700, 470, ex[i], ey[i], 339,429, 160, 160) == 1) 
					scarh -= 100;
				}
			}}}
			lvl.main(c,x,y,weapon1,weapon2,ammo1,ammo2,level);
			synchronized (c) {// all graphics
				int hudx1[] = { 0, 0, 150 }, hudy1[] = { 350, 480, 480 }, hudx2[] = {800, 800, 650 }, hudx[] = { 0, 300, 320, 480, 500, 800 }, hudy[] = {0, 20, 50, 50, 20, 0 };// hud elemnts
				c.clear();
				lvl.main(map,c,x[0],y[0],level);
				for (int cx = -1; cx++ < 40;) {// mapping blocks
					for (int cy = -1; cy++ < 24;) {
						c.drawImage(item_weapon[map[cy + y[0] / 20][cx + x[0] / 20]/100],-x[0] % 20 + 20 * cx, -y[0] % 20 + 20 * cy);
						c.drawImage(bt[map[cy + y[0] / 20][cx + x[0] / 20]%10],-x[0] % 20 + 20 * cx, -y[0] % 20 + 20 * cy,20, 20);
					}
				}
				for (int e = -1; e++ < ex.length - 1;) {
					if(ext[e]>0)
					c.drawImage(exp[Math.abs(3-ext[e])],ex[e]-x[0], ey[e]-y[0],160, 160);
				}
				for (int p = 0; p++ < x.length - 1;) {
					if (pin[p] <= 5)
						c.drawImage(e1, x[p] - x[0] + dx[p] * 35, y[p] - y[0],45 - dx[p] * 90, 82);
					else if (5 < pin[p] && pin[p] <= 10)
						c.drawImage(e2, x[p] - x[0] + dx[p] * 33, y[p] - y[0],43 - dx[p] * 86, 82);
					else if (10 < pin[p] && pin[p] <= 15)
						c.drawImage(e3, x[p] - x[0] + dx[p] * 35, y[p] - y[0],45 - dx[p] * 90, 82);
					else if (15 < pin[p] && pin[p] <= 20)
						c.drawImage(e4, x[p] - x[0] + dx[p] * 32, y[p] - y[0],45 - dx[p] * 90, 82);
					else if (20 < pin[p] && pin[p] <= 25)
						c.drawImage(e5, x[p] - x[0] + dx[p] * 43, y[p] - y[0],53 - dx[p] * 106, 82);
					else if (pin[p] >= 100 && pin[p] < 105)
						c.drawImage(ed1, x[p] - x[0] + dx[p] * 49, y[p] - y[0],49 - dx[p] * 98, 82);
					else if (pin[p] >= 105 && pin[p] < 110)
						c.drawImage(ed2, x[p] - x[0] + dx[p] * 84, y[p] - y[0],84 - dx[p] * 168, 82);
					else if (pin[p] >= 110)
						c.drawImage(ed3, x[p] - x[0] + dx[p] * 105,y[p] - y[0], 105 - dx[p] * 210, 82);
				}
				if (dy == 2) {// sprite animation for Chief
					if (pin[0] <= 3) {
						c.drawImage(Rc1, 162 + 38 * dx[0], 324,38 - dx[0] * 76, 76);
						c.drawImage(weapon[fstat][weapon1], 162 + 38 * dx[0],324, wdx[weapon1] - dx[0] * 2 * wdx[weapon1],40);
					} else if (3 < pin[0] && pin[0] <= 6) {
						c.drawImage(Rc2, 155 + 45 * dx[0], 337,45 - dx[0] * 90, 63);
						c.drawImage(weapon[fstat][weapon1], 155 + 45 * dx[0],337, wdx[weapon1] - dx[0] * 2 * wdx[weapon1],40);
					} else if (6 < pin[0]) {
						c.drawImage(Rc3, 158 + 42 * dx[0], 342,42 - dx[0] * 84, 58);
						c.drawImage(weapon[fstat][weapon1], 158 + 42 * dx[0],342, wdx[weapon1] - dx[0] * 2 * wdx[weapon1],40);
					}
				} else if (dy == 0) {
					if (pin[0] <= 5) {
						c.drawImage(R1, 165 + dx[0] * 35, 324, 35 - dx[0] * 70,76);
						c.drawImage(weapon[fstat][weapon1], 165 + 35 * dx[0],324, wdx[weapon1] - dx[0] * 2 * wdx[weapon1],40);
					} else if (5 < pin[0] && pin[0] <= 10) {
						c.drawImage(R2, 167 + dx[0] * 33, 324, 33 - dx[0] * 66,76);
						c.drawImage(weapon[fstat][weapon1], 167 + 33 * dx[0],324, wdx[weapon1] - dx[0] * 2 * wdx[weapon1],40);
					} else if (10 < pin[0] && pin[0] <= 15) {
						c.drawImage(R3, 165 + dx[0] * 35, 324, 35 - dx[0] * 70,76);
						c.drawImage(weapon[fstat][weapon1], 165 + 35 * dx[0],324, wdx[weapon1] - dx[0] * 2 * wdx[weapon1],40);
					} else if (15 < pin[0] && pin[0] <= 20) {
						c.drawImage(R4, 168 + dx[0] * 32, 324, 32 - dx[0] * 64,76);
						c.drawImage(weapon[fstat][weapon1], 168 + 32 * dx[0],324, wdx[weapon1] - dx[0] * 2 * wdx[weapon1],40);
					} else if (20 < pin[0] && pin[0] <= 25) {
						c.drawImage(R5, 157 + dx[0] * 43, 324, 43 - dx[0] * 86,76);
						c.drawImage(weapon[fstat][weapon1], 157 + 33 * dx[0],324, wdx[weapon1] - dx[0] * 2 * wdx[weapon1],40);
					}
				} else if (dy == 1) {
					if (pin[0] <= 3) {
						c.drawImage(Rj1, 165 + 35 * dx[0], 328,35 - dx[0] * 70, 72);
						c.drawImage(weapon[fstat][weapon1], 165 + 35 * dx[0],328, wdx[weapon1] - dx[0] * 2 * wdx[weapon1],40);
					} else if (3 < pin[0] && pin[0] <= 6) {
						c.drawImage(Rj2, 168 + 32 * dx[0], 325,32 - dx[0] * 64, 75);
						c.drawImage(weapon[fstat][weapon1], 168 + 32 * dx[0],325, wdx[weapon1] - dx[0] * 2 * wdx[weapon1],40);
					} else if (6 < pin[0] && pin[0] <= 9) {
						c.drawImage(Rj3, 169 + 31 * dx[0], 326,31 - dx[0] * 62, 74);
						c.drawImage(weapon[fstat][weapon1], 169 + 31 * dx[0],326, wdx[weapon1] - dx[0] * 2 * wdx[weapon1],40);
					} else if (9 < pin[0] && pin[0] <= 12) {
						c.drawImage(Rj4, 166 + 34 * dx[0], 330,34 - dx[0] * 68, 70);
						c.drawImage(weapon[fstat][weapon1], 166 + 34 * dx[0],330, wdx[weapon1] - dx[0] * 2 * wdx[weapon1],40);
					} else if (12 < pin[0]) {
						c.drawImage(Rj5, 157 + 34 * dx[0], 324,34 - dx[0] * 68, 72);
						c.drawImage(weapon[fstat][weapon1], 157 + 33 * dx[0],324, wdx[weapon1] - dx[0] * 2 * wdx[weapon1],40);
					}
				}
				c.setColor(new Color(228, 171, 228));
				if(map[(y[0]+390)/20][(x[0]+160)/20]/100>0)
					c.drawString("Press E to pick up weapons", 100, 100);
				for (int a = -1; a++ < 5;) {// ammos...
					for (int b = -1; b++ < ammox[a].length - 1;) {
						if (ammox[a][b] - x[0] < 800 || ammox[a][b] - x[0] > 0) {
							if (a != 0 && a != 5)
								c.fillOval(ammox[a][b] - x[0], ammoy[a][b]- y[0], 2, 2);
							else if (a == 0)
								c.drawImage(plasma, ammox[a][b] - x[0] + 6* ammod[a][b], ammoy[a][b] - y[0],6 - 12 * ammod[a][b], 6);
							else if (a == 5)
								c.drawImage(rocket, ammox[a][b] - x[0] + 8* ammod[a][b], ammoy[a][b] - y[0],8 - 16 * ammod[a][b], 4);
						}
					}
				}
				if(level==3){
					c.drawImage(scarab, 1600-x[0], 470-y[0]);
					if(x[0]>1000 &&pccd<15){
					c.setColor(new Color(76, 224, 164, 120));
					for(int i=-5;i++<10;)
					c.drawLine(scex+80-x[0]+i, scey+80-y[0]+i,1760-x[0]+i,625-y[0]+i);
					c.drawImage(plex,scex-x[0],scey-y[0],160,160);}}
				if (sstat == 2) {
					c.setColor(new Color(255, 255, 51, 60));
					if (dy == 2)
						c.fillOval(160, 343, 40, 52);
					else
						c.fillOval(160, 325, 40, 70);
				}
				// heads up display from interface to ammo counter
				if (sh[0] < 40) {
					if (c_hud > 5)
						c.setColor(new Color(86, 171, 228, 120));
					if (c_hud < 6)
						c.setColor(new Color(250, 140, 140, 120));
				} else {
					c.setColor(new Color(86, 171, 228, 120));
				}
				
				c.fillPolygon(hudx, hudy, 6);
				c.fillPolygon(hudx1, hudy1, 3);
				c.fillPolygon(hudx2, hudy1, 3);
				c.fillRoundRect(320, 20, sh[0], 20, 10, 10);
				c.fillRoundRect(10, 5, 35, 20, 20, 20);
				c.fillRoundRect(10, 32, 42, 25, 20, 20);
				c.setColor(new Color(250, 250, 250, 180));
				c.drawString("" + clip1, 20, 20);
				c.drawString("" + ammo1, 20, 50);
			}
		}
	}

	static void restart(int l) throws InterruptedException {
		AudioClip f1 = Applet.newAudioClip(HSA.class.getResource("f1.wav"));
		AudioClip f2 = Applet.newAudioClip(HSA.class.getResource("f2.wav"));
		f1.play();
		c.setColor(new Color(250, 240, 240, 120));
		for (int i = 0; i++ < 10;) {
			c.fillRect(0, 0, 800, 480);
			Thread.sleep(100);
		}
		c.setColor(new Color(0, 0, 0));
		c.setFont(new Font("Arial", Font.BOLD, 25));
		c.drawString("Finish the fight(Y) or quit(N)?", 200, 230);
		while (true) {
			if (c.isKeyDown('Y')) {
				f2.play();
				Thread.sleep(3000);
				lv.mapimport(l);
			} else if (c.isKeyDown('N'))
				System.exit(0);
		}
	}
	static void exit(int x, int y, int w1, int w2, int a1, int a2, int level){
		player[0]=x;
		player[1]=y;
		player[2]=w1;
		player[3]=w2;
		player[4]=a1;
		player[5]=a2;
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("C:\\save.txt")));
			writer.write(level);
			for(int i=-1;i++<5;)
			writer.write(player[i]);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	static void credit() throws InterruptedException{
		AudioClip tribute = Applet.newAudioClip(HSA.class.getResource("Tribute.wav"));
		tribute.play();
		c.setColor(new Color(0,0,0,30));
		for(int i=-1;i++<30;){
		c.fillRect(0, 0, 800, 480);
		Thread.sleep(100);}
		c.setColor(new Color(255,255,255,30));
		c.setFont(new Font("SansSerif",Font.CENTER_BASELINE, 15));
		for(int i=-1;i++<30;){
		c.drawString("In rememberance of the men and women of Reach.",200,220);
		c.drawString("Who sacrificed themselves so that we might live free and proud",160,240);
		Thread.sleep(100);}
		c.setColor(new Color(0,0,0,30));
		for(int i=-1;i++<30;){
		c.fillRect(0, 0, 800, 480);
		Thread.sleep(100);}
		c.setColor(new Color(255,255,255,30));
		for(int i=-1;i++<30;){
		c.drawString("And for every man and woman who died fighting for our freedom and wellbeing.",100,230);
		Thread.sleep(100);}
		c.setColor(new Color(0,0,0,30));
		for(int i=-1;i++<30;){
		c.fillRect(0, 0, 800, 480);
		Thread.sleep(100);}
		c.setColor(new Color(255,255,255,30));
		for(int i=-1;i++<30;){
		c.drawString("We remember.",350,230);
		Thread.sleep(100);}
		c.setColor(new Color(0,0,0,30));
		for(int i=-1;i++<30;){
		c.fillRect(0, 0, 800, 480);
		Thread.sleep(100);}
		c.setColor(new Color(255,255,255,30));
		for(int i=-1;i++<30;){
		c.drawString("Written/Directed/Coded by",350,220);
		c.drawString("Lennox Fei, a proud Spartan",350,240);
		Thread.sleep(100);}
		c.setColor(new Color(0,0,0,30));
		for(int i=-1;i++<30;){
		c.fillRect(0, 0, 800, 480);
		Thread.sleep(100);}
		c.setColor(new Color(255,255,255,30));
		for(int i=-1;i++<30;){
		c.drawString("HSA Physics Framework Developed By",350,220);
		c.drawString("Lennox's Majestic Studio",390,240);
		Thread.sleep(100);}
		c.setColor(new Color(0,0,0,30));
		for(int i=-1;i++<30;){
		c.fillRect(0, 0, 800, 480);
		Thread.sleep(100);}
		c.setColor(new Color(255,255,255,30));
		for(int i=-1;i++<30;){
		c.drawString("Models By",400,220);
		c.drawString("InnerRayg",400,240);
		Thread.sleep(100);}
		c.setColor(new Color(0,0,0,30));
		for(int i=-1;i++<30;){
		c.fillRect(0, 0, 800, 480);
		Thread.sleep(100);}
		c.setColor(new Color(255,255,255,30));
		for(int i=-1;i++<30;){
		c.drawString("Soundtrack By",385,220);
		c.drawString("Martin O'Donnel",380,240);
		Thread.sleep(100);}
		c.setColor(new Color(0,0,0,30));
		for(int i=-1;i++<30;){
		c.fillRect(0, 0, 800, 480);
		Thread.sleep(100);}
		c.setColor(new Color(255,255,255,30));
		for(int i=-1;i++<30;){
		c.drawString("HALO Created By",380,220);
		c.drawString("BUNGIE STUDIOS",380,240);
		Thread.sleep(100);}
		c.setColor(new Color(0,0,0,30));
		for(int i=-1;i++<30;){
		c.fillRect(0, 0, 800, 480);
		Thread.sleep(100);}
		c.setColor(new Color(255,255,255,30));
		for(int i=-1;i++<30;){
		c.drawString("A",480,220);
		c.drawString("Majestic STUDIOS PRODUCTION",370,240);
		Thread.sleep(100);}
		c.setColor(new Color(0,0,0,30));
		for(int i=-1;i++<30;){
		c.fillRect(0, 0, 800, 480);
		Thread.sleep(100);}
		c.setColor(new Color(255,255,255,30));
		for(int i=-1;i++<30;){
		c.drawString("Thank you for playing",350,240);
		Thread.sleep(100);}
		c.setColor(new Color(0,0,0,30));
		for(int i=-1;i++<30;){
		c.fillRect(0, 0, 800, 480);
		Thread.sleep(100);}
		c.setColor(new Color(255,255,255,30));
		for(int i=-1;i++<30;){
		c.drawString("H A L O : Dawn of Reach",350,230);
		Thread.sleep(100);}
		c.setColor(new Color(0,0,0,30));
		for(int i=-1;i++<30;){
			c.fillRect(0, 0, 800, 480);
			Thread.sleep(100);}
		int ty=0;
		while(ty<1120){
			ty++;
			Thread.sleep(50);
			synchronized(c){
			c.clear();
			c.setColor(new Color(0,0,0));
			c.fillRect(0, 0, 800, 480);
			c.setColor(new Color(250,250,250));
			for(int i=-1;i++<12;)
				c.drawString("Lennox Fei",350,-ty%40+i*40);
				}
		}
	}
}