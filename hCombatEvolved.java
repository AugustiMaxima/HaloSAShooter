package SAss;

public class hCombatEvolved {
	int collision(int x1, int y1, int x2, int y2, int w1, int h1, int w2, int h2) {//collision detection
		int b = 0;
		if (x2 <= x1 + w1 && x1 <= x2 + w2 && y1 <= y2 + h2 && y2 <= y1 + h1&& x2 != 0) {
			b = 1;
		}
		return b;
	}

	int fire(int bx[], int by[], int bd[],int bs[],int shot[],int a, int x, int y, int xd, int yd,int d,int dy,int w) {//firing
		int s = 0;
		for (int b = -1; b++ < bx.length - 1;) {
			if (bx[b] - x >= 800 || bx[b] - x <= 0) {
				by[b] =(dy==2)? y+340+yd:y + 320 + yd;
				bx[b] = x + 200 - xd * d;
				bd[b] = d;
				bs[b]=a;
				if(w==4)shot[b]=0;
				s = 1;
				break;
			}
		}
	return s;
}	
	int Efire(int bx[], int by[], int bd[],int bs[],int a, int x, int y, int xd, int yd,int d,int x0) {//firing
		int s = 0;
		for (int b = -1; b++ < bx.length - 1;) {
			if (bx[b] - x0 >= 800 || bx[b] - x0 <= 0) {
				by[b] =y+ yd;
				bx[b] = x + 45 - xd * d;
				bd[b] = d;
				bs[b]=a;
				s = 1;
				break;
			}
		}
	return s;
}
	int rocketexp(int ex[], int ey[],int ext[], int x, int y, int x1, int y1) {//rocket explosion
		int s = 0;
		for (int b = -1; b++ < ex.length-1;) {
			if (ex[b] - x >= 800 || ex[b] - x <= 0) {
				ey[b]= y1-80;
				ex[b] = x1-80;
				ext[b]=5;
				s=1;
				break;
			}
		}
	return s;
}	
	int blockdetect(int map[][],int x1, int y1, int x) {//collision detection
		int c1=0,c2=0,c3=0,c4=0,k=0,c=0,xa=0;
		if(x1>x+160){
			k=(x1-x-160)/20;
			xa=x+160;}
		else if(x1<x+160){
			k=(x+160-x1)/20;
			xa=x1;}
		for(int i=0;i++<k;){
			if(map[y1/20][xa/20+i]%10>0)
				c1=1;
			if(map[(y1+20)/20][xa/20+i]%10>0)
				c2=1;
			if(map[(y1+40)/20][xa/20+i]%10>0)
				c3=1;
			if(map[(y1+60)/20][xa/20+i]%10>0)
				c4=1;
		}
		if(c1+c2+c3+c4>3)
			c=1;
		return c;
	}
}